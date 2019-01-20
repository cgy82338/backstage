package yc.xuezhifan.schoolbackstage.advertising.service;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcGraphicAds;

/**  

* <p>Title: IYcGraphicAdService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月16日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月16日  

* @version 1.0  

*/
public interface IYcGraphicAdService {

	/**
	 * 添加图文广告
	 * @param ycGraphicAdMapper
	 */
	String insert(YcGraphicAds ycGraphicAds);
	
	/**
	 * 查询所有广告信息
	 * @param ycGraphicAds 
	 * @param yc_branch_id 分公司id
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageInfo<YcGraphicAds> findAll(YcGraphicAds ycGraphicAds, Integer currentPage, Integer pageSize);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcGraphicAds selectById(String id);
	
	/**
	 * 修改广告信息
	 * @param ycVideoAds
	 * @return
	 */
	String update(YcGraphicAds ycGraphicAds);
	
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
	YcGraphicAds selectBySpace(String yc_advertising_space);

}
