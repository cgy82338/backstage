package yc.xuezhifan.schoolbackstage.user.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
/**
 * 用户表
 * @author linxiao
 *
 */
@Component
public class YcUser {
	
	private String id;//主键

	private Integer yc_id;//小帆号
	
	private String yc_username;//用户名
	
	private String yc_nickname;//昵称（昵称为空时，默认用户名）
	
	private Integer yc_gender=2;//性别（1代表男，2代表女，默认为2）

	private String yc_province;//省
	
	private String yc_city;//市
	
	private String yc_district_name;//县区名称
	
	private String yc_district;//区/县 码

	private String yc_map_address;//地图地址
	
	private String yc_password;//明文密码
	
	private String yc_password_encryption;//加密密码
	
	@NotNull(message="手机号不能为空")
	private String yc_phone;//手机号

	@Value("1")
	private Integer yc_role;//角色（1代表家长，2代表教师3:校长）
	
	private String yc_avatar;//头像（头像为空时，为系统默认头像）
	
	private String yc_introduction;//个人简介
	
	private String yc_carte;//二维码名片
	
	@Value("1")
	private String yc_status="1";//状态（1为可用，2为不可用，默认为1）

	@CreatedDate
	private Date yc_login_time;//注册时间（默认当前系统时间）
	
	private String yc_founder;//创建人（默认当前登录人，存储创建人的唯一标识）
	
	private Integer yc_delete=1;//删除状态（1为展示，2为不展示，默认为1）
	
	private String yc_wechat_appid;//微信唯一标识
	
	private String yc_qq_unionid;//Qq唯一标识
	
	private String yc_alipay_appid;//支付宝唯一标识

	private String yc_token;//推送预留字段
	
	private String yc_rongcloudtoken;
	
	private String yc_idcard;//身份证号
	
	private String yc_video_name="1";//教师发布视频展示名（1为姓名2为昵称，默认为1）
	
	private String yc_allow_class="1";//判断是否允许通过班级添加好友 1：允许 2：不允许 默认为1
	
	private String yc_allow_qrcode="1";//判断是否允许通过二维码 添加 好友 1：y允许 2：不允许 默认为1
	
	private String yc_allow_address="1";//判断是否允许通过附近的人添加好友1：允许 2：不允许 默认为1
	
	private String yc_user_token;//学知帆token
	
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
	public String getYc_rongcloudtoken() {
		return yc_rongcloudtoken;
	}

	public void setYc_rongcloudtoken(String yc_rongcloudtoken) {
		this.yc_rongcloudtoken = yc_rongcloudtoken;
	}

	public String getYc_video_name() {
		return yc_video_name;
	}

	public void setYc_video_name(String yc_video_name) {
		this.yc_video_name = RegexUtil.isNull(yc_video_name) ? "1":yc_video_name;
	}

	public Integer getYc_id() {
		return yc_id;
	}

	public void setYc_id(Integer yc_id) {
		this.yc_id = yc_id;
	}

	public String getYc_username() {
		return yc_username;
	}

	public void setYc_username(String yc_username) {
		this.yc_username = yc_username;
	}

	public String getYc_nickname() {
		return yc_nickname;
	}

	public void setYc_nickname(String yc_nickname) {
		this.yc_nickname = yc_nickname;
	}

	public Integer getYc_gender() {
		return yc_gender;
	}

