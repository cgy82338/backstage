package yc.xuezhifan.schoolbackstage.teacher.bean;

import javax.validation.constraints.NotNull;
/**
 *

 * <p>Title: YcSubjectManagement.java </p>

 * <p>Description: 科目管理表</p>

 * <p>Copyright: Copyright (c) 2018年12月27日</p>

 * @email xiaoyu@xuezhifan.com

 * @author xiaoyu

 * @date 2018年12月27日

 * @version 1.0
 */
public class YcSubjectManagement {
    @NotNull(message="主键不能为空")
    private String id;
    @NotNull(message="科目编号不能为空")
    private Integer yc_subject_number;
    @NotNull(message="科目名称不能为空")
    private String yc_subject_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYc_subject_number() {
        return yc_subject_number;
    }

    public void setYc_subject_number(Integer yc_subject_number) {
        this.yc_subject_number = yc_subject_number;
    }

    public String getYc_subject_name() {
        return yc_subject_name;
    }

    public void setYc_subject_name(String yc_subject_name) {
        this.yc_subject_name = yc_subject_name;
    }
}
