package yc.xuezhifan.schoolbackstage.share.bean;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClass;

import java.util.Date;


/**
* @author linxiao
* @version 创建时间：2018年8月8日 下午6:26:18
* 孩子班级关系表
*/
public class YcChildClass {

	private String id;//主键，标识
	
	private String yc_child_id;//孩子唯一标识
	
	private String yc_class_id;//班级唯一标识
	
	private Date yc_create_time;//创建时间
	
	private Integer yc_status;//状态(1:申请2：通过 3:拒绝)
	
	private String yc_review_id;//审核人
	
	private Integer yc_permission_status;//权限（1群主2管理员3平民）
	
	private String yc_verification_message;//验证信息
	
	private String yc_reason;//拒绝理由
	
	private String yc_user_id;//申请人
	

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

	public String getYc_child_id() {
		return yc_child_id;
	}

	public void setYc_child_id(String yc_child_id) {
		this.yc_child_id = yc_child_id;
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

	public String getYc_verification_message() {
		return yc_verification_message;
	}

	public void setYc_verification_message(String yc_verification_message) {
		this.yc_verification_message = yc_verification_message;
	}

	public String getYc_reason() {
		return yc_reason;
	}

	public void setYc_reason(String yc_reason) {
		this.yc_reason = yc_reason;
	}

	public String getYc_user_id() {
		return yc_user_id;
	}

	public void setYc_user_id(String yc_user_id) {
		this.yc_user_id = yc_user_id;
	}

}
