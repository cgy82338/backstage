package yc.xuezhifan.schoolbackstage.advertising.service;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcVideoAds;

/**  

* <p>Title: 视频广告发布 </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月16日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月16日  

* @version 1.0  

*/
public interface IYcVideoAdService {

	/**
	 * 添加视频广告
	 * @param YcVideoAds
	 */
	String insertVideo(YcVideoAds YcVideoAds);
	
	/**
	 * 获取所有广告信息
	 * @param ycVideoAds 
	 * @return 返回广告对象
	 */
	PageInfo<YcVideoAds> findAll(YcVideoAds ycVideoAds, Integer currentPage, Integer pageSize);
	
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
	String update(YcVideoAds ycVideoAds);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	String delete(String id);

	/**
	 * 根据广告位查询
	 * @param yc_advertising_space
	 * @return
	 */
	YcVideoAds selectBySpace(String yc_advertising_space);
}
