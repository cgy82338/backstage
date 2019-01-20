package yc.xuezhifan.schoolbackstage.schoolfeature.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yc.xuezhifan.schoolbackstage.constants.YcSchoolConstants;
import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcCertification;
import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcSchoolFeatureStatus;
import yc.xuezhifan.schoolbackstage.schoolfeature.mapper.YcCertificationMapper;
import yc.xuezhifan.schoolbackstage.schoolfeature.service.IYcCertificationService;
import yc.xuezhifan.schoolbackstage.schoolfeature.service.IYcSchoolFeatureStatusService;
import yc.xuezhifan.schoolbackstage.utils.AliyunOSSUtil;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**
 * 
 * <p>
 * Title: YcCertificationImpl.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年10月2日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年10月2日
 * 
 * @version 1.0
 * 
 */
@Service
public class YcCertificationImpl implements IYcCertificationService {

	@Autowired
	private YcCertificationMapper ycCertificationMapper;

	@Autowired
	private IYcSchoolFeatureStatusService iYcSchoolFeatureStatusService;

	@Override
	@Transactional
	public String insert(YcCertification ycCertification, String yc_school_id, String yc_feature_id) {
		// 创建学校功能状态
		YcSchoolFeatureStatus ycSchoolFeatureStatus = new YcSchoolFeatureStatus();
		// 设置认证唯一标示
		ycCertification.setYc_certification_id(UUIDFactory.random());
		// 添加学校唯一标示
		ycSchoolFeatureStatus.setYc_school_id(yc_school_id);
		// 添加功能唯一标示
		ycSchoolFeatureStatus.setYc_feature_id(yc_feature_id);
		// 添加认证唯一标示
		ycSchoolFeatureStatus.setYc_certification_id(ycCertification.getYc_certification_id());
		String rs = iYcSchoolFeatureStatusService.insert(ycSchoolFeatureStatus);
		// 得到添加结果并处理
		Integer result = ycCertificationMapper.insert(ycCertification);
		if (RegexUtil.isNotNull(result) && YcSchoolConstants.SUCCESS.equals(rs)) {
			return YcSchoolConstants.SUCCESS;
		}
		return YcSchoolConstants.FAILURE;
	}

	@Override
	public YcCertification selectById(String yc_certification_id) {

		return ycCertificationMapper.selectById(yc_certification_id);
	}

	@Override
	@Transactional
	public String update(YcCertification ycCertification) {
		// 判断是否存在
		YcCertification certification = selectById(ycCertification.getYc_certification_id());
		if (RegexUtil.isNull(certification)) {
			return YcSchoolConstants.NOT_EXISTED;
		}
		// 当证书改变时删除oss上旧文件
		if (RegexUtil.isNotNull(ycCertification.getYc_certification_certificate()) && ycCertification
				.getYc_certification_certificate().equals(certification.getYc_certification_certificate())) {
			AliyunOSSUtil.deleteObject(certification.getYc_certification_certificate());
		}
		Integer rs = ycCertificationMapper.update(ycCertification);
		if (RegexUtil.isNotNull(rs)) {
			return YcSchoolConstants.SUCCESS;
		}
		return YcSchoolConstants.FAILURE;
	}
}
