package yc.xuezhifan.schoolbackstage.active.service;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivityApplicant;

import java.util.List;

/**
* <p>Title: YcActivityApplicantService.java </p> 

* <p>Description: 活动报名人表</p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年9月5日  

* @version 1.0
 */
public interface YcActivityApplicantService {
	
	/**
	 * 
	
	 * <p>Title: modify</p>  
	
	 * <p>Description: 修改活动报名人</p>  
	
	 * @param ycActivityApplicant
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月6日
	 */
	String modify(YcActivityApplicant ycActivityApplicant);
	
	/**
	 * 
	
	 * <p>Title: deleteActivityApplicant</p>  
	
	 * <p>Description: 删除活动报名人</p>  
	
	 * @param id
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月6日
	 */
	String deleteActivityApplicant(String id);
	
	/**
	 * <p>Title: selectByActivityId</p>  
	
	 * <p>Description: 根据活动id得到报名人信息(分页)</p>
	
	 * @param id
	 * @param yc_activity_id
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月6日
	 */
	PageInfo<YcActivityApplicant> selectByActivityId(String yc_activity_id, Integer currentPage, Integer pageSize);
	/*
	根据活动id得到报名人信息（不分页）
	 */
	List<YcActivityApplicant> selectByActivityIds(String yc_activity_id);
	
	/**
	 * 
	
	 * <p>Title: selectByAId</p>  
	
	 * <p>Description: 根据 活动报名人id 得到报名人信息</p>  
	
	 * @param id
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月6日
	 */
	YcActivityApplicant selectByAId(String id);
	
	/**
	 * 根据活动id删除报名人
	 * @param yc_activity_id
	 * @return
	 */
	String deleteByActiveId(String yc_activity_id);


	
}
