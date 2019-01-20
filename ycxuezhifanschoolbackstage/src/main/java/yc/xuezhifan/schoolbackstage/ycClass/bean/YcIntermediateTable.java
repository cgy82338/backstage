package yc.xuezhifan.schoolbackstage.ycClass.bean;


import javax.validation.constraints.NotNull;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

/** 
* @author hanchangqing 
* @version 创建时间：2018年8月6日 上午8:11:20 
* 教师科目与班级关系表
*/
public class YcIntermediateTable {
	
    private String yc_intermediate_table_id;//主键
	
	@NotNull(message="班级id不能为空")
	private String yc_class_id;//班级id(班级表的唯一标识)
	
	@NotNull(message="教师科目管理id不能为空")
	private String yc_teacher_information_id;//教师科目管理id(用户表的唯一标识)
	
	private Integer yc_teacher_position;//职务（1为班主任，2为普通教师，默认为2）
	
	private YcUser yctearcher;//教师信息
	
	public String getYc_intermediate_table_id() {
		return yc_intermediate_table_id;
	}

	
	/**
	 * 封装
	 * @param yc_intermediate_table_id
	 */
	public void setYc_intermediate_table_id(String yc_intermediate_table_id) {
		this.yc_intermediate_table_id = yc_intermediate_table_id;
	}

	public String getYc_class_id() {
		return yc_class_id;
	}

	public void setYc_class_id(String yc_class_id) {
		this.yc_class_id = yc_class_id;
	}

	public String getYc_teacher_information_id() {
		return yc_teacher_information_id;
	}

	public void setYc_teacher_information_id(String yc_teacher_information_id) {
		this.yc_teacher_information_id = yc_teacher_information_id;
	}

	public YcUser getYctearcher() {
		return yctearcher;
	}


	public void setYctearcher(YcUser yctearcher) {
		this.yctearcher = yctearcher;
	}


	public Integer getYc_teacher_position() {
		return yc_teacher_position;
	}


	public void setYc_teacher_position(Integer yc_teacher_position) {
		this.yc_teacher_position = yc_teacher_position;
	}


	@Override
	public String toString() {
		return "YcIntermediateTable [yc_intermediate_table_id=" + yc_intermediate_table_id + ", yc_class_id="
				+ yc_class_id + ", yc_teacher_information_id=" + yc_teacher_information_id + ", yc_teacher_position="
				+ yc_teacher_position + ", yctearcher=" + yctearcher + "]";
	}


	public YcIntermediateTable(String yc_intermediate_table_id, String yc_class_id, String yc_teacher_information_id,
			Integer yc_teacher_position, YcUser yctearcher) {
		super();
		this.yc_intermediate_table_id = yc_intermediate_table_id;
		this.yc_class_id = yc_class_id;
		this.yc_teacher_information_id = yc_teacher_information_id;
		this.yc_teacher_position = yc_teacher_position;
		this.yctearcher = yctearcher;
	}


	public YcIntermediateTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
