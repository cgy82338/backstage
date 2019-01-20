package yc.xuezhifan.schoolbackstage.teacher.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.teacher.bean.YcSubjectManagement;
import yc.xuezhifan.schoolbackstage.teacher.bean.YcTeacherManagement;
import yc.xuezhifan.schoolbackstage.teacher.vo.YcTeacherVo;


/**
 * 

* <p>Title: YcTeacherManagementMapper.java </p> 

* <p>Description: 教师管理Mapper</p> 

* <p>Copyright: Copyright (c) 2018年9月18日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年9月18日  

* @version 1.0
 */
@Mapper
public interface YcTeacherManagementMapper {

	/**
	 * 
	
	 * <p>Title: insertTeacherManagement</p>  
	
	 * <p>Description: 学校添加教师（单个添加）</p>  
	
	 * @param ycTeacherManagement
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月18日
	 */
	void insertTeacherManagement(YcTeacherManagement ycTeacherManagement);

	/**
	 *

	 * <p>Title: insertTeacherManagement</p>

	 * <p>Description: 学校批量添加教师 </p>

	 * @param ycTeacherVo

	 * @email zhuangzhuang@xuezhifan.com

	 * @author zhuangzhuang

	 * @date 2018年9月18日
	 */
	void insertTeacherManagement2(YcTeacherVo ycTeacherVo);
	
	/**
	 * 
	
	 * <p>Title: findAllBySchoolId</p>  
	
	 * <p>Description: 通过学校id查询教师</p>  
	
	 * @param id
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月21日
	 */
	List<YcTeacherVo> findAllBySchoolId(String id);
	
	
	/**
	 * 
	
	 * <p>Title: updateTeacherById</p>  
	
	 * <p>Description: 修改教师信息</p>  
	
	 * @param teacher
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
	int updateTeacherById(YcTeacherManagement teacher);

	/**
	 * 
	
	 * <p>Title: updateTeacherByTeacherId</p>  
	
	 * <p>Description: 将原信息修改为新账户信息（用户学校创建教师）</p>  
	
	 * @param ycTeacherVo 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年11月22日
	 */
	void updateTeacherByTeacherId(YcTeacherVo ycTeacherVo);

	/**
	 *

	 * <p>Title: getTeacherByUserId</p>

	 * <p>Description: 通过用户id查询教师科目管理表信息</p>

	 * @return

	 * @email xiaoyu@xuezhifan.com

	 * @author xiaoyu

	 * @date 2018年12月19日
	 */
	YcTeacherManagement getTeacherByUserId(String id);

	/**
	 *

	 * <p>Title: getSubjectByUserId</p>

	 * <p>Description: 通过教师管理科目表的科目id查询科目</p>

	 * @return

	 * @email xiaoyu@xuezhifan.com

	 * @author xiaoyu

	 * @date 2018年12月19日
	 */
	YcSubjectManagement getSubjectByUserId(String id);

	/**
	 * 
	
	 * <p>Title: findAll</p>  
	
	 * <p>Description: 查询所有科目</p>
	
	 * @return 
	
	 * @email xiaoyu@xuezhifan.com
	
	 * @author xiaoyu
	
	 * @date 2018年12月19日
	 */
	List<YcSubjectManagement> findSubjectAll();


	

	/**
	 * 
	
	 * <p>Title: findAllBySchoolId</p>  
	
	 * <p>Description: 通过学校id查询教师</p>  
	
	 * @param id
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
//	List<YcTeacherVo> findAllBySchoolId(String id);

	/**
	 * 
	
	 * <p>Title: selectByPhone</p>  
	
	 * <p>Description: 查询电话号码是否存在</p>  
	
	 * @param yc_phone
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
//	YcUser selectByPhone(String yc_phone);

	/**
	 * 
	
	 * <p>Title: insertUser</p>  
	
	 * <p>Description: 添加教师</p>  
	
	 * @param ycTeacherVo 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
//	void insertUser(YcTeacherVo ycTeacherVo);

	/**
	 * 
	
	 * <p>Title: selectById</p>  
	
	 * <p>Description: 根据Id查询教师信息</p>  
	
	 * @param id
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
//	YcUser selectById(String id);



	/**
	 * 
	
	 * <p>Title: deleteTeacherById</p>  
	
	 * <p>Description: 删除教师信息（仅将删除状态修改为不展示）</p>  
	
	 * @param id
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
//	int deleteTeacherById(String id);

	/**
	 * 
	
	 * <p>Title: findAll</p>  
	
	 * <p>Description: 查询所有教师信息</p>  
	
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月20日
	 */
//	List<YcTeacherVo> findAll();

	
}
