package yc.xuezhifan.schoolbackstage.protocol.bean;

import java.util.Date;
/**
 * <p>
 * Title: YcProtocol.java
 * </p>
 *
 * <p>
 * Description: 用户协议
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2019年1月11日
 * </p>
 *
 * @email xiaoyu@xuezhifan.com
 *
 * @author xiaoyu
 *
 * @date 2019年1月11日
 *
 * @version 1.0
 */
public class YcProtocol {
    private String id;
    private String yc_protocol_name;
    private Date yc_protocol_time;
    private Integer yc_delete;
    private String yc_protocol_content;
    private Integer yc_type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYc_protocol_name() {
        return yc_protocol_name;
    }

    public void setYc_protocol_name(String yc_protocol_name) {
        this.yc_protocol_name = yc_protocol_name;
    }

    public Date getYc_protocol_time() {
        return yc_protocol_time;
    }

    public void setYc_protocol_time(Date yc_protocol_time) {
        this.yc_protocol_time = yc_protocol_time;
    }

    public Integer getYc_delete() {
        return yc_delete;
    }

    public void setYc_delete(Integer yc_delete) {
        this.yc_delete = yc_delete;
    }

    public String getYc_protocol_content() {
        return yc_protocol_content;
    }

    public void setYc_protocol_content(String yc_protocol_content) {
        this.yc_protocol_content = yc_protocol_content;
    }

    public Integer getYc_type() {
        return yc_type;
    }

    public void setYc_type(Integer yc_type) {
        this.yc_type = yc_type;
    }
}
