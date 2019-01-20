package yc.xuezhifan.schoolbackstage.advertising.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcVideoAds;


/**
 * 

* <p>Title: YcVideoAdMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月16日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月16日  

* @version 1.0
 */
@Mapper
public interface YcVideoAdMapper {

	/**
	 * 添加视频广告
	 * @param YcVideoAds
	 */
	Integer insertVideo(YcVideoAds YcVideoAds);
	
	/**
	 * 获取所有广告信息
	 * @param videoAds 
	 * @return 返回广告对象
	 */
	List<YcVideoAds> findAll(YcVideoAds videoAds);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcVideoAds selectById(String id);
	
	/**
	 * 修改广告信息
	 * @param ycVideoAds
	 * @return
	 */
	Integer update(YcVideoAds ycVideoAds);
	
	/**
	 * 根据广告位查询
	 * @param yc_advertising_space
	 * @return
	 */
	YcVideoAds selectBySpace(String yc_advertising_space);
	
}
