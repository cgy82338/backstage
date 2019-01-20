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
import org.springframework.web.bind.annotation.ResponseBody;

import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcCertification;
import yc.xuezhifan.schoolbackstage.schoolfeature.service.IYcCertificationService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

/**
 * 
 * <p>
 * Title: YcCertificationController.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年10月3日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年10月3日
 * 
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/certification")
public class YcCertificationController {

	private static final Logger logger = LoggerFactory.getLogger(YcCertificationController.class);

	@Autowired
	private IYcCertificationService iYcCertificationService;

	/**
	 * 添加认证
	 * 
	 * @param ycCertification
	 * @param result
	 * @return
	 */
	@ResponseBody
	@SchoolLogin
	@RequestMapping(value = "/addCertification", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SuppressWarnings("unchecked")
	public JacksonData<YcCertification> addCertification(@CurrentSchool YcSchool ycSchool,
			@Valid YcCertification ycCertification, BindingResult result, String yc_feature_id) {
		//判断参数是否正确
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
		// 得到添加结果并处理
		String rs = iYcCertificationService.insert(ycCertification, ycSchool.getId(), yc_feature_id);
		if (RegexUtil.isNotNull(rs) && rs.equals(YcSchoolConstants.SUCCESS)) {
			return ResultUtil.success();
		} else {
			return ResultUtil.error(203, rs);
		}
	}

	/**
	 * 修改认证信息
	 * @param ycSchool
	 * @param ycCertification
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateCertification", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcCertification> updateCertification(@CurrentSchool YcSchool ycSchool,
			YcCertification ycCertification) {
		// 判断是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(ycCertification) && RegexUtil.isNotNull(ycCertification.getYc_certification_id())) {
				// 得到修改结果并处理
				String rs = iYcCertificationService.update(ycCertification);
				if (RegexUtil.isNotNull(rs) && rs.equals(YcSchoolConstants.SUCCESS)) {
					return ResultUtil.success();
				}
				return ResultUtil.error(203, rs);
			}
			return ResultUtil.error(201, YcSchoolConstants.PARAMETER_ERROR);
		}
		return ResultUtil.error(202, YcSchoolConstants.NOLOGIN);
	}
}
