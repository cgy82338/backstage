package yc.xuezhifan.schoolbackstage.schoolfeature.bean;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/**
 * 

* <p>Title: 学校功能 </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月1日</p>
 
* @email xiaobai@xuezhifan.com

* @author xiaobai

* @date 2018年10月1日  

* @version 1.0
 */
public class YcSchoolFeature {
	
	private String id;//主键
	
	@NotNull(message="功能名称不能为空")
	private String yc_school_feature_name;//功能名称
	
	@NotNull(message="功能价格不能为空")
	private BigDecimal yc_school_feature_price;//功能价格
	
	@NotNull(message="提成比例不能为空")
	private Integer yc_school_feature_commission;//提成比例
	
	@NotNull(message="功能图标不能为空")
	private String yc_school_feature_icon;//功能图标
	
	@NotNull(message="功能描述不能为空")
	private String yc_school_feature_description;//功能描述
	
	@NotNull(message="功能链接不能为空")
	private String yc_school_feature_link;//功能链接

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

	public String getYc_school_feature_name() {
		return yc_school_feature_name;
	}

	public void setYc_school_feature_name(String yc_school_feature_name) {
		this.yc_school_feature_name = yc_school_feature_name;
	}

	public BigDecimal getYc_school_feature_price() {
		return yc_school_feature_price;
	}

	public void setYc_school_feature_price(BigDecimal yc_school_feature_price) {
		this.yc_school_feature_price = yc_school_feature_price;
	}

	public Integer getYc_school_feature_commission() {
		return yc_school_feature_commission;
	}

	public void setYc_school_feature_commission(Integer yc_school_feature_commission) {
		this.yc_school_feature_commission = yc_school_feature_commission;
	}

	public String getYc_school_feature_icon() {
		return yc_school_feature_icon;
	}

	public void setYc_school_feature_icon(String yc_school_feature_icon) {
		this.yc_school_feature_icon = yc_school_feature_icon;
	}

	public String getYc_school_feature_description() {
		return yc_school_feature_description;
	}

	public void setYc_school_feature_description(String yc_school_feature_description) {
		this.yc_school_feature_description = yc_school_feature_description;
	}

	public String getYc_school_feature_link() {
		return yc_school_feature_link;
	}

	public void setYc_school_feature_link(String yc_school_feature_link) {
		this.yc_school_feature_link = yc_school_feature_link;
	}

	public YcSchoolFeature(String id, String yc_school_feature_name, BigDecimal yc_school_feature_price,
			Integer yc_school_feature_commission, String yc_school_feature_icon, String yc_school_feature_description,
			String yc_school_feature_link) {
		super();
		this.id = id;
		this.yc_school_feature_name = yc_school_feature_name;
		this.yc_school_feature_price = yc_school_feature_price;
		this.yc_school_feature_commission = yc_school_feature_commission;
		this.yc_school_feature_icon = yc_school_feature_icon;
		this.yc_school_feature_description = yc_school_feature_description;
		this.yc_school_feature_link = yc_school_feature_link;
	}

	public YcSchoolFeature() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
}
