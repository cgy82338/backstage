package yc.xuezhifan.schoolbackstage.school.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.rong.models.Result;
import io.rong.models.user.UserModel;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.school.mapper.YcSchoolMapper;
import yc.xuezhifan.schoolbackstage.school.service.YcSchoolService;
import yc.xuezhifan.schoolbackstage.school.vo.SchoolData;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;
import yc.xuezhifan.schoolbackstage.utils.*;

import java.util.List;

@Service
public class YcSchoolServiceImpl implements YcSchoolService {

    @Autowired
    YcSchoolMapper ycSchoolMapper;

    @Autowired
    private YcUserMapper ycUserMapper;

    /**
     * 根据token参数查询学校
     */
    @Override
    public YcSchool findByAccessToken(String schoolName) {
        // TODO Auto-generated method stub
        return ycSchoolMapper.selectByUserName(schoolName);
    }

    /**
     * 学校账户登录
     */
    @Override
    public YcSchool login(String username, String password) {
        try {
            YcSchool ycSchool = ycSchoolMapper.selectByUserName(username);
            if (RegexUtil.isNotNull(ycSchool)) {
                String pw = MD5Util.md5(password + "lover1314");
                if (pw.equals(ycSchool.getYc_school_pw_encryption())) {
                    return ycSchool;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <p>Title: findBySchoolId</p>
     *
     * <p>Description:根据学校id 查询 学校信息 </p>
     *
     * @param id
     * @return
     * @email xiaoke@xuezhifan.com
     * @author xiaoke
     * @date 2018年11月5日
     */
    @Override
    public YcSchool findBySchoolId(String id) {
        // TODO
        return ycSchoolMapper.selectById(id);
    }


    @Override
    @Transactional
    public String updateSchool(YcSchool ycSchool) {
        // 判断是否存在
        YcSchool school = selectById(ycSchool.getId());
        if (RegexUtil.isNull(school)) {
            return YcSchoolConstants.NOT_EXISTED;
        }
        // 通过手机号得到用户对象
        YcUser user = ycUserMapper.selectPhone(school.getYc_school_principal_phone());
        // 判断是否存在
        if (RegexUtil.isNull(user)) {
            return YcSchoolConstants.NOT_EXISTED;
        }
        // 创建用户对象
        YcUser ycUser = new YcUser();
        // 设置对应用户id
        ycUser.setId(user.getId());
        // 当密码不为空时设置加密密码
        if (RegexUtil.isNotNull(ycSchool.getYc_school_password())) {
            ycSchool.setYc_school_pw_encryption(MD5Util.md5(ycSchool.getYc_school_password() + "lover1314"));
            // 同步修改用户信息表密码
            ycUser.setYc_password_encryption(MD5Util.md5(ycSchool.getYc_school_password() + "lover1314"));
        }
        if (RegexUtil.isNotNull(ycSchool.getYc_school_principal_phone())) {
            // 验证用户表中手机号是否重复
            YcUser yuser = ycUserMapper.selectPhone(ycSchool.getYc_school_principal_phone());
            if (RegexUtil.isNotNull(yuser)) {
                return YcSchoolConstants.IS_EXISTED;
            } else {
                // 不存在时修改手机号
                ycUser.setYc_phone(ycSchool.getYc_school_principal_phone());
            }
        }
        // 当头像不为空时,删除oss存储
        if (RegexUtil.isNotNull(ycSchool.getYc_school_avatar())
                && ycSchool.getYc_school_avatar().equals(school.getYc_school_avatar())) {
            AliyunOSSUtil.deleteObject(school.getYc_school_avatar());
            // 修改用户信息表头像
            ycUser.setYc_avatar(ycSchool.getYc_school_avatar());
        }
        // 更新rongCloud 用户信息
        Result tresult = null;
        try {
            // 根据修改信息不同得到不同的token
            if (RegexUtil.isNotNull(ycUser.getYc_avatar()) && RegexUtil.isNull(ycUser.getYc_phone())) {
                tresult = RongCloudUtil.getRongcloud().user
                        .update(new UserModel(ycUser.getId(), user.getYc_phone(), ycUser.getYc_avatar()));
            } else if (RegexUtil.isNull(ycUser.getYc_avatar()) && RegexUtil.isNotNull(ycUser.getYc_phone())) {
                tresult = RongCloudUtil.getRongcloud().user
                        .update(new UserModel(ycUser.getId(), ycUser.getYc_phone(), user.getYc_avatar()));
            } else if (RegexUtil.isNotNull(ycUser.getYc_avatar()) && RegexUtil.isNotNull(ycUser.getYc_phone())) {
                tresult = RongCloudUtil.getRongcloud().user
                        .update(new UserModel(ycUser.getId(), ycUser.getYc_phone(), ycUser.getYc_avatar()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return YcSchoolConstants.FAILURE;
        }
        // 判断返回状态码,
        if (tresult.code != 200) {
            // 不为200时,返回失败
            return YcSchoolConstants.FAILURE;
        }
        ycUserMapper.updatePW(ycUser);
        Integer rs = ycSchoolMapper.updateSchool(ycSchool);
        if (RegexUtil.isNotNull(rs)) {
            return YcSchoolConstants.SUCCESS;
        }
        return YcSchoolConstants.FAILURE;
    }

    @Override
    public YcSchool selectById(String id) {
        return ycSchoolMapper.selectById(id);
    }

    /**
     * 修改管理后台密码
     */
    @Override
    public JacksonData updatepassword(String formerpass, String newqpass, YcSchool ycSchool) {
        YcSchool school = ycSchoolMapper.selectById(ycSchool.getId());
//		判断输入的原密码是否与数据库密码相同
        if (school.getYc_school_password().equals(formerpass)) {
//			密码相同则允许修改密码
            ycSchool.setYc_school_password(newqpass);
            ycSchool.setYc_school_pw_encryption(new MD5Util().md5(ycSchool.getYc_school_password() + Constants.SALT));
            ycSchoolMapper.updateSchool(ycSchool);
            return ResultUtil.success();
        } else {
            return ResultUtil.error(204, YcSchoolConstants.RQPASS);
        }
    }


    /**
     * 账号资料信息修改
     */
    @Override
    public JacksonData updateData(YcSchool ycSchool, SchoolData schoolData) {
        try {
            if (StringUtils.isNotBlank(schoolData.getSchoolname())) {//学校名称
                if (!schoolData.getSchoolname().equals(ycSchoolMapper.selectById(ycSchool.getId()).getYc_school_name())){//如果修改了学校
                    //                根据学校名称查询信息
                    if (ycSchoolMapper.selectSchoolByName(schoolData.getSchoolname()) != null) {//学校名称已存在
                        return ResultUtil.error(204, YcSchoolConstants.NAME_EXISTED);
                    }
                }
                ycSchool.setYc_school_name(schoolData.getSchoolname());
            }
            if (StringUtils.isNotBlank(schoolData.getAvatar())) {//学校头像
                ycSchool.setYc_school_avatar(schoolData.getAvatar());
            }
            ycSchoolMapper.updateSchool(ycSchool);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(204, YcSchoolConstants.FAILURE);
        }
    }

    /**
     * 账号所有人资料信息修改
     */
    @Override
    public JacksonData updateDataAll(YcSchool ycSchool, SchoolData schoolData) {
        try {
            if (StringUtils.isNotBlank(schoolData.getPhone())) {//登录人手机号
                ycSchool.setYc_school_principal_phone(schoolData.getPhone());
            }
            if (StringUtils.isBlank(schoolData.getYc_district())) {
                return ResultUtil.error(204, YcSchoolConstants.NOT_FULLADDRESS);
            }else {
                ycSchool.setYc_province(schoolData.getYc_province());//省
                ycSchool.setYc_city(schoolData.getYc_city());//市
                ycSchool.setYc_district(schoolData.getYc_district());//区
            }
            ycSchoolMapper.updateSchool(ycSchool);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(204, YcSchoolConstants.FAILURE);
        }
    }
}
