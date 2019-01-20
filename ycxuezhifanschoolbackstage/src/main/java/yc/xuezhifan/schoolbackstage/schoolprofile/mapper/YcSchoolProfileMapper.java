package yc.xuezhifan.schoolbackstage.schoolprofile.mapper;

import org.apache.ibatis.annotations.Mapper;
import yc.xuezhifan.schoolbackstage.schoolprofile.bean.YcSchoolProfile;


/**
 * 
 * 
 * <p>
 * Title: YcSchoolMapper.java
 * </p>
 * 
 * <p>
 * Description:学校概况表
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年9月8日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年9月8日
 * 
 * @version 1.0
 */

@Mapper
public interface YcSchoolProfileMapper {

	/**
	 * 
	 * <p>Title: insert</p>  
	
	 * <p>Description:添加学校概况  </p>  
	
	 * @param ycSchoolProfile
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年12月19日
	 */
	Integer insert(YcSchoolProfile ycSchoolProfile);
	
	/**
	 * 
	 * <p>Title: selectById</p>  
	
	 * <p>Description: 查看学校简介</p>  
	
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年12月18日
	 */
	YcSchoolProfile selectByAll(String yc_id);
}
