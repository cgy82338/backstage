package yc.xuezhifan.schoolbackstage.schoolbean.bean;

import java.util.Date;


/**
 * 

* <p>Title: YcSchoolBeanRecord.java </p> 

* <p>Description: 学校资金变化记录</p> 

* <p>Copyright: Copyright (c) 2018年12月21日</p>
 
* @email xiaoke@xuezhifan.com

* @author xiaoke 

* @date 2018年12月21日  

* @version 1.0
 */
public class YcSchoolBeanRecord {
	
	private String yc_record_id;//智慧豆记录表唯一标识 32位
	
	private char change_type;//改变类型 +:增加 -：减少
	
	private Double change_value;//改变值
	
	private Integer transaction_type;//1：充值 2：提现 3：视频消费 4:提成 5：广告消费 6：推广功能  7：活动消费 8:在线缴费9：打赏
	
	private String yc_school_id;//学校id
	
	private String yc_order_id;//订单id
	
	private Double yc_lave_money;//剩余智慧豆
	
	private Date yc_create_time;//时间默认为当前时间
	
	private YcOrder ycOrder;

	public YcOrder getYcOrder() {
		return ycOrder;
	}

	public void setYcOrder(YcOrder ycOrder) {
		this.ycOrder = ycOrder;
	}

	public String getYc_record_id() {
		return yc_record_id;
	}

	public void setYc_record_id(String yc_record_id) {
		this.yc_record_id = yc_record_id;
	}

	public char getChange_type() {
		return change_type;
	}

	public void setChange_type(char change_type) {
		this.change_type = change_type;
	}

	public Double getChange_value() {
		return change_value;
	}

	public void setChange_value(Double change_value) {
		this.change_value = change_value;
	}

	public Integer getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(Integer transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getYc_school_id() {
		return yc_school_id;
	}

	public void setYc_school_id(String yc_school_id) {
		this.yc_school_id = yc_school_id;
	}

	public String getYc_order_id() {
		return yc_order_id;
	}

	public void setYc_order_id(String yc_order_id) {
		this.yc_order_id = yc_order_id;
	}

	public Double getYc_lave_money() {
		return yc_lave_money;
	}

	public void setYc_lave_money(Double yc_lave_money) {
		this.yc_lave_money = yc_lave_money;
	}

	public Date getYc_create_time() {
		return yc_create_time;
	}

	public void setYc_create_time(Date yc_create_time) {
		this.yc_create_time = yc_create_time;
	}
	
	
	
}
