package yc.xuezhifan.schoolbackstage.advertising.service;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcPushAd;

/**  

* <p>Title: IYcPushAdService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月23日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月23日  

* @version 1.0  

*/
public interface IYcPushAdService {

	/**
	 * 添加推送广告
	 * @param ycPushAd
	 * @return
	 */
	String insert(YcPushAd ycPushAd);
	
	/**
	 * 查询所有推送广告
	 * @return
	 */
	PageInfo<YcPushAd> findAll(YcPushAd ycPushAd, Integer currentPage, Integer pageSize);
	
	/**
	 * 修改广告信息
	 * @param ycPushAd
	 * @return
	 */
	String update(YcPushAd ycPushAd);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcPushAd selectById(String id);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	String delete(String id);
	
	/**
	 * 根据广告位查询位推送次数
	 * @return
	 */
	Integer getVolume(String yc_advertising_space);
	
	/**
	 * 
	 * <p>Title: selectBydistrict</p>  
	
	 * <p>Description: 查询现在推送的广告</p>  
	
	 * @param yc_advertising_district
	 * @return 
	
	 * @email xiaoxiao@xuezhifan.com
	
	 * @author xiaoxiao
	
	 * @date 2018年11月30日
	 */
	YcPushAd selectBydistrict(String yc_advertising_district);
	
}
