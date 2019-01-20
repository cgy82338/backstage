package yc.xuezhifan.schoolbackstage.advertising.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcPushAd;


/**
 * 

* <p>Title: YcPushAdMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月16日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月16日  

* @version 1.0
 */
@Mapper
public interface YcPushAdMapper {

	/**
	 * 添加推送广告
	 * @param ycPushAd
	 * @return
	 */
	Integer insert(YcPushAd ycPushAd);
	
	/**
	 * 查询所有推送广告
	 * @return
	 */
	List<YcPushAd> findAll(YcPushAd ycPushAd);
	
	/**
	 * 修改广告信息
	 * @param ycPushAd
	 * @return
	 */
	Integer update(YcPushAd ycPushAd);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcPushAd selectById(String id);
	
	/**
	 * 根据广告位查询未推送数量
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
