package yc.xuezhifan.schoolbackstage.advertising.controller;

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

import yc.xuezhifan.schoolbackstage.advertising.bean.YcVideoAds;
import yc.xuezhifan.schoolbackstage.advertising.service.IYcVideoAdService;
import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcAdvertisingSpaceConstants;
import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

/**
 * 
 * <p>
 * Title: YcVideoAdController.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年10月27日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年10月27日
 * 
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/videoAd")
public class YcVideoAdController {

	private static final Logger logger = LoggerFactory.getLogger(YcVideoAdController.class);

	@Autowired
	private IYcVideoAdService iYcVideoAdService;

	/**
	 * 添加视频广告
	 * 
	 * @param YcSchool
	 * @param ycVideoAds
	 * @param result
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addVideoAd", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcVideoAds> addVideoAd(@CurrentSchool YcSchool ycSchool, @Valid YcVideoAds ycVideoAds,
			BindingResult result) {
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
		// 判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 设置发布人
			ycVideoAds.setYc_applicant(ycSchool.getId());
			// 得到添加结果并处理
			String rs = iYcVideoAdService.insertVideo(ycVideoAds);
			if (RegexUtil.isNotNull(rs) && YcAdvertisingSpaceConstants.SUCCESS.equals(rs)) {
				return ResultUtil.success();
			}
			return ResultUtil.error(204, rs);
		}
		return ResultUtil.error(202, YcAdvertisingSpaceConstants.NOLOGIN);
	}

	/**
	 * 查询已发布广告
	 * 
	 * @param YcSchool
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcVideoAds> findAll(@CurrentSchool YcSchool ycSchool, YcVideoAds ycVideoAds,
			@RequestParam(defaultValue = "1") Integer currentPage,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		// 判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (null == currentPage || null == pageSize) {
				return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
			}
			//设置发布人
			ycVideoAds.setYc_applicant(ycSchool.getId());
			// 得到查询结果并处理
			PageInfo<YcVideoAds> pageInfo = iYcVideoAdService.findAll(ycVideoAds, currentPage, pageSize);
			if (RegexUtil.isNotNull(pageInfo)) {
				return ResultUtil.success(pageInfo);
			}
			return ResultUtil.error(203, YcAdvertisingSpaceConstants.NODATA);
		}
		return ResultUtil.error(202, YcAdvertisingSpaceConstants.NOLOGIN);
	}

	/**
	 * 根据id查询
	 * 
	 * @param YcSchool
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findById", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcVideoAds> findById(@CurrentSchool YcSchool ycSchool, String id) {
		// 判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(id)) {
				// 得到查询结果并处理
				YcVideoAds ycVideoAds = iYcVideoAdService.selectById(id);
				if (RegexUtil.isNotNull(ycVideoAds)) {
					return ResultUtil.success(ycVideoAds);
				}
				return ResultUtil.error(203, YcAdvertisingSpaceConstants.NODATA);
			}
			return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
		}
		return ResultUtil.error(202, YcAdvertisingSpaceConstants.NOLOGIN);
	}

	/**
	 * 修改视频广告
	 * 
	 * @param YcSchool
	 * @param ycVideoAds
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateVideoAd", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcVideoAds> updateVideoAd(@CurrentSchool YcSchool ycSchool, YcVideoAds ycVideoAds) {
		// 判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(ycVideoAds) && RegexUtil.isNotNull(ycVideoAds.getId())) {
				// 得到修改结果并处理
				String rs = iYcVideoAdService.update(ycVideoAds);
				if (RegexUtil.isNotNull(rs) && YcAdvertisingSpaceConstants.SUCCESS.equals(rs)) {
					return ResultUtil.success();
				}
				return ResultUtil.error(204, rs);
			}
			return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
		}
		return ResultUtil.error(202, YcAdvertisingSpaceConstants.NOLOGIN);
	}

	/**
	 * 删除视频广告
	 * 
	 * @param YcSchool
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteVideoAd", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcVideoAds> deleteVideoAd(@CurrentSchool YcSchool ycSchool, String id) {
		// 判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(id)) {
				// 得到删除结果并处理
				String rs = iYcVideoAdService.delete(id);
				if (RegexUtil.isNotNull(rs) && YcAdvertisingSpaceConstants.SUCCESS.equals(rs)) {
					return ResultUtil.success();
				}
				return ResultUtil.error(204, rs);
			}
			return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
		}
		return ResultUtil.error(202, YcAdvertisingSpaceConstants.NOLOGIN);
	}

	/**
	 * 根据广告位查询
	 * 
	 * @param YcSchool
	 * @param yc_advertising_space
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findBySpace", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcVideoAds> findBySpace(@CurrentSchool YcSchool ycSchool, String yc_advertising_space) {
		// 判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(yc_advertising_space)) {
				// 得到查询结果并处理
				YcVideoAds ycVideoAds = iYcVideoAdService.selectBySpace(yc_advertising_space);
				if (RegexUtil.isNotNull(ycVideoAds)) {
					return ResultUtil.success(ycVideoAds);
				}
				return ResultUtil.error(203, YcAdvertisingSpaceConstants.NODATA);
			}
			return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
		}
		return ResultUtil.error(202, YcAdvertisingSpaceConstants.NOLOGIN);
	}
}
