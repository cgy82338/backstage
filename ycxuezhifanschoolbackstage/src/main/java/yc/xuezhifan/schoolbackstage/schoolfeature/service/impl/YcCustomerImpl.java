package yc.xuezhifan.schoolbackstage.schoolfeature.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcCustomerService;
import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcSchoolFeatureStatus;
import yc.xuezhifan.schoolbackstage.schoolfeature.mapper.YcCustomerServiceMapper;
import yc.xuezhifan.schoolbackstage.schoolfeature.service.IYcCustomerService;
import yc.xuezhifan.schoolbackstage.schoolfeature.service.IYcSchoolFeatureStatusService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**  

* <p>Title: YcCustomerImpl.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月3日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月3日  

* @version 1.0  

*/
@Service
public class YcCustomerImpl implements IYcCustomerService{

	@Autowired
	private YcCustomerServiceMapper ycCustomerServiceMapper;
	
	@Autowired
	private IYcSchoolFeatureStatusService iYcSchoolFeatureStatusService;

	@Override
	@Transactional
	public String insert(YcCustomerService ycCustomerService, String yc_school_id, String yc_feature_id) {
		//创建学校功能状态
		YcSchoolFeatureStatus ycSchoolFeatureStatus = new YcSchoolFeatureStatus();
		//设置客服唯一标示
		ycCustomerService.setId(UUIDFactory.random());
		//添加功能唯一标示
		ycSchoolFeatureStatus.setYc_feature_id(yc_feature_id);
		//添加学校唯一标示
		ycSchoolFeatureStatus.setYc_school_id(yc_school_id);
		//添加装束客服唯一标示
		ycSchoolFeatureStatus.setYc_customer_service_id(ycCustomerService.getId());
		//得到添加结果并处理
		String result = iYcSchoolFeatureStatusService.insert(ycSchoolFeatureStatus);
		Integer rs = ycCustomerServiceMapper.insert(ycCustomerService);
		if (RegexUtil.isNotNull(rs) && YcSchoolConstants.SUCCESS.equals(result)) {
			return YcSchoolConstants.SUCCESS;
		}
		return YcSchoolConstants.FAILURE;
	}

	@Override
	public YcCustomerService selectById(String id) {
		return ycCustomerServiceMapper.selectById(id);
	}

	@Override
	public String update(YcCustomerService ycCustomerService) {
		Integer rs = ycCustomerServiceMapper.update(ycCustomerService);
		if (RegexUtil.isNotNull(rs)) {
			return YcSchoolConstants.SUCCESS;
		}
		return YcSchoolConstants.FAILURE;
	}
}
