package yc.xuezhifan.schoolbackstage.advertising.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcPushAd;
import yc.xuezhifan.schoolbackstage.advertising.mapper.YcPushAdMapper;
import yc.xuezhifan.schoolbackstage.advertising.service.IYcPushAdService;
import yc.xuezhifan.schoolbackstage.advertising.space.service.IYcAdvertisingSpaceAreaService;
import yc.xuezhifan.schoolbackstage.constants.YcAdvertisingSpaceConstants;
import yc.xuezhifan.schoolbackstage.utils.AliyunOSSUtil;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**
 * 
 * <p>
 * Title: YcPushAdImpl.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年10月23日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年10月23日
 * 
 * @version 1.0
 * 
 */
@Service
public class YcPushAdImpl implements IYcPushAdService {

	@Autowired
	private YcPushAdMapper ycPushAdMapper;

	@Autowired
	private IYcAdvertisingSpaceAreaService iYcAdvertisingSpaceAreaService;

	@Override
	public PageInfo<YcPushAd> findAll(YcPushAd ycPushAd, Integer currentPage, Integer pageSize) {
		List<YcPushAd> ycPushAds = ycPushAdMapper.findAll(ycPushAd);
		if (RegexUtil.isNotNull(ycPushAds)) {
			PageHelper.startPage(currentPage, pageSize);
			return new PageInfo<>(ycPushAds);
		}
		return null;
	}

	@Override
	public String update(YcPushAd ycPushAd) {
		YcPushAd pushAd = selectById(ycPushAd.getId());
		// 判断是否存在
		if (RegexUtil.isNotNull(pushAd)) {
			// 判断是否上架中
			if (pushAd.getYc_advertising_status() == 2) {
				return YcAdvertisingSpaceConstants.IS_SHELF;
			}
			// 当申请凭证改变时,删除oss上旧文件
			if (RegexUtil.isNotNull(ycPushAd.getYc_certificate())
					&& ycPushAd.getYc_certificate().equals(pushAd.getYc_certificate())) {
				AliyunOSSUtil.deleteObject(pushAd.getYc_certificate());
			}
			Integer rs = ycPushAdMapper.update(ycPushAd);
			if (RegexUtil.isNotNull(rs)) {
				return YcAdvertisingSpaceConstants.SUCCESS;
			}
			return YcAdvertisingSpaceConstants.FAILURE;
		}
		return YcAdvertisingSpaceConstants.NOT_EXISTED;
	}

	@Override
	public YcPushAd selectById(String id) {
		return ycPushAdMapper.selectById(id);
	}

	@Override
	@Transactional
	public String delete(String id) {
		YcPushAd ycPushAd = new YcPushAd();
		ycPushAd.setId(id);
		ycPushAd.setYc_delete(2);
		return update(ycPushAd);
	}

	@Override
	public String insert(YcPushAd ycPushAd) {
		// 判断广告位是否含有广告
		if (iYcAdvertisingSpaceAreaService.selectStatus(ycPushAd.getYc_advertising_space())) {
			return YcAdvertisingSpaceConstants.HAVEAD;
		}
		// 设置唯一标示,广告状态
		ycPushAd.setId(UUIDFactory.random());
		ycPushAd.setYc_advertising_status(1);
		ycPushAd.setYc_delete(1);
		// 设置申请人类型
		ycPushAd.setYc_applicant_type(2);
		Integer rs = ycPushAdMapper.insert(ycPushAd);
		if (RegexUtil.isNotNull(rs)) {
			return YcAdvertisingSpaceConstants.SUCCESS;
		}
		return YcAdvertisingSpaceConstants.FAILURE;
	}

	@Override
	public Integer getVolume(String yc_advertising_space) {
		Integer rs = ycPushAdMapper.getVolume(yc_advertising_space);
		if (RegexUtil.isNotNull(rs)) {
			return rs;
		}
		return 0;
	}

	/**
	 * 查询现在推送的广告
	 */
	@Override
	public YcPushAd selectBydistrict(String yc_advertising_district) {
		YcPushAd pushAd = ycPushAdMapper.selectBydistrict(yc_advertising_district);
		return pushAd;
	}
	

}
