package yc.xuezhifan.schoolbackstage.schoolcircle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yc.xuezhifan.schoolbackstage.schoolcircle.bean.YcDynamicCommentReply;

/**
 * 

* <p>Title: YcDynamicCommentReplyMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月7日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年9月7日  

* @version 1.0
 */
@Mapper
public interface YcDynamicCommentReplyMapper {

	/**
	 * 查询动态评论回复
	 * @return
	 */
	List<YcDynamicCommentReply> selectById(String yc_dynamic_comment_id);
	
	/**
	 * 根据父类id查询
	 * @param yc_reply_content
	 * @return
	 */
	List<YcDynamicCommentReply> selectByReply(String yc_reply_content);
	
	/**
	 * 根据评论id删除
	 * @param yc_dynamic_comment_id
	 */
	void deleteByDynamic(@Param("yc_dynamic_comment_id") List<String> yc_dynamic_comment_id);
	
}
