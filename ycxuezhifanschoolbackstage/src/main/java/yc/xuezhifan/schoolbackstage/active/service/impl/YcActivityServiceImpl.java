package yc.xuezhifan.schoolbackstage.active.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivity;
import yc.xuezhifan.schoolbackstage.active.mapper.YcActivityMapper;
import yc.xuezhifan.schoolbackstage.active.service.YcActivityApplicantService;
import yc.xuezhifan.schoolbackstage.active.service.YcActivityService;
import yc.xuezhifan.schoolbackstage.constants.ActivityConstants;
import yc.xuezhifan.schoolbackstage.utils.AliyunOSSUtil;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;
/**
* <p>Title: YcActivityServiceImpl.java </p> 

* <p>Description: 活动表</p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年9月5日  

* @version 1.0
 */
@Service
public class YcActivityServiceImpl implements YcActivityService{

	@Autowired
	private YcActivityMapper ycActivityMapper;
	
	@Autowired
	private YcActivityApplicantService ycActivityApplicantService;
	
	@Value("${YcActivity.Image}")
	private String image;
	
	
	/**
	 * 添加活动
	 */
	@Override
	public String insertActivity(YcActivity ycActivity) {
		//判断如果没有添加图片，则系统默认添加
		if (RegexUtil.isNull(ycActivity.getYc_activity_cover_image())) {
			ycActivity.setYc_activity_cover_image(image);
		}
		//设置唯一标示
		ycActivity.setId(UUIDFactory.random());
		ycActivity.setYc_activity_type(1);
		Integer activity = ycActivityMapper.insertActivity(ycActivity);
		if (RegexUtil.isNotNull(activity)) {
			return ActivityConstants.SUCCESS;
		}
		return ActivityConstants.FAILURE;
	}

	/**
	 * 修改活动
	 */
	@Override
	public String modify(YcActivity ycActivity) {
		
		YcActivity selectByName = ycActivityMapper.selectById(ycActivity.getId());
	
		if (RegexUtil.isNotNull(selectByName)) {
			int modify = ycActivityMapper.modify(ycActivity);
			if (RegexUtil.isNotNull(modify)) {
				return ActivityConstants.SUCCESS;
			}
			return ActivityConstants.FAILURE;
		}
		return ActivityConstants.NOTEXISTED;
	}

	/**
	 * 删除活动
	 */
	@Override
	@Transactional
	public String deleteActivity(String id) {
		YcActivity activity = ycActivityMapper.selectById(id);
		//判断是否存在
		if (RegexUtil.isNotNull(activity)) {
			//删除封面图
			AliyunOSSUtil.deleteObject(activity.getYc_activity_cover_image());
			//删除详情页
			AliyunOSSUtil.deleteObject(activity.getYc_activity_details());
			Integer activitys = ycActivityMapper.deleteActivity(id);
			if (RegexUtil.isNotNull(activitys)) {
				//删除报名人信息
				ycActivityApplicantService.deleteByActiveId(id);
				return ActivityConstants.SUCCESS;
			} else {
				return ActivityConstants.FAILURE;
			}
		}
		return ActivityConstants.NOTEXISTED;
	}

	/**
	 * 根据id 查询
	 */
	@Override
	public YcActivity selectById(String id) {
		
		return  ycActivityMapper.selectById(id);
	}

	/**
	 * 查询所有活动
	 */
	@Override
	public PageInfo<YcActivity> findAllActivity(Integer pageNum, Integer pageSize, String yc_school_district) {
		List<YcActivity> findAllActivity = ycActivityMapper.findAll(yc_school_district);
		if (RegexUtil.isNotNull(findAllActivity)) {
			PageHelper.startPage(pageNum, pageSize);
			return new PageInfo<>(findAllActivity);
		}
		return null;
	}

}
