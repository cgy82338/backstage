package yc.xuezhifan.schoolbackstage.schoolbean.bean;
/**
 * 

* <p>Title: YcAdvOrderDetail.java </p> 

* <p>Description: 广告订单明细表</p> 

* <p>Copyright: Copyright (c) 2018年11月5日</p>
 
* @email xiaoke@xuezhifan.com

* @author xiaoke 

* @date 2018年11月5日  

* @version 1.0
 */

import java.math.BigDecimal;
import java.util.Date;

public class YcAdvOrderDetail {
	
	private String yc_adv_order_id;
	private String yc_adv_id;
	private String yc_adv_space_id;
	private BigDecimal yc_order_amount;
	private String yc_order_id;
	private String yc_user_id;
	private Date yc_create_time;
	
	public String getYc_adv_order_id() {
		return yc_adv_order_id;
	}
	public void setYc_adv_order_id(String yc_adv_order_id) {
		this.yc_adv_order_id = yc_adv_order_id;
	}
	public String getYc_adv_id() {
		return yc_adv_id;
	}
	public void setYc_adv_id(String yc_adv_id) {
		this.yc_adv_id = yc_adv_id;
	}
	public String getYc_adv_space_id() {
		return yc_adv_space_id;
	}
	public void setYc_adv_space_id(String yc_adv_space_id) {
		this.yc_adv_space_id = yc_adv_space_id;
	}
	public BigDecimal getYc_order_amount() {
		return yc_order_amount;
	}
	public void setYc_order_amount(BigDecimal yc_order_amount) {
		this.yc_order_amount = yc_order_amount;
	}
	public String getYc_order_id() {
		return yc_order_id;
	}
	public void setYc_order_id(String yc_order_id) {
		this.yc_order_id = yc_order_id;
	}
	public String getYc_user_id() {
		return yc_user_id;
	}
	public void setYc_user_id(String yc_user_id) {
		this.yc_user_id = yc_user_id;
	}
	public Date getYc_create_time() {
		return yc_create_time;
	}
	public void setYc_create_time(Date yc_create_time) {
		this.yc_create_time = yc_create_time;
	}
	
	
	

}
