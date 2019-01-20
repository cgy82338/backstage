package yc.xuezhifan.schoolbackstage.school.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;

/**
 * 

* <p>Title: YcSchool.java </p> 

* <p>Description: 学校</p> 

* <p>Copyright: Copyright (c) 2018年10月28日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月28日  

* @version 1.0
 */
public class YcSchool {
	
	private String id;//主键
	
	private String yc_school_id;//小帆号
	
	@NotNull(message="学校名称不能为空")
	private String yc_school_name;//学校名称
	
	@NotNull(message="学校类型不能为空")
	private Integer yc_school_type;//学校类型（1为教育学校，2为培训机构）
	
	@NotNull(message="省不能为空")
	private String yc_province;//省
	
	@NotNull(message="市不能为空")
	private String yc_city;//市
	
	@NotNull(message="区/县不能为空")
	private String yc_district;//区/县
	
	@NotNull(message="详细地址不能为空")
	private String yc_school_address;//详细地址
	
	@NotNull(message="地图地址不能为空")
	private String yc_school_map_address;//地图地址
	
	@NotNull(message="明文密码不能为空")
	private String yc_school_password;//明文密码
	
	private String yc_school_pw_encryption;//加密密码
	
	@NotNull(message="法人手机号不能为空")
	private String yc_school_corporation_phone;//法人手机号
	
	private String yc_school_avatar;//头像（头像为空时，为系统默认头像）
	
	@Value("1")
	private Integer yc_school_status;//状态（1为可用，2为不可用，默认为1）
	
	@CreatedDate
	private Date yc_school_login_time;//注册时间（默认当前系统时间）
	
	private String yc_school_founder;//创建人（默认当前登录人，存储创建人的唯一标识）
	
	@Value("1")
	private Integer yc_school_teaching_stage;//教学阶段（1为学前教育，2为小学，3为初中，4为高中，默认为1）
	
	@NotNull(message="学校负责人不能为空")
	private String yc_school_principal;//学校负责人
	
	@NotNull(message="负责人电话不能为空")
	private String yc_school_principal_phone;//负责人电话(做为密保手机号,用于找回密码)
	
	@NotNull(message="学校法人不能为空")
	private String yc_school_corporation;//学校法人
	
	@NotNull(message="上传学校营业执照不能为空")
	private String yc_school_business_license;//上传学校营业执照
	
	@NotNull(message="上传法人身份证照片不能为空")
	private String yc_school_corporate_photo;//上传法人身份证照片
	
	@NotNull(message="合同编码不能为空")
	private String yc_school_contract_code;//合同编码
	
	@CreatedDate
	private Date yc_school_contract_start;//合同开始时间
	
	@CreatedDate
	private Date yc_school_contract_end;//合同结束时间
	
	private Integer yc_is_public;// 公立or私立

	private String yc_school_end_photo;//身份证

	private String yc_contract;//合同

	/**
	 * 封装
	 * @return
	 */
	
	public String getId() {
		return id;
	}

	public Integer getYc_is_public() {
		return yc_is_public;
	}

