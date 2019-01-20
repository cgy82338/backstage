package yc.xuezhifan.schoolbackstage.notification.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yc.xuezhifan.schoolbackstage.notification.service.YcSystemNotificationService;
import yc.xuezhifan.schoolbackstage.utils.Page;

/**  

* <p>Title: YcSystemNotificationController.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年12月31日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai 

* @date 2018年12月31日  

* @version 1.0  

*/
@Controller
@RequestMapping("/systemNotification")
public class YcSystemNotificationController {

	private static final Logger logger = LoggerFactory.getLogger(YcSystemNotificationController.class);
	
	@Autowired
	private YcSystemNotificationService ycSystemNotificationService;
	

	/**
	 * 查询所有
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findAll", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public Page findAll(@RequestParam(defaultValue = "1") Integer currentPage,
						@RequestParam(defaultValue = "10") Integer pageSize) {
		return ycSystemNotificationService.findAll(currentPage,pageSize);
	}

}
