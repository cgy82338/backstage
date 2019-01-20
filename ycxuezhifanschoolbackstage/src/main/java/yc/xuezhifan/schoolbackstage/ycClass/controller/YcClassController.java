package yc.xuezhifan.schoolbackstage.ycClass.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.JdbcRowSet;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcClassConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClass;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcIntermediateTable;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcParentClass;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcClassMapper;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcParentClassMapper;
import yc.xuezhifan.schoolbackstage.ycClass.service.YcClassService;
import yc.xuezhifan.schoolbackstage.ycClass.vo.YcClassVo;

/**
 * <p>Title: YcClassController.java </p>
 *
 * <p>Description: 班级管理Controller</p>
 *
 * <p>Copyright: Copyright (c) 2018年10月9日</p>
 *
 * @author zhuangzhuang
 * @version 1.0
 * @email zhuangzhuang@xuezhifan.com
 * @date 2018年10月9日
 */
@Controller
@RequestMapping("/class")
public class YcClassController {
    private static final Logger logger = LoggerFactory.getLogger(YcClassController.class);

    @Autowired
    YcClassService ycClassService;

    /**
     * <p>
     * Title: saveClass
     * </p>
     *
     * <p>
     * Description: 创建班级信息
     * </p>
     *
     * @param ycClassVo
     * @return
     * @email xiaoyu@xuezhifan.com
     * @author xiaoyu
     * @date 2019年1月7日
     */

    @RequestMapping(value = "/saveClass",method = RequestMethod.POST)
    @ResponseBody
    @SchoolLogin
    public JacksonData insertClass(@CurrentSchool YcSchool ycSchool, YcClassVo ycClassVo){
        // 验证用户是否存在
        if (null == ycSchool) {
            return ResultUtil.error(202, YcClassConstants.NOlOGIN);
        }
        return ycClassService.saveClass(ycSchool,ycClassVo);
    }


    /**
     * <p>
     * Title: updateClass
     * </p>
     *
     * <p>
     * Description: 修改班级信息
     * </p>
     *
     * @param ycSchool
     * @param ycClassVo
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月22日
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/updateClass")
    @ResponseBody
    @SchoolLogin
    public JacksonData updateClass(@CurrentSchool YcSchool ycSchool, YcClassVo ycClassVo) {
        // 验证用户是否登录
        if (null == ycSchool) {
            return ResultUtil.error(202, YcClassConstants.NOlOGIN);
        }

        return ycClassService.updateClass(ycSchool,ycClassVo);
    }

    /**
     * <p>
     * Title: getClass
     * </p>
     *
     * <p>
     * Description: 查询本学校班级信息
     * </p>
     *
     * @param ycusername
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年9月22日
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getClassByschoolid", method = RequestMethod.POST)
    @ResponseBody
    @SchoolLogin
    public Page getClassByschoolid(@CurrentSchool YcSchool ycSchool, String ycusername,

                                   @RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize) {
        // 验证用户是否登录
        if (null == ycSchool) {
            return new Page(0, "", 0, null);
        }
        return ycClassService.getClassByschoolid(ycSchool.getId(), currentPage, pageSize, ycusername);
    }

    /**
     * <p>Title: getClassByClassId</p>
     *
     * <p>Description: 根据班级Id查询</p>
     *
     * @param ycSchool
     * @param classId
     * @return
     * @email zhuangzhuang@xuezhifan.com
     * @author zhuangzhuang
     * @date 2018年11月2日
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/getClassByClassId")
    @ResponseBody
    @SchoolLogin
    public JacksonData<YcClass> getClassByClassId(@CurrentSchool YcSchool ycSchool, String classId) {
        // 验证用户是否登录
        if (null == ycSchool) {
            return ResultUtil.error(202, YcClassConstants.NOlOGIN);
        }

        YcClass ycClass = ycClassService.getClassByClassId(classId);
        if (RegexUtil.isNotNull(ycClass)) {
            return ResultUtil.success(ycClass);
        }
        return ResultUtil.error(203, YcClassConstants.NODATA);
    }


    /**
     * <p>Title: schoolclassopen</p>
     *
     * <p>Description: 修改班级（弹窗）</p>
     *
     * @param id
     * @return
     * @email xiaoyu@xuezhifan.com
     * @author xiaoyu
     * @date 2018年12月29日
     */
    @RequestMapping("/schoolclassopen")
    @SchoolLogin
    public String schoolclassopen(@CurrentSchool YcSchool ycSchool, String id, Model model) {
        //		班级信息
        YcClass aclass = ycClassService.getClassByClassId(id);
        //		本校教师信息
        List<YcUser> teacherList = ycClassService.findUserBySchoolId(ycSchool.getId());
//        任课教师信息
        List<YcIntermediateTable> teachers = ycClassService.findClassTeacher(id);
        List<YcUser> users = new ArrayList<>();
//        其他教师信息
        List<YcUser> teacherOthers = ycClassService.findUserBySchoolId(ycSchool.getId());

        for (int i = 0; i < teachers.size(); i++) {
            YcUser user = ycClassService.findUserById(teachers.get(i).getYc_teacher_information_id());
            users.add(user);
            //            其他教师信息（相同教师剔除）
            for (int j = 0; j < teacherOthers.size(); j++) {
                if (teacherOthers.get(j).getId().equals(user.getId())) {
                    teacherOthers.remove(teacherOthers.get(j));
                }
            }

        }
        model.addAttribute("aclass", aclass);//班级信息
        model.addAttribute("teacherList", teacherList);//全校教师信息
        model.addAttribute("teacherOthers", teacherOthers);//其他教师信息
        model.addAttribute("teachers", users);//任课教师信息
        return "/school_class/school_class_open";
    }


}
