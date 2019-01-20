package yc.xuezhifan.schoolbackstage.schoolfeature.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcSchoolFeatureStatus;
import yc.xuezhifan.schoolbackstage.schoolfeature.mapper.YcSchoolFeatureStatusMapper;
import yc.xuezhifan.schoolbackstage.schoolfeature.service.IYcSchoolFeatureStatusService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**  

* <p>Title: YcSchoolFeatureStatusImpl.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月2日  

* @version 1.0  

*/
@Service
public class YcSchoolFeatureStatusImpl implements IYcSchoolFeatureStatusService{

	@Autowired
	private YcSchoolFeatureStatusMapper ycSchoolFeatureStatusMapper;

	@Override
	public String insert(YcSchoolFeatureStatus ycSchoolFeatureStatus) {
		//设置唯一标示
		ycSchoolFeatureStatus.setId(UUIDFactory.random());
		//设置开通时间
		ycSchoolFeatureStatus.setYc_feature_open_time(new Date());
		Integer result = ycSchoolFeatureStatusMapper.insert(ycSchoolFeatureStatus);
		if (RegexUtil.isNotNull(result)) {
			return YcSchoolConstants.SUCCESS;
		}
		return YcSchoolConstants.FAILURE;
	}

	@Override
	public String update(YcSchoolFeatureStatus ycSchoolFeatureStatus) {
		Integer result = ycSchoolFeatureStatusMapper.update(ycSchoolFeatureStatus);
		if (RegexUtil.isNotNull(result)) {
			return YcSchoolConstants.SUCCESS;
		}
		return YcSchoolConstants.FAILURE;
	}

	@Override
	public PageInfo<YcSchoolFeatureStatus> selectBySchool(String yc_school_id, Integer currentPage, Integer pageSize) {
		List<YcSchoolFeatureStatus> ycSchoolFeatureStatus = ycSchoolFeatureStatusMapper.selectBySchool(yc_school_id);
		if (RegexUtil.isNotNull(ycSchoolFeatureStatus)) {
			PageHelper.startPage(currentPage, pageSize);
			return new PageInfo<>(ycSchoolFeatureStatus);
		}
		return null;
	}
}
