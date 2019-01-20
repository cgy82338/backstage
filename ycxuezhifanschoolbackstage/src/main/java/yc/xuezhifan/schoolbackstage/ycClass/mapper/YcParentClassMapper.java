package yc.xuezhifan.schoolbackstage.ycClass.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcParentClass;



/**
 * @author linxiao
 * @version 创建时间：2018年8月9日 上午8:26:43
 * 家长班级关系表
 */
@Mapper
public interface YcParentClassMapper {

	/**
	 * 添加家长班级关系 
	 * @param ycParentClass
	 */
	Integer addParentClass(YcParentClass ycParentClass);

	/**
	 * 查询所有家长班级关系
	 * @return
	 */
//	List<YcParentClass> findAll();

	/**
	 *

	 * <p>Title: selectParentClassByParent</p>  

	 * <p>Description: 根据家长id查询家长班级关系</p>  

	 * @param id
	 * @return

	 * @email zhuangzhuang@xuezhifan.com

	 * @author zhuangzhuang

	 * @date 2018年10月7日
	 */
	List<YcParentClass> selectParentClassByParent(String parentId);

	/**
	 *

	 * <p>Title: deleteParentClass</p>  

	 * <p>Description: 根据家长和班级id删除关系信息</p>  

	 * @param yc_parent_id
	 * @param classId

	 * @email zhuangzhuang@xuezhifan.com

	 * @author zhuangzhuang
	 * @return

	 * @date 2018年10月9日
	 */
	Integer deleteParentClass(@Param("yc_parent_id") String yc_parent_id, @Param("yc_class_id") String yc_class_id);

	/**
	 *

	 * <p>Title: deleteByParent</p>  

	 * <p>Description: 根据家长Id删除所有关系</p>  

	 * @param parentId

	 * @email zhuangzhuang@xuezhifan.com

	 * @author zhuangzhuang

	 * @date 2018年11月7日
	 */
	void deleteByParent(String parentId);

	/**
	 *

	 * <p>Title: findByParent</p>  

	 * <p>Description:根据家长关系信息查询家长是否已经和班级存在关系 </p>  

	 * @param ycParentClass
	 * @return

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke

	 * @date 2018年11月19日
	 */
	YcParentClass findByParent(YcParentClass ycParentClass);
	/**
	 *

	 * <p>Title: findByClassId</p>  

	 * <p>Description: 根据班级id 查询管理员 </p>  

	 * @param yc_class_id
	 * @return

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke

	 * @date 2018年11月19日
	 */
	List<YcParentClass> findByClassId(String yc_class_id);
	/**
	 *

	 * <p>Title: modify</p>  

	 * <p>Description:修改家长与班级的关系 </p>  

	 * @param parentClass

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke
	 * @return

	 * @date 2018年11月19日
	 */
	int modify(YcParentClass parentClass);
	/**
	 *

	 * <p>Title: selectById</p>

	 * <p>Description:根据家长班级关系记录 </p>

	 * @param id
	 * @return

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke

	 * @date 2018年11月19日
	 */
	YcParentClass selectById(String id);
	/**
	 *

	 * <p>Title: findByClass</p>

	 * <p>Description:根据用户id 查询班级信息列表 </p>

	 * @param ycUser
	 * @return

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke

	 * @date 2018年11月20日
	 */

	List<YcParentClass> findByClass(YcUser ycUser);
	/**
	 *

	 * <p>Title: findGroupByClassId</p>

	 * <p>Description:根据班级id 查询所有成员 </p>

	 * @param yc_class_id
	 * @return

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke

	 * @date 2018年11月20日
	 */
	List<YcParentClass> findGroupByClassId(@Param("yc_class_id") String yc_class_id);
	/**
	 *

	 * <p>Title: findParentClassBatch</p>

	 * <p>Description:根据家长Id及班级Id 查询班级成员信息 </p>

	 * @param yc_class_id 班级id
	 * @param parentId 家长Id 数组
	 * @return

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke

	 * @date 2018年11月22日
	 */
	List<YcParentClass> findParentClassBatch(@Param("yc_class_id") String yc_class_id, @Param("parentId") String[] parentId);
	/**
	 *

	 * <p>Title: findPatentClassByClassId</p>

	 * <p>Description:根据班级id查询 班级成员信息列表 </p>

	 * @param yc_class_id
	 * @return

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke

	 * @date 2018年11月27日
	 */
	List<YcParentClass> findPatentClassByClassId(String yc_class_id);
	/**
	 *

	 * <p>Title: selectParentClass</p>

	 * <p>Description: 根据用户id 和班级id 查询用户与班级信息</p>

	 * @param id 用户id
	 * @param yc_class_id
	 * @return

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke

	 * @date 2018年11月27日
	 */
	YcParentClass selectParentClass(@Param("id") String id,@Param("yc_class_id") String yc_class_id);

	/*
	根据parnetid查询数据
	 */
	List<YcParentClass> findByParentId(String yc_parent_id);

	/*
	根据id修改群权限（删除教师，权限都修改为4已离职教师）
	 */
	Integer delTeacher(String id);
}

