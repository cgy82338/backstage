package yc.xuezhifan.schoolbackstage.active.controller;

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

import yc.xuezhifan.schoolbackstage.active.bean.YcActivity;
import yc.xuezhifan.schoolbackstage.active.service.YcActivityService;
import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.ActivityConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

/**
 * <p>
 * Title: YcActivityController.java
 * </p>
 * 
 * <p>
 * Description: 活动表
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年9月5日
 * </p>
 * 
 * @email xiaoxiao@xuezhifan.com
 * 
 * @author xiaoxiao
 * 
 * @date 2018年9月5日
 * 
 * @version 1.0
 */
@Controller
@RequestMapping("/ycActivity")
public class YcActivityController {

	private static final Logger logger = LoggerFactory.getLogger(YcActivityController.class);

	@Autowired
	private YcActivityService ycActivityService;

	/**
	 * 
	 * <p>
	 * Title: insertActivity
	 * </p>
	 * 
	 * <p>
	 * Description: 创建活动
	 * </p>
	 * 
	 * @param ycSchool
	 * @param ycActivity
	 * @param result
	 * @return
	 * 
	 * @email xiaoxiao@xuezhifan.com
	 * 
	 * @author xiaoxiao
	 * 
	 * @date 2018年10月15日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertActivity", method = RequestMethod.POST)
	@ResponseBody
	@SchoolLogin
	public JacksonData<YcActivity> insertActivity(@CurrentSchool YcSchool ycSchool, @Valid YcActivity ycActivity,
			BindingResult result) {
		System.out.println(ycActivity.getYc_activity_time());
		// 验证参数是否有误
		if (result.hasErrors()) {
			List<ObjectError> error = result.getAllErrors();
			for (ObjectError objectError : error) {
				// 参数错误信息写入日志文件
				logger.debug("错误码：" + objectError.getCode() + "~~message:" + objectError.getDefaultMessage() + "~~~"
						+ objectError.getObjectName());
			}
			return ResultUtil.error(201, ActivityConstants.PARAMETER_ERROR);
		}
		// 判断用户是否为登录状态
		if (null != ycSchool) {
			// 设置发布人
			ycActivity.setYc_activity_sponsor(ycSchool.getId());
			// 设置活动地址
			ycActivity.setYc_district(ycSchool.getYc_district());
			//设置发布人类型
			ycActivity.setYc_sponsor_type(3);
			String activity = ycActivityService.insertActivity(ycActivity);
			if (RegexUtil.isNotNull(activity)) {
				return ResultUtil.success();
			}
			return ResultUtil.error(204, activity);
		}
		return ResultUtil.error(202, ActivityConstants.NOlOGIN);

	}

	/**
	 * <p>
	 * Title: modify
	 * </p>
	 * 
	 * <p>
	 * Description: 修改活动
	 * </p>
	 * 
	 * @param YcSchool
	 * @param ycHobbyCourseAlbum
	 * @param result
	 * @return
	 * 
	 * @email xiaoxiao@xuezhifan.com
	 * 
	 * @author xiaoxiao
	 * 
	 * @date 2018年9月5日
	 */
	@SuppressWarnings("unchecked")
	@SchoolLogin
	@ResponseBody
	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public JacksonData<YcActivity> modify(@CurrentSchool YcSchool ycSchool, YcActivity ycActivity) {
		// 验证参数是否有误
		if (RegexUtil.isNull(ycActivity) || RegexUtil.isNull(ycActivity.getId())) {
			return ResultUtil.error(201, ActivityConstants.PARAMETER_ERROR);
		}
		// 判断用户是否为登录状态
		if (RegexUtil.isNotNull(ycSchool)) {
			// 得到修改结果并处理
			String modify = ycActivityService.modify(ycActivity);
			if (RegexUtil.isNotNull(modify) && modify.equals(ActivityConstants.SUCCESS)) {
				return ResultUtil.success();
			} else {
				return ResultUtil.error(201, modify);
			}
		}
		return ResultUtil.error(203, ActivityConstants.NOlOGIN);
	}

	/**
	 * <p>
	 * Title: deleteActivity
	 * </p>
	 * 
	 * <p>
	 * Description: 删除活动
	 * </p>
	 * 
	 * @param id
	 * @return
	 * 
	 * @email xiaoxiao@xuezhifan.com
	 * 
	 * @author xiaoxiao
	 * 
	 * @date 2018年9月6日
	 */
	@SuppressWarnings("unchecked")
	@SchoolLogin
	@ResponseBody
	@RequestMapping(value = "/deleteActivity", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public JacksonData<YcActivity> deleteActivity(@CurrentSchool YcSchool YcSchool, String id) {
		// 判断用户是否为登录状态
		if (RegexUtil.isNull(YcSchool)) {
			return ResultUtil.error(202, ActivityConstants.NOlOGIN);
		}
		if (RegexUtil.isNotNull(id)) {
			String st = ycActivityService.deleteActivity(id);
			if (RegexUtil.isNotNull(st) && st.equals(ActivityConstants.SUCCESS)) {
				return ResultUtil.success();
			} else {
				return ResultUtil.error(202, st);
			}
		}
		return ResultUtil.error(203, ActivityConstants.FAILURE);
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: selectById
	 * </p>
	 * 
	 * <p>
	 * Description: 根据id查询活动详情
	 * </p>
	 * 
	 * @param id
	 * @return
	 * 
	 * @email xiaoxiao@xuezhifan.com
	 * 
	 * @author xiaoxiao
	 * 
	 * @date 2018年9月6日
	 */
	@SuppressWarnings("unchecked")
	@SchoolLogin
	@ResponseBody
	@RequestMapping(value = "/selectById", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public JacksonData<YcActivity> selectById(@CurrentSchool YcSchool ycSchool, String id) {
		// 判断用户是否为登录状态
		if (RegexUtil.isNull(ycSchool)) {
			return ResultUtil.error(202, ActivityConstants.NOlOGIN);
		}
		// 判断参数是否正确
		if (RegexUtil.isNull(id)) {
			return ResultUtil.error(201, ActivityConstants.PARAMETER_ERROR);
		}
		YcActivity ById = ycActivityService.selectById(id);
		if (RegexUtil.isNotNull(ById)) {
			return ResultUtil.success(ById);
		}
		return ResultUtil.error(201, ActivityConstants.NODATA);
	}

	/**
	 *
	 *
	 * <p>
	 * Title: findAllActivity
	 * </p>
	 *
	 * <p>
	 * Description: 查询所有活动
	 * </p>
	 *
	 * @param classIds
	 * @param currentPage
	 * @param pageSize
	 * @return
	 *
	 * @email xiaoxiao@xuezhifan.com
	 *
	 * @author xiaoxiao
	 *
	 * @date 2018年9月6日
	 */
	@SuppressWarnings("unchecked")
	@SchoolLogin
	@ResponseBody
	@RequestMapping(value = "/findAllActivity", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public JacksonData<YcActivity> findAllActivity(@CurrentSchool YcSchool ycSchool,
			@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize) {
		// 判断用户是否为登录状态
		if (RegexUtil.isNull(ycSchool)) {
			return ResultUtil.error(202, ActivityConstants.NOlOGIN);
		}
		PageInfo<YcActivity> pageInfo = ycActivityService.findAllActivity(currentPage, pageSize,
				ycSchool.getYc_district());
		if (null == pageInfo) {
			return ResultUtil.error(203, ActivityConstants.NODATA);
		}
		return ResultUtil.success(pageInfo);

	}


}
