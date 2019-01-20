package yc.xuezhifan.schoolbackstage.schoolcircle.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.schoolcircle.bean.YcCircleDynamicLike;

/**
 * 

* <p>Title: YcCircleDynamicLikeMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年9月5日  

* @version 1.0
 */
@Mapper
public interface YcCircleDynamicLikeMapper {

	/**
	 * 根据动态获取点赞详情
	 * @param yc_circle_dynamic_id
	 * @return
	 */
	List<YcCircleDynamicLike> getLikeByDynamicId(String yc_circle_dynamic_id);
	
	/**
	 * 根据动态id删除点赞信息
	 * @param yc_circle_dynamic_id
	 */
	void deleteByDynamic(String yc_circle_dynamic_id);
}
