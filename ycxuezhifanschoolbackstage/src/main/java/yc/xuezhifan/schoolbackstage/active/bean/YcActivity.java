package yc.xuezhifan.schoolbackstage.active.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import yc.xuezhifan.schoolbackstage.activesponsor.bean.YcAdmin;
import yc.xuezhifan.schoolbackstage.activesponsor.bean.YcBranchAdmin;
import yc.xuezhifan.schoolbackstage.activesponsor.bean.YcSchoolVo;
import yc.xuezhifan.schoolbackstage.activesponsor.bean.YcUserVo;

/**
 * 
* <p>Title: 活动表 </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月19日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月19日  

* @version 1.0
 */
public class YcActivity {

	private String id;//主键，标识
	
	@NotNull(message="活动标题不能为空")
	private String yc_activity_title;//活动标题
	
	private String yc_activity_sponsor;//活动发起人
	
	private Date yc_activity_time;//活动时间
	
	private String yc_activity_cover_image;//活动封面图片
	
	@NotNull(message="活动地点不能为空")
	private String yc_activity_location;//活动地点
	
	private String yc_activity_map_location;//地图地点
	
	@NotNull(message="名额不能为空")
	private Integer yc_activity_people_number;//名额
	
	@NotNull(message="单人费用不能为空")
	private BigDecimal yc_activity_single_fee;//单人费用
	
	private String yc_activity_registration_time;//报名时间
	
	private String yc_activity_deadline_time;//截止时间
	
	@NotNull(message="联系电话不能为空")
	private String yc_activity_phone;//联系电话
	
	private String yc_district;//地区
	
	private String yc_activity_details;//详情页地址
	
	private Integer yc_sponsor_type;//发起人类型( 1为总公司, 2为分公司,3为学校,4为教师或家委会)
	
	private Integer yc_activity_type;//活动状态

	/**
	 * 封装
	 * @return
	 */
	public String getId() {
		return id;
	}

	public Integer getYc_activity_type() {
		return yc_activity_type;
	}

	public void setYc_activity_type(Integer yc_activity_type) {
		this.yc_activity_type = yc_activity_type;
	}

	public String getYc_district() {
		return yc_district;
	}

	public void setYc_district(String yc_district) {
		this.yc_district = yc_district;
	}

	public Integer getYc_sponsor_type() {
		return yc_sponsor_type;
	}

	public void setYc_sponsor_type(Integer yc_sponsor_type) {
		this.yc_sponsor_type = yc_sponsor_type;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_activity_title() {
		return yc_activity_title;
	}

	public void setYc_activity_title(String yc_activity_title) {
		this.yc_activity_title = yc_activity_title;
	}

	public String getYc_activity_sponsor() {
		return yc_activity_sponsor;
	}

	public void setYc_activity_sponsor(String yc_activity_sponsor) {
		this.yc_activity_sponsor = yc_activity_sponsor;
	}

	public Date getYc_activity_time() {
		return yc_activity_time;
	}

	public void setYc_activity_time(Date yc_activity_time) {
		this.yc_activity_time = yc_activity_time;
	}

	public String getYc_activity_cover_image() {
		return yc_activity_cover_image;
	}

	public void setYc_activity_cover_image(String yc_activity_cover_image) {
		this.yc_activity_cover_image = yc_activity_cover_image;
	}

	public String getYc_activity_location() {
		return yc_activity_location;
	}

	public void setYc_activity_location(String yc_activity_location) {
		this.yc_activity_location = yc_activity_location;
	}

	public String getYc_activity_map_location() {
		return yc_activity_map_location;
	}

	public void setYc_activity_map_location(String yc_activity_map_location) {
		this.yc_activity_map_location = yc_activity_map_location;
	}

	public Integer getYc_activity_people_number() {
		return yc_activity_people_number;
	}

	public void setYc_activity_people_number(Integer yc_activity_people_number) {
		this.yc_activity_people_number = yc_activity_people_number;
	}

	public BigDecimal getYc_activity_single_fee() {
		return yc_activity_single_fee;
	}

	public void setYc_activity_single_fee(BigDecimal yc_activity_single_fee) {
		this.yc_activity_single_fee = yc_activity_single_fee;
	}

	public String getYc_activity_registration_time() {
		return yc_activity_registration_time;
	}

	public void setYc_activity_registration_time(String yc_activity_registration_time) {
		this.yc_activity_registration_time = yc_activity_registration_time;
	}

	public String getYc_activity_deadline_time() {
		return yc_activity_deadline_time;
	}

	public void setYc_activity_deadline_time(String yc_activity_deadline_time) {
		this.yc_activity_deadline_time = yc_activity_deadline_time;
	}

	public String getYc_activity_phone() {
		return yc_activity_phone;
	}

	public void setYc_activity_phone(String yc_activity_phone) {
		this.yc_activity_phone = yc_activity_phone;
	}

	public String getYc_activity_details() {
		return yc_activity_details;
	}

	public void setYc_activity_details(String yc_activity_details) {
		this.yc_activity_details = yc_activity_details;
	}



}
