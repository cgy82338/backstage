package yc.xuezhifan.schoolbackstage.schooldynamics.service;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.schooldynamics.bean.YcSchoolDynamics;
import yc.xuezhifan.schoolbackstage.utils.Page;

/**  

* <p>Title: IYcSchoolDynamicsService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年11月5日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年11月5日  

* @version 1.0  

*/
public interface IYcSchoolDynamicsService {
	/**
	 * 添加学校动态
	 * @param ycSchoolDynamics
	 * @return
	 */
	JacksonData insert(YcSchoolDynamics ycSchoolDynamics);
	
	/**
	 * 根据学校获取学校动态
	 * @param yc_school_dynamics_school 学校唯一标示
	 * @return
	 */
	Page findBySchool(String yc_school_dynamics_school, Integer currentPage, Integer pageSize);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcSchoolDynamics selectById(String id, String yc_school_dynamics_school);
	
	/**
	 * 删除动态
	 * @param id
	 * @return
	 */
	String delete(String id, String yc_school_dynamics_school);
}
