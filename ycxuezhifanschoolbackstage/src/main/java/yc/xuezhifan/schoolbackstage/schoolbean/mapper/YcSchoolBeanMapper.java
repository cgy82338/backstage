package yc.xuezhifan.schoolbackstage.schoolbean.mapper;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcSchoolBean;



@Mapper
public interface YcSchoolBeanMapper {

	YcSchoolBean findBeanBySchoolId(String id);

	int modify(YcSchoolBean ycScboolBean);

	Integer save(YcSchoolBean ycWisdomBeans);

	YcSchoolBean findBeanById(String yc_school_id);

}
