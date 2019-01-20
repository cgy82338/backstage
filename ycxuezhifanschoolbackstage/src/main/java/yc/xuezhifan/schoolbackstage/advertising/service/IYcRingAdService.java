package yc.xuezhifan.schoolbackstage.advertising.service;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcRingAd;

/**  

* <p>Title: IYcRingAdService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月16日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月16日  

* @version 1.0  

*/
public interface IYcRingAdService {

	/**
	 * 添加圈广告
	 * @param ycRingAd
	 * @return
	 */
	String insert(YcRingAd ycRingAd);
	
	/**
	 * 查询所有
	 * @param ycRingAd 
	 * @return
	 */
	PageInfo<YcRingAd> findAll(YcRingAd ycRingAd, Integer currentPage, Integer pageSize);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcRingAd selectById(String id);
	
	/**
	 * 修改
	 * @param ycRingAd
	 * @return
	 */
	String update(YcRingAd ycRingAd);

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
	YcRingAd selectBySpace(String yc_advertising_space);
}
