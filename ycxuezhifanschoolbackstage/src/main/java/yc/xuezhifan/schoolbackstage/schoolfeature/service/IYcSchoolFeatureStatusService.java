package yc.xuezhifan.schoolbackstage.schoolfeature.service;


import com.github.pagehelper.PageInfo;
import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcSchoolFeatureStatus;

/**  

* <p>Title: IYcSchoolFeatureStatusService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月2日  

* @version 1.0  

*/
public interface IYcSchoolFeatureStatusService {

	/**
	 * 添加
	 * @param ycSchoolFeatureStatus
	 */
	String insert(YcSchoolFeatureStatus ycSchoolFeatureStatus);
	
	/**
	 * 修改
	 * @param ycSchoolFeatureStatus
	 * @return
	 */
	String update(YcSchoolFeatureStatus ycSchoolFeatureStatus);
	
	/**
	 * 根据学校查询
	 * @param yc_school_id
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageInfo<YcSchoolFeatureStatus> selectBySchool(String yc_school_id, Integer currentPage, Integer pageSize);
}
