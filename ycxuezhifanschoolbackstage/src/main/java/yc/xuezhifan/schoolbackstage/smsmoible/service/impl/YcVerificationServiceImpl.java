package yc.xuezhifan.schoolbackstage.smsmoible.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yc.xuezhifan.schoolbackstage.smsmoible.bean.YcVerificationCode;
import yc.xuezhifan.schoolbackstage.smsmoible.mapper.YcVerificationMapper;
import yc.xuezhifan.schoolbackstage.smsmoible.service.YcVerificationService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;



@Service
public class YcVerificationServiceImpl implements YcVerificationService {

	@Autowired
	private YcVerificationMapper ycVerificationMapper;
	/**
	 * 
	
	 * <p>Title: saveVerification</p>  
	
	 * <p>Description:保存验证码 </p>  
	
	 * @param ycVerificationCode
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年10月30日
	 */
	@Override
	public Integer saveVerification(YcVerificationCode ycVerificationCode) {
		ycVerificationCode.setId(UUIDFactory.random());//设置唯一标识
		ycVerificationCode.setYc_create_time(new Date());
		return ycVerificationMapper.saveVerification(ycVerificationCode);
	}
	@Override
	public YcVerificationCode getVerification(YcVerificationCode ycVerificationCode) {
		YcVerificationCode verificationCode = ycVerificationMapper.getVerification(ycVerificationCode);
		if (RegexUtil.isNull(verificationCode)) {
			return null;
		}
		return verificationCode;
	}
	@Override
	public void modify(YcVerificationCode ycVerificationCode) {
		ycVerificationCode.setYc_create_time(new Date());
		 ycVerificationMapper.modify(ycVerificationCode);
		
	}
	@Override
	public void delete(String id) {
		ycVerificationMapper.delete(id);
	}

}