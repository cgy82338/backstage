package yc.xuezhifan.schoolbackstage.teacher.vo;

import org.springframework.stereotype.Component;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

/**
 * 

* <p>Title: YcTeacherVo.java </p> 

* <p>Description: 教师Vo类</p> 

* <p>Copyright: Copyright (c) 2018年9月18日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年9月18日  

* @version 1.0
 */
@Component
public class YcTeacherVo  {//extends YcUser 

	private String yc_teacher_information_id;
	private String id;
	private Integer yc_teacher_informati_position;
	private String yc_subject_management_id;
	private YcUser ycUser=new YcUser();
	
	/**
	 * 封装
	 * 
	 * @return
	 */
	
	public String getYc_teacher_information_id() {
		return yc_teacher_information_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setYc_teacher_information_id(String yc_teacher_information_id) {
		this.yc_teacher_information_id = yc_teacher_information_id;
	}
	public Integer getYc_teacher_informati_position() {
		return yc_teacher_informati_position;
	}
	public void setYc_teacher_informati_position(Integer yc_teacher_informati_position) {
		this.yc_teacher_informati_position = yc_teacher_informati_position;
	}
	public String getYc_subject_management_id() {
		return yc_subject_management_id;
	}
	public void setYc_subject_management_id(String yc_subject_management_id) {
		this.yc_subject_management_id = yc_subject_management_id;
	}
	
	public YcUser getYcUser() {
		return ycUser;
	}
	public void setYcUser(YcUser ycUser) {
		this.ycUser = ycUser;
	}
	@Override
	public String toString() {
		return "YcTeacherVo [yc_teacher_information_id=" + yc_teacher_information_id + ", id=" + id
				+ ", yc_teacher_informati_position=" + yc_teacher_informati_position + ", yc_subject_management_id="
				+ yc_subject_management_id + ", ycUser=" + ycUser + "]";
	}

	
	
	
	
	
	

}
