package yc.xuezhifan.schoolbackstage.share.service.Impl;

import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.xuezhifan.schoolbackstage.share.bean.YcChildClass;
import yc.xuezhifan.schoolbackstage.share.bean.YcChildInformation;
import yc.xuezhifan.schoolbackstage.share.bean.YcChildParent;
import yc.xuezhifan.schoolbackstage.share.mapper.YcChildClassMapper;
import yc.xuezhifan.schoolbackstage.share.mapper.YcChildInformationMapper;
import yc.xuezhifan.schoolbackstage.share.mapper.YcChildParentMapper;
import yc.xuezhifan.schoolbackstage.share.service.ShareService;
import yc.xuezhifan.schoolbackstage.share.utils.ChildRelationUtil;
import yc.xuezhifan.schoolbackstage.share.vo.ShareVo;
import yc.xuezhifan.schoolbackstage.smsmoible.service.ISMSService;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;
import yc.xuezhifan.schoolbackstage.utils.*;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClass;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcParentClass;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcClassMapper;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcParentClassMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: ShareService.java </p>
 *
 * <p>Description: 关注孩子service实现类</p>
 *
 * <p>Copyright: Copyright (c) 2019年1月2日</p>
 *
 * @author xiaoyu
 * @version 1.0
 * @email xiaoyu@xuezhifan.com
 * @date 2019年1月2日
 */
@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    YcChildInformationMapper childInformationMapper;
    @Autowired
    YcUserMapper userMapper;
    @Autowired
    YcChildParentMapper childParentMapper;
    @Autowired
    YcChildClassMapper childClassMapper;
    @Autowired
    YcClassMapper classMapper;
    @Autowired
    YcParentClassMapper parentClassMapper;
    @Autowired
    ISMSService ismsService;

    @Override
    public YcChildInformation selectChildById(String id) {
        return childInformationMapper.selectById(id);
    }

    @Override
    public YcUser selectUserById(String id) {
        return userMapper.selectById(id);
    }

    /**
     * 分享关注孩子
     *
     * @param shareVo
     * @return
     */
    @Override
    public Integer shareChild(ShareVo shareVo) {//1:关注成功（未注册用户）2:关注成功（已注册用户）3:已关注4:不为家长不能进行关注
        int isUser = 0;//用于判断是否需要发短信
//        通过手机号查询用户
        YcUser user = userMapper.selectByPhone(shareVo.getPhone());
        if (user == null) {//没有此用户，则创建家长用户
            isUser = 1;
            user = new YcUser();
            user.setId(UUIDFactory.random());
            user.setYc_username(shareVo.getUsername());
            user.setYc_nickname(user.getYc_username());
            user.setYc_password(PasswordRandom.getStringRandom(6));
            user.setYc_password_encryption(new MD5Util().md5(user.getYc_password() + Constants.SALT));
            user.setYc_phone(shareVo.getPhone());
            user.setYc_role(1);//默认为家长
            user.setYc_avatar(Constants.DEFAULTREGISTRAVAER);
            user.setYc_login_time(new Date());
            try {
                //usermodel 中 id name 头像
                TokenResult register = RongCloudUtil.getRongcloud().user.register(
                        new UserModel(user.getId(), user.getYc_username(), user.getYc_avatar())
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
            userMapper.insertUser(user);
        }
        //        判断用户是否已关注过孩子
        YcChildParent isShare = childParentMapper.selectByChildAndParent(shareVo.getId(), user.getId());
        if (isShare != null) {
            return 3;
        } else {
            if (userMapper.selectByPhone(shareVo.getPhone()).getYc_role() == 1){//为家长才能关注
                //            建立家长与班级的关系
                YcChildParent ycChildParent = new YcChildParent();
                ycChildParent.setId(UUIDFactory.random());
                ycChildParent.setYc_child_id(shareVo.getId());
                ycChildParent.setYc_parent_id(user.getId());
                ycChildParent.setYc_relationship(shareVo.getRelation());
                ycChildParent.setYc_status(2);//关注建立的联系都为关联人
                childParentMapper.insertYcChildParent(ycChildParent);
//            通过孩子id查询孩子所有所在班级，并把此家长与查询出的班级建立关联
                List<YcChildClass> childClass = childClassMapper.selectByChildId(shareVo.getId());
//            所有孩子与班级的关联信息
                for (YcChildClass aClass : childClass) {
                    YcParentClass ycParentClass = new YcParentClass();
                    ycParentClass.setId(UUIDFactory.random());
                    ycParentClass.setYc_parent_id(user.getId());
                    ycParentClass.setYc_class_id(aClass.getYc_class_id());
                    ycParentClass.setYc_create_time(new Date());
                    ycParentClass.setYc_status(2);
                    ycParentClass.setYc_review_id("");
                    ycParentClass.setYc_permission_status(3);
                    ycParentClass.setYc_verification_message("");
                    YcClass ycClass = classMapper.selectClassById(aClass.getYc_class_id());
                    if (ycClass.getYc_class_nature().equals("1")) {
                        ycParentClass.setYc_remarks(shareVo.getChildname() + ChildRelationUtil.findChildRelationByNumber(shareVo.getRelation()));
                    } else {
                        ycParentClass.setYc_remarks(user.getYc_username());
                    }
                    ycParentClass.setYc_reason("");
                    ycParentClass.setYc_message_avoidance("1");
//               添加到家长班级关系表
                    parentClassMapper.addParentClass(ycParentClass);
                }
                if (isUser == 1) {
                    //                发送短信
                    ismsService.shareSend(user, shareVo.getChildname());
                    return 1;
                }
                return 2;
            }else {
                return 4;
            }

        }

    }
}
