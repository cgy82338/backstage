package yc.xuezhifan.schoolbackstage.advertising.space.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.space.bean.YcAdvertisingSpaceArea;
import yc.xuezhifan.schoolbackstage.advertising.space.service.IYcAdvertisingSpaceAreaService;
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
 * Title: YcAdvertisingSpaceAreaController.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年10月13日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年10月13日
 * 
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/spaceArea")
public class YcAdvertisingSpaceAreaController {

	@Autowired
	private IYcAdvertisingSpaceAreaService iYcAdvertisingSpaceAreaService;

	/**
	 * 根据地区及名称查询信息
	 * 
	 * @param YcSchool
	 * @param yc_advertising_district
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findByParam", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcAdvertisingSpaceArea> findByArea(@CurrentSchool YcSchool ycSchool, Integer type,
			@RequestParam(defaultValue = "1") Integer currentPage,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		// 验证用户是否为登录状态
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否错误
			if (null == currentPage || null == pageSize) {
				return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
			}
			// 得到查询结果并处理
			PageInfo<YcAdvertisingSpaceArea> pageInfo = iYcAdvertisingSpaceAreaService
					.selectByArea(ycSchool.getYc_district(), currentPage, pageSize, type);
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
	public JacksonData<YcAdvertisingSpaceArea> findById(@CurrentSchool YcSchool ycSchool, String id) {
		// 验证用户是否为登录状态
		if (RegexUtil.isNotNull(ycSchool)) {
			// 判断参数是否正确
			if (RegexUtil.isNull(id)) {
				return ResultUtil.error(201, YcAdvertisingSpaceConstants.PARAMETER_ERROR);
			}
			// 得到查询结果并处理
			YcAdvertisingSpaceArea ycAdvertisingSpaceArea = iYcAdvertisingSpaceAreaService.selectById(id);
			if (RegexUtil.isNotNull(ycAdvertisingSpaceArea)) {
				return ResultUtil.success(ycAdvertisingSpaceArea);
			}
			return ResultUtil.error(203, YcAdvertisingSpaceConstants.NODATA);
		}
		return ResultUtil.error(202, YcAdvertisingSpaceConstants.NOLOGIN);
	}

}
