package yc.xuezhifan.schoolbackstage.schoolbean.mapper;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcSchoolBean;
import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcSchoolBeanRecord;



@Mapper
public interface YcSchoolBeanRecordMapper {

	int save(YcSchoolBeanRecord ycSchoolBeanRecord);

	Integer modify(YcSchoolBean ycWisdomBeans);

}
