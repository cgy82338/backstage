package yc.xuezhifan.schoolbackstage.schoolfeature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcSchoolFeature;
import yc.xuezhifan.schoolbackstage.schoolfeature.service.IYcSchoolFeatureService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;


/**  

* <p>Title: YcSchoolFeatureController.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月2日  

* @version 1.0  

*/
@Controller
@RequestMapping("/schoolFeature")
public class YcSchoolFeatureController {

	@Autowired
	private IYcSchoolFeatureService iYcSchoolFeatureService;
	
	/**
	 * 获取所有功能
	 * @return
	 */
	@ResponseBody
	@SchoolLogin
	@RequestMapping(value="/findAll",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@SuppressWarnings("unchecked")
	public JacksonData<YcSchoolFeature> getAll(@CurrentSchool YcSchool ycSchool, 
			@RequestParam(defaultValue="1")Integer currentPage, @RequestParam(defaultValue="10")Integer pageSize){
		//判断当前用户是否为登录状态
		if (RegexUtil.isNull(ycSchool)) {
			return ResultUtil.error(202, YcSchoolConstants.NOLOGIN);
		}
		//得到查询结果并处理
		PageInfo<YcSchoolFeature> ycSchoolFeatures = iYcSchoolFeatureService.findAll(currentPage, pageSize);
		if (RegexUtil.isNotNull(ycSchoolFeatures)) {
			return ResultUtil.success(ycSchoolFeatures);
		}
		return ResultUtil.error(203, YcSchoolConstants.NODATA);
	}
	
}
