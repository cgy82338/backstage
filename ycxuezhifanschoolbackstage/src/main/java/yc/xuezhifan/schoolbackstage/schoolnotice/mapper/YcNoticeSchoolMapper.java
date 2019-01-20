package yc.xuezhifan.schoolbackstage.schoolnotice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yc.xuezhifan.schoolbackstage.schoolnotice.bean.YcNoticeSchool;

/**
 * 
* <p>Title: YcNoticeSchoolMapper.java </p> 

* <p>Description:  学校通知公告表</p> 

* <p>Copyright: Copyright (c) 2018年12月1日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年12月1日  

* @version 1.0
 */
@Mapper
public interface YcNoticeSchoolMapper {

	void del(String id);
	/**
	 * 添加学校通知公告
	 * @param ycNoticeSchoolMapper
	 */
	Integer insert(List<YcNoticeSchool> ycNoticeSchool);
	
	/**
	 * 查询所有学校通知公告
	 * @return
	 */
	List<YcNoticeSchool> findAll(@Param("currentPage") Integer currentPage,
                                 @Param("pageSize") Integer pageSize);
	
	/**
	 * <p>Title: noticeSchoolById</p>  
	
	 * <p>Description: 根据id查询</p>  
	
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	 * @param id 
	
	 * @date 2018年10月3日
	 */
	List<YcNoticeSchool> noticeSchoolById(String id);
	
	/**
	 * <p>Title: noticeSchoolByUserId</p>  
	
	 * <p>Description: 根据发布人id查询</p>  
	
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	 * @param yc_notice_id
	
	 * @date 2018年10月3日
	 */
	List<YcNoticeSchool> noticeSchoolByUserId(String yc_notice_school);
	
	
	/**
	 * 
	 * <p>Title: selectByUserToken</p>  
	
	 * <p>Description: 根据班级Id获取家长的token</p>  
	
	 * @param yc_notice_class
	 * @param advertising_people
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年11月6日
	 */
	List<String> selectByUserToken(@Param("yc_notice_class") String yc_notice_class, @Param("advertising_people") Integer advertising_people);

}