	public void setYc_gender(Integer yc_gender) {
		this.yc_gender = RegexUtil.isNull(yc_gender) ? 2:yc_gender;
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

	public String getYc_map_address() {
		return yc_map_address;
	}

	public void setYc_map_address(String yc_map_address) {
		this.yc_map_address = yc_map_address;
	}

	public String getYc_password() {
		return yc_password;
	}

	public void setYc_password(String yc_password) {
		this.yc_password = yc_password;
	}

	public String getYc_password_encryption() {
		return yc_password_encryption;
	}

	public void setYc_password_encryption(String yc_password_encryption) {
		this.yc_password_encryption = yc_password_encryption;
	}

	public String getYc_phone() {
		return yc_phone;
	}

	public void setYc_phone(String yc_phone) {
		this.yc_phone = yc_phone;
	}

	public Integer getYc_role() {
		return yc_role;
	}

	public void setYc_role(Integer yc_role) {
		this.yc_role = RegexUtil.isNull(yc_role) ? 1:yc_role;
	}

	public String getYc_avatar() {
		return yc_avatar;
	}

	public void setYc_avatar(String yc_avatar) {
		this.yc_avatar = yc_avatar;
	}

	public String getYc_introduction() {
		return yc_introduction;
	}

	public void setYc_introduction(String yc_introduction) {
		this.yc_introduction = yc_introduction;
	}

	public String getYc_carte() {
		return yc_carte;
	}

	public void setYc_carte(String yc_carte) {
		this.yc_carte = yc_carte;
	}

	public String getYc_status() {
		return yc_status;
	}

	public void setYc_status(String yc_status) {
		this.yc_status = RegexUtil.isNull(yc_status) ? "1":yc_status ;
	}

	public Date getYc_login_time() {
		return yc_login_time;
	}

	public void setYc_login_time(Date yc_login_time) {
		this.yc_login_time = yc_login_time;
	}

	public String getYc_founder() {
		return yc_founder;
	}

	public void setYc_founder(String yc_founder) {
		this.yc_founder = yc_founder;
	}

	public 	Integer getYc_delete() {
		return yc_delete;
	}

	public void setYc_delete(Integer yc_delete) {
		this.yc_delete = RegexUtil.isNull(yc_delete) ? 1:yc_delete ;
	}

	public String getYc_wechat_appid() {
		return yc_wechat_appid;
	}

	public void setYc_wechat_appid(String yc_wechat_appid) {
		this.yc_wechat_appid = yc_wechat_appid;
	}

	public String getYc_qq_unionid() {
		return yc_qq_unionid;
	}

	public void setYc_qq_unionid(String yc_qq_unionid) {
		this.yc_qq_unionid = yc_qq_unionid;
	}

	public String getYc_alipay_appid() {
		return yc_alipay_appid;
	}

	public void setYc_alipay_appid(String yc_alipay_appid) {
		this.yc_alipay_appid = yc_alipay_appid;
	}

	public String getYc_token() {
		return yc_token;
	}

	public void setYc_token(String yc_token) {
		this.yc_token = yc_token;
	}

	public String getYc_idcard() {
		return yc_idcard;
	}

	public void setYc_idcard(String yc_idcard) {
		this.yc_idcard = yc_idcard;
	}

	
	
	
	public String getYc_allow_class() {
		return yc_allow_class;
	}

	public void setYc_allow_class(String yc_allow_class) {
		this.yc_allow_class = RegexUtil.isNull(yc_allow_class) ? "1":yc_allow_class;
	}

	public String getYc_allow_qrcode() {
		return yc_allow_qrcode;
	}

	public void setYc_allow_qrcode(String yc_allow_qrcode) {
		this.yc_allow_qrcode = RegexUtil.isNull(yc_allow_qrcode) ? "1":yc_allow_qrcode;
	}

	public String getYc_allow_address() {
		return yc_allow_address;
	}

	public void setYc_allow_address(String yc_allow_address) {
		this.yc_allow_address = RegexUtil.isNull(yc_allow_address) ? "1":yc_allow_address;
	}

	
	
	public String getYc_user_token() {
		return yc_user_token;
	}

	public void setYc_user_token(String yc_user_token) {
		this.yc_user_token = yc_user_token;
	}

	public String getYc_district_name() {
		return yc_district_name;
	}

	public void setYc_district_name(String yc_district_name) {
		this.yc_district_name = yc_district_name;
	}

	@Override
	public String toString() {
		return "YcUser [id=" + id + ", yc_id=" + yc_id + ", yc_username=" + yc_username + ", yc_nickname=" + yc_nickname
				+ ", yc_gender=" + yc_gender + ", yc_province=" + yc_province + ", yc_city=" + yc_city
				+ ", yc_district=" + yc_district + ", yc_map_address=" + yc_map_address + ", yc_password=" + yc_password
				+ ", yc_password_encryption=" + yc_password_encryption + ", yc_phone=" + yc_phone + ", yc_role="
				+ yc_role + ", yc_avatar=" + yc_avatar + ", yc_introduction=" + yc_introduction + ", yc_carte="
				+ yc_carte + ", yc_status=" + yc_status + ", yc_login_time=" + yc_login_time + ", yc_founder="
				+ yc_founder + ", yc_delete=" + yc_delete + ", yc_wechat_appid=" + yc_wechat_appid + ", yc_qq_unionid="
				+ yc_qq_unionid + ", yc_alipay_appid=" + yc_alipay_appid + ", yc_token=" + yc_token + ", yc_idcard="
				+ yc_idcard + "]";
	}

	public YcUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YcUser(String id, Integer yc_id, String yc_username, String yc_nickname, Integer yc_gender,
			String yc_province, String yc_city, String yc_district, String yc_map_address, String yc_password,
			String yc_password_encryption, String yc_phone, Integer yc_role, String yc_avatar, String yc_introduction,
			String yc_carte, String yc_status, Date yc_login_time, String yc_founder, Integer yc_delete,
			String yc_wechat_appid, String yc_qq_unionid, String yc_alipay_appid, String yc_token, String yc_idcard) {
		super();
		this.id = id;
		this.yc_id = yc_id;
		this.yc_username = yc_username;
		this.yc_nickname = yc_nickname;
		this.yc_gender = yc_gender;
		this.yc_province = yc_province;
		this.yc_city = yc_city;
		this.yc_district = yc_district;
		this.yc_map_address = yc_map_address;
		this.yc_password = yc_password;
		this.yc_password_encryption = yc_password_encryption;
		this.yc_phone = yc_phone;
		this.yc_role = yc_role;
		this.yc_avatar = yc_avatar;
		this.yc_introduction = yc_introduction;
		this.yc_carte = yc_carte;
		this.yc_status = yc_status;
		this.yc_login_time = yc_login_time;
		this.yc_founder = yc_founder;
		this.yc_delete = yc_delete;
		this.yc_wechat_appid = yc_wechat_appid;
		this.yc_qq_unionid = yc_qq_unionid;
		this.yc_alipay_appid = yc_alipay_appid;
		this.yc_token = yc_token;
		this.yc_idcard = yc_idcard;
	}

	
	
	
}