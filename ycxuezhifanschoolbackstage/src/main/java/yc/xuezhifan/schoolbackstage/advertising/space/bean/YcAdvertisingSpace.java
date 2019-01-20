package yc.xuezhifan.schoolbackstage.advertising.space.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;

/**
 * 

* <p>Title: 广告位 </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月12日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月12日  

* @version 1.0
 */
public class YcAdvertisingSpace {

	private String id;//主键，标识  
	
	@NotNull(message="广告位编号不能为空")
	private Integer yc_advertising_number;//广告位编号
	
	@NotNull(message="广告位名称不能为空")
	private String yc_advertising_name;//广告位名称 
	
	@NotNull(message="广告位高度不能为空")
	private Integer yc_advertising_height;//广告位高度	
	
	@NotNull(message="广告位宽度不能为空")
	private Integer yc_advertising_space;//广告位宽度 	
	
	@NotNull(message="广告位类型不能为空")
	private Integer yc_advertising_type;//广告位类型(1视频,2图文,3推送,4圈)	
	
	@Value("1")
	private Integer yc_advertising_count;//广告数量（默认为1，轮播可以更改）	
	
	private String yc_advertising_creator;//广告位创建人（默认当前登录管理员唯一标识）	
	
	@CreatedDate
	private Date yc_advertising_time;//广告位创建时间（默认当前系统时间） 	

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

	public Integer getYc_advertising_number() {
		return yc_advertising_number;
	}

	public void setYc_advertising_number(Integer yc_advertising_number) {
		this.yc_advertising_number = yc_advertising_number;
	}

	public String getYc_advertising_name() {
		return yc_advertising_name;
	}

	public void setYc_advertising_name(String yc_advertising_name) {
		this.yc_advertising_name = yc_advertising_name;
	}

	public Integer getYc_advertising_height() {
		return yc_advertising_height;
	}

	public void setYc_advertising_height(Integer yc_advertising_height) {
		this.yc_advertising_height = yc_advertising_height;
	}

	public Integer getYc_advertising_space() {
		return yc_advertising_space;
	}

	public void setYc_advertising_space(Integer yc_advertising_space) {
		this.yc_advertising_space = yc_advertising_space;
	}

	public Integer getYc_advertising_type() {
		return yc_advertising_type;
	}

	public void setYc_advertising_type(Integer yc_advertising_type) {
		this.yc_advertising_type = yc_advertising_type;
	}

	public Integer getYc_advertising_count() {
		return yc_advertising_count;
	}

	public void setYc_advertising_count(Integer yc_advertising_count) {
		this.yc_advertising_count = yc_advertising_count;
	}

	public String getYc_advertising_creator() {
		return yc_advertising_creator;
	}

	public void setYc_advertising_creator(String yc_advertising_creator) {
		this.yc_advertising_creator = yc_advertising_creator;
	}

	public Date getYc_advertising_time() {
		return yc_advertising_time;
	}

	public void setYc_advertising_time(Date yc_advertising_time) {
		this.yc_advertising_time = yc_advertising_time;
	}
	
}
