package yc.xuezhifan.schoolbackstage.advertising.space.mapper;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.advertising.space.bean.YcAdvertisingSpace;


/**
 * 
* <p>Title: YcAdvertisingSpaceMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月12日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月12日  

* @version 1.0
 */
@Mapper
public interface YcAdvertisingSpaceMapper {

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	YcAdvertisingSpace selectById(String id);
	
}
