package yc.xuezhifan.schoolbackstage.schoolfeature.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcSchoolFeatureStatus;

/**
 * 

* <p>Title: YcSchoolFeatureStatusMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月1日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月1日  

* @version 1.0
 */
@Mapper
public interface YcSchoolFeatureStatusMapper {

	/**
	 * 添加
	 * @param ycSchoolFeatureStatus
	 */
	Integer insert(YcSchoolFeatureStatus ycSchoolFeatureStatus);
	
	/**
	 * 修改
	 * @param ycSchoolFeatureStatus
	 * @return
	 */
	Integer update(YcSchoolFeatureStatus ycSchoolFeatureStatus);
	
	/**
	 * 根据学校id查询
	 * @return
	 */
	List<YcSchoolFeatureStatus> selectBySchool(String yc_school_id);
}
