package yc.xuezhifan.schoolbackstage.schoolcircle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yc.xuezhifan.schoolbackstage.schoolcircle.bean.YcCircleDynamic;

/**
 * 

* <p>Title: YcCircleDynamicMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年9月5日  

* @version 1.0
 */
@Mapper
public interface YcCircleDynamicMapper {

	/**
	 * 根据学校id查询学校圈动态
	 * @param yc_school_id
	 * @return
	 */
	List<YcCircleDynamic> selectBySchool(@Param("yc_school_id") String yc_school_id, @Param("currentPage") Integer currentPage,
                                         @Param("pageSize") Integer pageSize);
	
	/**
	 * 删除动态
	 * @param id
	 */
	Integer delete(String id);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcCircleDynamic seletById(String id);
	
}
