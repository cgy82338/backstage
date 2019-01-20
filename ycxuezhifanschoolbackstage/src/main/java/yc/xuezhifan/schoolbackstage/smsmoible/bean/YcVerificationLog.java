package yc.xuezhifan.schoolbackstage.smsmoible.bean;
/**
 * 

* <p>Title: YcVerificationLog.java </p> 

* <p>Description: 验证码日志表</p> 

* <p>Copyright: Copyright (c) 2018年10月30日</p>
 
* @email xiaoke@xuezhifan.com

* @author xiaoke 

* @date 2018年10月30日  

* @version 1.0
 */
public class YcVerificationLog {
	private String id;//验证码日志唯一标识
	private String yc_code_id;//验证码表 唯一标识id
	private String Yc_code;// 验证码
	private Integer  Yc_use_count;// 验证次数
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYc_code_id() {
		return yc_code_id;
	}
	public void setYc_code_id(String yc_code_id) {
		this.yc_code_id = yc_code_id;
	}
	public String getYc_code() {
		return Yc_code;
	}
	public void setYc_code(String yc_code) {
		Yc_code = yc_code;
	}
	public Integer getYc_use_count() {
		return Yc_use_count;
	}
	public void setYc_use_count(Integer yc_use_count) {
		Yc_use_count = yc_use_count;
	}
	
	
}
