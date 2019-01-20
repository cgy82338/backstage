package yc.xuezhifan.schoolbackstage.ycClass.service;

import java.util.List;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcParentClass;


public interface YcParentClassService {
	
	//验证
	YcParentClass findByParent(YcParentClass ycParentClass);
	//根据班级id查询班级管理员信息
	List<YcParentClass> findByClassId(String yc_class_id);
	//修改班级记录
	void modify(YcParentClass parentClass);
	/**
	 * 
	
	 * <p>Title: save</p>  
	
	 * <p>Description: </p>  
	
	 * @param yc_parent_id 教师id
	 * @param yc_class_id 班级id
	 * @param yc_status 状态(1：通过 2:拒绝,3申请4:已退出)
	 * @param yc_permission_status 权限（1群主2管理员3平民）
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月27日
	 */
	void save(String yc_parent_id, String yc_class_id, Integer yc_status, Integer yc_permission_status);
	//根据id 查询家长班级关系记录
	YcParentClass selectById(String id);
	/**
	 * 
	
	 * <p>Title: findByClass</p>  
	
	 * <p>Description:根据用户id 查询所属的班级id </p>  
	
	 * @param ycUser
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月20日
	 */
	List<YcParentClass> findByClass(YcUser ycUser);
	/**
	 * 
	
	 * <p>Title: delete</p>  
	
	 * <p>Description:家长退出班级 </p>  
	
	 * @param ycParentClass 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月20日
	 */
	void delete(String yc_parent_id, String yc_class_id) throws Exception;
	/**
	 * 
	
	 * <p>Title: findGroupByClassId</p>  
	
	 * <p>Description:根据班级id 查询所有所有成员 </p>  
	
	 * @param yc_class_id
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月20日
	 */
	List<YcParentClass> findGroupByClassId(String yc_class_id);
	/**
	 * 
	
	 * <p>Title: findParentClassBatch</p>  
	
	 * <p>Description:根据班级Id 及家长Id 查询所有 群成员信息 </p>  
	
	 * @param yc_class_id 班级id
	 * @param parentId 家长id 数组
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月22日
	 */
	List<YcParentClass> findParentClassBatch(String yc_class_id, String[] parentId);
	/**
	 * 
	
	 * <p>Title: findPatentClassByClassId</p>  
	
	 * <p>Description:根据id </p>  
	
	 * @param yc_class_id
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月24日
	 */
	List<YcParentClass> findPatentClassByClassId(String yc_class_id);
	/**
	 * 
	
	 * <p>Title: modify</p>  
	
	 * <p>Description:修改班级及家长信息 </p>  
	
	 * @param ycUser
	 * @param ycParentClass
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月27日
	 */
	String modify(YcUser ycUser, YcParentClass ycParentClass);
	/**
	*
	 * <p>Title: deleteByClassId</p>  
	
	 * <p>Description:根据班级解散群成员 </p>  
	
	 * @param ClassId
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	 * 
	
	 * @date 2018年12月8日
	 */
	Boolean deleteByClassId(String ClassId);
	/**
	 * 
	
	 * <p>Title: modifyTeacherStatus</p>  
	
	 * <p>Description:删除教师和教师换班级时修改用户表 </p>  
	
	 * @param yc_tearcher_id
	 * @param yc_class_id
	 * @param yc_permission_status
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年12月20日
	 */
	String modifyTeacherStatus(String yc_tearcher_id, String yc_class_id, Integer yc_permission_status);
	/**
	 * 
	
	 * <p>Title: modifyTearche</p>  
	
	 * <p>Description:更换班主任 </p>  
	
	 * @param yc_tearcher_id
	 * @param yc_targer_tearcher_id
	 * @param yc_class_id
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年12月20日
	 */
	String modifyTearche(String yc_tearcher_id, String yc_targer_tearcher_id, String yc_class_id);


}
