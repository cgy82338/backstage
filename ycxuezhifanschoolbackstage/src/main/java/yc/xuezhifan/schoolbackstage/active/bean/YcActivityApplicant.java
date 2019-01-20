package yc.xuezhifan.schoolbackstage.active.bean;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 

* <p>Title: 活动报名人表 </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月19日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月19日  

* @version 1.0
 */
public class YcActivityApplicant {

	private String id;//主键，标识
	
	private String yc_activity_id;//活动编号（唯一标识）
	
	private String yc_activity_applicant_id;//活动报名人帐号（唯一标识）
	
	private Integer yc_activity_people_number;//报名人数
	
	private String yc_activity_people_phone;//报名人电话

	private BigDecimal yc_activity_costs;//活动费用

	private Date yc_create_time;

	
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

	public String getYc_activity_id() {
		return yc_activity_id;
	}

	public void setYc_activity_id(String yc_activity_id) {
		this.yc_activity_id = yc_activity_id;
	}

	public String getYc_activity_applicant_id() {
		return yc_activity_applicant_id;
	}

	public void setYc_activity_applicant_id(String yc_activity_applicant_id) {
		this.yc_activity_applicant_id = yc_activity_applicant_id;
	}

	public Integer getYc_activity_people_number() {
		return yc_activity_people_number;
	}

	public void setYc_activity_people_number(Integer yc_activity_people_number) {
		this.yc_activity_people_number = yc_activity_people_number;
	}

	public String getYc_activity_people_phone() {
		return yc_activity_people_phone;
	}

	public void setYc_activity_people_phone(String yc_activity_people_phone) {
		this.yc_activity_people_phone = yc_activity_people_phone;
	}

	public BigDecimal getYc_activity_costs() {
		return yc_activity_costs;
	}

	public void setYc_activity_costs(BigDecimal yc_activity_costs) {
		this.yc_activity_costs = yc_activity_costs;
	}

	public Date getYc_create_time() {
		return yc_create_time;
	}

	public void setYc_create_time(Date yc_create_time) {
		this.yc_create_time = yc_create_time;
	}
}
