package yc.xuezhifan.schoolbackstage.active.bean;

import java.util.Date;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

/**
 * 

* <p>Title: YcActivityLog.java </p> 

* <p>Description: 活动报名日志</p> 

* <p>Copyright: Copyright (c) 2018年9月7日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年9月7日  

* @version 1.0
 */
public class YcActivityLog {

	private String yc_activity_log_id;//日志id
	
	private String yc_activity_id;//活动id
	
	private String yc_user_id;//用户id
	
	private String yc_admin_id;//管理员id
	
	private Date yc_browse_time;//浏览时间
	
	private String yc_log_remark;//日志内容
	
	private String yc_ip;//用户ip

	private YcUser ycUser;
	
	
	public YcUser getYcUser() {
		return ycUser;
	}

	public void setYcUser(YcUser ycUser) {
		this.ycUser = ycUser;
	}

	public String getYc_admin_id() {
		return yc_admin_id;
	}

	public void setYc_admin_id(String yc_admin_id) {
		this.yc_admin_id = yc_admin_id;
	}

	public String getYc_log_remark() {
		return yc_log_remark;
	}

	public void setYc_log_remark(String yc_log_remark) {
		this.yc_log_remark = yc_log_remark;
	}

	public String getYc_activity_log_id() {
		return yc_activity_log_id;
	}

	public void setYc_activity_log_id(String yc_activity_log_id) {
		this.yc_activity_log_id = yc_activity_log_id;
	}

	public String getYc_activity_id() {
		return yc_activity_id;
	}

	public void setYc_activity_id(String yc_activity_id) {
		this.yc_activity_id = yc_activity_id;
	}

	public String getYc_user_id() {
		return yc_user_id;
	}

	public void setYc_user_id(String yc_user_id) {
		this.yc_user_id = yc_user_id;
	}

	public Date getYc_browse_time() {
		return yc_browse_time;
	}

	public void setYc_browse_time(Date yc_browse_time) {
		this.yc_browse_time = yc_browse_time;
	}

	public String getYc_ip() {
		return yc_ip;
	}

	public void setYc_ip(String yc_ip) {
		this.yc_ip = yc_ip;
	}

	public YcActivityLog(String yc_activity_log_id, String yc_activity_id, String yc_user_id, Date yc_browse_time,
			String yc_ip) {
		super();
		this.yc_activity_log_id = yc_activity_log_id;
		this.yc_activity_id = yc_activity_id;
		this.yc_user_id = yc_user_id;
		this.yc_browse_time = yc_browse_time;
		this.yc_ip = yc_ip;
	}

	public YcActivityLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
