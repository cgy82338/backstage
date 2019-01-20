package yc.xuezhifan.schoolbackstage.active.vo;

import java.math.BigDecimal;

/**
 * 校园活动展示类
 */
public class YcActivityVo {
    private String id;//活动id
    private String activity_title;//活动名称
    private String activity_cover_image;//封面图片
    private Integer activity_people_number;//名额
    private String activity_sponsor;//发起人
    private String sponsor_type;//发起人类型
    private Integer activity_people_number_yes;//已报名人数
    private BigDecimal activity_single_fee;//活动费用


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivity_title() {
        return activity_title;
    }

    public void setActivity_title(String activity_title) {
        this.activity_title = activity_title;
    }

    public String getActivity_cover_image() {
        return activity_cover_image;
    }

    public void setActivity_cover_image(String activity_cover_image) {
        this.activity_cover_image = activity_cover_image;
    }

    public Integer getActivity_people_number() {
        return activity_people_number;
    }

    public void setActivity_people_number(Integer activity_people_number) {
        this.activity_people_number = activity_people_number;
    }

    public String getActivity_sponsor() {
        return activity_sponsor;
    }

    public void setActivity_sponsor(String activity_sponsor) {
        this.activity_sponsor = activity_sponsor;
    }

    public String getSponsor_type() {
        return sponsor_type;
    }

    public void setSponsor_type(String sponsor_type) {
        this.sponsor_type = sponsor_type;
    }

    public Integer getActivity_people_number_yes() {
        return activity_people_number_yes;
    }

    public void setActivity_people_number_yes(Integer activity_people_number_yes) {
        this.activity_people_number_yes = activity_people_number_yes;
    }

    public BigDecimal getActivity_single_fee() {
        return activity_single_fee;
    }

    public void setActivity_single_fee(BigDecimal activity_single_fee) {
        this.activity_single_fee = activity_single_fee;
    }
}
