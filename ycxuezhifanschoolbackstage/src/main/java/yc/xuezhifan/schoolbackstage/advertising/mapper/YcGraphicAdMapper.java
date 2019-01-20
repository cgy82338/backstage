package yc.xuezhifan.schoolbackstage.advertising.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcGraphicAds;


/**
 * 

* <p>Title: YcGraphicAdMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月16日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月16日  

* @version 1.0
 */
@Mapper
public interface YcGraphicAdMapper {

	/**
	 * 添加图文广告
	 * @param ycGraphicAdMapper
	 */
	Integer insert(YcGraphicAds ycGraphicAds);
	
	/**
	 * 查询所有
	 * @param graphicAds 
	 * @param ids
	 * @return
	 */
	List<YcGraphicAds> findAll(YcGraphicAds graphicAds);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcGraphicAds selectById(String id);
	
	/**
	 * 修改
	 * @param ycGraphicAds
	 * @return
	 */
	Integer update(YcGraphicAds ycGraphicAds);

	/**
	 * 根据广告位查询
	 * @param yc_advertising_space
	 * @return
	 */
	YcGraphicAds selectBySpace(String yc_advertising_space);
}
