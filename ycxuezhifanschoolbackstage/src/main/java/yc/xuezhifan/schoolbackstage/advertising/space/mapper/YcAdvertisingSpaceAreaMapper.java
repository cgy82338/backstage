package yc.xuezhifan.schoolbackstage.advertising.space.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import yc.xuezhifan.schoolbackstage.advertising.space.bean.YcAdvertisingSpaceArea;


/**
 * 

* <p>Title: YcAdvertisingSpaceAreaMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月12日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月12日  

* @version 1.0
 */
@Mapper
public interface YcAdvertisingSpaceAreaMapper {

	/**
	 * 修改市场实际价
	 * @param ycAdvertisingSpaceArea
	 * @return
	 */
	Integer update(YcAdvertisingSpaceArea ycAdvertisingSpaceArea);
	
	/**
	 * 根据地区获取广告位信息
	 * @param yc_advertising_district 区县唯一标示
	 * @param yc_advertising_name 广告位名称
	 * @param type 广告类型
	 * @return
	 */
	List<YcAdvertisingSpaceArea> selectByArea(
            @Param("yc_advertising_district")
                    String yc_advertising_district,
            @Param("type") Integer type);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcAdvertisingSpaceArea selectById(String id);
	
}
