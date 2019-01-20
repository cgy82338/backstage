package yc.xuezhifan.schoolbackstage.help.bean;

import java.util.Date;

/**
 * <p>
 * Title: YcHelp.java
 * </p>
 *
 * <p>
 * Description: 使用帮助
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2019年1月11日
 * </p>
 *
 * @email xiaoyu@xuezhifan.com
 *
 * @author xiaoyu
 *
 * @date 2019年1月11日
 *
 * @version 1.0
 */
public class YcHelp {

	//@NotNull(message="主键不能为空")
	private String id;//主键，标识
	
	//@NotNull(message="帮助标题不能为空")
	private String yc_help_title;//帮助标题
	
	//@NotNull(message="时间不能为空")
	//@CreatedDate
	private Date yc_help_time;//时间
	
	//@NotNull(message="帮助详情不能为空")
	private String yc_help_details;//帮助详情

	/**
	 * 封装
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_help_title() {
		return yc_help_title;
	}

	public void setYc_help_title(String yc_help_title) {
		this.yc_help_title = yc_help_title;
	}

	public Date getYc_help_time() {
		return yc_help_time;
	}

	public void setYc_help_time(Date yc_help_time) {
		this.yc_help_time = yc_help_time;
	}

	public String getYc_help_details() {
		return yc_help_details;
	}

	public void setYc_help_details(String yc_help_details) {
		this.yc_help_details = yc_help_details;
	}

	public YcHelp(String id, String yc_help_title, Date yc_help_time, String yc_help_details) {
		super();
		this.id = id;
		this.yc_help_title = yc_help_title;
		this.yc_help_time = yc_help_time;
		this.yc_help_details = yc_help_details;
	}

	public YcHelp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
