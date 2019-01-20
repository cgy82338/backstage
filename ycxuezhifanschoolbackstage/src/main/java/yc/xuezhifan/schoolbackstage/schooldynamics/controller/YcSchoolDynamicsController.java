package yc.xuezhifan.schoolbackstage.schooldynamics.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schooldynamics.bean.YcSchoolDynamics;
import yc.xuezhifan.schoolbackstage.schooldynamics.service.IYcSchoolDynamicsService;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

/**
 * 
 * <p>
 * Title: YcSchoolDynamicsController.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年11月5日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年11月5日
 * 
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/schoolDynamics")
public class YcSchoolDynamicsController {

	private static final Logger logger = LoggerFactory.getLogger(YcSchoolDynamicsController.class);

	@Autowired
	private IYcSchoolDynamicsService iYcSchoolDynamicsService;

	/**
	 * 发布学校动态
	 * 
	 * @param ycSchool
	 * @param ycSchoolDynamics
	 * @param result
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addSchoolDynamics", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData addSchoolDynamics(@CurrentSchool YcSchool ycSchool,
			@Valid YcSchoolDynamics ycSchoolDynamics, BindingResult result) {
		// 验证参数是否有误
		if (result.hasErrors()) {
			List<ObjectError> error = result.getAllErrors();
			for (ObjectError objectError : error) {
				// 参数错误信息写入日志文件
				logger.debug("错误码：" + objectError.getCode() + "~~message:" + objectError.getDefaultMessage() + "~~~"
						+ objectError.getObjectName());
			}
			return ResultUtil.error(201, YcSchoolConstants.PARAMETER_ERROR);
		}
		// 判断是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 设置发布学校
			ycSchoolDynamics.setYc_school_dynamics_school(ycSchool.getId());
		}
		// 得到添加结果并处理
		return iYcSchoolDynamicsService.insert(ycSchoolDynamics);
	}

	/**
	 * 根据学校查询所有学校动态
	 * 
	 * @param ycSchool
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findBySchool",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public Page findBySchool(@CurrentSchool YcSchool ycSchool,
							 @RequestParam(defaultValue = "1") Integer currentPage,
							 @RequestParam(defaultValue = "10") Integer pageSize) {
			// 得到查询结果并处理
			return iYcSchoolDynamicsService.findBySchool(ycSchool.getId(), currentPage,
					pageSize);
	}

	/**
	 * 根据id查询动态
	 * 
	 * @param ycSchool
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findById", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcSchoolDynamics> findById(@CurrentSchool YcSchool ycSchool, String id) {
		// 判断是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(id)) {
				// 得到查询结果并处理
				YcSchoolDynamics ycSchoolDynamics = iYcSchoolDynamicsService.selectById(id, ycSchool.getId());
				if (RegexUtil.isNotNull(ycSchoolDynamics)) {
					return ResultUtil.success(ycSchoolDynamics);
				}
				return ResultUtil.error(203, YcSchoolConstants.NODATA);
			}
			return ResultUtil.error(201, YcSchoolConstants.PARAMETER_ERROR);
		}
		return ResultUtil.error(202, YcSchoolConstants.NOLOGIN);
	}

	/**
	 * 删除动态
	 * 
	 * @param ycSchool
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteSchoolDynamics", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcSchoolDynamics> deleteSchoolDynamics(@CurrentSchool YcSchool ycSchool, String id) {
		// 判断是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(id)) {
				// 得到查询结果并处理
				String rs = iYcSchoolDynamicsService.delete(id, ycSchool.getId());
				if (RegexUtil.isNotNull(rs) && YcSchoolConstants.SUCCESS.equals(rs)) {
					return ResultUtil.success();
				}
				return ResultUtil.error(204, rs);
			}
			return ResultUtil.error(201, YcSchoolConstants.PARAMETER_ERROR);
		}
		return ResultUtil.error(202, YcSchoolConstants.NOLOGIN);
	}

	/**
	 * 根据id查询动态内容详情
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectDetail")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public String selectDetail(@CurrentSchool YcSchool ycSchool, String id) {
		YcSchoolDynamics ycSchoolDynamics = iYcSchoolDynamicsService.selectById(id, ycSchool.getId());
		if (ycSchoolDynamics == null){
			return "<h2 align='center'>暂无内容</h2>";
		}else {
			return ycSchoolDynamics.getYc_school_dynamics_detail();
		}
	}
}
