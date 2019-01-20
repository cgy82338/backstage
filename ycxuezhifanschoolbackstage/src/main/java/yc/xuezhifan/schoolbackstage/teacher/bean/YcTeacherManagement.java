package yc.xuezhifan.schoolbackstage.teacher.bean;

import javax.validation.constraints.NotNull;


/** 
* @author hanchangqing 
* @version 创建时间：2018年8月4日 下午4:25:21 
* 教师科目管理表 
*/
public class YcTeacherManagement {
	
	@NotNull(message="主键不能为空")
    private String yc_teacher_information_id;//主键
	
	@NotNull(message="中间表id不能为空")
	private String id;//中间表id(用户表的唯一标识)
	
	@NotNull(message="职务不能为空")
	private Integer yc_teacher_informati_position;//职务（1为班主任，2为普通教师，默认为2）
	
	private String yc_subject_management_id;//科目唯一标识

	/**
	 * 封装
	 * @return
	 */
	public String getYc_teacher_information_id() {
		return yc_teacher_information_id;
	}

	public void setYc_teacher_information_id(String yc_teacher_information_id) {
		this.yc_teacher_information_id = yc_teacher_information_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public YcTeacherManagement(String yc_teacher_information_id, String id,
			Integer yc_teacher_informati_position, String yc_subject_management_id) {
		super();
		this.yc_teacher_information_id = yc_teacher_information_id;
		this.id = id;
		this.yc_teacher_informati_position = yc_teacher_informati_position;
		this.yc_subject_management_id = yc_subject_management_id;
	}

	public YcTeacherManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
