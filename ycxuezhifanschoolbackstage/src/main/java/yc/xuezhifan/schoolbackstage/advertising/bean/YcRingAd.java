package yc.xuezhifan.schoolbackstage.advertising.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * <p>
 * Title: 圈广告
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年10月16日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年10月16日
 * 
 * @version 1.0
 * 
 */
public class YcRingAd {

	private String id;// 主键，标识

	@NotNull(message = "广告标题不能为空")
	private String yc_headline;// 广告标题

	private Integer yc_applicant_type;//申请人类型(1为分公司,2为学校)
	
	@NotNull(message = "广告位不能为空")
	private String yc_advertising_space;// 广告位（存储广告位地区管理唯一标识）

	@Value("1")
	private Integer yc_serving_people;// 投放人群（1代表男，2代表女，3代表全部）

	private Date yc_start_time;// 开始时间
	
	private Date yc_end_time;// 结束时间

	@NotNull(message = "图片地址不能为空")
	private String yc_advertising_content;// 投放文件地址

	private String yc_advertising_link;// 广告链接（默认链接必填）

	private String yc_advertising_details;// 广告详情页地址

	private String yc_certificate;// 申请凭证

	private String yc_applicat_phone;// 申请人电话

	private Integer yc_volume;// 投放量

	private BigDecimal yc_price;// 价格

	private String yc_advertising_district;// 广告地区/区县（存储区县唯一标识）

	@Value("1")
	private Integer yc_advertising_status;// 广告状态（1为审核中，2为已上架，3为已结束）

	@Value("1")
	private Integer yc_delete;// 删除状态（1为展示，2为不展示，默认为1）

	private String yc_applicant;// 申请人唯一标示

	public Integer getYc_applicant_type() {
		return yc_applicant_type;
	}

	public void setYc_applicant_type(Integer yc_applicant_type) {
		this.yc_applicant_type = yc_applicant_type;
	}

	public Date getYc_end_time() {
		return yc_end_time;
	}

	public void setYc_end_time(Date yc_end_time) {
		this.yc_end_time = yc_end_time;
	}

	public String getYc_applicant() {
		return yc_applicant;
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

	public Integer getYc_serving_people() {
		return yc_serving_people;
	}

	public void setYc_serving_people(Integer yc_serving_people) {
		this.yc_serving_people = yc_serving_people;
	}

	public Date getYc_start_time() {
		return yc_start_time;
	}

	public void setYc_start_time(Date yc_start_time) {
		this.yc_start_time = yc_start_time;
	}

	public String getYc_advertising_content() {
		return yc_advertising_content;
	}

	public void setYc_advertising_content(String yc_advertising_content) {
		this.yc_advertising_content = yc_advertising_content;
	}

	public String getYc_advertising_link() {
		return yc_advertising_link;
	}

	public void setYc_advertising_link(String yc_advertising_link) {
		this.yc_advertising_link = yc_advertising_link;
	}

	public String getYc_advertising_details() {
		return yc_advertising_details;
	}

	public void setYc_advertising_details(String yc_advertising_details) {
		this.yc_advertising_details = yc_advertising_details;
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

	public Integer getYc_volume() {
		return yc_volume;
	}

	public void setYc_volume(Integer yc_volume) {
		this.yc_volume = yc_volume;
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
		result = prime * result + ((yc_advertising_content == null) ? 0 : yc_advertising_content.hashCode());
		result = prime * result + ((yc_advertising_details == null) ? 0 : yc_advertising_details.hashCode());
		result = prime * result + ((yc_advertising_district == null) ? 0 : yc_advertising_district.hashCode());
		result = prime * result + ((yc_advertising_link == null) ? 0 : yc_advertising_link.hashCode());
		result = prime * result + ((yc_advertising_space == null) ? 0 : yc_advertising_space.hashCode());
		result = prime * result + ((yc_advertising_status == null) ? 0 : yc_advertising_status.hashCode());
		result = prime * result + ((yc_applicat_phone == null) ? 0 : yc_applicat_phone.hashCode());
		result = prime * result + ((yc_certificate == null) ? 0 : yc_certificate.hashCode());
		result = prime * result + ((yc_delete == null) ? 0 : yc_delete.hashCode());
		result = prime * result + ((yc_headline == null) ? 0 : yc_headline.hashCode());
		result = prime * result + ((yc_price == null) ? 0 : yc_price.hashCode());
		result = prime * result + ((yc_serving_people == null) ? 0 : yc_serving_people.hashCode());
		result = prime * result + ((yc_start_time == null) ? 0 : yc_start_time.hashCode());
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
		YcRingAd other = (YcRingAd) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (yc_advertising_content == null) {
			if (other.yc_advertising_content != null)
				return false;
		} else if (!yc_advertising_content.equals(other.yc_advertising_content))
			return false;
		if (yc_advertising_details == null) {
			if (other.yc_advertising_details != null)
				return false;
		} else if (!yc_advertising_details.equals(other.yc_advertising_details))
			return false;
		if (yc_advertising_district == null) {
			if (other.yc_advertising_district != null)
				return false;
		} else if (!yc_advertising_district.equals(other.yc_advertising_district))
			return false;
		if (yc_advertising_link == null) {
			if (other.yc_advertising_link != null)
				return false;
		} else if (!yc_advertising_link.equals(other.yc_advertising_link))
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
		if (yc_serving_people == null) {
			if (other.yc_serving_people != null)
				return false;
		} else if (!yc_serving_people.equals(other.yc_serving_people))
			return false;
		if (yc_start_time == null) {
			if (other.yc_start_time != null)
				return false;
		} else if (!yc_start_time.equals(other.yc_start_time))
			return false;
		if (yc_volume == null) {
			if (other.yc_volume != null)
				return false;
		} else if (!yc_volume.equals(other.yc_volume))
			return false;
		return true;
	}

}
