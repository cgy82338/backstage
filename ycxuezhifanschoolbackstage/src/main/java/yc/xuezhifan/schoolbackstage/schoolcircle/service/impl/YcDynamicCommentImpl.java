package yc.xuezhifan.schoolbackstage.schoolcircle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yc.xuezhifan.schoolbackstage.schoolcircle.bean.YcDynamicComment;
import yc.xuezhifan.schoolbackstage.schoolcircle.mapper.YcDynamicCommentMapper;
import yc.xuezhifan.schoolbackstage.schoolcircle.service.IYcDynamicCommentReplyService;
import yc.xuezhifan.schoolbackstage.schoolcircle.service.IYcDynamicCommentService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;

/**  

* <p>Title: YcDynamicCommentImpl.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月6日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年9月6日  

* @version 1.0  

*/
@Service
public class YcDynamicCommentImpl implements IYcDynamicCommentService{

	@Autowired
	private YcDynamicCommentMapper ycDynamicCommentMapper;
	
	@Autowired
	private IYcDynamicCommentReplyService iYcDynamicCommentReplyService;
	

	@Override
	public List<YcDynamicComment> findByDynamicId(String yc_circle_dynamic_id) {
		List<YcDynamicComment> ycDynamicComments = ycDynamicCommentMapper.findByDynamicId(yc_circle_dynamic_id);
		if (RegexUtil.isNotNull(ycDynamicComments)) {
			return ycDynamicComments;
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteByDynamic(String yc_circle_dynamic_id) {
		List<String> id = new ArrayList<String>();
		//根据评论得到所有回复
		List<YcDynamicComment> ycDynamicComments = findByDynamicId(yc_circle_dynamic_id);
		if (RegexUtil.isNotNull(ycDynamicComments)) {
			for (int i = 0; i < ycDynamicComments.size(); i++) {
				String ids = ycDynamicComments.get(i).getId();
				id.add(ids);
			}
			//删除评论
			ycDynamicCommentMapper.deleteByDynamic(yc_circle_dynamic_id);
			//删除回复
			iYcDynamicCommentReplyService.deleteByDynamic(id);
			
		}
	}
}
