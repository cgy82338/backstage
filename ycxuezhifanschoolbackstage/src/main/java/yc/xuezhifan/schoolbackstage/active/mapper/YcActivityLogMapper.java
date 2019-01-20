package yc.xuezhifan.schoolbackstage.active.mapper;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivityLog;

/**
 * 

* <p>Title: YcActivityLogMapper.java </p> 

* <p>Description: 活动报名日志</p> 

* <p>Copyright: Copyright (c) 2018年9月7日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年9月7日  

* @version 1.0
 */
@Mapper
public interface YcActivityLogMapper {

	//添加活动报名浏览日志
	void insertLog(YcActivityLog ycActivityLog);
	
}
