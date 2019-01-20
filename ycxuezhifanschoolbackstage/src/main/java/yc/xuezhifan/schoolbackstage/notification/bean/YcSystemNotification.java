package yc.xuezhifan.schoolbackstage.notification.bean;

import java.util.Date;

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

public class YcSystemNotification {
	
	private String id;//主键，标识
	
	private String yc_notification_title;//标题
	
	private String yc_notification_name;//系统通知内容
	
	private Date yc_notification_time;//系统通知发布时间
	
	private String yc_notification_publisher;//发布人


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_notification_title() {
		return yc_notification_title;
	}

	public void setYc_notification_title(String yc_notification_title) {
		this.yc_notification_title = yc_notification_title;
	}

	public String getYc_notification_name() {
		return yc_notification_name;
	}

	public void setYc_notification_name(String yc_notification_name) {
		this.yc_notification_name = yc_notification_name;
	}

	public Date getYc_notification_time() {
		return yc_notification_time;
	}

	public void setYc_notification_time(Date yc_notification_time) {
		this.yc_notification_time = yc_notification_time;
	}

	public String getYc_notification_publisher() {
		return yc_notification_publisher;
	}

	public void setYc_notification_publisher(String yc_notification_publisher) {
		this.yc_notification_publisher = yc_notification_publisher;
	}
}
