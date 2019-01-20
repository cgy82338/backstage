package yc.xuezhifan.schoolbackstage.smsmoible.mapper;

import org.apache.ibatis.annotations.Mapper;

import yc.xuezhifan.schoolbackstage.smsmoible.bean.YcVerificationCode;



@Mapper
public interface YcVerificationMapper {

	Integer saveVerification(YcVerificationCode ycVerificationCode);

	YcVerificationCode getVerification(YcVerificationCode ycVerificationCode);


	void modify(YcVerificationCode ycVerificationCode);

	void delete(String id);

}
