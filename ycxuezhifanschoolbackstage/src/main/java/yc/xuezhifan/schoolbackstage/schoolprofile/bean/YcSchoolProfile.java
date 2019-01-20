package yc.xuezhifan.schoolbackstage.schoolprofile.bean;

/**  
* <p>Title: YcFaculty.java </p> 

* <p>Description: 学校概况表（学校简介）</p> 

* <p>Copyright: Copyright (c) 2018年12月18日</p>
 
* @email xiaoxiao@xuezhifan.com

* @author xiaoxiao 

* @date 2018年12月18日  

* @version 1.0  

*/
public class YcSchoolProfile {

	private String yc_id;//主键，标识
	private String yc_introduction;//简介
	private String yc_image;//图片
	private String yc_phone;//电话
	private String yc_school_id;//学校id
	
	public String getYc_id() {
		return yc_id;
	}
	public void setYc_id(String yc_id) {
		this.yc_id = yc_id;
	}
	public String getYc_introduction() {
		return yc_introduction;
	}
	public void setYc_introduction(String yc_introduction) {
		this.yc_introduction = yc_introduction;
	}
	public String getYc_image() {
		return yc_image;
	}
	public void setYc_image(String yc_image) {
		this.yc_image = yc_image;
	}
	public String getYc_phone() {
		return yc_phone;
	}
	public void setYc_phone(String yc_phone) {
		this.yc_phone = yc_phone;
	}
	public String getYc_school_id() {
		return yc_school_id;
	}
	public void setYc_school_id(String yc_school_id) {
		this.yc_school_id = yc_school_id;
	}
	public YcSchoolProfile(String yc_id, String yc_introduction, String yc_image, String yc_phone,
			String yc_school_id) {
		super();
		this.yc_id = yc_id;
		this.yc_introduction = yc_introduction;
		this.yc_image = yc_image;
		this.yc_phone = yc_phone;
		this.yc_school_id = yc_school_id;
	}
	public YcSchoolProfile() {
		super();
	}
	
}
