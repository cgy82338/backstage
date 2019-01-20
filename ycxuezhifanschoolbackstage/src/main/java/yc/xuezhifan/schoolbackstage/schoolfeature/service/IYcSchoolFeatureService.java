package yc.xuezhifan.schoolbackstage.schoolfeature.service;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcSchoolFeature;


/**  

* <p>Title: IYcSchoolFeatureService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月2日  

* @version 1.0  

*/
public interface IYcSchoolFeatureService {
	
	/**
	 * 查询所有功能
	 * @param pageSize 
	 * @param currentPage 
	 * @return
	 */
	PageInfo<YcSchoolFeature> findAll(Integer currentPage, Integer pageSize);
	
}
