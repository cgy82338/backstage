package yc.xuezhifan.schoolbackstage.ycClass.bean;

import java.util.Date;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;




/**
 * @author linxiao
 * @version 创建时间：2018年8月8日 下午6:36:48
 * 家长班级关系表
 */
public class YcParentClass {

	private String id;//主键，标识

	private String yc_parent_id;//家长唯一标识

	private String yc_class_id;//班级唯一标识

	private Date yc_create_time;//创建时间

	private Integer yc_status=1;//状态(1：通过 2:拒绝,3:申请4:已退出)

	private String yc_review_id;//审核人

	private Integer yc_permission_status=3;//权限（1群主2管理员3平民,4:已离职教师）

	private String yc_verification_message;//验证信息

	private String yc_remarks;//群备注

	private String yc_reason;//拒绝理由

	private YcUser ycUser;//家长信息

	private YcClass  ycClass;

	private YcUser ycReview;//审核人信息

	private String yc_message_avoidance;//免打扰 1:非免打扰 2:免打扰

	public YcUser getYcReview() {
		return ycReview;
	}

	public void setYcReview(YcUser ycReview) {
		this.ycReview = ycReview;
	}

	public String getYc_reason() {
		return yc_reason;
	}

	public void setYc_reason(String yc_reason) {
		this.yc_reason = yc_reason;
	}

	public String getYc_verification_message() {
		return yc_verification_message;
	}

	public void setYc_verification_message(String yc_verification_message) {
		this.yc_verification_message = yc_verification_message;
	}



	public YcUser getYcUser() {
		return ycUser;
	}

	public void setYcUser(YcUser ycUser) {
		this.ycUser = ycUser;
	}

	/**
	 * 封装
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_parent_id() {
		return yc_parent_id;
	}

	public void setYc_parent_id(String yc_parent_id) {
		this.yc_parent_id = yc_parent_id;
	}

	public String getYc_class_id() {
		return yc_class_id;
	}

	public void setYc_class_id(String yc_class_id) {
		this.yc_class_id = yc_class_id;
	}

	public Date getYc_create_time() {
		return yc_create_time;
	}

	public void setYc_create_time(Date yc_create_time) {
		this.yc_create_time = yc_create_time;
	}

	public Integer getYc_status() {
		return yc_status;
	}

	public void setYc_status(Integer yc_status) {
		this.yc_status = yc_status;
	}

	public String getYc_review_id() {
		return yc_review_id;
	}

	public void setYc_review_id(String yc_review_id) {
		this.yc_review_id = yc_review_id;
	}

	public Integer getYc_permission_status() {
		return yc_permission_status;
	}

	public void setYc_permission_status(Integer yc_permission_status) {
		this.yc_permission_status = yc_permission_status;
	}

	public YcClass getYcClass() {
		return ycClass;
	}

	public void setYcClass(YcClass ycClass) {
		this.ycClass = ycClass;
	}



	public String getYc_remarks() {
		return yc_remarks;
	}

	public void setYc_remarks(String yc_remarks) {
		this.yc_remarks = yc_remarks;
	}

	public String getYc_message_avoidance() {
		return yc_message_avoidance;
	}

	public void setYc_message_avoidance(String yc_message_avoidance) {
		this.yc_message_avoidance = yc_message_avoidance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((yc_class_id == null) ? 0 : yc_class_id.hashCode());
		result = prime * result + ((yc_create_time == null) ? 0 : yc_create_time.hashCode());
		result = prime * result + ((yc_parent_id == null) ? 0 : yc_parent_id.hashCode());
		result = prime * result + ((yc_permission_status == null) ? 0 : yc_permission_status.hashCode());
		result = prime * result + ((yc_review_id == null) ? 0 : yc_review_id.hashCode());
		result = prime * result + ((yc_status == null) ? 0 : yc_status.hashCode());
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
		YcParentClass other = (YcParentClass) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (yc_class_id == null) {
			if (other.yc_class_id != null)
				return false;
		} else if (!yc_class_id.equals(other.yc_class_id))
			return false;
		if (yc_create_time == null) {
			if (other.yc_create_time != null)
				return false;
		} else if (!yc_create_time.equals(other.yc_create_time))
			return false;
		if (yc_parent_id == null) {
			if (other.yc_parent_id != null)
				return false;
		} else if (!yc_parent_id.equals(other.yc_parent_id))
			return false;
		if (yc_permission_status == null) {
			if (other.yc_permission_status != null)
				return false;
		} else if (!yc_permission_status.equals(other.yc_permission_status))
			return false;
		if (yc_review_id == null) {
			if (other.yc_review_id != null)
				return false;
		} else if (!yc_review_id.equals(other.yc_review_id))
			return false;
		if (yc_status == null) {
			if (other.yc_status != null)
				return false;
		} else if (!yc_status.equals(other.yc_status))
			return false;
		return true;
	}

	public YcParentClass(String id, String yc_parent_id, String yc_class_id, Date yc_create_time, Integer yc_status,
						 String yc_review_id, Integer yc_permission_status) {
		super();
		this.id = id;
		this.yc_parent_id = yc_parent_id;
		this.yc_class_id = yc_class_id;
		this.yc_create_time = yc_create_time;
		this.yc_status = yc_status;
		this.yc_review_id = yc_review_id;
		this.yc_permission_status = yc_permission_status;
	}

	@Override
	public String toString() {
		return "YcParentClass [id=" + id + ", yc_parent_id=" + yc_parent_id + ", yc_class_id=" + yc_class_id
				+ ", yc_create_time=" + yc_create_time + ", yc_status=" + yc_status + ", yc_review_id=" + yc_review_id
				+ ", yc_permission_status=" + yc_permission_status + "]";
	}


	public YcParentClass() {
		super();
		// TODO Auto-generated constructor stub
	}



}
