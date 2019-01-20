package yc.xuezhifan.schoolbackstage.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yc.xuezhifan.schoolbackstage.active.bean.YcActivity;
import yc.xuezhifan.schoolbackstage.active.bean.YcActivityApplicant;
import yc.xuezhifan.schoolbackstage.active.mapper.YcActivityApplicantMapper;
import yc.xuezhifan.schoolbackstage.active.mapper.YcActivityMapper;
import yc.xuezhifan.schoolbackstage.active.vo.YcActivityVo;
import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.protocol.mapper.YcProtocolMapper;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.school.mapper.YcSchoolMapper;
import yc.xuezhifan.schoolbackstage.schooldynamics.bean.YcSchoolDynamics;
import yc.xuezhifan.schoolbackstage.schooldynamics.mapper.YcSchoolDynamicsMapper;
import yc.xuezhifan.schoolbackstage.schoolprofile.bean.YcSchoolProfile;
import yc.xuezhifan.schoolbackstage.schoolprofile.mapper.YcSchoolProfileMapper;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: WebController.java </p>
 *
 * <p>Description: 页面转发</p>
 *
 * <p>Copyright: Copyright (c) 2018年12月18日</p>
 *
 * @author xiaoyu
 * @version 1.0
 * @email xiaoyu@xuezhifan.com
 * @date 2018年12月18日
 */
@Controller
@RequestMapping("/school")
public class WebController {

    @Autowired
    private YcUserMapper ycUserMapper;

    @Autowired
    private YcSchoolMapper schoolMapper;

    @Autowired
    private YcSchoolDynamicsMapper schoolDynamicsMapper;

    @Autowired
    private YcActivityMapper ycActivityMapper;

    @Autowired
    private YcActivityApplicantMapper ycActivityApplicantMapper;

    @Autowired
    private YcSchoolProfileMapper ycSchoolProfileMapper;


    // 登录页*
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(HttpServletRequest request) {
        return new ModelAndView("/user/login");
    }

    // 首页*
    @RequestMapping("/index")
    @SchoolLogin
    public ModelAndView showIndex(HttpServletRequest request) {
        return new ModelAndView("/index");
    }

    // 控制台内容*
    @RequestMapping("console")
    public ModelAndView console() {
        return new ModelAndView("/home/console");
    }

    // 忘记密码*
    @RequestMapping("forget")
    public ModelAndView forget() {
        return new ModelAndView("/user/forget");
    }

    // 发布通知*
    @RequestMapping("/insertSchoolNotice")
    public ModelAndView insertSchoolNotice() {
        return new ModelAndView("/school/school_notice/insert_school_notice");
    }

    // 学校历史通知*
    @RequestMapping("/schoolNotice")
    public ModelAndView schoolNotice() {
        return new ModelAndView("/school/school_notice/school_notice");
    }

    // 发布学校动态*
    @RequestMapping("/insertSchoolDynamic")
    public ModelAndView insertSchoolDynamic() {
        return new ModelAndView("/school/school_dynamic/insert_school_dynamic");
    }

    // 学校历史动态*
    @RequestMapping("/schoolDynamic")
    @SchoolLogin
    public ModelAndView schoolDynamic(@CurrentSchool YcSchool ycSchool, Model model) {
        List<YcSchoolDynamics> school = schoolDynamicsMapper.findBySchool(ycSchool.getId());
        if (school.isEmpty()) {
            model.addAttribute("msg", "暂无内容");
        } else {
            model.addAttribute("dynamicsList", school);
            model.addAttribute("username", schoolMapper.selectById(ycSchool.getId()).getYc_school_principal());
        }
        return new ModelAndView("/school/school_dynamic/school_dynamic");
    }

    // 系统通知*
    @RequestMapping("/schoolnotification")
    public ModelAndView schoolnotification() {
        return new ModelAndView("/school/school_notification");
    }

    //  发布校园活动
    @RequestMapping("/insertSchoolActivity")
    public String insertSchoolActivity() {
        return "/school/school_activity/insert_school_activity";
    }

    //  校园活动历史
    @RequestMapping("/schoolActivity")
    public String schoolActivity(Model model) {
        List<YcActivity> list = ycActivityMapper.selectByType(3);
        if (list.isEmpty()) {
            model.addAttribute("msg", "暂无内容");
        } else {
            List<YcActivityVo> activitys = new ArrayList<>();
            for (YcActivity ycActivity : list) {
                YcActivityVo ycActivityVo = new YcActivityVo();
                ycActivityVo.setId(ycActivity.getId());
                ycActivityVo.setActivity_title(ycActivity.getYc_activity_title());//活动名称
                ycActivityVo.setActivity_cover_image(ycActivity.getYc_activity_cover_image());//封面图片
                ycActivityVo.setActivity_people_number(ycActivity.getYc_activity_people_number());//名额
                ycActivityVo.setActivity_single_fee(ycActivity.getYc_activity_single_fee());//活动费用
                ycActivityVo.setActivity_sponsor(schoolMapper.selectById(ycActivity.getYc_activity_sponsor()).getYc_school_principal());//发起人
                if (ycActivity.getYc_sponsor_type() == 1) {//发起人类型
                    ycActivityVo.setSponsor_type("总公司");
                } else if (ycActivity.getYc_sponsor_type() == 2) {
                    ycActivityVo.setSponsor_type("分公司");
                } else if (ycActivity.getYc_sponsor_type() == 3) {
                    ycActivityVo.setSponsor_type("学校");
                } else if (ycActivity.getYc_sponsor_type() == 4) {
                    ycActivityVo.setSponsor_type("教师");
                }
                List<YcActivityApplicant> applicants = ycActivityApplicantMapper.selectByActivityId(ycActivity.getId());
                if (applicants == null) {//已报名人数
                    ycActivityVo.setActivity_people_number_yes(0);
                } else {
                    Integer sum = 0;
                    for (int i = 0; i < applicants.size(); i++) {
                        sum += applicants.get(i).getYc_activity_people_number();
                    }
                    ycActivityVo.setActivity_people_number_yes(sum);
                }
                activitys.add(ycActivityVo);
            }
            model.addAttribute("activitys", activitys);
        }
        return "/school/school_activity/school_activity";
    }

