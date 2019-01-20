package yc.xuezhifan.schoolbackstage.schoolfeedback.bean;

import java.util.Date;

/**
 *

 * <p>Title: YcSchoolFeedback.java </p>

 * <p>Description: 反馈表</p>

 * <p>Copyright: Copyright (c) 2018年12月29日</p>

 * @email xiaoyu@xuezhifan.com

 * @author xiaoyu

 * @date 2018年12月29日

 * @version 1.0
 */
public class YcSchoolFeedback {
    private String id;//主键
    private String yc_school_id;//反馈学校（唯一标识）
    private Date yc_feedback_time;//反馈时间
    private String yc_processing_id;//处理人（后台管理员）
    private Date yc_processing_time;//处理时间
    private String yc_feedback_detail;//反馈详情
    private String yc_detail_result;//处理结果
    private Integer yc_feedback_status;//状态（1为未处理，2为已处理）
    private String yc_feedback_phone;//联系方式

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

    public Date getYc_feedback_time() {
        return yc_feedback_time;
    }

    public void setYc_feedback_time(Date yc_feedback_time) {
        this.yc_feedback_time = yc_feedback_time;
    }

    public String getYc_processing_id() {
        return yc_processing_id;
    }

    public void setYc_processing_id(String yc_processing_id) {
        this.yc_processing_id = yc_processing_id;
    }

    public Date getYc_processing_time() {
        return yc_processing_time;
    }

    public void setYc_processing_time(Date yc_processing_time) {
        this.yc_processing_time = yc_processing_time;
    }

    public String getYc_feedback_detail() {
        return yc_feedback_detail;
    }

    public void setYc_feedback_detail(String yc_feedback_detail) {
        this.yc_feedback_detail = yc_feedback_detail;
    }

    public String getYc_detail_result() {
        return yc_detail_result;
    }

    public void setYc_detail_result(String yc_detail_result) {
        this.yc_detail_result = yc_detail_result;
    }

    public Integer getYc_feedback_status() {
        return yc_feedback_status;
    }

    public void setYc_feedback_status(Integer yc_feedback_status) {
        this.yc_feedback_status = yc_feedback_status;
    }

    public String getYc_feedback_phone() {
        return yc_feedback_phone;
    }

    public void setYc_feedback_phone(String yc_feedback_phone) {
        this.yc_feedback_phone = yc_feedback_phone;
    }
}
