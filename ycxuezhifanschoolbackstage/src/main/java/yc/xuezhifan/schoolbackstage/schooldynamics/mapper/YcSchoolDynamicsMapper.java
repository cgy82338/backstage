package yc.xuezhifan.schoolbackstage.schooldynamics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yc.xuezhifan.schoolbackstage.schooldynamics.bean.YcSchoolDynamics;

/**  

* <p>Title: YcSchoolDynamicsMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年11月5日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年11月5日  

* @version 1.0  

*/
@Mapper
public interface YcSchoolDynamicsMapper {

	/**
	 * 添加学校动态
	 * @param ycSchoolDynamics
	 * @return
	 */
	Integer insert(YcSchoolDynamics ycSchoolDynamics);
	
	/**
	 * 根据学校获取学校动态
	 * @param yc_school_dynamics_school 学校唯一标示
	 * @return
	 */
	List<YcSchoolDynamics> findBySchool(String yc_school_dynamics_school);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcSchoolDynamics selectById(@Param("id") String id, @Param("yc_school_dynamics_school") String yc_school_dynamics_school);
	
	/**
	 * 删除动态
	 * @param id
	 * @return
	 */
	Integer delete(@Param("id") String id, @Param("yc_school_dynamics_school") String yc_school_dynamics_school);
}
