package yc.xuezhifan.schoolbackstage.advertising.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcVideoAds;
import yc.xuezhifan.schoolbackstage.advertising.mapper.YcVideoAdMapper;
import yc.xuezhifan.schoolbackstage.advertising.service.IYcVideoAdService;
import yc.xuezhifan.schoolbackstage.advertising.space.service.IYcAdvertisingSpaceAreaService;
import yc.xuezhifan.schoolbackstage.constants.YcAdvertisingSpaceConstants;
import yc.xuezhifan.schoolbackstage.utils.AliyunOSSUtil;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**
 * 
 * <p>
 * Title: YcVideoAdImpl.java
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
public class YcVideoAdImpl implements IYcVideoAdService {

	@Autowired
	private YcVideoAdMapper ycVideoAdMapper;

	@Autowired
	private IYcAdvertisingSpaceAreaService iYcAdvertisingSpaceAreaService;

	@Override
	@Transactional
	public String insertVideo(YcVideoAds ycVideoAds) {
		// 设置唯一标示,广告状态
		ycVideoAds.setId(UUIDFactory.random());
		ycVideoAds.setYc_advertising_status(1);
		ycVideoAds.setYc_delete(1);
		//设置申请人类型
		ycVideoAds.setYc_applicant_type(2);
		Integer rs = ycVideoAdMapper.insertVideo(ycVideoAds);
		// 修改广告位状态为有广告
		String result = iYcAdvertisingSpaceAreaService.updateStatus(ycVideoAds.getYc_advertising_space(), 2);
		// 得到结果并处理
		if (RegexUtil.isNotNull(rs) && YcAdvertisingSpaceConstants.SUCCESS.equals(result)) {
			return YcAdvertisingSpaceConstants.SUCCESS;
		}
		return YcAdvertisingSpaceConstants.FAILURE;
	}

	@Override
	public PageInfo<YcVideoAds> findAll(YcVideoAds videoAds, Integer currentPage, Integer pageSize) {
		List<YcVideoAds> ycVideoAds = ycVideoAdMapper.findAll(videoAds);
		if (RegexUtil.isNotNull(ycVideoAds)) {
			PageHelper.startPage(currentPage, pageSize);
			return new PageInfo<>(ycVideoAds);
		}
		return null;
	}

	@Override
	public YcVideoAds selectById(String id) {
		return ycVideoAdMapper.selectById(id);
	}

	@Override
	@Transactional
	public String update(YcVideoAds ycVideoAds) {
		// 判断是否存在
		YcVideoAds videoAds = selectById(ycVideoAds.getId());
		if (RegexUtil.isNull(videoAds)) {
			return YcAdvertisingSpaceConstants.NOT_EXISTED;
		}
		//判断是否上架中
		if (videoAds.getYc_advertising_status() == 2) {
			return YcAdvertisingSpaceConstants.IS_SHELF;
		}
		// 当视频改变时,删除oss旧视频
		if (RegexUtil.isNotNull(ycVideoAds.getYc_advertising_content())
				&& ycVideoAds.getYc_advertising_content().equals(videoAds.getYc_advertising_content())) {
			AliyunOSSUtil.deleteObject(videoAds.getYc_advertising_content());
		}
		// 当详情页改变时,删除oss上旧存储
		if (RegexUtil.isNotNull(ycVideoAds.getYc_advertising_details())
				&& ycVideoAds.getYc_advertising_details().equals(videoAds.getYc_advertising_details())) {
			AliyunOSSUtil.deleteObject(videoAds.getYc_advertising_details());
		}
		// 当申请凭证改变时,删除oss上旧存储
		if (RegexUtil.isNotNull(ycVideoAds.getYc_certificate())
				&& ycVideoAds.getYc_certificate().equals(videoAds.getYc_certificate())) {
			AliyunOSSUtil.deleteObject(videoAds.getYc_certificate());
		}
		//当广告设置为删除时,将广告位设置为空
		if (RegexUtil.isNotNull(ycVideoAds.getYc_delete()) && ycVideoAds.getYc_delete() == 2) {
			iYcAdvertisingSpaceAreaService.updateStatus(videoAds.getYc_advertising_space(), 1);
		}
		Integer rs = ycVideoAdMapper.update(ycVideoAds);
		if (RegexUtil.isNotNull(rs)) {
			return YcAdvertisingSpaceConstants.SUCCESS;
		}
		return YcAdvertisingSpaceConstants.FAILURE;
	}

	@Override
	public String delete(String id) {
		YcVideoAds ycVideoAds = new YcVideoAds();
		ycVideoAds.setId(id);
		ycVideoAds.setYc_delete(2);
		return update(ycVideoAds);
	}

	@Override
	public YcVideoAds selectBySpace(String yc_advertising_space) {
		return ycVideoAdMapper.selectBySpace(yc_advertising_space);
	}

}
