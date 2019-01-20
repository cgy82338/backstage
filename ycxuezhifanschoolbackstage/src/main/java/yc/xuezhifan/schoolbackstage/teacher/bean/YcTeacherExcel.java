package yc.xuezhifan.schoolbackstage.teacher.bean;


import cn.afterturn.easypoi.excel.annotation.Excel;
/**
 *

 * <p>Title: YcSubjectManagement.java </p>

 * <p>Description: 批量添加教师表</p>

 * <p>Copyright: Copyright (c) 2018年12月27日</p>

 * @email xiaoyu@xuezhifan.com

 * @author xiaoyu

 * @date 2018年12月27日

 * @version 1.0
 */
//@ExcelTarget(value="" )
public class YcTeacherExcel {

	@Excel(name = "教师姓名", orderNum = "0",width=20)
	private String name;

	@Excel(name = "手机号码", orderNum = "1",width=20)
	private String phone;
	
	@Excel(name = "性别,提示：男/女", orderNum = "2",width=20)
	private String sex;
		
	@Excel(name = "身份证号", orderNum = "3",width=30)
	private String idcard;

	/**
	 * 封装
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcard == null) ? 0 : idcard.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YcTeacherExcel other = (YcTeacherExcel) obj;
		if (idcard == null) {
			if (other.idcard != null)
				return false;
		} else if (!idcard.equals(other.idcard))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "YcTeacherExcel [name=" + name + ", phone=" + phone + ", sex=" + sex + ", idcard=" + idcard + "]";
	}

	public YcTeacherExcel(String name, String phone, String sex, String idcard) {
		super();
		this.name = name;
		this.phone = phone;
		this.sex = sex;
		this.idcard = idcard;
	}

	public YcTeacherExcel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
