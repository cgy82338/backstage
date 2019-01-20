package yc.xuezhifan.schoolbackstage.active.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivityApplicant;
import yc.xuezhifan.schoolbackstage.active.mapper.YcActivityApplicantMapper;
import yc.xuezhifan.schoolbackstage.active.service.YcActivityApplicantService;
import yc.xuezhifan.schoolbackstage.constants.ActivityConstants;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;

/**
 * 

* <p>Title: YcActivityApplicantServiceImpl.java </p> 

* <p>Description: 活动报名人表</p> 

* <p>Copyright: Copyright (c) 2018年9月5日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年9月5日  

* @version 1.0
 */
@Service
public class YcActivityApplicantServiceImpl implements YcActivityApplicantService{

	@Autowired
	private YcActivityApplicantMapper ycActivityApplicantMapper;

	/**
	 * 修改活动报名人
	 */
	@Override
	public String modify(YcActivityApplicant ycActivityApplicant) {
		YcActivityApplicant selectByName = ycActivityApplicantMapper.selectById(ycActivityApplicant.getId());
		//判断是否存在
		if (RegexUtil.isNotNull(selectByName)) {
			int modify = ycActivityApplicantMapper.modify(ycActivityApplicant);
			if (RegexUtil.isNotNull(modify)) {
				return ActivityConstants.SUCCESS;
			}
			return ActivityConstants.FAILURE;
		}
		return ActivityConstants.NOTEXISTED;
	}

	/**
	 * 删除活动报名人
	 */
	@Override
	public String deleteActivityApplicant(String id) {
		YcActivityApplicant ycActivityApplicant = ycActivityApplicantMapper.selectById(id);
		if (RegexUtil.isNotNull(ycActivityApplicant)) {
			Integer activitys = ycActivityApplicantMapper.deleteActivityApplicant(id);
			if (RegexUtil.isNotNull(activitys)) {
				return ActivityConstants.SUCCESS;
			} else {
				return ActivityConstants.FAILURE;
			}
		}
		return ActivityConstants.NOTEXISTED;
	}

	@Override
	public PageInfo<YcActivityApplicant> selectByActivityId(String yc_activity_id, Integer currentPage, Integer pageSize) {
		List<YcActivityApplicant> ycActivityApplicants = ycActivityApplicantMapper.selectByActivityId(yc_activity_id);
		if (RegexUtil.isNotNull(ycActivityApplicants)) {
			PageHelper.startPage(currentPage, pageSize);
			return new PageInfo<>(ycActivityApplicants);
		}
		return null;
	}

	@Override
	public List<YcActivityApplicant> selectByActivityIds(String yc_activity_id) {
		return ycActivityApplicantMapper.selectByActivityId(yc_activity_id);
	}

	@Override
	public YcActivityApplicant selectByAId(String id) {
		return ycActivityApplicantMapper.selectById(id);
	}

	@Override
	public String deleteByActiveId(String yc_activity_id) {
		List<YcActivityApplicant> ycActivityApplicants = ycActivityApplicantMapper.selectByActivityId(yc_activity_id);
		//判断是否存在
		if (RegexUtil.isNull(ycActivityApplicants)) {
			return ActivityConstants.NOTEXISTED;
		}
		Integer rs = ycActivityApplicantMapper.deleteByActiveId(yc_activity_id);
		if (RegexUtil.isNotNull(rs)) {
			return ActivityConstants.SUCCESS;
		}
		return ActivityConstants.FAILURE;
	}

}
