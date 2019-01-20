package yc.xuezhifan.schoolbackstage.active.service;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivityLog;

/**
* <p>Title: YcActivityLogService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月7日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年9月7日  

* @version 1.0
 */
public interface YcActivityLogService {

	//添加活动报名浏览日志
	void insertLog(YcActivityLog ycActivityLog);
	
}
