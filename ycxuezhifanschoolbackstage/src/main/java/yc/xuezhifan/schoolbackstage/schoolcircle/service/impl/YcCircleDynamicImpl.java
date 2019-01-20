package yc.xuezhifan.schoolbackstage.schoolcircle.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yc.xuezhifan.schoolbackstage.constants.YcCircleDynamicConstants;
import yc.xuezhifan.schoolbackstage.schoolcircle.bean.YcCircleDynamic;
import yc.xuezhifan.schoolbackstage.schoolcircle.mapper.YcCircleDynamicMapper;
import yc.xuezhifan.schoolbackstage.schoolcircle.service.IYcCircleDynamicLikeService;
import yc.xuezhifan.schoolbackstage.schoolcircle.service.IYcCircleDynamicService;
import yc.xuezhifan.schoolbackstage.schoolcircle.service.IYcDynamicCommentService;
import yc.xuezhifan.schoolbackstage.utils.AliyunOSSUtil;
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
public class YcCircleDynamicImpl implements IYcCircleDynamicService{

	@Autowired
	private YcCircleDynamicMapper ycCircleDynamicMapper;
	
	@Autowired
	private IYcDynamicCommentService iYcDynamicCommentService;
	
	@Autowired
	private IYcCircleDynamicLikeService iYcCircleDynamicLikeService;


	@Override
	public List<YcCircleDynamic> selectBySchool(String yc_school_id, Integer currentPage, Integer pageSize) {
		List<YcCircleDynamic> ycCircleDynamics = ycCircleDynamicMapper.selectBySchool(yc_school_id, currentPage, pageSize);
		if (RegexUtil.isNull(ycCircleDynamics)) {
			return null;
		}
		return ycCircleDynamics;
	}

	@Override
	@Transactional
	public String delete(String id) {
		//判断是否存在
		YcCircleDynamic ycCircleDynamic = ycCircleDynamicMapper.seletById(id);
		if (RegexUtil.isNull(ycCircleDynamic)) {
			return YcCircleDynamicConstants.IS_DELETE;
		}
		//删除动态对应的评论
		iYcDynamicCommentService.deleteByDynamic(id);
		//删除动态对应的点赞
		iYcCircleDynamicLikeService.deleteByDynamic(id);
		//得到oss存储动态内容,并删除
		if (ycCircleDynamic.getYc_dynamic_image() != null) {
			String[] path = ycCircleDynamic.getYc_dynamic_image().split(",");
			AliyunOSSUtil.deleteObjectList(Arrays.asList(path));
		}
		if (ycCircleDynamic.getYc_dynamic_video() != null) {
			String[] path = ycCircleDynamic.getYc_dynamic_video().split(",");
			AliyunOSSUtil.deleteObjectList(Arrays.asList(path));
		}
		Integer result = ycCircleDynamicMapper.delete(id);
		if (RegexUtil.isNotNull(result)) {
			return YcCircleDynamicConstants.SUCCESS;
		}
		return YcCircleDynamicConstants.FAILURE;
	}

}
