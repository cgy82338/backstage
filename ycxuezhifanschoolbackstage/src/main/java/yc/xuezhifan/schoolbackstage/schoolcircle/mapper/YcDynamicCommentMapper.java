package yc.xuezhifan.schoolbackstage.schoolcircle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.schoolcircle.bean.YcDynamicComment;
/**
 * 

* <p>Title: YcDynamicCommentMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月6日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年9月6日  

* @version 1.0
 */
@Mapper
public interface YcDynamicCommentMapper {

	
	/**
	 * 根据动态查询评论
	 * @return
	 */
	List<YcDynamicComment> findByDynamicId(String yc_circle_dynamic_id);
	
	/**
	 * 根据评论id删除
	 * @param yc_circle_dynamic_id
	 */
	void deleteByDynamic(String yc_circle_dynamic_id);
	
}
