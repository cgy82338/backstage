package yc.xuezhifan.schoolbackstage.teacher.vo;

import yc.xuezhifan.schoolbackstage.teacher.bean.YcSubjectManagement;
import yc.xuezhifan.schoolbackstage.teacher.bean.YcTeacherManagement;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

import java.util.List;

/**
 * <p>Title: TeacherManagementVo.java </p>
 *
 * <p>Description: 修改教师数据</p>
 *
 * <p>Copyright: Copyright (c) 2018年12月19日</p>
 *
 * @author xiaoyu
 * @version 1.0
 * @email xiaoyu@xuezhifan.com
 * @date 2018年12月19日
 */
public class TeacherManagementVo {
    private YcUser user;//用户信息
    private YcTeacherManagement teacher;//教师信息
    private YcSubjectManagement subject;//科目信息
    private List<YcSubjectManagement> subjects;//所有科目信息

    public YcUser getUser() {
        return user;
    }

    public void setUser(YcUser user) {
        this.user = user;
    }

    public YcTeacherManagement getTeacher() {
        return teacher;
    }

    public void setTeacher(YcTeacherManagement teacher) {
        this.teacher = teacher;
    }

    public YcSubjectManagement getSubject() {
        return subject;
    }

    public void setSubject(YcSubjectManagement subject) {
        this.subject = subject;
    }

    public List<YcSubjectManagement> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<YcSubjectManagement> subjects) {
        this.subjects = subjects;
    }
}
