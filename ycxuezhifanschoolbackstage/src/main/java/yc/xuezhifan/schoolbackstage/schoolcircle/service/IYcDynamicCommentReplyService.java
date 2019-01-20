package yc.xuezhifan.schoolbackstage.schoolcircle.service;


import java.util.List;

/**  

* <p>Title: IYcDynamicCommentReplyService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月6日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年9月6日  

* @version 1.0  

*/
public interface IYcDynamicCommentReplyService {

	/**
	 * 根据评论id删除
	 * @param yc_dynamic_comment_id
	 */
	void deleteByDynamic(List<String> yc_dynamic_comment_id);
}
