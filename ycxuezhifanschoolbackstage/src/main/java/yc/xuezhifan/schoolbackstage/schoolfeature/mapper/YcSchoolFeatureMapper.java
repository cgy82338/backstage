package yc.xuezhifan.schoolbackstage.schoolfeature.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcSchoolFeature;


/**
 * 

* <p>Title: YcSchoolFeatureMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月1日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月1日  

* @version 1.0
 */
@Mapper
public interface YcSchoolFeatureMapper {

	
	/**
	 * 查询所有功能
	 * @return
	 */
	List<YcSchoolFeature> findAll();
	
}
