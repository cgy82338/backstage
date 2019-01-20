package yc.xuezhifan.schoolbackstage.advertising.space.service;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.space.bean.YcAdvertisingSpaceArea;

/**  

* <p>Title: IYcAdvertisingSpaceAreaService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月13日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月13日  

* @version 1.0  

*/
public interface IYcAdvertisingSpaceAreaService {

	/**
	 *  根据地区获取广告位信息
	 * @param yc_advertising_district 区县id
	 * @return
	 */
	PageInfo<YcAdvertisingSpaceArea> selectByArea(String yc_school_district, Integer currentPage, Integer pageSize, Integer type);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcAdvertisingSpaceArea selectById(String id);
	
	/**
	 * 判断广告位是否为空
	 * @param yc_advertising_space 
	 * @return
	 */
	boolean selectStatus(String yc_advertising_space);

	/**
	 * 修改广告位状态
	 * @param yc_advertising_space
	 * @param i
	 * @return
	 */
	String updateStatus(String yc_advertising_space, int i);
}
