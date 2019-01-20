package yc.xuezhifan.schoolbackstage.schoolfeature.mapper;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcCustomerService;

/**
 * 

* <p>Title: YcCustomerServiceMapper.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月2日  

* @version 1.0
 */
@Mapper
public interface YcCustomerServiceMapper {

	/**
	 * 添加专属客服
	 * @param ycCustomerService
	 */
	Integer insert(YcCustomerService ycCustomerService);
	
	/**
	 * 根据id得到客服信息
	 * @param id 主键
	 * @return
	 */
	YcCustomerService selectById(String id);
	
	/**
	 * 修改客服信息
	 * @param ycCustomerService 修改内容
	 */
	Integer update(YcCustomerService ycCustomerService);
}
