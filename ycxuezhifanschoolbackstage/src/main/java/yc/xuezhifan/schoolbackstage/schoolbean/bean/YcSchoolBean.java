package yc.xuezhifan.schoolbackstage.schoolbean.bean;

import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;



/**
 * 

* <p>Title: YcScboolBean.java </p> 

* <p>Description:学校智慧豆 </p> 

* <p>Copyright: Copyright (c) 2018年12月20日</p>
 
* @email xiaoke@xuezhifan.com

* @author xiaoke 

* @date 2018年12月20日  

* @version 1.0
 */
public class YcSchoolBean {
	
	private String yc_wisdom_beans_id;//用户智慧豆唯一标识 32位 唯一值
	
	private Double yc_wisdom_beans;//智慧豆总数
	
	private Double yc_disable_beans;//不可提现的数目
	
	private String yc_school_id;//学校id
	
	private YcSchool ycSchool;//学校信息

	public String getYc_wisdom_beans_id() {
		return yc_wisdom_beans_id;
	}

	public void setYc_wisdom_beans_id(String yc_wisdom_beans_id) {
		this.yc_wisdom_beans_id = yc_wisdom_beans_id;
	}

	public Double getYc_wisdom_beans() {
		return yc_wisdom_beans;
	}

	public void setYc_wisdom_beans(Double yc_wisdom_beans) {
		this.yc_wisdom_beans = yc_wisdom_beans;
	}

	public Double getYc_disable_beans() {
		return yc_disable_beans;
	}

	public void setYc_disable_beans(Double yc_disable_beans) {
		this.yc_disable_beans = yc_disable_beans;
	}

	public String getYc_school_id() {
		return yc_school_id;
	}

	public void setYc_school_id(String yc_school_id) {
		this.yc_school_id = yc_school_id;
	}

	public YcSchool getYcSchool() {
		return ycSchool;
	}

	public void setYcSchool(YcSchool ycSchool) {
		this.ycSchool = ycSchool;
	}
	
}
