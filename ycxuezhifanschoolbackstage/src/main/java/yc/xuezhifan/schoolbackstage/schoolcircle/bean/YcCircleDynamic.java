package yc.xuezhifan.schoolbackstage.schoolcircle.bean;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

/**
 * 

* <p>Title: YcCircleDynamic.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月7日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年9月7日  

* @version 1.0
 */
public class YcCircleDynamic {

	private String id;//主键，标识
	
	private String yc_school_id;//学校唯一标识
	
	private String yc_class_id;//班级唯一标识
	
	private String yc_user_id;//用户唯一标识
	
	private String yc_dynamic_video;//视频地址
	
	private String yc_dynamic_image;//图片地址
	
	@NotNull(message="动态类型不能为空")
	private Integer yc_circle_dynamic_type;//动态类型（1为校园圈，2为班级圈, 3为全部）
	
	@NotNull(message="动态内容不能为空")
	private String yc_circle_dynamic_content;//动态内容
	
	@CreatedDate
	private Date yc_release_time;//发布时间

	private YcUser ycUser;//发布人信息
	
	private List<YcCircleDynamicLike> ycCircleDynamicLikes;//点赞
	
	private List<YcDynamicComment> ycDynamicComments;//评论
	
	private Integer yc_circle_dynamic_status;//动态状态(1为展示,2为不展示,默认为1)
	
	/**
	 * 封装
	 * @return
	 */
	
	public String getId() {
		return id;
	}

	public String getYc_dynamic_video() {
		return yc_dynamic_video;
	}

	public void setYc_dynamic_video(String yc_dynamic_video) {
		this.yc_dynamic_video = yc_dynamic_video;
	}

	public String getYc_dynamic_image() {
		return yc_dynamic_image;
	}

	public void setYc_dynamic_image(String yc_dynamic_image) {
		this.yc_dynamic_image = yc_dynamic_image;
	}

	public Integer getYc_circle_dynamic_status() {
		return yc_circle_dynamic_status;
	}

	public void setYc_circle_dynamic_status(Integer yc_circle_dynamic_status) {
		this.yc_circle_dynamic_status = yc_circle_dynamic_status;
	}

	public List<YcCircleDynamicLike> getYcCircleDynamicLikes() {
		return ycCircleDynamicLikes;
	}

	public void setYcCircleDynamicLikes(List<YcCircleDynamicLike> ycCircleDynamicLikes) {
		this.ycCircleDynamicLikes = ycCircleDynamicLikes;
	}

	public List<YcDynamicComment> getYcDynamicComments() {
		return ycDynamicComments;
	}

	public void setYcDynamicComments(List<YcDynamicComment> ycDynamicComments) {
		this.ycDynamicComments = ycDynamicComments;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_school_id() {
		return yc_school_id;
	}

	public void setYc_school_id(String yc_school_id) {
		this.yc_school_id = yc_school_id;
	}

	public String getYc_class_id() {
		return yc_class_id;
	}

	public void setYc_class_id(String yc_class_id) {
		this.yc_class_id = yc_class_id;
	}

	public String getYc_user_id() {
		return yc_user_id;
	}

	public void setYc_user_id(String yc_user_id) {
		this.yc_user_id = yc_user_id;
	}

	public Integer getYc_circle_dynamic_type() {
		return yc_circle_dynamic_type;
	}

	public void setYc_circle_dynamic_type(Integer yc_circle_dynamic_type) {
		this.yc_circle_dynamic_type = yc_circle_dynamic_type;
	}

	public String getYc_circle_dynamic_content() {
		return yc_circle_dynamic_content;
	}

	public void setYc_circle_dynamic_content(String yc_circle_dynamic_content) {
		this.yc_circle_dynamic_content = yc_circle_dynamic_content;
	}

	public Date getYc_release_time() {
		return yc_release_time;
	}

	public void setYc_release_time(Date yc_release_time) {
		this.yc_release_time = yc_release_time;
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
		result = prime * result + ((yc_circle_dynamic_content == null) ? 0 : yc_circle_dynamic_content.hashCode());
		result = prime * result + ((yc_circle_dynamic_type == null) ? 0 : yc_circle_dynamic_type.hashCode());
		result = prime * result + ((yc_class_id == null) ? 0 : yc_class_id.hashCode());
		result = prime * result + ((yc_release_time == null) ? 0 : yc_release_time.hashCode());
		result = prime * result + ((yc_school_id == null) ? 0 : yc_school_id.hashCode());
		result = prime * result + ((yc_user_id == null) ? 0 : yc_user_id.hashCode());
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
		YcCircleDynamic other = (YcCircleDynamic) obj;
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
		if (yc_circle_dynamic_content == null) {
			if (other.yc_circle_dynamic_content != null)
				return false;
		} else if (!yc_circle_dynamic_content.equals(other.yc_circle_dynamic_content))
			return false;
		if (yc_circle_dynamic_type == null) {
			if (other.yc_circle_dynamic_type != null)
				return false;
		} else if (!yc_circle_dynamic_type.equals(other.yc_circle_dynamic_type))
			return false;
		if (yc_class_id == null) {
			if (other.yc_class_id != null)
				return false;
		} else if (!yc_class_id.equals(other.yc_class_id))
			return false;
		if (yc_release_time == null) {
			if (other.yc_release_time != null)
				return false;
		} else if (!yc_release_time.equals(other.yc_release_time))
			return false;
		if (yc_school_id == null) {
			if (other.yc_school_id != null)
				return false;
		} else if (!yc_school_id.equals(other.yc_school_id))
			return false;
		if (yc_user_id == null) {
			if (other.yc_user_id != null)
				return false;
		} else if (!yc_user_id.equals(other.yc_user_id))
			return false;
		return true;
	}
	
	
}
