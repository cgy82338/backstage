package yc.xuezhifan.schoolbackstage.schoolfeedback.mapper;

import org.apache.ibatis.annotations.Mapper;
import yc.xuezhifan.schoolbackstage.schoolfeedback.bean.YcSchoolFeedback;

@Mapper
public interface YcSchoolFeedbackMapper {

    /**
     * 添加反馈信息
     */
    Integer insertFeedback(YcSchoolFeedback feedback);


}
