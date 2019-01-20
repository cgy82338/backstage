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

import yc.xuezhifan.schoolbackstage.advertising.bean.YcRingAd;
import yc.xuezhifan.schoolbackstage.advertising.service.IYcRingAdService;
import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcAdvertisingSpaceConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

/**
 * 
 * <p>
 * Title: YcRingAdController.java
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
@RequestMapping("/ringAd")
public class YcRingAdController {

	private static final Logger logger = LoggerFactory.getLogger(YcRingAdController.class);

	@Autowired
	private IYcRingAdService iYcRingAdService;

	/**
	 * 发布圈广告
	 * 
	 * @param YcSchool
	 * @param ycRingAd
	 * @param result
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addRingAd", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcRingAd> addRingAd(@CurrentSchool YcSchool ycSchool, @Valid YcRingAd ycRingAd,
			BindingResult result) {
		// 验证参数是否正确
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError objectError : errors) {
				// 参数错误信息写入日志文件
				logger.debug("错误码:" + objectError.getCode() + "~~message:" + objectError.getDefaultMessage() + "~~~"
						+ objectError.getObjectName());
			}
			return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
		}
		// 判断用户是否为登录状态
		if (RegexUtil.isNotNull(ycSchool)) {
			// 设置发布人
			ycRingAd.setYc_applicant(ycSchool.getId());
			// 得到添加结果并处理
			String rs = iYcRingAdService.insert(ycRingAd);
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
	@RequestMapping(value = "/findAll", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcRingAd> findAll(@CurrentSchool YcSchool ycSchool, YcRingAd ycRingAd,
			@RequestParam(defaultValue = "1") Integer currentPage,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		// 判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (null == currentPage || null == pageSize) {
				return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
			}
			//设置发布人
			ycRingAd.setYc_applicant(ycSchool.getId());
			// 得到查询结果并处理
			PageInfo<YcRingAd> pageInfo = iYcRingAdService.findAll(ycRingAd, currentPage, pageSize);
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
	public JacksonData<YcRingAd> findById(@CurrentSchool YcSchool ycSchool, String id) {
		// 判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(id)) {
				// 得到查询结果并处理
				YcRingAd ycRingAd = iYcRingAdService.selectById(id);
				if (RegexUtil.isNotNull(ycRingAd)) {
					return ResultUtil.success(ycRingAd);
				}
				return ResultUtil.error(203, YcAdvertisingSpaceConstants.NODATA);
			}
			return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
		}
		return ResultUtil.error(202, YcAdvertisingSpaceConstants.NOLOGIN);
	}

	/**
	 * 修改广告信息
	 * 
	 * @param YcSchool
	 * @param ycRingAd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateRing", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcRingAd> updateRing(@CurrentSchool YcSchool ycSchool, YcRingAd ycRingAd) {
		// 判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(ycRingAd) && RegexUtil.isNotNull(ycRingAd.getId())) {
				// 得到修改结果并处理
				String rs = iYcRingAdService.update(ycRingAd);
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
	 * 删除广告信息
	 * @param YcSchool
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteRing", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcRingAd> deleteRing(@CurrentSchool YcSchool ycSchool, String id) {
		// 判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNotNull(id)) {
				// 得到删除结果并处理
				String rs = iYcRingAdService.delete(id);
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
	 * @param YcSchool
	 * @param yc_advertising_space
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findBySpace", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcRingAd> findBySpace(@CurrentSchool YcSchool ycSchool, String yc_advertising_space){
		//判断管理员是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			//判断参数是否正确
			if (RegexUtil.isNotNull(yc_advertising_space)) {
				//得到查询结果并处理
				YcRingAd ycRingAd = iYcRingAdService.selectBySpace(yc_advertising_space);
				if (RegexUtil.isNotNull(ycRingAd)) {
					return ResultUtil.success(ycRingAd);
				}
				return ResultUtil.error(203, YcAdvertisingSpaceConstants.NODATA);
			}
			return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
		}
		return ResultUtil.error(202, YcAdvertisingSpaceConstants.NOLOGIN);
	}

}