	public void setYc_is_public(Integer yc_is_public) {
		this.yc_is_public = yc_is_public;
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

	public String getYc_school_name() {
		return yc_school_name;
	}

	public void setYc_school_name(String yc_school_name) {
		this.yc_school_name = yc_school_name;
	}

	public Integer getYc_school_type() {
		return yc_school_type;
	}

	public void setYc_school_type(Integer yc_school_type) {
		this.yc_school_type = yc_school_type;
	}

	public String getYc_province() {
		return yc_province;
	}

	public void setYc_province(String yc_province) {
		this.yc_province = yc_province;
	}

	public String getYc_city() {
		return yc_city;
	}

	public void setYc_city(String yc_city) {
		this.yc_city = yc_city;
	}

	public String getYc_district() {
		return yc_district;
	}

	public void setYc_district(String yc_district) {
		this.yc_district = yc_district;
	}

	public String getYc_school_address() {
		return yc_school_address;
	}

	public void setYc_school_address(String yc_school_address) {
		this.yc_school_address = yc_school_address;
	}

	public String getYc_school_map_address() {
		return yc_school_map_address;
	}

	public void setYc_school_map_address(String yc_school_map_address) {
		this.yc_school_map_address = yc_school_map_address;
	}

	public String getYc_school_password() {
		return yc_school_password;
	}

	public void setYc_school_password(String yc_school_password) {
		this.yc_school_password = yc_school_password;
	}

	public String getYc_school_pw_encryption() {
		return yc_school_pw_encryption;
	}

	public void setYc_school_pw_encryption(String yc_school_pw_encryption) {
		this.yc_school_pw_encryption = yc_school_pw_encryption;
	}

	public String getYc_school_corporation_phone() {
		return yc_school_corporation_phone;
	}

	public void setYc_school_corporation_phone(String yc_school_corporation_phone) {
		this.yc_school_corporation_phone = yc_school_corporation_phone;
	}

	public String getYc_school_avatar() {
		return yc_school_avatar;
	}

	public void setYc_school_avatar(String yc_school_avatar) {
		this.yc_school_avatar = yc_school_avatar;
	}

	public Integer getYc_school_status() {
		return yc_school_status;
	}

	public void setYc_school_status(Integer yc_school_status) {
		this.yc_school_status = yc_school_status;
	}

	public Date getYc_school_login_time() {
		return yc_school_login_time;
	}

	public void setYc_school_login_time(Date yc_school_login_time) {
		this.yc_school_login_time = yc_school_login_time;
	}

	public String getYc_school_founder() {
		return yc_school_founder;
	}

	public void setYc_school_founder(String yc_school_founder) {
		this.yc_school_founder = yc_school_founder;
	}

	public Integer getYc_school_teaching_stage() {
		return yc_school_teaching_stage;
	}

	public void setYc_school_teaching_stage(Integer yc_school_teaching_stage) {
		this.yc_school_teaching_stage = yc_school_teaching_stage;
	}

	public String getYc_school_principal() {
		return yc_school_principal;
	}

	public void setYc_school_principal(String yc_school_principal) {
		this.yc_school_principal = yc_school_principal;
	}

	public String getYc_school_principal_phone() {
		return yc_school_principal_phone;
	}

	public void setYc_school_principal_phone(String yc_school_principal_phone) {
		this.yc_school_principal_phone = yc_school_principal_phone;
	}

	public String getYc_school_corporation() {
		return yc_school_corporation;
	}

	public void setYc_school_corporation(String yc_school_corporation) {
		this.yc_school_corporation = yc_school_corporation;
	}

	public String getYc_school_business_license() {
		return yc_school_business_license;
	}

	public void setYc_school_business_license(String yc_school_business_license) {
		this.yc_school_business_license = yc_school_business_license;
	}

	public String getYc_school_corporate_photo() {
		return yc_school_corporate_photo;
	}

	public void setYc_school_corporate_photo(String yc_school_corporate_photo) {
		this.yc_school_corporate_photo = yc_school_corporate_photo;
	}

	public String getYc_school_contract_code() {
		return yc_school_contract_code;
	}

	public void setYc_school_contract_code(String yc_school_contract_code) {
		this.yc_school_contract_code = yc_school_contract_code;
	}

	public Date getYc_school_contract_start() {
		return yc_school_contract_start;
	}

	public void setYc_school_contract_start(Date yc_school_contract_start) {
		this.yc_school_contract_start = yc_school_contract_start;
	}

	public Date getYc_school_contract_end() {
		return yc_school_contract_end;
	}

	public void setYc_school_contract_end(Date yc_school_contract_end) {
		this.yc_school_contract_end = yc_school_contract_end;
	}

	public String getYc_school_end_photo() {
		return yc_school_end_photo;
	}

	public void setYc_school_end_photo(String yc_school_end_photo) {
		this.yc_school_end_photo = yc_school_end_photo;
	}

	public String getYc_contract() {
		return yc_contract;
	}

	public void setYc_contract(String yc_contract) {
		this.yc_contract = yc_contract;
	}
}
