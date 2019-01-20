package yc.xuezhifan.schoolbackstage.schoolfeature.bean;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;

/**
 * 

* <p>Title: YcSchoolFeatureStatus.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月1日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月1日  

* @version 1.0
 */
public class YcSchoolFeatureStatus {

	private String id;//主键
	
	private String yc_school_id;//学校唯一标识
	
	private String yc_feature_id;//功能唯一标识
	
	@Value("1")
	private Integer yc_feature_status;//功能状态（1为关闭，2为开通）
	
	@CreatedDate
	private Date yc_feature_open_time;//开通时间
	
	private String yc_customer_service_id;//外键（专属客服id）
	
	private String yc_certification_id;//外键（认证id）

	private YcCertification ycCertification;//认证
	
	private YcCustomerService ycCustomerService;//专属客服
	
	/**
	 * 封装
	 * @return
	 */
	public String getId() {
		return id;
	}

	public YcCertification getYcCertification() {
		return ycCertification;
	}

	public void setYcCertification(YcCertification ycCertification) {
		this.ycCertification = ycCertification;
	}

	public YcCustomerService getYcCustomerService() {
		return ycCustomerService;
	}

	public void setYcCustomerService(YcCustomerService ycCustomerService) {
		this.ycCustomerService = ycCustomerService;
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

	public String getYc_feature_id() {
		return yc_feature_id;
	}

	public void setYc_feature_id(String yc_feature_id) {
		this.yc_feature_id = yc_feature_id;
	}

	public Integer getYc_feature_status() {
		return yc_feature_status;
	}

	public void setYc_feature_status(Integer yc_feature_status) {
		this.yc_feature_status = yc_feature_status;
	}

	public Date getYc_feature_open_time() {
		return yc_feature_open_time;
	}

	public void setYc_feature_open_time(Date yc_feature_open_time) {
		this.yc_feature_open_time = yc_feature_open_time;
	}

	public String getYc_customer_service_id() {
		return yc_customer_service_id;
	}

	public void setYc_customer_service_id(String yc_customer_service_id) {
		this.yc_customer_service_id = yc_customer_service_id;
	}

	public String getYc_certification_id() {
		return yc_certification_id;
	}

	public void setYc_certification_id(String yc_certification_id) {
		this.yc_certification_id = yc_certification_id;
	}

	public YcSchoolFeatureStatus(String id, String yc_school_id, String yc_feature_id, Integer yc_feature_status,
			Date yc_feature_open_time, String yc_customer_service_id, String yc_certification_id) {
		super();
		this.id = id;
		this.yc_school_id = yc_school_id;
		this.yc_feature_id = yc_feature_id;
		this.yc_feature_status = yc_feature_status;
		this.yc_feature_open_time = yc_feature_open_time;
		this.yc_customer_service_id = yc_customer_service_id;
		this.yc_certification_id = yc_certification_id;
	}

	public YcSchoolFeatureStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
