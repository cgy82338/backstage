package yc.xuezhifan.schoolbackstage.schoolfeature.bean;

import javax.validation.constraints.NotNull;


/**
 * 

* <p>Title: YcCertification.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月2日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月2日  

* @version 1.0
 */
public class YcCertification {

	private String yc_certification_id;//主键
	
	@NotNull(message="实名认证不能为空")
	private String yc_certification_verified;//实名认证
	
	@NotNull(message="证书认证不能为空")
	private String yc_certification_certificate;//证书认证
	
	/**
	 * 封装
	 * @return
	 */
	public String getYc_certification_id() {
		return yc_certification_id;
	}

	public void setYc_certification_id(String yc_certification_id) {
		this.yc_certification_id = yc_certification_id;
	}

	public String getYc_certification_verified() {
		return yc_certification_verified;
	}

	public void setYc_certification_verified(String yc_certification_verified) {
		this.yc_certification_verified = yc_certification_verified;
	}

	public String getYc_certification_certificate() {
		return yc_certification_certificate;
	}

	public void setYc_certification_certificate(String yc_certification_certificate) {
		this.yc_certification_certificate = yc_certification_certificate;
	}

	public YcCertification(String yc_certification_id, String yc_certification_verified,
			String yc_certification_certificate) {
		super();
		this.yc_certification_id = yc_certification_id;
		this.yc_certification_verified = yc_certification_verified;
		this.yc_certification_certificate = yc_certification_certificate;
	}

	public YcCertification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
