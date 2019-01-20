package yc.xuezhifan.schoolbackstage.advertising.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * 
 * <p>
 * Title: YcPushAd.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年10月15日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年10月15日
 * 
 * @version 1.0
 * 
 */
public class YcPushAd {

	private String id;// 主键，标识

	@NotNull
	private String yc_headline;// 广告标题

	@NotNull
	private String yc_advertising_space;// 广告位（存储广告位唯一标识）

	private Integer yc_push_type;// 推送类型

	@NotNull
	private Integer yc_advertising_people;// 投放人群（1代表男，2代表女，3代表全部）

	@NotNull
	private String yc_push_content;// 推送内容

	@NotNull
	private Integer yc_volume;// 投放量

	private String yc_certificate;// 申请凭证

	private Date yc_review_time;//审核时间
	
	@NotNull
	private String yc_applicat_phone;// 申请人电话

	@NotNull
	private BigDecimal yc_price;// 价格

	@NotNull
	private String yc_advertising_district;// 广告地区/区县（存储区县唯一标识）

	private Integer yc_advertising_status;// 广告状态（1为审核中，2为已上架，3为已结束）

	private Integer yc_delete;// 删除状态（1为展示，2为不展示，默认为1）

	private String yc_applicant;// 申请人唯一标示

	private Integer yc_applicant_type;//申请人类型(1为分公司,2为学校)
	

	public Integer getYc_applicant_type() {
		return yc_applicant_type;
	}

	public void setYc_applicant_type(Integer yc_applicant_type) {
		this.yc_applicant_type = yc_applicant_type;
	}

	public String getYc_applicant() {
		return yc_applicant;
	}

	public Date getYc_review_time() {
		return yc_review_time;
	}

	public void setYc_review_time(Date yc_review_time) {
		this.yc_review_time = yc_review_time;
	}

	public void setYc_applicant(String yc_applicant) {
		this.yc_applicant = yc_applicant;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_headline() {
		return yc_headline;
	}

	public void setYc_headline(String yc_headline) {
		this.yc_headline = yc_headline;
	}

	public String getYc_advertising_space() {
		return yc_advertising_space;
	}

	public void setYc_advertising_space(String yc_advertising_space) {
		this.yc_advertising_space = yc_advertising_space;
	}

	public Integer getYc_push_type() {
		return yc_push_type;
	}

	public void setYc_push_type(Integer yc_push_type) {
		this.yc_push_type = yc_push_type;
	}

	public Integer getYc_advertising_people() {
		return yc_advertising_people;
	}

	public void setYc_advertising_people(Integer yc_advertising_people) {
		this.yc_advertising_people = yc_advertising_people;
	}

	public String getYc_push_content() {
		return yc_push_content;
	}

	public void setYc_push_content(String yc_push_content) {
		this.yc_push_content = yc_push_content;
	}

	public Integer getYc_volume() {
		return yc_volume;
	}

	public void setYc_volume(Integer yc_volume) {
		this.yc_volume = yc_volume;
	}

	public String getYc_certificate() {
		return yc_certificate;
	}

	public void setYc_certificate(String yc_certificate) {
		this.yc_certificate = yc_certificate;
	}

	public String getYc_applicat_phone() {
		return yc_applicat_phone;
	}

	public void setYc_applicat_phone(String yc_applicat_phone) {
		this.yc_applicat_phone = yc_applicat_phone;
	}

	public BigDecimal getYc_price() {
		return yc_price;
	}

	public void setYc_price(BigDecimal yc_price) {
		this.yc_price = yc_price;
	}

	public String getYc_advertising_district() {
		return yc_advertising_district;
	}

	public void setYc_advertising_district(String yc_advertising_district) {
		this.yc_advertising_district = yc_advertising_district;
	}

	public Integer getYc_advertising_status() {
		return yc_advertising_status;
	}

	public void setYc_advertising_status(Integer yc_advertising_status) {
		this.yc_advertising_status = yc_advertising_status;
	}

	public Integer getYc_delete() {
		return yc_delete;
	}

	public void setYc_delete(Integer yc_delete) {
		this.yc_delete = yc_delete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((yc_advertising_district == null) ? 0 : yc_advertising_district.hashCode());
		result = prime * result + ((yc_advertising_people == null) ? 0 : yc_advertising_people.hashCode());
		result = prime * result + ((yc_advertising_space == null) ? 0 : yc_advertising_space.hashCode());
		result = prime * result + ((yc_advertising_status == null) ? 0 : yc_advertising_status.hashCode());
		result = prime * result + ((yc_applicat_phone == null) ? 0 : yc_applicat_phone.hashCode());
		result = prime * result + ((yc_certificate == null) ? 0 : yc_certificate.hashCode());
		result = prime * result + ((yc_delete == null) ? 0 : yc_delete.hashCode());
		result = prime * result + ((yc_headline == null) ? 0 : yc_headline.hashCode());
		result = prime * result + ((yc_price == null) ? 0 : yc_price.hashCode());
		result = prime * result + ((yc_push_content == null) ? 0 : yc_push_content.hashCode());
		result = prime * result + ((yc_push_type == null) ? 0 : yc_push_type.hashCode());
		result = prime * result + ((yc_volume == null) ? 0 : yc_volume.hashCode());
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
		YcPushAd other = (YcPushAd) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (yc_advertising_district == null) {
			if (other.yc_advertising_district != null)
				return false;
		} else if (!yc_advertising_district.equals(other.yc_advertising_district))
			return false;
		if (yc_advertising_people == null) {
			if (other.yc_advertising_people != null)
				return false;
		} else if (!yc_advertising_people.equals(other.yc_advertising_people))
			return false;
		if (yc_advertising_space == null) {
			if (other.yc_advertising_space != null)
				return false;
		} else if (!yc_advertising_space.equals(other.yc_advertising_space))
			return false;
		if (yc_advertising_status == null) {
			if (other.yc_advertising_status != null)
				return false;
		} else if (!yc_advertising_status.equals(other.yc_advertising_status))
			return false;
		if (yc_applicat_phone == null) {
			if (other.yc_applicat_phone != null)
				return false;
		} else if (!yc_applicat_phone.equals(other.yc_applicat_phone))
			return false;
		if (yc_certificate == null) {
			if (other.yc_certificate != null)
				return false;
		} else if (!yc_certificate.equals(other.yc_certificate))
			return false;
		if (yc_delete == null) {
			if (other.yc_delete != null)
				return false;
		} else if (!yc_delete.equals(other.yc_delete))
			return false;
		if (yc_headline == null) {
			if (other.yc_headline != null)
				return false;
		} else if (!yc_headline.equals(other.yc_headline))
			return false;
		if (yc_price == null) {
			if (other.yc_price != null)
				return false;
		} else if (!yc_price.equals(other.yc_price))
			return false;
		if (yc_push_content == null) {
			if (other.yc_push_content != null)
				return false;
		} else if (!yc_push_content.equals(other.yc_push_content))
			return false;
		if (yc_push_type == null) {
			if (other.yc_push_type != null)
				return false;
		} else if (!yc_push_type.equals(other.yc_push_type))
			return false;
		if (yc_volume == null) {
			if (other.yc_volume != null)
				return false;
		} else if (!yc_volume.equals(other.yc_volume))
			return false;
		return true;
	}

}
