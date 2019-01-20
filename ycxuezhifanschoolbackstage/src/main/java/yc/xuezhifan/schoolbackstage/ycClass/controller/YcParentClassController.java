package yc.xuezhifan.schoolbackstage.ycClass.controller;/*package yc.xuezhifan.schoolbackstage.ycClass.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
*//**
 * 

* <p>Title: YcParentClassController.java </p> 

* <p>Description:家长班级关系 </p> 

* <p>Copyright: Copyright (c) 2018年11月20日</p>
 
* @email xiaoke@xuezhifan.com

* @author xiaoke 

* @date 2018年11月20日  

* @version 1.0
 *//*
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yc.xuezhifan.schoolbackstage.ycClass.service.YcParentClassService;


@Controller
public class YcParentClassController {
	private static Logger logger=LoggerFactory.getLogger(YcParentClassController.class);
	@Autowired
	private YcParentClassService ycParentClassService;
	
	@RequestMapping(value="/groupList")
	@ResponseBody
	@LoginRequired
	public JacksonData<YcParentClass> groupList(@CurrentUser YcUser ycUser){
		if (RegexUtil.isNull(ycUser)) {
			return ResultUtil.errorList(202, YcParentClassConstants.NOlOGIN);
		}
		try {
			List<YcParentClass> ycParentClasses=ycParentClassService.findByClass(ycUser);
			return ResultUtil.success(ycParentClasses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(e.getMessage());
			return ResultUtil.errorList(202, YcParentClassConstants.FAILURE);
		}
	}
	*//**
	 * 
	
	 * <p>Title: getgroupMemberList</p>  
	
	 * <p>Description:根据班级id 查询所有成员 </p>  
	
	 * @param ycUser
	 * @param yc_class_id
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月20日
	 *//*
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/getgroupMemberList")
	@ResponseBody
	@LoginRequired
	public JacksonData<YcParentClass> getgroupMemberList(@CurrentUser YcUser ycUser,String yc_class_id){
		if (RegexUtil.isNull(ycUser)) {
		return ResultUtil.errorList(202, YcParentClassConstants.NOlOGIN);
		}
		
		try {
			Map<String, Object> map=new HashMap<>();
			List<YcParentClass> ycParentClasses=ycParentClassService.findGroupByClassId(yc_class_id);//查询班级群成员信息
			if (RegexUtil.isNotNull(ycParentClasses)) {
				map.put("ycClass", ycParentClasses.get(0).getYcClass());//设置班级信息
			}
			map.put("ycParentClasses", ycParentClasses);
			return ResultUtil.success(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info(e.getMessage());
			return ResultUtil.errorList(203,YcParentClassConstants.FAILURE);//返回错误信息
		}
	}
	*//**
	 * 
	
	 * <p>Title: modifyParentClass</p>  
	
	 * <p>Description:修改班级成员信息 </p>  
	
	 * @param ycUser
	 * @param ycParentClass
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月27日
	 *//*
	@RequestMapping(value="/modifyParentClass")
	@ResponseBody
	@LoginRequired
	public JacksonData<YcParentClass> modifyParentClass(@CurrentUser YcUser ycUser,YcParentClass ycParentClass){
		if (RegexUtil.isNull(ycUser)) {
			return ResultUtil.error(202, YcParentClassConstants.NOlOGIN);
		}
		if (RegexUtil.isNull(ycParentClass)) {
			return ResultUtil.error(202, YcParentClassConstants.PARAMETER_ERROR);
		}
		String result=ycParentClassService.modify(ycUser,ycParentClass);
		return ResultUtil.success(result);
	}
	*//**
	 * 
	
	 * <p>Title: setupAdmin</p>  
	
	 * <p>Description:设置管理员 </p>  
	
	 * @param ycUser
	 * @param adminId
	 * @param yc_class_id
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月27日
	 *//*
	@RequestMapping(value="/setupAdmin")
	@ResponseBody
	@LoginRequired
	public JacksonData<YcParentClass> setupAdmin(@CurrentUser YcUser ycUser,String[] adminId,String yc_class_id){
		if (RegexUtil.isNull(ycUser)) {
			return ResultUtil.error(202, YcParentClassConstants.NOlOGIN);
		}
		if (RegexUtil.isNull(adminId)) {
			return ResultUtil.error(201, YcParentClassConstants.PARAMETER_ERROR);
		}
		if (RegexUtil.isNull(yc_class_id)) {
			return ResultUtil.error(201, YcParentClassConstants.PARAMETER_ERROR);
		}
		return null;
		
	}
}
*/