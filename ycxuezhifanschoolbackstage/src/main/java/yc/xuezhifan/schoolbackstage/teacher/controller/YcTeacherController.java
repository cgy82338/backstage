package yc.xuezhifan.schoolbackstage.teacher.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcTeacherConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.teacher.service.YcTeacherService;
import yc.xuezhifan.schoolbackstage.teacher.vo.YcTeacherVo;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClass;
import yc.xuezhifan.schoolbackstage.ycClass.mapper.YcClassMapper;
import yc.xuezhifan.schoolbackstage.ycClass.service.YcParentClassService;

import java.util.List;

/**
 * 
 * 
 * <p>
 * Title: YcTeacherController.java
 * </p>
 * 
 * <p>
 * Description: 教师controller
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年9月18日
 * </p>
 * 
 * @email zhuangzhuang@xuezhifan.com
 * 
 * @author zhuangzhuang
 * 
 * @date 2018年9月18日
 * 
 * @version 1.0
 */
@Controller
@RequestMapping("/teacher")
public class YcTeacherController {

	@Autowired
	private YcTeacherService ycTeacherService;

	@Autowired
	private YcParentClassService ycParentClassService;


	@Autowired
	private YcUserMapper userMapper;

	@RequestMapping("/del")
	@ResponseBody
	public String del(String id){
		userMapper.deleteAll(id);
		return "ok";
	}
	/**
	 * 
	 * 
	 * <p>
	 * Title: saveTeacher
	 * </p>
	 * 
	 * <p>
	 * Description: 学校添加教师（单个添加）
	 * </p>
	 * 
	 * @param ycSchool
	 * @param user
	 * @return
	 * 
	 * @email zhuangzhuang@xuezhifan.com
	 * 
	 * @author zhuangzhuang
	 * 
	 * @date 2018年9月18日
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	@SchoolLogin
	@ResponseBody
	@RequestMapping(value = "/saveTeacher",method = RequestMethod.POST)
	public JacksonData saveTeacher(@CurrentSchool YcSchool ycSchool, YcUser user){
		// 验证用户是否存在
		if (null == ycSchool) {
			return ResultUtil.error(202, YcTeacherConstants.NOlOGIN);
		}
			return ycTeacherService.saveTeacher(ycSchool,user);
	}

	/**
	 * 
	
	 * <p>Title: getTeacherBySchoolid</p>  
	
	 * <p>Description: 通过学校id查询教师</p>  
	
	 * @param ycusername
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getTeacherBySchoolid",method = RequestMethod.POST)
	@ResponseBody
	@SchoolLogin
	public Page getTeacherBySchoolid(@CurrentSchool YcSchool ycSchool,String ycusername, @RequestParam(defaultValue="1") Integer currentPage,
									 @RequestParam(defaultValue="10") Integer pageSize) throws Exception {
//		无学校信息则返回null
		if (null == ycSchool) {
			return new Page(0,"",0,null);
		}
		return ycTeacherService.getTeacherBySchoolid(ycSchool.getId(),currentPage,pageSize,ycusername);
	}
	
	/**
	 * 
	
	 * <p>Title: deleteTeacherById</p>  
	
	 * <p>Description: 删除教师信息（仅将删除状态修改为不展示）</p>  
	
	 * @param teacherId
	 * @return
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteTeacherById",method = RequestMethod.POST)
	@ResponseBody
	@SchoolLogin
	public JacksonData deleteTeacherById(@CurrentSchool YcSchool ycSchool , String teacherId ){
		if (RegexUtil.isNull(ycSchool)) {
			return ResultUtil.error(202, YcTeacherConstants.NOlOGIN);
		}
		return ycTeacherService.deleteTeacherById(teacherId);
	}
	/**
	 *

	 * <p>Title: deleteTeacherById</p>

	 * <p>Description: 修改教师信息（弹窗）</p>

	 * @param id
	 * @return
	 * @email xiaoyu@xuezhifan.com
	 * @author xiaoyu
	 * @date 2018年12月19日
	 */
	@RequestMapping("/schoolteacheropen")
	public String schoolteacheropen(String id,Model model){
		YcUser user = ycTeacherService.getUserById(id);
		model.addAttribute("user",user);
		return "/school_teacher/school_teacher_open";
	}

	/**
	 *

	 * <p>Title: updateTeacherUser</p>

	 * <p>Description: 修改教师信息</p>

	 * @param user
	 * @return
	 * @email xiaoyu@xuezhifan.com
	 * @author xiaoyu
	 * @date 2018年12月19日
	 */
	@RequestMapping(value = "/updateTeacherUser",method = RequestMethod.POST)
	@ResponseBody
	public JacksonData updateTeacherUser(YcUser user){
		if (user == null){
			return ResultUtil.error(204,YcTeacherConstants.FAILURE);
		}
		return ycTeacherService.updateTeacherUser(user);
	}
		

}
