package yc.xuezhifan.schoolbackstage.schoolfeature.service;

import yc.xuezhifan.schoolbackstage.schoolfeature.bean.YcCustomerService;

/**  

* <p>Title: IYcCustomerService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月3日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年10月3日  

* @version 1.0  

*/
public interface IYcCustomerService {

	/**
	 * 添加专属客服
	 * @param ycCustomerService
	 */
	String insert(YcCustomerService ycCustomerService, String yc_school_id, String yc_feature_id);
	
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
	String update(YcCustomerService ycCustomerService);
}
