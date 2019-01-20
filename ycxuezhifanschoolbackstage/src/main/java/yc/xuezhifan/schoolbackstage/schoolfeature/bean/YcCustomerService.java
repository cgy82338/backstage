package yc.xuezhifan.schoolbackstage.schoolfeature.bean;

import javax.validation.constraints.NotNull;

/**
 * 

* <p>Title: YcCustomerService.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月2日  

* @version 1.0
 */
public class YcCustomerService {
	
	private String id;//主键
	
	@NotNull
	private String yc_customer_service_phone;//联系客服电话
	
	@NotNull
	private String yc_customer_service_address;//详细地址
	
	@NotNull
	private String yc_customer_service_number;//聊天ID

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

	public String getYc_customer_service_phone() {
		return yc_customer_service_phone;
	}

	public void setYc_customer_service_phone(String yc_customer_service_phone) {
		this.yc_customer_service_phone = yc_customer_service_phone;
	}

	public String getYc_customer_service_address() {
		return yc_customer_service_address;
	}

	public void setYc_customer_service_address(String yc_customer_service_address) {
		this.yc_customer_service_address = yc_customer_service_address;
	}

	public String getYc_customer_service_number() {
		return yc_customer_service_number;
	}

	public void setYc_customer_service_number(String yc_customer_service_number) {
		this.yc_customer_service_number = yc_customer_service_number;
	}

	
}
