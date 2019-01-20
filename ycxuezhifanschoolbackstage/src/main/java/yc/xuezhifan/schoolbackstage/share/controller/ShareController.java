package yc.xuezhifan.schoolbackstage.share.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.SMSConstants;
import yc.xuezhifan.schoolbackstage.share.bean.YcChildInformation;
import yc.xuezhifan.schoolbackstage.share.bean.YcChildParent;
import yc.xuezhifan.schoolbackstage.share.mapper.YcChildInformationMapper;
import yc.xuezhifan.schoolbackstage.share.mapper.YcChildParentMapper;
import yc.xuezhifan.schoolbackstage.share.service.ShareService;
import yc.xuezhifan.schoolbackstage.share.utils.ChildRelationUtil;
import yc.xuezhifan.schoolbackstage.share.vo.ShareVo;
import yc.xuezhifan.schoolbackstage.smsmoible.bean.YcVerificationCode;
import yc.xuezhifan.schoolbackstage.smsmoible.service.ISMSService;
import yc.xuezhifan.schoolbackstage.smsmoible.util.CodeUtil;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;
import yc.xuezhifan.schoolbackstage.utils.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: ShareController.java </p>
 *
 * <p>Description: 关注孩子controller</p>
 *
 * <p>Copyright: Copyright (c) 2019年1月2日</p>
 *
 * @author xiaoyu
 * @version 1.0
 * @email xiaoyu@xuezhifan.com
 * @date 2019年1月2日
 */
@Controller
@RequestMapping("/xuezhifan")
public class ShareController {

    @Autowired
    ShareService shareService;


    /**
     * 跳转页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/share")
    public String share(String id, Model model) throws ParseException {
        YcChildInformation ycChildInformation = shareService.selectChildById(id);
        YcUser user = shareService.selectUserById(ycChildInformation.getYc_founder());
        String age = "";
        if (ycChildInformation.getYc_child_brith() != null) {
            Date brith = ycChildInformation.getYc_child_brith();
            long time = System.currentTimeMillis() - brith.getTime();
            int days = (int) (time / 1000 / 60 / 60 / 24);
            int year = days / 365;
            int month = (days % 365) / 30;
            int day = (days % 365) % 30;
            age = year + "年" + month + "月" + day + "天";
        }
        model.addAttribute("child", ycChildInformation);//孩子信息
        model.addAttribute("age", age);//孩子年龄
        model.addAttribute("founderName", user.getYc_username());//创建人
        return "/share/share";
    }


    /**
     * 转发到关注成功页面
     *
     * @param shareVo
     * @return
     */
    @RequestMapping(value = "/shareChild",method = RequestMethod.POST)
    public String addUser(ShareVo shareVo,Model model) {
        String msg = null;
        String success = "";
        YcChildInformation child = shareService.selectChildById(shareVo.getId());
        Integer status = shareService.shareChild(shareVo);//1:关注成功（未注册用户）2:关注成功（已注册用户）3:已关注
        if (status == 1){
            msg = "关注成功";
            success = "初始账号密码已发送到您的手机，快点下载学知帆，登录后就可以看到" + child.getYc_child_name() + "的全部照片和动态啦";
        }else if (status == 2){
            msg = "关注成功";
            success = "登录后就可以看到" + child.getYc_child_name() + "的全部照片和动态啦";
        }else if(status == 3){
            msg = "您已经关注过"+child.getYc_child_name()+"了";
            success = "登录后就可以看到" + child.getYc_child_name() + "的全部照片和动态啦";
        }else if(status == 4){
            msg = "非常抱歉，只有为家长用户才能关注孩子哦";
        }
        Map<String,String> map = new HashMap<>();
        map.put("msg",msg);//结果
        map.put("success",success);//提醒语句
        map.put("childavator",child.getYc_child_avatar());//头像
        model.addAttribute("result", map);
        return "/share/sharesuccess";
    }

//    /**
    //     * 发送短信
    //     * @param phone
    //     * @return
    //     */
//    @RequestMapping(value = "/sendCode",method = RequestMethod.POST)
//    @ResponseBody
//    public JacksonData shareSend(String phone){
//        try {
//            ismsService.shareSend(phone, CodeUtil.createData(4));
//            return ResultUtil.success();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResultUtil.error(204, SMSConstants.FAILURE);
//    }
//
//    /**
//     * 验证短信
//     * @param verificationCode
//     * @return
//     */
//    @RequestMapping(value = "/checkCode",method = RequestMethod.POST)
//    @ResponseBody
//    public JacksonData checkShareCode(YcVerificationCode verificationCode){
//        String phone = verificationCode.getYc_mobile();
//        String code = verificationCode.getYc_code();
//        if (ismsService.checkShareCode(phone,code)){
//            return ResultUtil.success();
//        }else {
//            return ResultUtil.error(204,SMSConstants.FAILURE);
//        }
//    }
}
