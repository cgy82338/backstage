package yc.xuezhifan.schoolbackstage.schooldynamics.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * 

* <p>Title: 学校动态表 </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年11月5日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年11月5日  

* @version 1.0
 */
public class YcSchoolDynamics {
		
	private String id;//主键，标识
	
	@NotNull(message="学校动态标题不能为空")
	private String yc_school_dynamics_title;//学校动态标题
	
	@NotNull(message="学校动态副标题不能为空")
	private String yc_school_dynamics_subtitle;//学校动态副标题
	
	private Date yc_school_dynamics_time;//发布时间
	
	@NotNull(message="封面图片不能为空")
	private String yc_school_dynamics_title_image;//封面图片
	
	@NotNull(message="内容详情不能为空")
	private String yc_school_dynamics_detail;//内容详情
	
	private String yc_school_dynamics_school;//所属学校唯一标识

	private Integer yc_school_dynamics_type;//1已读2未读

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

	public String getYc_school_dynamics_title() {
		return yc_school_dynamics_title;
	}

	public void setYc_school_dynamics_title(String yc_school_dynamics_title) {
		this.yc_school_dynamics_title = yc_school_dynamics_title;
	}

	public String getYc_school_dynamics_subtitle() {
		return yc_school_dynamics_subtitle;
	}

	public void setYc_school_dynamics_subtitle(String yc_school_dynamics_subtitle) {
		this.yc_school_dynamics_subtitle = yc_school_dynamics_subtitle;
	}

	public Date getYc_school_dynamics_time() {
		return yc_school_dynamics_time;
	}

	public void setYc_school_dynamics_time(Date yc_school_dynamics_time) {
		this.yc_school_dynamics_time = yc_school_dynamics_time;
	}

	public String getYc_school_dynamics_title_image() {
		return yc_school_dynamics_title_image;
	}

	public void setYc_school_dynamics_title_image(String yc_school_dynamics_title_image) {
		this.yc_school_dynamics_title_image = yc_school_dynamics_title_image;
	}

	public String getYc_school_dynamics_detail() {
		return yc_school_dynamics_detail;
	}

	public void setYc_school_dynamics_detail(String yc_school_dynamics_detail) {
		this.yc_school_dynamics_detail = yc_school_dynamics_detail;
	}

	public String getYc_school_dynamics_school() {
		return yc_school_dynamics_school;
	}

	public void setYc_school_dynamics_school(String yc_school_dynamics_school) {
		this.yc_school_dynamics_school = yc_school_dynamics_school;
	}

	public Integer getYc_school_dynamics_type() {
		return yc_school_dynamics_type;
	}

	public void setYc_school_dynamics_type(Integer yc_school_dynamics_type) {
		this.yc_school_dynamics_type = yc_school_dynamics_type;
	}
}
