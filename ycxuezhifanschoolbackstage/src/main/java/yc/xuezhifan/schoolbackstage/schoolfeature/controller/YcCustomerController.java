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
import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcCustomerService;
import yc.xuezhifan.schoolbackstage.schoolfeature.service.IYcCustomerService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

/**
 * 
 * <p>
 * Title: YcCustomerController.java
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
@RequestMapping("/customer")
public class YcCustomerController {

	private static final Logger logger = LoggerFactory.getLogger(YcCustomerController.class);

	@Autowired
	private IYcCustomerService iYcCustomerService;

	/**
	 * 添加专属客服
	 * 
	 * @param ycCustomerService
	 * @param result
	 * @return
	 */
	@ResponseBody
	@SchoolLogin
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SuppressWarnings("unchecked")
	public JacksonData<YcCustomerService> addCustomer(@CurrentSchool YcSchool ycSchool,
			@Valid YcCustomerService ycCustomerService, BindingResult result, String yc_feature_id) {
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
		String rs = iYcCustomerService.insert(ycCustomerService, ycSchool.getId(), yc_feature_id);
		if (RegexUtil.isNotNull(rs) && rs.equals(YcSchoolConstants.SUCCESS)) {
			return ResultUtil.success();
		} else {
			return ResultUtil.error(203, rs);
		}
	}

	/**
	 * 修改客服信息
	 * 
	 * @param ycSchool
	 * @param ycCustomerService
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcCustomerService> updateCustomer(@CurrentSchool YcSchool ycSchool,
			YcCustomerService ycCustomerService) {
		// 判断是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(ycCustomerService) && RegexUtil.isNotNull(ycCustomerService.getId())) {
				// 得到修改结果并处理
				String rs = iYcCustomerService.update(ycCustomerService);
				if (RegexUtil.isNotNull(rs) && rs.equals(YcSchoolConstants.SUCCESS)) {
					return ResultUtil.success();
				} else {
					return ResultUtil.error(203, rs);
				}
			}
		}
		return ResultUtil.error(202, YcSchoolConstants.NOLOGIN);
	}

}
