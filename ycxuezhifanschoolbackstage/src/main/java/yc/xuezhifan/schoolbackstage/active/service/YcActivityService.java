package yc.xuezhifan.schoolbackstage.active.service;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivity;

/**
* <p>Title: YcActivityService.java </p> 

* <p>Description: 活动表</p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年9月5日  

* @version 1.0
 */
public interface YcActivityService {

	/**
	 * <p>Title: insertActivity</p>  
	
	 * <p>Description: 添加活动</p>  
	
	 * @param ycActivity
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月5日
	 */
	String insertActivity(YcActivity ycActivity);
	
	/**
	 * <p>Title: modify</p>  
	
	 * <p>Description: 修改活动</p>  
	
	 * @param ycActivity
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月5日
	 */
	String modify(YcActivity ycActivity);
	
	/**
	 * 
	
	 * <p>Title: deleteActivity</p>  
	
	 * <p>Description: 删除活动</p>  
	
	 * @param ycUser
	 * @param ycActivity
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月6日
	 */
	String deleteActivity(String id);
	
	
	/**
	 * 
	
	 * <p>Title: selectById</p>  
	
	 * <p>Description: 根据id 查询</p>  
	
	 * @param id
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月6日
	 */
	YcActivity selectById(String id);
	
	/**
	 * <p>Title: findAllActivity</p>  
	
	 * <p>Description: 查询所有活动</p>  
	
	 * @param pageNum
	 * @param pageSize
	 * @param classIds
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	 * @param ycAdmin 
	
	 * @date 2018年9月6日
	 */
	PageInfo<YcActivity> findAllActivity(Integer pageNum, Integer pageSize, String yc_school_id);
}
