package yc.xuezhifan.schoolbackstage.school.mapper;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;

import java.util.List;

@Mapper
public interface YcSchoolMapper {

	/**
	 * 
	
	 * <p>Title: selectByUserName</p>  
	
	 * <p>Description: 登录账户查询</p>  
	
	 * @param username
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年10月28日
	 */
	YcSchool selectByUserName(String username);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcSchool selectById(String id);
	
	/**
	 * 
	 * @param ycSchool
	 * @return
	 */
	Integer updateSchool(YcSchool ycSchool);

	/**
	 *根据学校名称查询信息
	 * @param
	 * @return
	 */
	YcSchool selectSchoolByName(String schoolname);


}
