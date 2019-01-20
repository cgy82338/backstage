package yc.xuezhifan.schoolbackstage.teacher.service;

import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.teacher.bean.YcTeacherExcel;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClass;

import java.util.List;
import java.util.Map;


/**
 * 

* <p>Title: YcTeacherService.java </p> 

* <p>Description: 教师Service</p> 

* <p>Copyright: Copyright (c) 2018年9月18日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年9月18日  

* @version 1.0
 */
public interface YcTeacherService {

	/**
	 *

	 * <p>Title: saveTeacher</p>

	 * <p>Description: 学校添加教师（单个添加）</p>

	 * @param id
	 * @return
	 * @throws Exception

	 * @email zhuangzhuang@xuezhifan.com

	 * @author zhuangzhuang

	 * @date 2018年9月18日
	 */
	YcUser getUserById(String id);

	/**
	 *

	 * <p>Title: saveTeacher</p>

	 * <p>Description: 学校添加教师（单个添加）</p>

	 * @param user
	 * @return
	 * @throws Exception

	 * @email zhuangzhuang@xuezhifan.com

	 * @author zhuangzhuang

	 * @date 2018年9月18日
	 */
	JacksonData saveTeacher(YcSchool school,YcUser user);

	/**
	 * 
	
	 * <p>Title: getTeacherBySchoolid</p>  
	
	 * <p>Description: 通过学校id查询教师</p>  
	
	 * @param id
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
	Page getTeacherBySchoolid(String id,Integer currentPage,Integer pageSize,String ycusername);

	/**
	 * 
	
	 * <p>Title: deleteTeacherById</p>  
	
	 * <p>Description: 删除教师信息（仅将删除状态修改为不展示）</p>  
	
	 * @param teacherId
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
	JacksonData deleteTeacherById(String teacherId);

	

	/**
	 * 
	
	 * <p>Title: saveTeacherBatch</p>  
	
	 * <p>Description: excel批量创建教师账户</p>  
	
	 * @param personList
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	 * @param personList
	 * @throws Exception 
	
	 * @date 2018年10月3日
	 */
	String saveTeacherBatch(YcSchool ycSchool, List<YcTeacherExcel> personList);

	/**
	 *

	 * <p>Title: updateTeacherUser</p>

	 * <p>Description: 修改教师信息</p>

	 * @param user
	 * @return
	 * @email xiaoyu@xuezhifan.com
	 * @author xiaoyu
	 * @date 2018年12月19日
	 */
	JacksonData updateTeacherUser(YcUser user);


}
