package yc.xuezhifan.schoolbackstage.teacher.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcTeacherConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.school.mapper.YcSchoolMapper;
import yc.xuezhifan.schoolbackstage.smsmoible.service.ISMSService;
import yc.xuezhifan.schoolbackstage.teacher.bean.YcSubjectManagement;
import yc.xuezhifan.schoolbackstage.teacher.bean.YcTeacherExcel;
import yc.xuezhifan.schoolbackstage.teacher.bean.YcTeacherManagement;
import yc.xuezhifan.schoolbackstage.teacher.mapper.YcTeacherManagementMapper;
import yc.xuezhifan.schoolbackstage.teacher.service.YcTeacherService;
import yc.xuezhifan.schoolbackstage.teacher.vo.YcTeacherVo;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;
import yc.xuezhifan.schoolbackstage.utils.*;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClass;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcParentClass;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcClassMapper;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcParentClassMapper;

import java.util.*;

/**
 * <p>
 * Title: YcTeacherServiceImpl.java
 * </p>
 *
 * <p>
 * Description: 教师Service实现
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2018年9月18日
 * </p>
 *
 * @author zhuangzhuang
 * @version 1.0
 * @email zhuangzhuang@xuezhifan.com
 * @date 2018年9月18日
 */
@Service
public class YcTeacherServiceImpl implements YcTeacherService {

    @Autowired
    private YcTeacherManagementMapper ycTeacherManagementMapper;

    @Autowired
    private YcUserMapper ycUserMapper;

    @Autowired
    private YcSchoolMapper ycSchoolMapper;

    @Autowired
    private YcClassMapper ycClassMapper;

    @Autowired
    private ISMSService ismsService;

    @Autowired
    private YcParentClassMapper parentClassMapper;

