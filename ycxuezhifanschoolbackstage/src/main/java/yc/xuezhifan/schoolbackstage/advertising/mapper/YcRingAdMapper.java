package yc.xuezhifan.schoolbackstage.advertising.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcRingAd;

/**  

* <p>Title: YcRingAdMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月16日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月16日  

* @version 1.0  

*/
@Mapper
public interface YcRingAdMapper {

	/**
	 * 添加圈广告
	 * @param ycRingAd
	 * @return
	 */
	Integer insert(YcRingAd ycRingAd);
	
	/**
	 * 查询所有
	 * @param ycRingAd 
	 * @return
	 */
	List<YcRingAd> findAll(YcRingAd ycRingAd);
	
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
	Integer update(YcRingAd ycRingAd);
	
	/**
	 * 根据广告位查询
	 * @param yc_advertising_space
	 * @return
	 */
	YcRingAd selectBySpace(String yc_advertising_space);
	
}
