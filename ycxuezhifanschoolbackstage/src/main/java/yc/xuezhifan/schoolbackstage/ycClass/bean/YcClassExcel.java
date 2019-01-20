package yc.xuezhifan.schoolbackstage.ycClass.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class YcClassExcel {

	@Excel(name = "班级名称", orderNum = "0",width=30)
	private String className;

	@Excel(name = "班主任手机号码", orderNum = "1",width=30)
	private String phone;
	
	@Excel(name = "任课教师手机号,提示：分割线用'/'", orderNum = "2",width=30)
	private String otherPhone;

	/**
	 * 封装
	 */
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOtherPhone() {
		return otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((otherPhone == null) ? 0 : otherPhone.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		YcClassExcel other = (YcClassExcel) obj;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (otherPhone == null) {
			if (other.otherPhone != null)
				return false;
		} else if (!otherPhone.equals(other.otherPhone))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "YcClassExcel [className=" + className + ", phone=" + phone + ", otherPhone=" + otherPhone + "]";
	}

	public YcClassExcel(String className, String phone, String otherPhone) {
		super();
		this.className = className;
		this.phone = phone;
		this.otherPhone = otherPhone;
	}

	public YcClassExcel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