    /**
     * 学校添加教师（单个添加）
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    @SuppressWarnings("static-access")
    public JacksonData saveTeacher(YcSchool ycSchool, YcUser user) {
        try {
            YcUser addUser = new YcUser();
//             根据手机号查询用户信息
            YcUser ycUser = ycUserMapper.selectByPhone(user.getYc_phone());
//               手机号被注册
            if (RegexUtil.isNotNull(ycUser)) {
//                不为删除状态
                if (ycUser.getYc_delete() == 1) {
                    return ResultUtil.error(204, YcTeacherConstants.PHONEEXISTED);
                } else {//                    为删除状态
                    if (ycUser.getYc_role() == 1) {//为家长
                        return ResultUtil.error(204, ycUser.getYc_phone() + "" + YcTeacherConstants.ROLEPARENT);
                    } else {//为教师
                        ycUser.setYc_username(user.getYc_username());
//                        如果昵称不为空则为当前昵称
                        if (user.getYc_nickname() != null) {
                            ycUser.setYc_nickname(user.getYc_nickname());
                        }
                        ycUser.setYc_gender(user.getYc_gender());
                        ycUser.setYc_phone(user.getYc_phone());
                        ycUser.setYc_idcard(user.getYc_idcard());
                        //            如果头像不为空，则为当前头像
                        if (user.getYc_avatar() != null) {
                            ycUser.setYc_avatar(user.getYc_avatar());
                        }
//                        地址不填
                        ycUser.setYc_province("");
                        ycUser.setYc_city("");
                        ycUser.setYc_district(ycSchool.getYc_district());
                        ycUser.setYc_district_name("");
                        ycUser.setYc_map_address(ycSchool.getYc_school_map_address());
                        ycUser.setYc_password(PasswordRandom.getStringRandom(6));
                        ycUser.setYc_password_encryption(new MD5Util().md5(ycUser.getYc_password() + Constants.SALT));
                        ycUser.setYc_login_time(new Date());
                        ycUser.setYc_founder(ycSchool.getId());
                        ycUser.setYc_delete(1);
                        //			修改用户部分信息
                        ycUserMapper.updateTeacherById(ycUser);
                        addUser = ycUser;
                    }
                }
            } else {//手机号没被注册
                user.setId(UUIDFactory.random());
//            如果昵称为空，则默认为用户名
                if (user.getYc_nickname() == null) {
                    user.setYc_nickname(user.getYc_username());
                }
                user.setYc_gender(user.getYc_gender());
//            地址不填
                user.setYc_province("");
                user.setYc_city("");
                user.setYc_district(ycSchool.getYc_district());
                user.setYc_district_name("");
                user.setYc_map_address(ycSchool.getYc_school_map_address());
                user.setYc_password(PasswordRandom.getStringRandom(6));
                user.setYc_password_encryption(new MD5Util().md5(user.getYc_password() + Constants.SALT));
                user.setYc_role(2);
//            如果头像为空，则默认为默认头像
                if (user.getYc_avatar() == null) {
                    user.setYc_avatar(Constants.DEFAULTREGISTRAVAER);
                }
                user.setYc_introduction("");
                user.setYc_carte("");
                user.setYc_status("1");
                user.setYc_login_time(new Date());
                user.setYc_founder(ycSchool.getId());
                user.setYc_delete(1);
                user.setYc_wechat_appid("");
                user.setYc_qq_unionid("");
                user.setYc_alipay_appid("");
                user.setYc_token("");
                //usermodel 中 id name 头像
                TokenResult register = RongCloudUtil.getRongcloud().user.register(
                        new UserModel(user.getId(), user.getYc_username(), user.getYc_avatar())
                );
                user.setYc_rongcloudtoken(register.getToken());
                user.setYc_video_name("1");
                user.setYc_allow_class("1");
                user.setYc_allow_qrcode("1");
                user.setYc_allow_address("1");
                user.setYc_user_token("");
//			添加用户信息
                ycUserMapper.insertUser(user);
                addUser = user;
            }
            //			添加教师科目管理表数据
//            YcTeacherManagement ycTeacherManagement = new YcTeacherManagement();
//            ycTeacherManagement.setYc_teacher_information_id(UUIDFactory.random());
//            ycTeacherManagement.setId(addUser.getId());
//            ycTeacherManagement.setYc_teacher_informati_position(2);//职务 teacher.getPosition()
//            ycTeacherManagement.setYc_subject_management_id("");//科目唯一标识暂时为空
//            ycTeacherManagementMapper.insertTeacherManagement(ycTeacherManagement);

            //           给用户发短信告知用户密码
            ismsService.passwordSend(addUser.getYc_phone(), addUser.getYc_password());

            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(204, YcTeacherConstants.ADDFALSE);
        }

    }

    /**
     * excel批量创建教师账户
     *
     * @throws Exception
     */
    @Transactional(rollbackFor = {Exception.class})
    @SuppressWarnings("static-access")
    @Override
    public String saveTeacherBatch(YcSchool ycSchool, List<YcTeacherExcel> personList) {
        Map<String, String> map = new LinkedHashMap<>();
        boolean flag = true;// 标记成败
        StringBuilder addTeacher = new StringBuilder();//记录错误信息

        //用户表数据
        for (int i = 0; i < personList.size(); i++) {
//                清除空格不报错
            String name = personList.get(i).getName();
            if (StringUtils.isNotBlank(name)) {
                name = name.replace(" ", "");
            }
            String phone = personList.get(i).getPhone();
            if (StringUtils.isNotBlank(phone)) {
                phone = phone.replace(" ", "");
            }
            String sex = personList.get(i).getSex();
            if (StringUtils.isNotBlank(sex)) {
                sex = sex.replace(" ", "");
            }
            String idcard = personList.get(i).getIdcard();
            if (StringUtils.isNotBlank(idcard)) {
                idcard = idcard.replace(" ", "");
            }
            if (StringUtils.isBlank(name) && StringUtils.isBlank(phone) && StringUtils.isBlank(sex) && StringUtils.isBlank(idcard)) {
                continue;
            }
            int sum = 0;
//                规定姓名格式
            if (StringUtils.isBlank(name)) {
                sum += 1;
                addTeacher.append(sum + "：姓名不能为空。<br>");
                flag = false;
            } else {
                if (name.length() < 2 || name.length() > 20) {
                    sum += 1;
                    addTeacher.append("姓名必须在2~20个字符之间。<br>");
                    flag = false;
                }
            }
//               规定手机号码
            if (StringUtils.isBlank(phone)) {
                sum += 1;
                addTeacher.append(sum + "：手机号不能为空。<br>");
                flag = false;
            } else {
                if (phone.length() != 11) {
                    sum += 1;
                    addTeacher.append(sum + "：[" + phone + "]手机号格式不正确,请填写正确的手机号。<br>");
                    flag = false;
                } else {
//                      根据手机号查询用户信息
                    YcUser ycUser = ycUserMapper.selectByPhone(phone);
//                     手机号被注册
                    if (RegexUtil.isNotNull(ycUser)) {
//                     不为删除状态
                        if (ycUser.getYc_delete() == 1) {
                            sum += 1;
                            addTeacher.append(sum + "：手机号[" + phone + "]已存在。<br>");
                            flag = false;
                        } else {//为删除状态
                            if (ycUser.getYc_role() == 1) {//为家长
                                sum += 1;
                                addTeacher.append(sum + "：手机号[" + phone + "]已为家长用户，无法注册。<br>");
                                flag = false;
                            }
                        }
                    }
                }
            }
//                规定身份证号
            if (StringUtils.isNotBlank(idcard)) {
                if (idcard.length() != 18) {
                    sum += 1;
                    addTeacher.append(sum + "：[" + idcard + "]身份证号格式不正确，请填写正确的身份证号。<br>");
                    flag = false;
                }
            }
            if (!flag) {//有错误操作则结束循环
                break;
            }
        }

        if (flag) {
            for (int i = 0; i < personList.size(); i++) {
                try {
//                            清除空格不报错
                    String name = personList.get(i).getName();
                    if (StringUtils.isNotBlank(name)) {
                        name = name.replace(" ", "");
                    }
                    String phone = personList.get(i).getPhone();
                    if (StringUtils.isNotBlank(phone)) {
                        phone = phone.replace(" ", "");
                    }
                    String sex = personList.get(i).getSex();
                    if (StringUtils.isNotBlank(sex)) {
                        sex = sex.replace(" ", "");
                    }
                    String idcard = personList.get(i).getIdcard();
                    if (StringUtils.isNotBlank(idcard)) {
                        idcard = idcard.replace(" ", "");
                    }
                    if (StringUtils.isBlank(name) && StringUtils.isBlank(phone) && StringUtils.isBlank(sex) && StringUtils.isBlank(idcard)) {
                        continue;
                    }
                    YcUser addUser = null;
                    YcUser ycUser = ycUserMapper.selectByPhone(phone);
                    if (RegexUtil.isNotNull(ycUser)) {//手机号被注册
                        ycUser.setYc_username(name);
                        if (StringUtils.isBlank(sex)) {
                            ycUser.setYc_gender(2);
                        } else {
                            if ("男".equals(sex)) {
                                ycUser.setYc_gender(1);
                            } else if ("女".equals(sex)) {
                                ycUser.setYc_gender(2);
                            } else {
                                ycUser.setYc_gender(2);
                            }
                        }
                        ycUser.setYc_phone(phone);
                        ycUser.setYc_idcard(idcard);
//                        地址不填
                        ycUser.setYc_province("");
                        ycUser.setYc_city("");
                        ycUser.setYc_district(ycSchool.getYc_district());
                        ycUser.setYc_district_name("");
                        ycUser.setYc_map_address(ycSchool.getYc_school_map_address());
                        ycUser.setYc_password(PasswordRandom.getStringRandom(6));
                        ycUser.setYc_password_encryption(new MD5Util().md5(ycUser.getYc_password() + Constants.SALT));
                        ycUser.setYc_login_time(new Date());
                        ycUser.setYc_founder(ycSchool.getId());
                        ycUser.setYc_delete(1);
                        //			修改用户部分信息
                        ycUserMapper.updateTeacherById(ycUser);
                        addUser = ycUser;
                    } else {//手机号没被注册
                        YcUser user = new YcUser();
                        user.setId(UUIDFactory.random());
                        user.setYc_username(name);
                        user.setYc_nickname(user.getYc_username());
                        if (StringUtils.isBlank(sex)) {
                            ycUser.setYc_gender(2);
                        } else {
                            if ("男".equals(sex)) {
                                user.setYc_gender(1);
                            } else if ("女".equals(sex)) {
                                user.setYc_gender(2);
                            } else {
                                user.setYc_gender(2);
                            }
                        }
                        user.setYc_phone(phone);
                        user.setYc_idcard(idcard);
//                              地址不填
                        user.setYc_province("");
                        user.setYc_city("");
                        user.setYc_district(ycSchool.getYc_district());
                        user.setYc_district_name("");
                        user.setYc_map_address(ycSchool.getYc_school_map_address());
                        user.setYc_password(PasswordRandom.getStringRandom(6));
                        user.setYc_password_encryption(new MD5Util().md5(user.getYc_password() + Constants.SALT));
                        user.setYc_role(2);
                        user.setYc_avatar(Constants.DEFAULTREGISTRAVAER);
                        user.setYc_introduction("");
                        user.setYc_carte("");
                        user.setYc_status("1");
                        user.setYc_login_time(new Date());
                        user.setYc_founder(ycSchool.getId());
                        user.setYc_delete(1);
                        user.setYc_wechat_appid("");
                        user.setYc_qq_unionid("");
                        user.setYc_alipay_appid("");
                        user.setYc_token("");
                        //usermodel 中 id name 头像
                        TokenResult register = RongCloudUtil.getRongcloud().user.register(
                                new UserModel(user.getId(), user.getYc_username(), user.getYc_avatar())
                        );
                        user.setYc_rongcloudtoken(register.getToken());
                        user.setYc_video_name("1");
                        user.setYc_allow_class("1");
                        user.setYc_allow_qrcode("1");
                        user.setYc_allow_address("1");
                        user.setYc_user_token("");
//			添加用户信息
                        ycUserMapper.insertUser(user);
                        addUser = user;
                    }
                    //			添加教师科目管理表数据
//                YcTeacherManagement ycTeacherManagement = new YcTeacherManagement();
//                ycTeacherManagement.setYc_teacher_information_id(UUIDFactory.random());
//                ycTeacherManagement.setId(addUser.getId());
//                ycTeacherManagement.setYc_teacher_informati_position(2);//职务 teacher.getPosition()
//                ycTeacherManagement.setYc_subject_management_id("");//科目唯一标识暂时为空
//                ycTeacherManagementMapper.insertTeacherManagement(ycTeacherManagement);

                    //           给用户发短信告知用户密码
                    ismsService.passwordSend(addUser.getYc_phone(), addUser.getYc_password());
                } catch (Exception e) {
                    e.printStackTrace();
                    return "发生异常，批量添加教师失败";
                }
            }
            return "批量添加教师成功";
        } else {
            return "批量添加教师失败：<br>" + addTeacher;
        }
    }

