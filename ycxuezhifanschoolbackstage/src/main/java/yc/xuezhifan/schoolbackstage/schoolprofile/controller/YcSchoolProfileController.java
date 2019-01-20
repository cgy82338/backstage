package yc.xuezhifan.schoolbackstage.schoolprofile.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolprofile.bean.YcSchoolProfile;
import yc.xuezhifan.schoolbackstage.schoolprofile.mapper.YcSchoolProfileMapper;
import yc.xuezhifan.schoolbackstage.schoolprofile.service.YcSchoolProfileService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

/**  
* <p>Title: YcChargesController.java </p> 

* <p>Description: 学校概况</p> 

* <p>Copyright: Copyright (c) 2018年12月18日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年12月18日  

* @version 1.0  

*/
@Controller
@RequestMapping("/ycSchoolProfile")
public class YcSchoolProfileController {
	
	@Autowired
	private YcSchoolProfileService ycSchoolProfileService;

	/**
	 * 
	 * <p>Title: selectByAll</p>  
	
	 * <p>Description: 查看列表</p>  
	
	 * @param ycUser
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年12月18日
	 */
	@ResponseBody
	@RequestMapping(value = "/selectByAll", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@SchoolLogin
	@SuppressWarnings("unchecked")
	public JacksonData<YcSchoolProfile> selectByAll(@CurrentSchool YcSchool ycSchool){
		if (RegexUtil.isNotNull(ycSchool)) {
			YcSchoolProfile selectByAll = ycSchoolProfileService.selectByAll(ycSchool.getId());
		if (RegexUtil.isNotNull(selectByAll)) {
			return ResultUtil.success(selectByAll);
		}
		return ResultUtil.error(203, YcSchoolConstants.NODATA);
		}
		return ResultUtil.error(202, YcSchoolConstants.NOLOGIN);
	}

	/**
	 * 
	 * <p>Title: insert</p>  
	
	 * <p>Description:添加学校概况   </p>  
	
	 * @param ycUser
	 * @param ycSchoolProfile
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年12月19日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	@SchoolLogin
	public JacksonData<YcSchoolProfile> insert(@CurrentSchool YcSchool ycSchool,@Valid YcSchoolProfile ycSchoolProfile){
		if (RegexUtil.isNotNull(ycSchool)) {
			ycSchoolProfile.setYc_school_id(ycSchool.getId());
			String selectByAll = ycSchoolProfileService.insert(ycSchoolProfile);
		if (RegexUtil.isNotNull(selectByAll)) {
			return ResultUtil.success();
		}
		return ResultUtil.error(203, YcSchoolConstants.NODATA);
		}
		return ResultUtil.error(202, YcSchoolConstants.NOLOGIN);
	}
}
