package yc.xuezhifan.schoolbackstage.active.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivityApplicant;
import yc.xuezhifan.schoolbackstage.active.service.YcActivityApplicantService;
import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.ActivityConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

import java.util.List;

/**
 * <p>
 * Title: YcActivityApplicantController.java
 * </p>
 *
 * <p>
 * Description: 活动报名人表
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2018年9月5日
 * </p>
 *
 * @author xiaoxiao
 * @version 1.0
 * @email xiaoxiao@xuezhifan.com
 * @date 2018年9月5日
 */

@Controller
@RequestMapping("/ycActivityApplicant")
public class YcActivityApplicantController {

    @Autowired
    private YcActivityApplicantService ycActivityApplicantService;

    /**
     * <p>
     * Title: selectByActivityId
     * </p>
     *
     * <p>
     * Description: 根据活动id得到报名人信息
     * </p>
     *
     * @param id
     * @param yc_activity_id
     * @return
     * @email xiaoxiao@xuezhifan.com
     * @author xiaoxiao
     * @date 2018年9月6日
     */
    @SuppressWarnings("unchecked")
    @SchoolLogin
    @ResponseBody
    @RequestMapping(value = "/selectByActivityId", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public JacksonData<YcActivityApplicant> selectByActivityId(@CurrentSchool YcSchool ycSchool, String yc_activity_id,
                                                               Integer currentPage, Integer pageSize) {
        // 判断管理员是否登录
        if (RegexUtil.isNull(ycSchool)) {
            return ResultUtil.error(202, ActivityConstants.NOlOGIN);
        }
        // 判断参数是否有误
        if (null == currentPage || null == pageSize || RegexUtil.isNull(yc_activity_id)) {
            return ResultUtil.error(201, ActivityConstants.PARAMETER_ERROR);
        }
        // 得到查询结果并处理
        PageInfo<YcActivityApplicant> byActivityId = ycActivityApplicantService.selectByActivityId(yc_activity_id,
                currentPage, pageSize);
        if (RegexUtil.isNotNull(byActivityId)) {
            return ResultUtil.success(byActivityId);
        }
        return ResultUtil.error(203, ActivityConstants.NODATA);
    }

    /**
     * <p>
     * Title: selectByAId
     * </p>
     *
     * <p>
     * Description: 根据 id 得到报名人信息
     * </p>
     *
     * @param id
     * @return
     * @email xiaoxiao@xuezhifan.com
     * @author xiaoxiao
     * @date 2018年9月6日
     */
    @SuppressWarnings("unchecked")
    @SchoolLogin
    @ResponseBody
    @RequestMapping(value = "/selectByAId", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public JacksonData<YcActivityApplicant> selectByAId(@CurrentSchool YcSchool ycSchool, String id) {
        // 判断管理员是否登录
        if (RegexUtil.isNull(ycSchool)) {
            return ResultUtil.error(202, ActivityConstants.NOlOGIN);
        }
        // 判断参数是否正确
        if (RegexUtil.isNull(id)) {
            return ResultUtil.error(201, ActivityConstants.PARAMETER_ERROR);
        }
        // 得到查询结果并处理
        YcActivityApplicant byActivityId = ycActivityApplicantService.selectByAId(id);
        if (RegexUtil.isNotNull(byActivityId)) {
            return ResultUtil.success(byActivityId);
        }
        return ResultUtil.error(203, ActivityConstants.FAILURE);
    }

    /**
     * 根据id删除
     *
     * @param YcSchool
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @SchoolLogin
    @SuppressWarnings("unchecked")
    public JacksonData<YcActivityApplicant> deleteById(@CurrentSchool YcSchool ycSchool, String id) {
        // 判断管理员是否登录
        if (RegexUtil.isNotNull(ycSchool)) {
            // 判断参数是否正确
            if (RegexUtil.isNotNull(id)) {
                // 得到删除结果并处理
                String rs = ycActivityApplicantService.deleteActivityApplicant(id);
                if (RegexUtil.isNotNull(rs) && ActivityConstants.SUCCESS.equals(rs)) {
                    return ResultUtil.success();
                }
                return ResultUtil.error(20, rs);
            }
            return ResultUtil.error(201, ActivityConstants.PARAMETER_ERROR);
        }
        return ResultUtil.error(202, ActivityConstants.NODATA);
    }

    @Autowired
    YcUserMapper ycUserMapper;

    /**
     * <p>
     * Title: schoolactivityopen
     * </p>
     *
     * <p>
     * Description: 查看报名信息弹窗
     * </p>
     *
     * @param id
     * @return
     * @email xiaoyu@xuezhifan.com
     * @author xiaoyu
     * @date 2019年1月14日
     */
    @SuppressWarnings("unchecked")
    @SchoolLogin
    @RequestMapping(value = "/schoolactivityopen")
    public String schoolactivityopen(@CurrentSchool YcSchool ycSchool, String id, Model model) {

        List<YcActivityApplicant> applicants = ycActivityApplicantService.selectByActivityIds(id);
        if (applicants.isEmpty()){
            model.addAttribute("msg", "暂无内容");
        }else {
            for (int i = 0; i < applicants.size(); i++) {
                applicants.get(i).setYc_activity_applicant_id(ycUserMapper.selectById(applicants.get(i).getYc_activity_applicant_id()).getYc_id().toString());
            }
            model.addAttribute("applicants", applicants);
        }

        return "/school/school_activity/school_activity_open";

    }

}