    /**
     * 通过学校id查询教师
     */
    @Override
    public Page getTeacherBySchoolid(String id, Integer currentPage, Integer pageSize, String ycusername) {

        try {
            //		            分页
            PageHelper.startPage(currentPage, pageSize);
            List<YcUser> ycUser = ycUserMapper.selectByfounder(id);
            if (ycUser == null) {
                return new Page(0, "", 0, null);
            } else {
                for (YcUser user : ycUser) {
                    //		合并省市区（地址）
                    String address = "";
                    if (StringUtils.isNotBlank(user.getYc_province())) {
                        address += user.getYc_province();
                    }
                    if (StringUtils.isNotBlank(user.getYc_city())) {
                        address += "-" + user.getYc_city() + "-";
                    }
                    if (StringUtils.isNotBlank(user.getYc_district_name())) {
                        address += user.getYc_district_name();
                    }
                    user.setYc_province(address);
                }
                //		        如果搜索条件不为空（按姓名查询）
                if (StringUtils.isNotBlank(ycusername)) {
                    List<YcUser> users = new ArrayList<>();
                    for (YcUser user : ycUser) {
                        if (user.getYc_username().contains(ycusername)) {
                            users.add(user);
                        }
                    }
                    ycUser = users;
                }
            }
            PageInfo<YcUser> pageInfo = new PageInfo<>(ycUser);
            return new Page(0, "", (int) pageInfo.getTotal(), pageInfo.getList());//状态码，内容，总记录数，数据集
        } catch (Exception e) {
            e.printStackTrace();
            return new Page(0, "", 0, null);
        }
    }

