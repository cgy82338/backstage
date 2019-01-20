package yc.xuezhifan.schoolbackstage.notification.service;

import com.github.pagehelper.PageInfo;
import yc.xuezhifan.schoolbackstage.notification.bean.YcSystemNotification;
import yc.xuezhifan.schoolbackstage.utils.Page;


/**  

* <p>Title: YcSystemNotificationService.java </p>

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年12月31日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年12月31日  

* @version 1.0  

*/
public interface YcSystemNotificationService {

	/**
	 * 查询所有系统通知类别
	 * @return
	 */
	Page findAll(Integer currentPage, Integer pageSize);
	
}
