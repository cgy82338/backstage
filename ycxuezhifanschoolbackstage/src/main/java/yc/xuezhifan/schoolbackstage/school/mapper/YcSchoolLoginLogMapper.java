package yc.xuezhifan.schoolbackstage.school.mapper;

import org.apache.ibatis.annotations.Mapper;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchoolLoginLog;

@Mapper
public interface YcSchoolLoginLogMapper {

    /**
     *

     * <p>Title: insertSchoolLoginLog</p>

     * <p>Description: 添加学校登录日志</p>

     * @param ycSchoolLoginLog
     * @return

     * @email xiaoyu@xuezhifan.com

     * @author xiaoyu

     * @date 2018年12月28日
     */

    Integer insertSchoolLoginLog(YcSchoolLoginLog ycSchoolLoginLog);


}