    /**
     * 删除教师信息（仅将删除状态修改为不展示）
     */
    @Override
    public JacksonData deleteTeacherById(String teacherId) {
//        根据班主任id查询班级信息
        List<YcClass> headTeahcerById = ycClassMapper.findHeadTeahcerById(teacherId);

        if (!headTeahcerById.isEmpty()) {//		是班主任
            return ResultUtil.error(204, YcTeacherConstants.DELTEACHER);
        } else {//不是班主任
            try {
                List<YcParentClass> ycParentClass = parentClassMapper.findByParentId(teacherId);
                for (YcParentClass parentClass : ycParentClass) {
                    parentClass.setYc_permission_status(4);//已离职教师
                    parentClassMapper.delTeacher(parentClass.getId());//修改权限
                }
                ycUserMapper.deleteTeacherById(teacherId);
                return ResultUtil.success();
            } catch (Exception e) {
                e.printStackTrace();
                return ResultUtil.error(204, YcTeacherConstants.FAILURE);
            }

        }

    }

    /**
     * 通过id查询用户信息
     *
     * @throws Exception
     */
    @Override
    public YcUser getUserById(String id) {
//		查询用户信息
        return ycUserMapper.getUserById(id);
    }

    /**
     * 修改教师信息
     *
     * @throws Exception
     */
    @Override
    public JacksonData updateTeacherUser(YcUser user) {
        try {
            //		查询此用户的全部信息
            YcUser ycuser = ycUserMapper.getUserById(user.getId());
            //判断手机号是否已存在
            if (!ycuser.getYc_phone().equals(user.getYc_phone())) {
                YcUser ycUser = ycUserMapper.selectByPhone(user.getYc_phone());
                if (RegexUtil.isNotNull(ycUser)) {
                    return ResultUtil.error(204, YcTeacherConstants.PHONEEXISTED);
                }
            }
            //		替换为页面信息
            ycuser.setYc_username(user.getYc_username());
            ycuser.setYc_nickname(user.getYc_nickname());
            //        如果昵称为空，则为用户名
            if (StringUtils.isBlank(user.getYc_nickname())) {
                ycuser.setYc_nickname(user.getYc_username());
            }
            ycuser.setYc_gender(user.getYc_gender());
            ycuser.setYc_phone(user.getYc_phone());
            ycuser.setYc_idcard(user.getYc_idcard());

//		修改用户属性
            ycUserMapper.updateTeacherById(ycuser);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(204, YcTeacherConstants.FAILURE);
        }

    }


}
