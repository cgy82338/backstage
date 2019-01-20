package yc.xuezhifan.schoolbackstage.schoolcircle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yc.xuezhifan.schoolbackstage.schoolcircle.bean.YcCircleDynamicLike;
import yc.xuezhifan.schoolbackstage.schoolcircle.mapper.YcCircleDynamicLikeMapper;
import yc.xuezhifan.schoolbackstage.schoolcircle.service.IYcCircleDynamicLikeService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;

/**  

* <p>Title: YcCircleDynamicLikeImpl.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年9月5日  

* @version 1.0  

*/
@Service
public class YcCircleDynamicLikeImpl implements IYcCircleDynamicLikeService{

	@Autowired
	private YcCircleDynamicLikeMapper ycCircleDynamicLikeMapper;
	
	@Override
	public List<YcCircleDynamicLike> getLikeByDynamicId(String yc_circle_dynamic_id) {
		List<YcCircleDynamicLike> ycCircleDynamicLikes = ycCircleDynamicLikeMapper.getLikeByDynamicId(yc_circle_dynamic_id);
		if (RegexUtil.isNotNull(ycCircleDynamicLikes)) {
			return ycCircleDynamicLikes;
		}
		return null;
	}

	@Override
	public void deleteByDynamic(String yc_circle_dynamic_id) {
		ycCircleDynamicLikeMapper.deleteByDynamic(yc_circle_dynamic_id);
	}

}
