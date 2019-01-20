package yc.xuezhifan.schoolbackstage.smsmoible.service;

import yc.xuezhifan.schoolbackstage.smsmoible.bean.YcVerificationCode;

public interface YcVerificationService {
	
	/**
	 * 
	
	 * <p>Title: saveVerification</p>  
	
	 * <p>Description: 保存验证码</p>  
	
	 * @param ycVerificationCode
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年10月30日
	 */
	Integer saveVerification(YcVerificationCode ycVerificationCode);
	
	/**
	 * 
	
	 * <p>Title: getVerification</p>  
	
	 * <p>Description:根据条件查询验证码信息 </p>  
	
	 * @param ycVerificationCode
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年10月30日
	 */
	YcVerificationCode getVerification(YcVerificationCode ycVerificationCode);
	
	/**
	 * 
	
	 * <p>Title: modify</p>  
	
	 * <p>Description:修改 短信发送记录 </p>  
	
	 * @param ycVerificationCode 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月10日
	 */
	void modify(YcVerificationCode ycVerificationCode);
	
	/**
	 * 
	
	 * <p>Title: delete</p>  
	
	 * <p>Description:共测试使用 </p>  
	
	 * @param id 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月21日
	 */
	void delete(String id);

}
