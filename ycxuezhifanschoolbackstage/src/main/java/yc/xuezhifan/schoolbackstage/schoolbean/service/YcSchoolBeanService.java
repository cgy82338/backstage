package yc.xuezhifan.schoolbackstage.schoolbean.service;

import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcSchoolBean;


/**
 * 

* <p>Title: YcScboolBeanService.java </p> 

* <p>Description:学校智慧豆表 </p> 

* <p>Copyright: Copyright (c) 2018年12月20日</p>
 
* @email xiaoke@xuezhifan.com

* @author xiaoke 

* @date 2018年12月20日  

* @version 1.0
 */
public interface YcSchoolBeanService {
	/**
	 * 
	
	 * <p>Title: findBeanBySchoolId</p>  
	
	 * <p>Description:根据学校id查询学校的智慧豆 </p>  
	
	 * @param id 学校id
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年12月20日
	 */
	YcSchoolBean findBeanBySchoolId(String id);
	/**
	 * 
	
	 * <p>Title: modifyBeans</p>  
	
	 * <p>Description:消费修改记录 </p>  
	
	 * @param ycScboolBean 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	 * @param yc_order_id 
	 * @return 
	 * @throws Exception 
	
	 * @date 2018年12月20日
	 */

	String modifyBeans(String id, Double yc_payment_amount, String yc_order_id) throws Exception;
	
	/**
	 * 
	
	 * <p>Title: saveBeans</p>  
	
	 * <p>Description: 添加用户智慧豆数量</p>  
	
	 * @param ycWisdomBeans 用户智慧豆信息
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年10月23日
	 */
	Integer  saveBeans(YcSchoolBean ycWisdomBeans);
	/**
	 * 
	
	 * <p>Title: modifyBeans</p>  
	
	 * <p>Description:修改智慧豆信息 </p>  
	
	 * @param ycWisdomBeans
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年10月23日
	 */
	Integer modifyBeans(YcSchoolBean ycWisdomBeans);
	
	YcSchoolBean findBeanById(String yc_school_id);


}
