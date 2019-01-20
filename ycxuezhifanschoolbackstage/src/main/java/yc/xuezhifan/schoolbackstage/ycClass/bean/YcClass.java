package yc.xuezhifan.schoolbackstage.ycClass.bean;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

/** 
* @author hanchangqing 
* @version 创建时间：2018年8月6日 上午8:15:52 
* 班级表 
*/
public class YcClass {
	
	private String yc_class_id;//主键
	
	private Integer yc_class_number;//班级编号
	
	private String yc_school_id;//主键
	
	@NotNull(message="班级名称不能为空")
	private String yc_class_name;//班级名称
	
	private Date yc_class_create_time;//创建时间
	
	private String yc_class_create_id;//创建人
	
	private String yc_class_head_teacher_id;//班主任唯一标识
	
	private String yc_class_head_teacher_name;//班主任姓名
	
	private String yc_class_avatar;//班级群组头像
	
	private double sa_longitude;//经度
	
	private double sa_latitude;//纬度
	
	private String Yc_address;//详细地址
	
	private String Yc_class_introduction;//班级简介
	
	private String yc_class_nature;// 班级性质 1:专业班级 2：家长群组
	
	private String yc_banned_status;//群组禁言状态 1:非禁言 2:禁言
	
//	private YcSchool ycSchool;//班级所属学校
	
	private List<YcIntermediateTable> ycIntermediateTables;

	/**
	 * 封装
	 * 
	 */
	public String getYc_class_id() {
		return yc_class_id;
	}

	public void setYc_class_id(String yc_class_id) {
		this.yc_class_id = yc_class_id;
	}

	public Integer getYc_class_number() {
		return yc_class_number;
	}

	public void setYc_class_number(Integer yc_class_number) {
		this.yc_class_number = yc_class_number;
	}

	public String getYc_school_id() {
		return yc_school_id;
	}

	public void setYc_school_id(String yc_school_id) {
		this.yc_school_id = yc_school_id;
	}

	public String getYc_class_name() {
		return yc_class_name;
	}

	public void setYc_class_name(String yc_class_name) {
		this.yc_class_name = yc_class_name;
	}

	public Date getYc_class_create_time() {
		return yc_class_create_time;
	}

	public void setYc_class_create_time(Date yc_class_create_time) {
		this.yc_class_create_time = yc_class_create_time;
	}

	public String getYc_class_create_id() {
		return yc_class_create_id;
	}

	public void setYc_class_create_id(String yc_class_create_id) {
		this.yc_class_create_id = yc_class_create_id;
	}

	public String getYc_class_head_teacher_id() {
		return yc_class_head_teacher_id;
	}

	public void setYc_class_head_teacher_id(String yc_class_head_teacher_id) {
		this.yc_class_head_teacher_id = yc_class_head_teacher_id;
	}

	public String getYc_class_head_teacher_name() {
		return yc_class_head_teacher_name;
	}

	public void setYc_class_head_teacher_name(String yc_class_head_teacher_name) {
		this.yc_class_head_teacher_name = yc_class_head_teacher_name;
	}

	public String getYc_class_avatar() {
		return yc_class_avatar;
	}

	public void setYc_class_avatar(String yc_class_avatar) {
		this.yc_class_avatar = yc_class_avatar;
	}

	public List<YcIntermediateTable> getYcIntermediateTables() {
		return ycIntermediateTables;
	}

	public void setYcIntermediateTables(List<YcIntermediateTable> ycIntermediateTables) {
		this.ycIntermediateTables = ycIntermediateTables;
	}

	public double getSa_longitude() {
		return sa_longitude;
	}

	public void setSa_longitude(double sa_longitude) {
		this.sa_longitude = sa_longitude;
	}

	public double getSa_latitude() {
		return sa_latitude;
	}

	public void setSa_latitude(double sa_latitude) {
		this.sa_latitude = sa_latitude;
	}

	public String getYc_address() {
		return Yc_address;
	}

	public void setYc_address(String yc_address) {
		Yc_address = yc_address;
	}

	public String getYc_class_introduction() {
		return Yc_class_introduction;
	}

	public void setYc_class_introduction(String yc_class_introduction) {
		Yc_class_introduction = yc_class_introduction;
	}

	public String getYc_class_nature() {
		return yc_class_nature;
	}

	public void setYc_class_nature(String yc_class_nature) {
		this.yc_class_nature = yc_class_nature;
	}

	
	public String getYc_banned_status() {
		return yc_banned_status;
	}

