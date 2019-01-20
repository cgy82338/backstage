package yc.xuezhifan.schoolbackstage.schoolfeedback.service;

import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolfeedback.bean.YcSchoolFeedback;

/**
 *

 * <p>Title: YcSchoolFeedbackService.java </p>

 * <p>Description: 反馈Service</p>

 * <p>Copyright: Copyright (c) 2018年12月29日</p>

 * @email xiaoyu@xuezhifan.com

 * @author xiaoyu

 * @date 2018年12月29日

 * @version 1.0
 */
public interface YcSchoolFeedbackService {

    /**
     * 添加反馈
     */
    JacksonData insertFeedback(YcSchool ycSchool,YcSchoolFeedback ycSchoolFeedback);
}
