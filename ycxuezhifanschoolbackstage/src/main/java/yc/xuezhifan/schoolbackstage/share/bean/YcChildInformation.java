package yc.xuezhifan.schoolbackstage.share.bean;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 *

 * <p>Title: YcChildInformation.java </p>

 * <p>Description: 孩子信息</p>

 * <p>Copyright: Copyright (c) 2019年1月2日</p>

 * @email xiaoyu@xuezhifan.com

 * @author xiaoyu

 * @date 2019年1月2日

 * @version 1.0
 */
public class YcChildInformation {

	private String id;//主键
	
	private String yc_school_id;//学校唯一标识
	
	private String yc_class_id;//班级唯一标识
	
	private String yc_clas_address;//家庭住址
	
	@NotNull(message="孩子姓名不能为空")
	private String yc_child_name;//孩子姓名
	
	@NotNull(message="孩子性别不能为空")
	private Integer yc_child_gender;//孩子性别（1为男，2为女，默认为2）
	
	private Date yc_child_brith;//孩子出生年月
	
	@NotNull(message="孩子头像不能为空")
	private String yc_child_avatar;//孩子头像
	
	private String yc_founder;//创建人id

	private Integer yc_delete;//删除状态（1未删除2已删除）
	
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

	public String getYc_school_id() {
		return yc_school_id;
	}

	public void setYc_school_id(String yc_school_id) {
		this.yc_school_id = yc_school_id;
	}

	public String getYc_class_id() {
		return yc_class_id;
	}

	public void setYc_class_id(String yc_class_id) {
		this.yc_class_id = yc_class_id;
	}

	public String getYc_clas_address() {
		return yc_clas_address;
	}

	public void setYc_clas_address(String yc_clas_address) {
		this.yc_clas_address = yc_clas_address;
	}

	public String getYc_child_name() {
		return yc_child_name;
	}

	public void setYc_child_name(String yc_child_name) {
		this.yc_child_name = yc_child_name;
	}

	public Integer getYc_child_gender() {
		return yc_child_gender;
	}

	public void setYc_child_gender(Integer yc_child_gender) {
		this.yc_child_gender = yc_child_gender;
	}

	public Date getYc_child_brith() {
		return yc_child_brith;
	}

	public void setYc_child_brith(Date yc_child_brith) {
		this.yc_child_brith = yc_child_brith;
	}

	public String getYc_child_avatar() {
		return yc_child_avatar;
	}

	public void setYc_child_avatar(String yc_child_avatar) {
		this.yc_child_avatar = yc_child_avatar;
	}

	public String getYc_founder() {
		return yc_founder;
	}

	public void setYc_founder(String yc_founder) {
		this.yc_founder = yc_founder;
	}

	public Integer getYc_delete() {
		return yc_delete;
	}

	public void setYc_delete(Integer yc_delete) {
		this.yc_delete = yc_delete;
	}
}