	public void setYc_banned_status(String yc_banned_status) {
		this.yc_banned_status = yc_banned_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Yc_address == null) ? 0 : Yc_address.hashCode());
		result = prime * result + ((Yc_class_introduction == null) ? 0 : Yc_class_introduction.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sa_latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sa_longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ycIntermediateTables == null) ? 0 : ycIntermediateTables.hashCode());
		result = prime * result + ((yc_class_avatar == null) ? 0 : yc_class_avatar.hashCode());
		result = prime * result + ((yc_class_create_id == null) ? 0 : yc_class_create_id.hashCode());
		result = prime * result + ((yc_class_create_time == null) ? 0 : yc_class_create_time.hashCode());
		result = prime * result + ((yc_class_head_teacher_id == null) ? 0 : yc_class_head_teacher_id.hashCode());
		result = prime * result + ((yc_class_head_teacher_name == null) ? 0 : yc_class_head_teacher_name.hashCode());
		result = prime * result + ((yc_class_id == null) ? 0 : yc_class_id.hashCode());
		result = prime * result + ((yc_class_name == null) ? 0 : yc_class_name.hashCode());
		result = prime * result + ((yc_class_nature == null) ? 0 : yc_class_nature.hashCode());
		result = prime * result + ((yc_class_number == null) ? 0 : yc_class_number.hashCode());
		result = prime * result + ((yc_school_id == null) ? 0 : yc_school_id.hashCode());
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
		YcClass other = (YcClass) obj;
		if (Yc_address == null) {
			if (other.Yc_address != null)
				return false;
		} else if (!Yc_address.equals(other.Yc_address))
			return false;
		if (Yc_class_introduction == null) {
			if (other.Yc_class_introduction != null)
				return false;
		} else if (!Yc_class_introduction.equals(other.Yc_class_introduction))
			return false;
		if (Double.doubleToLongBits(sa_latitude) != Double.doubleToLongBits(other.sa_latitude))
			return false;
		if (Double.doubleToLongBits(sa_longitude) != Double.doubleToLongBits(other.sa_longitude))
			return false;
		if (ycIntermediateTables == null) {
			if (other.ycIntermediateTables != null)
				return false;
		} else if (!ycIntermediateTables.equals(other.ycIntermediateTables))
			return false;
		if (yc_class_avatar == null) {
			if (other.yc_class_avatar != null)
				return false;
		} else if (!yc_class_avatar.equals(other.yc_class_avatar))
			return false;
		if (yc_class_create_id == null) {
			if (other.yc_class_create_id != null)
				return false;
		} else if (!yc_class_create_id.equals(other.yc_class_create_id))
			return false;
		if (yc_class_create_time == null) {
			if (other.yc_class_create_time != null)
				return false;
		} else if (!yc_class_create_time.equals(other.yc_class_create_time))
			return false;
		if (yc_class_head_teacher_id == null) {
			if (other.yc_class_head_teacher_id != null)
				return false;
		} else if (!yc_class_head_teacher_id.equals(other.yc_class_head_teacher_id))
			return false;
		if (yc_class_head_teacher_name == null) {
			if (other.yc_class_head_teacher_name != null)
				return false;
		} else if (!yc_class_head_teacher_name.equals(other.yc_class_head_teacher_name))
			return false;
		if (yc_class_id == null) {
			if (other.yc_class_id != null)
				return false;
		} else if (!yc_class_id.equals(other.yc_class_id))
			return false;
		if (yc_class_name == null) {
			if (other.yc_class_name != null)
				return false;
		} else if (!yc_class_name.equals(other.yc_class_name))
			return false;
		if (yc_class_nature == null) {
			if (other.yc_class_nature != null)
				return false;
		} else if (!yc_class_nature.equals(other.yc_class_nature))
			return false;
		if (yc_class_number == null) {
			if (other.yc_class_number != null)
				return false;
		} else if (!yc_class_number.equals(other.yc_class_number))
			return false;
		if (yc_school_id == null) {
			if (other.yc_school_id != null)
				return false;
		} else if (!yc_school_id.equals(other.yc_school_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "YcClass [yc_class_id=" + yc_class_id + ", yc_class_number=" + yc_class_number + ", yc_school_id="
				+ yc_school_id + ", yc_class_name=" + yc_class_name + ", yc_class_create_time=" + yc_class_create_time
				+ ", yc_class_create_id=" + yc_class_create_id + ", yc_class_head_teacher_id="
				+ yc_class_head_teacher_id + ", yc_class_head_teacher_name=" + yc_class_head_teacher_name
				+ ", yc_class_avatar=" + yc_class_avatar + ", sa_longitude=" + sa_longitude + ", sa_latitude="
				+ sa_latitude + ", Yc_address=" + Yc_address + ", Yc_class_introduction=" + Yc_class_introduction
				+ ", yc_class_nature=" + yc_class_nature + ", ycIntermediateTables=" + ycIntermediateTables + "]";
	}

	public YcClass(String yc_class_id, Integer yc_class_number, String yc_school_id, String yc_class_name,
			Date yc_class_create_time, String yc_class_create_id, String yc_class_head_teacher_id,
			String yc_class_head_teacher_name, String yc_class_avatar, double sa_longitude, double sa_latitude,
			String yc_address, String yc_class_introduction, String yc_class_nature,
			List<YcIntermediateTable> ycIntermediateTables) {
		super();
		this.yc_class_id = yc_class_id;
		this.yc_class_number = yc_class_number;
		this.yc_school_id = yc_school_id;
		this.yc_class_name = yc_class_name;
		this.yc_class_create_time = yc_class_create_time;
		this.yc_class_create_id = yc_class_create_id;
		this.yc_class_head_teacher_id = yc_class_head_teacher_id;
		this.yc_class_head_teacher_name = yc_class_head_teacher_name;
		this.yc_class_avatar = yc_class_avatar;
		this.sa_longitude = sa_longitude;
		this.sa_latitude = sa_latitude;
		Yc_address = yc_address;
		Yc_class_introduction = yc_class_introduction;
		this.yc_class_nature = yc_class_nature;
		this.ycIntermediateTables = ycIntermediateTables;
	}

	public YcClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
}
