package yc.xuezhifan.schoolbackstage.active.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivity;

/**
* <p>Title: YcActivityMapper.java </p> 

* <p>Description: 活动表</p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年9月5日  

* @version 1.0
 */
@Mapper
public interface YcActivityMapper {

	/**
	 * 添加活动
	 * @param ycActivity
	 */
	Integer insertActivity(YcActivity ycActivity);
	
	/**
	 * 查询所有活动
	 * @param yc_school_district
	 * @return
	 */
	List<YcActivity> findAll(String yc_school_district);
	
	/**
	 * 根据id 查询 -->
	
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
	 * 根据发起人类型查询 -->

	 * <p>Title: selectByType</p>

	 * <p>Description: 根据发起人类型查询</p>

	 * @param type
	 * @return

	 * @email xiaoyu@xuezhifan.com

	 * @author xiaoyu

	 * @date 2019年1月13日
	 */
	List<YcActivity> selectByType(Integer type);

	/**
	 * <p>Title: selectByName</p>  
	
	 * <p>Description: 根据标题和用户昵称 查询活动</p>  
	
	 * @param yc_activity_title标题
	 * @param yc_activity_sponsor昵称
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月5日
	 */
	YcActivity selectByName(String yc_activity_title, String yc_activity_sponsor);
	
	/**
	 * <p>Title: modify</p>  
	
	 * <p>Description: 修改活动</p>  
	
	 * @param ycActivity
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月5日
	 */
	int modify(YcActivity ycActivity);
	
	/**
	 * 
	
	 * <p>Title: deleteActivity</p>  
	
	 * <p>Description: 删除活动</p>  
	
	 * @param id 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月6日
	 */
	Integer deleteActivity(String id);
}
