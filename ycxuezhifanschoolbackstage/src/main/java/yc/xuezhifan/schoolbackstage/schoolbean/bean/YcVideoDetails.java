package yc.xuezhifan.schoolbackstage.schoolbean.bean;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/** 
 * 视频明细表
* @author hanchangqing 
* @version 创建时间：2018年8月4日 下午3:27:32 
*/
public class YcVideoDetails {
	
	@NotNull(message="主键不能为空")
     private String yc_order_detail_id;//主键，标识
     
	 private String yc_user_id;//用户id
	
	 private String yc_school_id;//学校id
	
	 private String yc_agent_id;//分公司id
	
	@NotNull(message="支付金额不能为空")
	 private BigDecimal yc_payment_amount;//支付金额

	@NotNull(message="视频id不能为空")
	 private String yc_video_id;//视频id
	
	private String yc_adv_id;//广告订单
	
	public String getYc_adv_id() {
		return yc_adv_id;
	}

	public void setYc_adv_id(String yc_adv_id) {
		this.yc_adv_id = yc_adv_id;
	}

	@NotNull(message="订单备注不能为空")
	 private String yc_order_detail_remarks;//订单备注

	
	/**
	 * 封装
	 * @return
	 */
	public String getYc_order_detail_id() {
		return yc_order_detail_id;
	}

	public void setYc_order_detail_id(String yc_order_detail_id) {
		this.yc_order_detail_id = yc_order_detail_id;
	}

	public String getYc_user_id() {
		return yc_user_id;
	}

	public void setYc_user_id(String yc_user_id) {
		this.yc_user_id = yc_user_id;
	}

	public String getYc_school_id() {
		return yc_school_id;
	}

	public void setYc_school_id(String yc_school_id) {
		this.yc_school_id = yc_school_id;
	}

	public String getYc_agent_id() {
		return yc_agent_id;
	}

	public void setYc_agent_id(String yc_agent_id) {
		this.yc_agent_id = yc_agent_id;
	}

	public BigDecimal getYc_payment_amount() {
		return yc_payment_amount;
	}

	public void setYc_payment_amount(BigDecimal yc_payment_amount) {
		this.yc_payment_amount = yc_payment_amount;
	}

	public String getYc_video_id() {
		return yc_video_id;
	}

	public void setYc_video_id(String yc_video_id) {
		this.yc_video_id = yc_video_id;
	}

	public String getYc_order_detail_remarks() {
		return yc_order_detail_remarks;
	}

	public void setYc_order_detail_remarks(String yc_order_detail_remarks) {
		this.yc_order_detail_remarks = yc_order_detail_remarks;
	}

	public YcVideoDetails(String yc_order_detail_id, String yc_user_id, String yc_school_id, String yc_agent_id,
			BigDecimal yc_payment_amount, String yc_video_id, String yc_order_detail_remarks) {
		super();
		this.yc_order_detail_id = yc_order_detail_id;
		this.yc_user_id = yc_user_id;
		this.yc_school_id = yc_school_id;
		this.yc_agent_id = yc_agent_id;
		this.yc_payment_amount = yc_payment_amount;
		this.yc_video_id = yc_video_id;
		this.yc_order_detail_remarks = yc_order_detail_remarks;
	}

	public YcVideoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "YcVideoDetails [yc_order_detail_id=" + yc_order_detail_id + ", yc_user_id=" + yc_user_id
				+ ", yc_school_id=" + yc_school_id + ", yc_agent_id=" + yc_agent_id + ", yc_payment_amount="
				+ yc_payment_amount + ", yc_video_id=" + yc_video_id + ", yc_order_detail_remarks="
				+ yc_order_detail_remarks + "]";
	}

	public YcVideoDetails(String yc_user_id, String yc_video_id) {
		super();
		this.yc_user_id = yc_user_id;
		this.yc_video_id = yc_video_id;
	}
	
	
	
}
