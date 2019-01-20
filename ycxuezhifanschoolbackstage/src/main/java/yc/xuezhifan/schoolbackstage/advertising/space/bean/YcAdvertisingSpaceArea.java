package yc.xuezhifan.schoolbackstage.advertising.space.bean;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

/**
 * 

* <p>Title: 广告位地区管理表  </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月12日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月12日  

* @version 1.0
 */
public class YcAdvertisingSpaceArea {

	private String id;//主键，标识
	
	@NotNull(message="广告位唯一标识不能为空")
	private  String yc_advertising_id ;//广告位唯一标识
	
	private  String yc_advertising_district ;//广告地区/区县（存储区县唯一标识，为空时默认为全国）
	
	@NotNull(message="底价不能为空")
	private  BigDecimal yc_reserve_price ;//底价
	
	@NotNull(message="市场指导价不能为空")
	private  BigDecimal yc_market_guidance_price ;//市场指导价
	
	@NotNull(message="市场实际价不能为空")
	private  BigDecimal yc_actual_market_price ;//市场实际价（由代理商填写，默认指导价）
	
	@NotNull(message="提成比例不能为空")
	private  Integer yc_proportion_commission ;//提成比例
	
	@NotNull(message="优惠不能为空")
	private  BigDecimal yc_offer ;//优惠
	
	@Value("1")
	private Integer yc_advertising_status;//广告位状态（2为有广告，1为无广告）
	
	private YcAdvertisingSpace ycAdvertisingSpace;//广告位
		
	/**
	 * 封装
	 * @return
	 */
	
	public String getId() {
		return id;
	}

	public YcAdvertisingSpace getYcAdvertisingSpace() {
		return ycAdvertisingSpace;
	}

	public void setYcAdvertisingSpace(YcAdvertisingSpace ycAdvertisingSpace) {
		this.ycAdvertisingSpace = ycAdvertisingSpace;
	}

	public Integer getYc_advertising_status() {
		return yc_advertising_status;
	}

	public void setYc_advertising_status(Integer yc_advertising_status) {
		this.yc_advertising_status = yc_advertising_status;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_advertising_id() {
		return yc_advertising_id;
	}

	public void setYc_advertising_id(String yc_advertising_id) {
		this.yc_advertising_id = yc_advertising_id;
	}

	public String getYc_advertising_district() {
		return yc_advertising_district;
	}

	public void setYc_advertising_district(String yc_advertising_district) {
		this.yc_advertising_district = yc_advertising_district;
	}

	public BigDecimal getYc_reserve_price() {
		return yc_reserve_price;
	}

	public void setYc_reserve_price(BigDecimal yc_reserve_price) {
		this.yc_reserve_price = yc_reserve_price;
	}

	public BigDecimal getYc_market_guidance_price() {
		return yc_market_guidance_price;
	}

	public void setYc_market_guidance_price(BigDecimal yc_market_guidance_price) {
		this.yc_market_guidance_price = yc_market_guidance_price;
	}

	public BigDecimal getYc_actual_market_price() {
		return yc_actual_market_price;
	}

	public void setYc_actual_market_price(BigDecimal yc_actual_market_price) {
		this.yc_actual_market_price = yc_actual_market_price;
	}

	public Integer getYc_proportion_commission() {
		return yc_proportion_commission;
	}

	public void setYc_proportion_commission(Integer yc_proportion_commission) {
		this.yc_proportion_commission = yc_proportion_commission;
	}

	public BigDecimal getYc_offer() {
		return yc_offer;
	}

	public void setYc_offer(BigDecimal yc_offer) {
		this.yc_offer = yc_offer;
	}

	public YcAdvertisingSpaceArea(String id, String yc_advertising_id, String yc_advertising_district, BigDecimal yc_reserve_price,
			BigDecimal yc_market_guidance_price, BigDecimal yc_actual_market_price, Integer yc_proportion_commission,
			BigDecimal yc_offer) {
		super();
		this.id = id;
		this.yc_advertising_id = yc_advertising_id;
		this.yc_advertising_district = yc_advertising_district;
		this.yc_reserve_price = yc_reserve_price;
		this.yc_market_guidance_price = yc_market_guidance_price;
		this.yc_actual_market_price = yc_actual_market_price;
		this.yc_proportion_commission = yc_proportion_commission;
		this.yc_offer = yc_offer;
	}

	public YcAdvertisingSpaceArea() {
		super();
	}

	@Override
	public String toString() {
		return "YcAdvertisingSpaceArea [id=" + id + ", yc_advertising_id=" + yc_advertising_id
				+ ", yc_advertising_district=" + yc_advertising_district + ", yc_reserve_price=" + yc_reserve_price
				+ ", yc_market_guidance_price=" + yc_market_guidance_price + ", yc_actual_market_price="
				+ yc_actual_market_price + ", yc_proportion_commission=" + yc_proportion_commission + ", yc_offer="
				+ yc_offer + "]";
	}

	
	
}