    //    调用地图
    @RequestMapping("/toMap")
    public ModelAndView toMap() {
        return new ModelAndView("/school/school_activity/eventMap");

    }

    // 查看本校教师*
    @RequestMapping("/schoolteachershow")
    public String schoolteachershow() {
        return "/school_teacher/school_teacher_show";
    }

    //  添加教师
    @RequestMapping("/schoolteacherinsert")
    public String schoolteacherinsert() {
        return "/school_teacher/school_teacher_insert";
    }

    //   批量添加教师
    @RequestMapping("/schoolteacherinserts")
    public String schoolteacherinserts() {
        return "/school_teacher/school_teacher_inserts";
    }


    //    查看本校班级*
    @RequestMapping("/schoolclassshow")
    public String schoolclassshow() {
        return "/school_class/school_class_show";
    }


    //    创建新班级*
    @RequestMapping("/schoolclassinsert")
    @SchoolLogin
    public String schoolclassinsert(@CurrentSchool YcSchool ycSchool, Model model) {
        List<YcUser> teacher = ycUserMapper.selectByfounder(ycSchool.getId());
        model.addAttribute("teachers", teacher);
        return "/school_class/school_class_insert";
    }

    //    创建新班级*
    @RequestMapping("/schoolclassinserts")
    public String schoolclassinserts() {
        return "/school_class/school_class_inserts";
    }


    //    账号资料*
    @RequestMapping("/schoolinformationdata")
    @SchoolLogin
    public String schoolinformationdata(@CurrentSchool YcSchool ycSchool, Model model) {
        YcSchool school = schoolMapper.selectById(ycSchool.getId());
        model.addAttribute("school", school);
        return "/school_information/school_information_data";
    }

    //    账号资料修改省市区*
    @RequestMapping("/dataAll")
    @SchoolLogin
    public String citypicker(String phone, String address, Model model) {
        model.addAttribute("phone", phone);
        model.addAttribute("address", address.replace("-", "/"));
        return "/school_information/dataAll";
    }

    //    账号资料修改头像*
    @RequestMapping("/data")
    public String upavator(String schoolimg, String schoolname, Model model) {
        model.addAttribute("schoolimg", schoolimg);
        model.addAttribute("schoolname", schoolname);
        return "/school_information/data";
    }

    //    修改密码*
    @RequestMapping("/schoolinformationpassword")
    public String schoolinformationpassword() {
        return "/school_information/school_information_password";
    }

    //    意见反馈*
    @RequestMapping("/schoolinformationfeedback")
    public String schoolinformationfeedback() {
        return "/school_information/school_information_feedback";
    }

    //    用户协议*
    @RequestMapping("/schoolinformationagreement")
    public String schoolinformationagreement() {
        return "/school_information/school_information_agreement";
    }

    //    使用帮助*
    @RequestMapping("/schoolinformationhelp")
    public String schoolinformationhelp() {
        return "/school_information/school_information_help";
    }


    //暂通模块
    @RequestMapping("/schooltoo")
    public String schooltoo() {
        return "school_notification";
    }

    //  发布共享文件*
    @RequestMapping("/fileShared_add")
    public String fileShared_add() {
        return "/fileShared/fileShared_add";
    }

    //  共享文件列表*
    @RequestMapping("/fileShared_list")
    public String fileShared_list() {
        return "/fileShared/fileShared_list";
    }

    //  添加学校简介
    @RequestMapping("/addProfile")
    @SchoolLogin
    public String addProfile() {
        return "/school_profile/addprofile";
    }

    //  查看学校简介*
    @RequestMapping("/profileshow")
    @SchoolLogin
    public String schoolprofile(@CurrentSchool YcSchool ycSchool, Model model) {
        YcSchoolProfile profile = ycSchoolProfileMapper.selectByAll(ycSchool.getId());
        model.addAttribute("profile", profile);
        return "/school_profile/profileshow";
    }

    //  推广*
    @RequestMapping("/generalize")
    public String generalize(){
        return "/microschoolManage/generalize";
    }
    //  微校*
    @RequestMapping("/microschool")
    public String microschool(){
        return "/microschoolManage/microschool";
    }
    //  专属客服*
    @RequestMapping("/customer")
    public String customer(){
        return "/microschoolManage/customer";
    }
    //  认证*
    @RequestMapping("/certification")
    public String certification(){
        return "/microschoolManage/certification";
    }
//  推广支付成功页面
    @RequestMapping("/success")
    public String success(){
        return "/microschoolManage/success";
    }
}

