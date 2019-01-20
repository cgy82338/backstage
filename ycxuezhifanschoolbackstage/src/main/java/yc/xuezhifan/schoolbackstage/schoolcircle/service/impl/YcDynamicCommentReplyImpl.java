package yc.xuezhifan.schoolbackstage.schoolcircle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yc.xuezhifan.schoolbackstage.schoolcircle.mapper.YcDynamicCommentReplyMapper;
import yc.xuezhifan.schoolbackstage.schoolcircle.service.IYcDynamicCommentReplyService;

/**  

* <p>Title: YcDynamicCommentReplyImpl.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月6日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年9月6日  

* @version 1.0  

*/
@Service
public class YcDynamicCommentReplyImpl implements IYcDynamicCommentReplyService{
	
	@Autowired
	private YcDynamicCommentReplyMapper ycDynamicCommentReplyMapper;
	
	@Override
	public void deleteByDynamic(List<String> yc_dynamic_comment_id) {
		ycDynamicCommentReplyMapper.deleteByDynamic(yc_dynamic_comment_id);		
	}

}
