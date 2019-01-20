package yc.xuezhifan.schoolbackstage.ycClass.service;

import java.util.List;
import java.util.Map;

import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClass;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClassExcel;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcIntermediateTable;
import yc.xuezhifan.schoolbackstage.ycClass.vo.YcClassVo;

/**
 * 

* <p>Title: YcClassService.java </p> 

* <p>Description: 班级管理Service</p> 

* <p>Copyright: Copyright (c) 2018年9月22日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年9月22日  

* @version 1.0
 */
public interface YcClassService {



	/**
	 * <p>
	 * Title: saveClass
	 * </p>
	 *
	 * <p>
	 * Description: 创建班级信息
	 * </p>
	 *
	 * @param ycClassVo
	 * @return
	 * @email xiaoyu@xuezhifan.com
	 * @author xiaoyu
	 * @date 2019年1月7日
	 */
	JacksonData saveClass(YcSchool ycSchool,YcClassVo ycClassVo);
	

	/**
	 * 
	
	 * <p>Title: updateClass</p>  
	
	 * <p>Description: 修改班级信息</p>  
	
	 * @param ycClassVo
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	 * @param ycClassVo
	 * @date 2018年9月22日
	 */
	public JacksonData updateClass(YcSchool ycSchool,YcClassVo ycClassVo);

	

	/**
	 * 
	
	 * <p>Title: getClassByschoolid</p>  
	
	 * <p>Description: 查询本学校班级信息</p>  
	
	 * @param id
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年9月22日
	 */
	Page getClassByschoolid(String id,Integer currentPage, Integer pageSize, String ycusername);

	/**
	 * 
	
	 * <p>Title: getClassByClassId</p>  
	
	 * <p>Description: 根据班级Id查询</p>  
	
	 * @param classId
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年11月2日
	 */
	public YcClass getClassByClassId(String classId);

	/**
	 * 
	
	 * <p>Title: saveClassBatch</p>  
	
	 * <p>Description: 导入表格并批量添加数据</p>  
	
	 * @param ycSchool
	 * @param personList
	 * @return 
	
	 * @email zhuangzhuang@xuezhifan.com
	
	 * @author zhuangzhuang
	
	 * @date 2018年11月5日
	 */
	public String saveClassBatch(YcSchool ycSchool, List<YcClassExcel> personList);


	/**
	 * 通过学校id查询本校教师
	 */
	List<YcUser> findUserBySchoolId(String id);


	/**
	 * 通过班级id查询任课教师
	 */
	List<YcIntermediateTable> findClassTeacher(String id);

	/**
	 * 通过用户id查询用户信息
	 */
	YcUser findUserById(String id);



}
