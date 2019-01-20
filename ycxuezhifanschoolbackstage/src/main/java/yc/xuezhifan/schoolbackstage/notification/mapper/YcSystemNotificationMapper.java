package yc.xuezhifan.schoolbackstage.notification.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yc.xuezhifan.schoolbackstage.notification.bean.YcSystemNotification;


/**
 * 

* <p>Title: 系统通知类别 </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年12月30日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年12月30日  

* @version 1.0
 */
@Mapper
public interface YcSystemNotificationMapper {

	
	/**
	 * 查询所有系统通知类别
	 * @return
	 */
	List<YcSystemNotification> findAll();

}
