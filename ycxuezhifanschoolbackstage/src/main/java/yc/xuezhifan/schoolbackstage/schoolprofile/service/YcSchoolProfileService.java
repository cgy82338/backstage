package yc.xuezhifan.schoolbackstage.schoolprofile.service;


import yc.xuezhifan.schoolbackstage.schoolprofile.bean.YcSchoolProfile;

/**
* <p>Title: YcChargesService.java </p> 

* <p>Description: 学校概况</p> 

* <p>Copyright: Copyright (c) 2018年12月18日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年12月18日  

* @version 1.0  

*/
public interface YcSchoolProfileService {
	
	/**
	 * 
	 * <p>Title: insert</p>  
	
	 * <p>Description:添加学校概况  </p>  
	
	 * @param ycSchoolProfile
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年12月19日
	 */
	String  insert(YcSchoolProfile ycSchoolProfile);
	
	/**
	 * 
	 * <p>Title: selectById</p>  
	
	 * <p>Description: 查看学校简介</p>  
	
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年12月18日
	 */
	YcSchoolProfile selectByAll(String id);
}
