package yc.xuezhifan.schoolbackstage.advertising.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcGraphicAds;
import yc.xuezhifan.schoolbackstage.advertising.mapper.YcGraphicAdMapper;
import yc.xuezhifan.schoolbackstage.advertising.service.IYcGraphicAdService;
import yc.xuezhifan.schoolbackstage.advertising.space.service.IYcAdvertisingSpaceAreaService;
import yc.xuezhifan.schoolbackstage.constants.YcAdvertisingSpaceConstants;
import yc.xuezhifan.schoolbackstage.utils.AliyunOSSUtil;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**
 * 
 * <p>
 * Title: YcGraphicAdImpl.java
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
public class YcGraphicAdImpl implements IYcGraphicAdService {

	@Autowired
	private YcGraphicAdMapper ycGraphicAdMapper;

	@Autowired
	private IYcAdvertisingSpaceAreaService iYcAdvertisingSpaceAreaService;

	@Override
	@Transactional
	public String insert(YcGraphicAds ycGraphicAds) {
		// 设置唯一标示,广告状态
		ycGraphicAds.setId(UUIDFactory.random());
		ycGraphicAds.setYc_advertising_status(1);
		ycGraphicAds.setYc_delete(1);
		//设置申请人类型
		ycGraphicAds.setYc_applicant_type(2);
		Integer rs = ycGraphicAdMapper.insert(ycGraphicAds);
		// 修改广告位状态为有广告
		String result = iYcAdvertisingSpaceAreaService.updateStatus(ycGraphicAds.getYc_advertising_space(), 2);
		// 得到结果并处理
		if (RegexUtil.isNotNull(rs) && YcAdvertisingSpaceConstants.SUCCESS.equals(result)) {
			return YcAdvertisingSpaceConstants.SUCCESS;
		}
		return YcAdvertisingSpaceConstants.FAILURE;
	}

	@Override
	public YcGraphicAds selectById(String id) {
		return ycGraphicAdMapper.selectById(id);
	}

	@Override
	@Transactional
	public String update(YcGraphicAds ycGraphicAds) {
		// 判断是否存在
		YcGraphicAds graphicAds = selectById(ycGraphicAds.getId());
		if (RegexUtil.isNull(graphicAds)) {
			return YcAdvertisingSpaceConstants.NOT_EXISTED;
		}
		// 判断是否上架中
		if (graphicAds.getYc_advertising_status() == 2) {
			return YcAdvertisingSpaceConstants.IS_SHELF;
		}
		//// 当图片改变时,删除oss旧视频
		if (RegexUtil.isNotNull(ycGraphicAds.getYc_advertising_content())
				&& ycGraphicAds.getYc_advertising_content().equals(graphicAds.getYc_advertising_content())) {
			AliyunOSSUtil.deleteObject(graphicAds.getYc_advertising_content());
		}
		// 当详情页改变时,删除oss上旧存储
		if (RegexUtil.isNotNull(ycGraphicAds.getYc_advertising_details())
				&& ycGraphicAds.getYc_advertising_details().equals(graphicAds.getYc_advertising_details())) {
			AliyunOSSUtil.deleteObject(graphicAds.getYc_advertising_details());
		}
		// 当申请凭证改变时,删除oss上旧存储
		if (RegexUtil.isNotNull(ycGraphicAds.getYc_certificate())
				&& ycGraphicAds.getYc_certificate().equals(graphicAds.getYc_certificate())) {
			AliyunOSSUtil.deleteObject(graphicAds.getYc_certificate());
		}
		// 当广告设置为删除时,将广告位设置为空
		if (RegexUtil.isNotNull(ycGraphicAds.getYc_delete()) && ycGraphicAds.getYc_delete() == 2) {
			iYcAdvertisingSpaceAreaService.updateStatus(graphicAds.getYc_advertising_space(), 1);
		}
		Integer rs = ycGraphicAdMapper.update(ycGraphicAds);
		if (RegexUtil.isNotNull(rs)) {
			return YcAdvertisingSpaceConstants.SUCCESS;
		}
		return YcAdvertisingSpaceConstants.FAILURE;
	}

	@Override
	public String delete(String id) {
		YcGraphicAds ycGraphicAds = new YcGraphicAds();
		ycGraphicAds.setId(id);
		ycGraphicAds.setYc_delete(2);
		return update(ycGraphicAds);
	}

	@Override
	public PageInfo<YcGraphicAds> findAll(YcGraphicAds graphicAds, Integer currentPage,
			Integer pageSize) {
		List<YcGraphicAds> ycGraphicAds = ycGraphicAdMapper.findAll(graphicAds);
		if (RegexUtil.isNotNull(ycGraphicAds)) {
			PageHelper.startPage(currentPage, pageSize);
			return new PageInfo<>(ycGraphicAds);
		}
		return null;
	}

	@Override
	public YcGraphicAds selectBySpace(String yc_advertising_space) {
		return ycGraphicAdMapper.selectBySpace(yc_advertising_space);
	}

}
