package yc.xuezhifan.schoolbackstage.smsmoible.mapper;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.smsmoible.bean.YcVerificationLog;

@Mapper
public interface YcVerificationLogMapper {

	YcVerificationLog getYcVerificationLog(YcVerificationLog ycVerificationLog);

	int saveYcVerificationLog(YcVerificationLog ycVerificationLog);

	int modifyYcVerificationLog(YcVerificationLog ycVerificationLog);

	void delete(String id);

}
