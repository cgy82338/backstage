package yc.xuezhifan.schoolbackstage.ycClass.vo;

import yc.xuezhifan.schoolbackstage.ycClass.bean.YcClass;

/**
 * 班级信息加任课教师
 */
public class YcClassVo {

    private String yc_class_id;//班级id
    private String yc_class_name;//班级名称
    private String yc_class_head_teacher_id;//班主任id
    private String yc_teacherIds;//任课教师

    public String getYc_class_id() {
        return yc_class_id;
    }

    public void setYc_class_id(String yc_class_id) {
        this.yc_class_id = yc_class_id;
    }

    public String getYc_class_name() {
        return yc_class_name;
    }

    public void setYc_class_name(String yc_class_name) {
        this.yc_class_name = yc_class_name;
    }

    public String getYc_class_head_teacher_id() {
        return yc_class_head_teacher_id;
    }

    public void setYc_class_head_teacher_id(String yc_class_head_teacher_id) {
        this.yc_class_head_teacher_id = yc_class_head_teacher_id;
    }

    public String getYc_teacherIds() {
        return yc_teacherIds;
    }

    public void setYc_teacherIds(String yc_teacherIds) {
        this.yc_teacherIds = yc_teacherIds;
    }
}
