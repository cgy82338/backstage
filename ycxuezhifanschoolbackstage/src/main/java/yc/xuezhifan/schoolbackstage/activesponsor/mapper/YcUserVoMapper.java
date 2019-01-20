package yc.xuezhifan.schoolbackstage.activesponsor.mapper;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.activesponsor.bean.YcUserVo;

/**  

* <p>Title: YcUserVoMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年11月2日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年11月2日  

* @version 1.0  

*/
@Mapper
public interface YcUserVoMapper {

	/**
	 * 根据id查询
	 * @param yc_admin_id
	 * @return
	 */
	YcUserVo selectById(String yc_admin_id);
}
