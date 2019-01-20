package yc.xuezhifan.schoolbackstage.school.bean;

import java.util.Date;

/**
 * 	学校登录日志
 */
public class YcSchoolLoginLog {
    private String id;
    private String yc_school_id;
    private Date yc_school_login_time;
    private String yc_school_log_ip;

    public String getId() {
        return id;
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

    public Date getYc_school_login_time() {
        return yc_school_login_time;
    }

    public void setYc_school_login_time(Date yc_school_login_time) {
        this.yc_school_login_time = yc_school_login_time;
    }

    public String getYc_school_log_ip() {
        return yc_school_log_ip;
    }

    public void setYc_school_log_ip(String yc_school_log_ip) {
        this.yc_school_log_ip = yc_school_log_ip;
    }
}
