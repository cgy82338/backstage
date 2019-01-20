package yc.xuezhifan.schoolbackstage.activesponsor.bean;

/**
 * 
 * <p>
 * Title: YcUserVo.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年11月2日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年11月2日
 * 
 * @version 1.0
 * 
 */
public class YcUserVo {

	private String yc_admin_id;// 主键，标识

	private String yc_xzf_id;// 学知人账号

	private String yc_name;// 真实姓名

	private String yc_avatar;// 头像

	public String getYc_admin_id() {
		return yc_admin_id;
	}

	public void setYc_admin_id(String yc_admin_id) {
		this.yc_admin_id = yc_admin_id;
	}

	public String getYc_xzf_id() {
		return yc_xzf_id;
	}

	public void setYc_xzf_id(String yc_xzf_id) {
		this.yc_xzf_id = yc_xzf_id;
	}

	public String getYc_name() {
		return yc_name;
	}

	public void setYc_name(String yc_name) {
		this.yc_name = yc_name;
	}

	public String getYc_avatar() {
		return yc_avatar;
	}

	public void setYc_avatar(String yc_avatar) {
		this.yc_avatar = yc_avatar;
	}

}
