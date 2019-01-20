package yc.xuezhifan.schoolbackstage.schoolfeature.controller;

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
import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcSchoolFeatureStatus;
import yc.xuezhifan.schoolbackstage.schoolfeature.service.IYcSchoolFeatureStatusService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

/**
 * 
 * <p>
 * Title: YcSchoolFeatureStatusController.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年11月2日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年11月2日
 * 
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/featureStatus")
public class YcSchoolFeatureStatusController {

	private static final Logger logger = LoggerFactory.getLogger(YcCertificationController.class);

	@Autowired
	private IYcSchoolFeatureStatusService iYcSchoolFeatureStatusService;

	/**
	 * 开通学校功能 (推广,微校)
	 * 
	 * @param ycSchool
	 * @param ycSchoolFeatureStatus
	 * @param result
	 * @param yc_feature_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addSchoolCircle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcSchoolFeatureStatus> addSchoolCircle(@CurrentSchool YcSchool ycSchool,
			@Valid YcSchoolFeatureStatus ycSchoolFeatureStatus, BindingResult result, String yc_feature_id) {
		// 判断参数是否正确
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError objectError : errors) {
				// 参数错误信息写入日志文件
				logger.debug("错误码:" + objectError.getCode() + "~~message:" + objectError.getDefaultMessage() + "~~~"
						+ objectError.getObjectName());
			}
			return ResultUtil.error(201, YcSchoolConstants.PARAMETER_ERROR);
		}
		// 判断是否登录
		if (RegexUtil.isNull(ycSchool)) {
			return ResultUtil.error(202, YcSchoolConstants.NOLOGIN);
		}
		// 添加学校唯一标示
		ycSchoolFeatureStatus.setYc_school_id(ycSchool.getId());
		// 设置功能唯一标示
		ycSchoolFeatureStatus.setYc_feature_id(yc_feature_id);
		// 得到添加结果并处理
		String rs = iYcSchoolFeatureStatusService.insert(ycSchoolFeatureStatus);
		if (RegexUtil.isNotNull(rs) && YcSchoolConstants.SUCCESS.equals(rs)) {
			return ResultUtil.success();
		}
		return ResultUtil.error(204, rs);
	}

	/**
	 * 根据学校查询所有已开通功能
	 * 
	 * @param ycSchool
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findBySchool", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcSchoolFeatureStatus> findBySchool(@CurrentSchool YcSchool ycSchool,
			@RequestParam(defaultValue = "1") Integer currentPage,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		// 判断是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (null == currentPage || null == pageSize) {
				return ResultUtil.error(201, YcSchoolConstants.PARAMETER_ERROR);
			}
			// 得到查询结果并处理
			PageInfo<YcSchoolFeatureStatus> pageInfo = iYcSchoolFeatureStatusService.selectBySchool(ycSchool.getId(),
					currentPage, pageSize);
			if (RegexUtil.isNotNull(pageInfo)) {
				return ResultUtil.success(pageInfo);
			}
			return ResultUtil.error(203, YcSchoolConstants.NODATA);
		}
		return ResultUtil.error(202, YcSchoolConstants.NOLOGIN);
	}

}
