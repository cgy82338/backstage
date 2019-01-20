package yc.xuezhifan.schoolbackstage.schoolnotice.bean;

import java.util.Date;

import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;


/**
* <p>Title: YcNoticeSchool.java </p> 

* <p>Description: 学校通知公告表</p> 

* <p>Copyright: Copyright (c) 2018年10月1日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年10月1日  

* @version 1.0
 */
public class YcNoticeSchool {

	private String id;//主键，标识
	
	private String yc_notice_detail;//通知公告详情
	
	private String yc_notice_image;//通知公告图片
	
	private String yc_notice_voice;//通知公告语音
	
	private String yc_notice_school;//学校ID（唯一标识）
	
	private String yc_notice_id;//发布人（唯一标识）
	
	private Date yc_notice_time;//发布时间
	

	private YcSchool ycSchool;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_notice_detail() {
		return yc_notice_detail;
	}

	public void setYc_notice_detail(String yc_notice_detail) {
		this.yc_notice_detail = yc_notice_detail;
	}

	public String getYc_notice_image() {
		return yc_notice_image;
	}

	public void setYc_notice_image(String yc_notice_image) {
		this.yc_notice_image = yc_notice_image;
	}

	public String getYc_notice_voice() {
		return yc_notice_voice;
	}

	public void setYc_notice_voice(String yc_notice_voice) {
		this.yc_notice_voice = yc_notice_voice;
	}

	public String getYc_notice_school() {
		return yc_notice_school;
	}

	public void setYc_notice_school(String yc_notice_school) {
		this.yc_notice_school = yc_notice_school;
	}

	public String getYc_notice_id() {
		return yc_notice_id;
	}

	public void setYc_notice_id(String yc_notice_id) {
		this.yc_notice_id = yc_notice_id;
	}

	public Date getYc_notice_time() {
		return yc_notice_time;
	}

	public void setYc_notice_time(Date yc_notice_time) {
		this.yc_notice_time = yc_notice_time;
	}

	public YcSchool getYcSchool() {
		return ycSchool;
	}

	public void setYcSchool(YcSchool ycSchool) {
		this.ycSchool = ycSchool;
	}

	public YcNoticeSchool(String id, String yc_notice_detail, String yc_notice_image, String yc_notice_voice,
			String yc_notice_school, String yc_notice_id, Date yc_notice_time, String yc_notice_class,
			YcSchool ycSchool) {
		super();
		this.id = id;
		this.yc_notice_detail = yc_notice_detail;
		this.yc_notice_image = yc_notice_image;
		this.yc_notice_voice = yc_notice_voice;
		this.yc_notice_school = yc_notice_school;
		this.yc_notice_id = yc_notice_id;
		this.yc_notice_time = yc_notice_time;
		this.ycSchool = ycSchool;
	}

	public YcNoticeSchool() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
