package yc.xuezhifan.schoolbackstage.schoolcircle.bean;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

/**
 * 

* <p>Title: YcDynamicComment.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年9月7日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年9月7日  

* @version 1.0
 */
public class YcDynamicComment {

	private String id;//主键，标识
	
	@NotNull(message="圈动态唯一标识不能为空")
	private String yc_circle_dynamic_id;//圈动态唯一标识
	
	private String yc_commentator_id;//评论人唯一标识
	
	@NotNull(message="评论内容不能为空")
	private String yc_circle_dynamic_content;//评论内容
	
	private YcUser ycUser;
	
	@CreatedDate
	private Date yc_comment_time;//评论时间

	private List<YcDynamicCommentReply> ycDynamicCommentReply;//评论回复信息
	

	public List<YcDynamicCommentReply> getYcDynamicCommentReply() {
		return ycDynamicCommentReply;
	}


	public void setYcDynamicCommentReply(List<YcDynamicCommentReply> ycDynamicCommentReply) {
		this.ycDynamicCommentReply = ycDynamicCommentReply;
	}


	public YcUser getYcUser() {
		return ycUser;
	}


	public void setYcUser(YcUser ycUser) {
		this.ycUser = ycUser;
	}


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


	public String getYc_commentator_id() {
		return yc_commentator_id;
	}


	public void setYc_commentator_id(String yc_commentator_id) {
		this.yc_commentator_id = yc_commentator_id;
	}


	public String getYc_circle_dynamic_content() {
		return yc_circle_dynamic_content;
	}


	public void setYc_circle_dynamic_content(String yc_circle_dynamic_content) {
		this.yc_circle_dynamic_content = yc_circle_dynamic_content;
	}


	public Date getYc_comment_time() {
		return yc_comment_time;
	}


	public void setYc_comment_time(Date yc_comment_time) {
		this.yc_comment_time = yc_comment_time;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ycDynamicCommentReply == null) ? 0 : ycDynamicCommentReply.hashCode());
		result = prime * result + ((ycUser == null) ? 0 : ycUser.hashCode());
		result = prime * result + ((yc_circle_dynamic_content == null) ? 0 : yc_circle_dynamic_content.hashCode());
		result = prime * result + ((yc_circle_dynamic_id == null) ? 0 : yc_circle_dynamic_id.hashCode());
		result = prime * result + ((yc_comment_time == null) ? 0 : yc_comment_time.hashCode());
		result = prime * result + ((yc_commentator_id == null) ? 0 : yc_commentator_id.hashCode());
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
		YcDynamicComment other = (YcDynamicComment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ycDynamicCommentReply == null) {
			if (other.ycDynamicCommentReply != null)
				return false;
		} else if (!ycDynamicCommentReply.equals(other.ycDynamicCommentReply))
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
		if (yc_circle_dynamic_id == null) {
			if (other.yc_circle_dynamic_id != null)
				return false;
		} else if (!yc_circle_dynamic_id.equals(other.yc_circle_dynamic_id))
			return false;
		if (yc_comment_time == null) {
			if (other.yc_comment_time != null)
				return false;
		} else if (!yc_comment_time.equals(other.yc_comment_time))
			return false;
		if (yc_commentator_id == null) {
			if (other.yc_commentator_id != null)
				return false;
		} else if (!yc_commentator_id.equals(other.yc_commentator_id))
			return false;
		return true;
	}

	
}
