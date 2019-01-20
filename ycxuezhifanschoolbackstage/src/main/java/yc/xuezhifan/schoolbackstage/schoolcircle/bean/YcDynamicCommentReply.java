package yc.xuezhifan.schoolbackstage.schoolcircle.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

/**
 * 
 * 
 * <p>
 * Title: YcDynamicCommentReply.java
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年9月7日
 * </p>
 * 
 * @email xiaobai@xuezhifan.com
 * 
 * @author xiaobai
 * 
 * @date 2018年9月7日
 * 
 * @version 1.0
 */
public class YcDynamicCommentReply {

	private String id;// 主键，标识

	private String yc_reply_content;// 回复父类唯一标识

	@NotNull(message = "动态评论唯一标识不能为空")
	private String yc_dynamic_comment_id;// 动态评论唯一标识

	private String yc_respondent_id;// 回复人唯一标识

	@NotNull(message = "回复内容不能为空")
	private String yc_respondent_content;// 回复内容

	private Date yc_reply_time;// 回复时间

	private YcUser replyUser;// 回复人

	private String yc_user_id;// 被回复人唯一标示

	private YcUser ycUser;// 被回复人

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_reply_content() {
		return yc_reply_content;
	}

	public void setYc_reply_content(String yc_reply_content) {
		this.yc_reply_content = yc_reply_content;
	}

	public String getYc_dynamic_comment_id() {
		return yc_dynamic_comment_id;
	}

	public void setYc_dynamic_comment_id(String yc_dynamic_comment_id) {
		this.yc_dynamic_comment_id = yc_dynamic_comment_id;
	}

	public String getYc_respondent_id() {
		return yc_respondent_id;
	}

	public void setYc_respondent_id(String yc_respondent_id) {
		this.yc_respondent_id = yc_respondent_id;
	}

	public String getYc_respondent_content() {
		return yc_respondent_content;
	}

	public void setYc_respondent_content(String yc_respondent_content) {
		this.yc_respondent_content = yc_respondent_content;
	}

	public Date getYc_reply_time() {
		return yc_reply_time;
	}

	public void setYc_reply_time(Date yc_reply_time) {
		this.yc_reply_time = yc_reply_time;
	}

	public YcUser getReplyUser() {
		return replyUser;
	}

	public void setReplyUser(YcUser replyUser) {
		this.replyUser = replyUser;
	}

	public String getYc_user_id() {
		return yc_user_id;
	}

	public void setYc_user_id(String yc_user_id) {
		this.yc_user_id = yc_user_id;
	}

	public YcUser getYcUser() {
		return ycUser;
	}

	public void setYcUser(YcUser ycUser) {
		this.ycUser = ycUser;
	}

}
