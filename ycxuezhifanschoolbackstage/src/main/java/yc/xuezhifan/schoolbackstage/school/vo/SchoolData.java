package yc.xuezhifan.schoolbackstage.school.vo;

/**
 * 账号资料修改信息
 */
public class SchoolData {
    private String avatar;//学校头像
    private String schoolname;//学校名称
    private String phone;//登录人手机号
    private String yc_province ;//省
    private String yc_city;//市
    private String yc_district;//区
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
