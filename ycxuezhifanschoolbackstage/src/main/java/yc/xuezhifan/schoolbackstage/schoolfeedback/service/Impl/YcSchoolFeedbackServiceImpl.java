package yc.xuezhifan.schoolbackstage.schoolfeedback.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolfeedback.bean.YcSchoolFeedback;
import yc.xuezhifan.schoolbackstage.schoolfeedback.mapper.YcSchoolFeedbackMapper;
import yc.xuezhifan.schoolbackstage.schoolfeedback.service.YcSchoolFeedbackService;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

import java.util.Date;

/**
 *

 * <p>Title: YcSchoolFeedbackServiceImpl.java </p>

 * <p>Description: 反馈Service实现</p>

 * <p>Copyright: Copyright (c) 2018年12月29日</p>

 * @email xiaoyu@xuezhifan.com

 * @author xiaoyu

 * @date 2018年12月29日

 * @version 1.0
 */
@Service
public class YcSchoolFeedbackServiceImpl implements YcSchoolFeedbackService {

    @Autowired
    YcSchoolFeedbackMapper ycSchoolFeedbackMapper;

    /**
     * 添加反馈
     */
    @Override
    public JacksonData insertFeedback(YcSchool ycSchool,YcSchoolFeedback ycSchoolFeedback) {
        try {
            ycSchoolFeedback.setId(UUIDFactory.random());
            ycSchoolFeedback.setYc_school_id(ycSchool.getId());
            ycSchoolFeedback.setYc_feedback_time(new Date());
            ycSchoolFeedbackMapper.insertFeedback(ycSchoolFeedback);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(204, "失败");
        }

    }
}
