package yc.xuezhifan.schoolbackstage.schoolcircle.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

/**
 * 

* <p>Title: YcCircleDynamicLike.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月7日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年9月7日  

* @version 1.0
 */

public class YcCircleDynamicLike {

	private String id;//主键，标识
	
	@NotNull(message="动态唯一标识不能为空")
	private String yc_circle_dynamic_id;//动态唯一标识
	
	private String yc_like_id;//点赞人唯一标识
	
	@CreatedDate
	private Date yc_like_time;//点赞时间
	
	private YcUser ycUser;//点赞人

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_circle_dynamic_id() {
		return yc_circle_dynamic_id;
	}

	public void setYc_circle_dynamic_id(String yc_circle_dynamic_id) {
		this.yc_circle_dynamic_id = yc_circle_dynamic_id;
	}

	public String getYc_like_id() {
		return yc_like_id;
	}

	public void setYc_like_id(String yc_like_id) {
		this.yc_like_id = yc_like_id;
	}

	public Date getYc_like_time() {
		return yc_like_time;
	}

	public void setYc_like_time(Date yc_like_time) {
		this.yc_like_time = yc_like_time;
	}

	public YcUser getYcUser() {
		return ycUser;
	}

	public void setYcUser(YcUser ycUser) {
		this.ycUser = ycUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ycUser == null) ? 0 : ycUser.hashCode());
		result = prime * result + ((yc_circle_dynamic_id == null) ? 0 : yc_circle_dynamic_id.hashCode());
		result = prime * result + ((yc_like_id == null) ? 0 : yc_like_id.hashCode());
		result = prime * result + ((yc_like_time == null) ? 0 : yc_like_time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YcCircleDynamicLike other = (YcCircleDynamicLike) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ycUser == null) {
			if (other.ycUser != null)
				return false;
		} else if (!ycUser.equals(other.ycUser))
			return false;
		if (yc_circle_dynamic_id == null) {
			if (other.yc_circle_dynamic_id != null)
				return false;
		} else if (!yc_circle_dynamic_id.equals(other.yc_circle_dynamic_id))
			return false;
		if (yc_like_id == null) {
			if (other.yc_like_id != null)
				return false;
		} else if (!yc_like_id.equals(other.yc_like_id))
			return false;
		if (yc_like_time == null) {
			if (other.yc_like_time != null)
				return false;
		} else if (!yc_like_time.equals(other.yc_like_time))
			return false;
		return true;
	}

	
	
}
