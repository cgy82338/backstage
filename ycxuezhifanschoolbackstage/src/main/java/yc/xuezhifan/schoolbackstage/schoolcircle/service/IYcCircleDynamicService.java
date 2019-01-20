package yc.xuezhifan.schoolbackstage.schoolcircle.service;

import java.util.List;

import yc.xuezhifan.schoolbackstage.schoolcircle.bean.YcCircleDynamic;

/**  

* <p>Title: IYcCircleDynamicLikeService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年9月5日  

* @version 1.0  

*/
public interface IYcCircleDynamicService {

	/**
	 * 根据学校id查询学校圈动态
	 * @param yc_school_id
	 * @return
	 */
	List<YcCircleDynamic> selectBySchool(String yc_school_id, Integer currentPage, Integer pageSize);
	
	/**
	 * 删除动态
	 * @param id
	 */
	String delete(String id);
	
}
