package yc.xuezhifan.schoolbackstage.schoolbean.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;


/** 
* @author hanchangqing 
* @version 创建时间：2018年8月4日 下午3:38:01 
* 订单表
*/
public class YcOrder {
	
	@NotNull(message="主键不能为空")
	private String yc_order_id;//主键，标识
	
	@NotNull(message="订单类型不能为空")
	private Integer yc_order_type;//订单类型（1：同步视频，2：精品视频，3:兴趣新品，4：语音听播，5:广告位，6：推广功能，7：活动 8：缴费，9：打赏）
	
	@NotNull(message="交易类型不能为空")
	private Integer yc_order_transaction_type;//交易类型（1:充值 2:消费）
	
	@NotNull(message="付方式不能为空")
	private Integer yc_order_payment_method;//支付方式(1：智慧豆，2:微信，3：支付宝)
	
	@NotNull(message="用户类型不能为空")
	private Integer yc_order_user_type;//用户类型（1:家长，2：教师 ，3：学校，4：代理商，5：培训）
	
	@NotNull(message="支付金额不能为空")
	private BigDecimal yc_payment_amount;//支付金额
	
	@NotNull(message="订单明细表id不能为空")
	private String yc_order_detail_id;//订单明细表id
	
	private String yc_user_id;//用户id
	
	private String yc_school_id;//学校id
	
	private String yc_agent_id;//分公司id
	
	@NotNull(message="创建时间不能为空")
	private Date yc_create_time;//创建时间
	
	private Date yc_complete_time;//完成时间
	
	@NotNull(message="订单状态不能为空")
	private Integer yc_order_status;//订单状态（1：已创建，2：已支付，3：已取消，4:已完成）
	
	private YcVideoDetails ycVideoDetails;
	
	
	

	public YcVideoDetails getYcVideoDetails() {
		return ycVideoDetails;
	}

	public void setYcVideoDetails(YcVideoDetails ycVideoDetails) {
		this.ycVideoDetails = ycVideoDetails;
	}

	/**
	 * 封装
	 * @return
	 */
	public String getYc_order_id() {
		return yc_order_id;
	}

	public void setYc_order_id(String yc_order_id) {
		this.yc_order_id = yc_order_id;
	}

	public Integer getYc_order_type() {
		return yc_order_type;
	}

	public void setYc_order_type(Integer yc_order_type) {
		this.yc_order_type = yc_order_type;
	}

	public Integer getYc_order_transaction_type() {
		return yc_order_transaction_type;
	}

	public void setYc_order_transaction_type(Integer yc_order_transaction_type) {
		this.yc_order_transaction_type = yc_order_transaction_type;
	}

	public Integer getYc_order_payment_method() {
		return yc_order_payment_method;
	}

	public void setYc_order_payment_method(Integer yc_order_payment_method) {
		this.yc_order_payment_method = yc_order_payment_method;
	}

	public Integer getYc_order_user_type() {
		return yc_order_user_type;
	}

	public void setYc_order_user_type(Integer yc_order_user_type) {
		this.yc_order_user_type = yc_order_user_type;
	}

	public BigDecimal getYc_payment_amount() {
		return yc_payment_amount;
	}

	public void setYc_payment_amount(BigDecimal yc_payment_amount) {
		this.yc_payment_amount = yc_payment_amount;
	}

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

	public Date getYc_create_time() {
		return yc_create_time;
	}

	public void setYc_create_time(Date yc_create_time) {
		this.yc_create_time = yc_create_time;
	}

	public Date getYc_complete_time() {
		return yc_complete_time;
	}

	public void setYc_complete_time(Date yc_complete_time) {
		this.yc_complete_time = yc_complete_time;
	}

	public Integer getYc_order_status() {
		return yc_order_status;
	}

	public void setYc_order_status(Integer yc_order_status) {
		this.yc_order_status = yc_order_status;
	}

	public YcOrder(String yc_order_id, Integer yc_order_type, Integer yc_order_transaction_type,
			Integer yc_order_payment_method, Integer yc_order_user_type, BigDecimal yc_payment_amount,
			String yc_order_detail_id, String yc_user_id, String yc_school_id, String yc_agent_id, Date yc_create_time,
			Date yc_complete_time, Integer yc_order_status) {
		super();
		this.yc_order_id = yc_order_id;
		this.yc_order_type = yc_order_type;
		this.yc_order_transaction_type = yc_order_transaction_type;
		this.yc_order_payment_method = yc_order_payment_method;
		this.yc_order_user_type = yc_order_user_type;
		this.yc_payment_amount = yc_payment_amount;
		this.yc_order_detail_id = yc_order_detail_id;
		this.yc_user_id = yc_user_id;
		this.yc_school_id = yc_school_id;
		this.yc_agent_id = yc_agent_id;
		this.yc_create_time = yc_create_time;
		this.yc_complete_time = yc_complete_time;
		this.yc_order_status = yc_order_status;
	}

	public YcOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
