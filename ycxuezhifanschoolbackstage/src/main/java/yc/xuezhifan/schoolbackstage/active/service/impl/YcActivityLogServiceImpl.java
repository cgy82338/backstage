package yc.xuezhifan.schoolbackstage.active.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivityLog;
import yc.xuezhifan.schoolbackstage.active.mapper.YcActivityLogMapper;
import yc.xuezhifan.schoolbackstage.active.service.YcActivityLogService;

/**  
* <p>Title: YcActivityLogServiceImpl.java </p> 

* <p>Description: 活动登入</p> 

* <p>Copyright: Copyright (c) 2018年9月7日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年9月7日  

* @version 1.0  

*/
@Service
public class YcActivityLogServiceImpl implements YcActivityLogService{

	@Autowired
	private YcActivityLogMapper ycActivityLogMapper;
	
	/**
	 * 添加保存
	 */
	@Override
	public void insertLog(YcActivityLog ycActivityLog) {
		ycActivityLogMapper.insertLog(ycActivityLog);
	}

}
