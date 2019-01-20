package yc.xuezhifan.schoolbackstage.share.bean;


import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

/**
* @author linxiao
* @version 创建时间：2018年8月8日 下午3:14:53
* 孩子家长关系表
*/
public class YcChildParent {
	
	private String id;//主键
	
	private String yc_child_id;//孩子唯一标识
	
	private Integer yc_status;//是否第一创建人(1是2否)
	
	private String yc_parent_id;//家长唯一标识（存储用户表id）
	
	private Integer yc_relationship;//与孩子关系（默认为母亲）

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYc_child_id() {
		return yc_child_id;
	}

	public void setYc_child_id(String yc_child_id) {
		this.yc_child_id = yc_child_id;
	}

	public Integer getYc_status() {
		return yc_status;
	}

	public void setYc_status(Integer yc_status) {
		this.yc_status = yc_status;
	}

	public String getYc_parent_id() {
		return yc_parent_id;
	}

	public void setYc_parent_id(String yc_parent_id) {
		this.yc_parent_id = yc_parent_id;
	}

	public Integer getYc_relationship() {
		return yc_relationship;
	}

	public void setYc_relationship(Integer yc_relationship) {
		this.yc_relationship = yc_relationship;
	}
}
