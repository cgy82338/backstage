package yc.xuezhifan.schoolbackstage.schoolnotice.service;

import com.github.pagehelper.PageInfo;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolnotice.bean.YcNoticeSchool;
import yc.xuezhifan.schoolbackstage.utils.Page;

import java.util.List;

/**  
* <p>Title: YcNoticeSchoolService.java </p> 

* <p>Description: 学校通知公告</p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年10月2日  

* @version 1.0  

*/
public interface YcNoticeSchoolService {

	/**
	 * <p>Title: insert</p>  
	
	 * <p>Description: 创建学校通知公告</p>  
	
	 * @param ycNoticeSchool
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年10月2日
	 */
	String insert(YcNoticeSchool ycNoticeSchool, YcSchool ycSchool);
	
	/**
	 * <p>Title: findAll</p>  
	
	 * <p>Description: 查询所有学校通知公告</p>  
	
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年10月2日
	 */
	List<YcNoticeSchool> findAll(Integer currentPage, Integer pageSize);
	
	/**
	 * <p>Title: noticeSchoolById</p>  
	
	 * <p>Description: 根据id查询</p>  
	
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年10月3日
	 */
	Page noticeSchoolById(String id, Integer currentPage, Integer pageSize);
	
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
	List<String> selectByUserToken(String yc_notice_class, Integer advertising_people);



}
