package yc.xuezhifan.schoolbackstage.fileshared.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;


/**
 * 

* <p>Title: YcFileShared.java </p> 

* <p>Description: 文件共享表</p> 

* <p>Copyright: Copyright (c) 2018年10月19日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月19日  

* @version 1.0
 */
public class YcFileShared {
	
	private String yc_file_shared_id;//主键
	
	@NotNull(message="名称不能为空")
	private String yc_file_shared_name;//名称
	
	private Date yc_file_shared_time;//共享时间
	
	private String yc_file_shared_type;//	文件类型
	
	private String yc_file_shared_size;//	文件大小
	
	private String yc_user_id;//共享人（yc_user_id）

	private String yc_file_shared_url;//文件保存地址

	private String yc_file_shared_class;//文件共享班级

	private String yc_file_shared_school;//文件共享学校

	private Integer yc_publisher_type;//发布人类型（1用户 2学校 ）
	
	/**
	 * 封装
	 * @return
	 */
	public String getYc_file_shared_id() {
		return yc_file_shared_id;
	}

	public void setYc_file_shared_id(String yc_file_shared_id) {
		this.yc_file_shared_id = yc_file_shared_id;
	}

	public String getYc_file_shared_name() {
		return yc_file_shared_name;
	}

	public void setYc_file_shared_name(String yc_file_shared_name) {
		this.yc_file_shared_name = yc_file_shared_name;
	}

	public Date getYc_file_shared_time() {
		return yc_file_shared_time;
	}

	public void setYc_file_shared_time(Date yc_file_shared_time) {
		this.yc_file_shared_time = yc_file_shared_time;
	}

	public String getYc_file_shared_type() {
		return yc_file_shared_type;
	}

	public void setYc_file_shared_type(String yc_file_shared_type) {
		this.yc_file_shared_type = yc_file_shared_type;
	}

	public String getYc_file_shared_size() {
		return yc_file_shared_size;
	}

	public void setYc_file_shared_size(String yc_file_shared_size) {
		this.yc_file_shared_size = yc_file_shared_size;
	}

	public String getYc_user_id() {
		return yc_user_id;
	}

	public void setYc_user_id(String yc_user_id) {
		this.yc_user_id = yc_user_id;
	}

	public String getYc_file_shared_url() {
		return yc_file_shared_url;
	}

	public void setYc_file_shared_url(String yc_file_shared_url) {
		this.yc_file_shared_url = yc_file_shared_url;
	}

	public String getYc_file_shared_class() {
		return yc_file_shared_class;
	}

	public void setYc_file_shared_class(String yc_file_shared_class) {
		this.yc_file_shared_class = yc_file_shared_class;
	}

	public String getYc_file_shared_school() {
		return yc_file_shared_school;
	}

	public void setYc_file_shared_school(String yc_file_shared_school) {
		this.yc_file_shared_school = yc_file_shared_school;
	}

	public Integer getYc_publisher_type() {
		return yc_publisher_type;
	}

	public void setYc_publisher_type(Integer yc_publisher_type) {
		this.yc_publisher_type = yc_publisher_type;
	}

	@Override
	public String toString() {
		return "YcFileShared [yc_file_shared_id=" + yc_file_shared_id + ", yc_file_shared_name=" + yc_file_shared_name
				+ ", yc_file_shared_time=" + yc_file_shared_time + ", yc_file_shared_type=" + yc_file_shared_type
				+ ", yc_file_shared_size=" + yc_file_shared_size + ", yc_user_id=" + yc_user_id
				+ ", yc_file_shared_url=" + yc_file_shared_url + ", yc_file_shared_class=" + yc_file_shared_class
				+ ", yc_file_shared_school=" + yc_file_shared_school + ", yc_publisher_type=" + yc_publisher_type + "]";
	}
	
	
	
	
	
}
