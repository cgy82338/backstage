package yc.xuezhifan.schoolbackstage.schoolcircle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcCircleDynamicConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolcircle.bean.YcCircleDynamic;
import yc.xuezhifan.schoolbackstage.schoolcircle.service.IYcCircleDynamicService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;


/**  

* <p>Title: YcCircleDynamicLikeController.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年9月5日  

* @version 1.0  

*/
@Controller
@RequestMapping("/schoolCircle")
public class YcCircleDynamicController {
	
	@Autowired
	private IYcCircleDynamicService iYcCircleDynamicService;

	/**
	 * 获取学校圈动态
	 * @param ycUser
	 * @param yc_school_id
	 * @param pageSize
	 * @param currentPage
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getSchoolCircleDynamic",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcCircleDynamic> getSchoolCircleDynamic(
			@CurrentSchool YcSchool ycSchool, @RequestParam(defaultValue="1")Integer currentPage, @RequestParam(defaultValue="10")Integer pageSize){
		//判断是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			//判断参数是否正确
			if (null == currentPage || null == pageSize) {
				return ResultUtil.error(203, YcCircleDynamicConstants.NODATA);
			}
			//得到查询结果并处理
			List<YcCircleDynamic> pageInfo = iYcCircleDynamicService.selectBySchool(ycSchool.getId(), currentPage, pageSize);
			if (RegexUtil.isNotNull(pageInfo)) {
				return ResultUtil.success(pageInfo);
			}
			return ResultUtil.error(203, YcCircleDynamicConstants.NODATA);
		}
		return ResultUtil.error(202, YcCircleDynamicConstants.NOLOGIN);
	}
	
		
	/**
	 * 删除动态
	 * @param ycUser
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteCircleDynamic",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcCircleDynamic> deleteCircleDynamic(@CurrentSchool YcSchool ycSchool, String id){
		//判断是否登录
		if (RegexUtil.isNotNull(ycSchool)) {
			//判断参数是否正确
			if (RegexUtil.isNotNull(id)) {
					String result = iYcCircleDynamicService.delete(id);
					if (RegexUtil.isNotNull(result) && result.equals(YcCircleDynamicConstants.SUCCESS)) {
						return ResultUtil.success();
					}else {
						return ResultUtil.error(203, result);
					}
			}
			return ResultUtil.error(203, YcCircleDynamicConstants.NODATA);
		}
		return ResultUtil.error(202, YcCircleDynamicConstants.NOLOGIN);
	}
}
