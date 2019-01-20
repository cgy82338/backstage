package yc.xuezhifan.schoolbackstage.advertising.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcRingAd;
import yc.xuezhifan.schoolbackstage.advertising.mapper.YcRingAdMapper;
import yc.xuezhifan.schoolbackstage.advertising.service.IYcRingAdService;
import yc.xuezhifan.schoolbackstage.advertising.space.service.IYcAdvertisingSpaceAreaService;
import yc.xuezhifan.schoolbackstage.constants.YcAdvertisingSpaceConstants;
import yc.xuezhifan.schoolbackstage.utils.AliyunOSSUtil;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**
 * 
 * <p>
 * Title: YcRingAdImpl.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年10月16日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年10月16日
 * 
 * @version 1.0
 * 
 */
@Service
public class YcRingAdImpl implements IYcRingAdService {

	@Autowired
	private YcRingAdMapper ycRingAdMapper;

	@Autowired
	private IYcAdvertisingSpaceAreaService iYcAdvertisingSpaceAreaService;

	@Override
	public String insert(YcRingAd ycRingAd) {
		// 设置唯一标示,广告状态
		ycRingAd.setId(UUIDFactory.random());
		ycRingAd.setYc_advertising_status(1);
		ycRingAd.setYc_delete(1);
		// 设置申请人类型
		ycRingAd.setYc_applicant_type(2);
		Integer rs = ycRingAdMapper.insert(ycRingAd);
		// 修改广告位状态为有广告
		String result = iYcAdvertisingSpaceAreaService.updateStatus(ycRingAd.getYc_advertising_space(), 2);
		// 得到结果并处理
		if (RegexUtil.isNotNull(rs) && YcAdvertisingSpaceConstants.SUCCESS.equals(result)) {
			return YcAdvertisingSpaceConstants.SUCCESS;
		}
		return YcAdvertisingSpaceConstants.FAILURE;
	}

	@Override
	public PageInfo<YcRingAd> findAll(YcRingAd ycRingAd, Integer currentPage, Integer pageSize) {
		List<YcRingAd> ycRingAds = ycRingAdMapper.findAll(ycRingAd);
		if (RegexUtil.isNotNull(ycRingAds)) {
			PageHelper.startPage(currentPage, pageSize);
			return new PageInfo<>(ycRingAds);
		}
		return null;
	}

	@Override
	public YcRingAd selectById(String id) {
		return ycRingAdMapper.selectById(id);
	}

	@Override
	@Transactional
	public String update(YcRingAd ycRingAd) {
		// 判断是否存在
		YcRingAd ringAd = selectById(ycRingAd.getId());
		if (RegexUtil.isNull(ringAd)) {
			return YcAdvertisingSpaceConstants.NOT_EXISTED;
		}
		// 判断是否上架中
		if (ycRingAd.getYc_advertising_status() == 2) {
			return YcAdvertisingSpaceConstants.IS_SHELF;
		}
		// 当视频改变时,删除oss旧视频
		if (RegexUtil.isNotNull(ycRingAd.getYc_advertising_content())
				&& ycRingAd.getYc_advertising_content().equals(ringAd.getYc_advertising_content())) {
			AliyunOSSUtil.deleteObject(ringAd.getYc_advertising_content());
		}
		// 当详情页改变时,删除oss上旧存储
		if (RegexUtil.isNotNull(ycRingAd.getYc_advertising_details())
				&& ycRingAd.getYc_advertising_details().equals(ringAd.getYc_advertising_details())) {
			AliyunOSSUtil.deleteObject(ringAd.getYc_advertising_details());
		}
		// 当申请凭证改变时,删除oss上旧存储
		if (RegexUtil.isNotNull(ycRingAd.getYc_certificate())
				&& ycRingAd.getYc_certificate().equals(ringAd.getYc_certificate())) {
			AliyunOSSUtil.deleteObject(ringAd.getYc_certificate());
		}
		// 当修改广告状态为删除时,将广告位设置为空
		if (RegexUtil.isNotNull(ycRingAd.getYc_delete()) && ycRingAd.getYc_delete() == 2) {
			iYcAdvertisingSpaceAreaService.updateStatus(ringAd.getYc_advertising_space(), 1);
		}
		Integer rs = ycRingAdMapper.update(ycRingAd);
		if (RegexUtil.isNotNull(rs)) {
			return YcAdvertisingSpaceConstants.SUCCESS;
		}
		return YcAdvertisingSpaceConstants.FAILURE;
	}

	@Override
	@Transactional
	public String delete(String id) {
		YcRingAd ycRingAd = new YcRingAd();
		ycRingAd.setId(id);
		ycRingAd.setYc_delete(2);
		return update(ycRingAd);
	}

	@Override
	public YcRingAd selectBySpace(String yc_advertising_space) {
		return ycRingAdMapper.selectBySpace(yc_advertising_space);
	}
}
