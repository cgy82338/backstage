package yc.xuezhifan.schoolbackstage.schoolfeedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolfeedback.bean.YcSchoolFeedback;
import yc.xuezhifan.schoolbackstage.schoolfeedback.service.YcSchoolFeedbackService;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

import java.util.Date;

/**
 *

 * <p>Title: YcSchoolFeedbackController.java </p>

 * <p>Description: 反馈controller</p>

 * <p>Copyright: Copyright (c) 2018年12月29日</p>

 * @email xiaoyu@xuezhifan.com

 * @author xiaoyu

 * @date 2018年12月29日

 * @version 1.0
 */

@Controller
@RequestMapping("/feedback")
public class YcSchoolFeedbackController {

    @Autowired
    YcSchoolFeedbackService ycSchoolFeedbackService;


    @RequestMapping("/insertfeedback")
    @ResponseBody
    @SchoolLogin
    public JacksonData insertFeedback(@CurrentSchool YcSchool ycSchool,YcSchoolFeedback ycSchoolFeedback){
        return ycSchoolFeedbackService.insertFeedback(ycSchool,ycSchoolFeedback);
    }

}
