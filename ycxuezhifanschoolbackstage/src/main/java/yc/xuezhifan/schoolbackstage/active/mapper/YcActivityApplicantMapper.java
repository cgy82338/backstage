package yc.xuezhifan.schoolbackstage.active.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivityApplicant;
/**
* <p>Title: YcActivityApplicantMapper.java </p> 

* <p>Description: 活动报名人表</p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年9月5日  

* @version 1.0
 */
@Mapper
public interface YcActivityApplicantMapper {
	
	/**
	 * 根据活动id得到报名人信息（分页）
	 * @param yc_activity_id 活动id
	 * @return
	 */
	List<YcActivityApplicant> selectByActivityId(String yc_activity_id);

	
	/**
	 * 根据id得到报名人信息 -->
	
	 * <p>Title: selectByAId</p>  
	
	 * <p>Description: </p>  
	
	 * @param id
	 * @param yc_activity_id
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年9月6日
	 */
	YcActivityApplicant selectById(String id);
	
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
	Integer modify(YcActivityApplicant ycActivityApplicant);

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
	Integer deleteActivityApplicant(String id);
	
	/**
	 * 根据活动id删除
	 * @param yc_activity_id
	 * @return
	 */
	Integer deleteByActiveId(String yc_activity_id);
}
