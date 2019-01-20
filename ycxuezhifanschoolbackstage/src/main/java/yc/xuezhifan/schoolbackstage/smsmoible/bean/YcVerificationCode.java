package yc.xuezhifan.schoolbackstage.smsmoible.bean;

import java.util.Date;

/**
 * 

* <p>Title: YcVerificationCode.java </p> 

* <p>Description:验证码表 </p> 

* <p>Copyright: Copyright (c) 2018年10月30日</p>
 
* @email xiaoke@xuezhifan.com

* @author xiaoke 

* @date 2018年10月30日  

* @version 1.0
 */
public class YcVerificationCode {
	private String id;// 验证码 唯一 标识
	private String yc_mobile;// 手机号
	private String yc_code_use;// 验证码用途
	private Date yc_create_time;// 验证码变化时间
	private String yc_code;
	
	public String getYc_code() {
		return yc_code;
	}
	public void setYc_code(String yc_code) {
		this.yc_code = yc_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYc_mobile() {
		return yc_mobile;
	}
	public void setYc_mobile(String yc_mobile) {
		this.yc_mobile = yc_mobile;
	}
	public String getYc_code_use() {
		return yc_code_use;
	}
	public void setYc_code_use(String yc_code_use) {
		this.yc_code_use = yc_code_use;
	}
	public Date getYc_create_time() {
		return yc_create_time;
	}
	public void setYc_create_time(Date yc_create_time) {
		this.yc_create_time = yc_create_time;
	}
	
	
	
}