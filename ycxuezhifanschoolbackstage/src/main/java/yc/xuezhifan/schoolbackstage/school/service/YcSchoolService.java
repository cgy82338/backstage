package yc.xuezhifan.schoolbackstage.school.service;

import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.school.vo.SchoolData;

public interface YcSchoolService {

	/**
	 * 
	
	 * <p>Title: findByAccessToken</p>  
	
	 * <p>Description: 根据token参数查询学校</p>  
	
	 * @param schoolName
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年10月28日
	 */
	YcSchool findByAccessToken(String schoolName);

	/**
	 * 
	
	 * <p>Title: login</p>  
	
	 * <p>Description: 学校账户登录</p>  
	
	 * @param username
	 * @param password
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年10月28日
	 */
	YcSchool login(String username, String password);
	
	/**
	 * 修改学校信息
	 * @param ycSchool
	 * @return
	 */
	String updateSchool(YcSchool ycSchool);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcSchool selectById(String id);

	YcSchool findBySchoolId(String id);

	/**
	 * 修改管理后台密码
	 */
	JacksonData updatepassword(String formerpass,String newqpass,YcSchool ycSchool);//原先密码    新密码

	/**
	 * 账号资料信息修改
	 */
	JacksonData updateData(YcSchool ycSchool,SchoolData schoolData);

	/**
	 * 账号所有人资料信息修改
	 */
	JacksonData updateDataAll(YcSchool ycSchool,SchoolData schoolData);
}
