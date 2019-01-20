package yc.xuezhifan.schoolbackstage.smsmoible.service;

import yc.xuezhifan.schoolbackstage.smsmoible.bean.YcVerificationLog;

public interface YcVerificationLogService {
	
	/**
	 * 
	
	 * <p>Title: getYcVerificationLog</p>  
	
	 * <p>Description:获取验证码日志记录 </p>  
	
	 * @param ycVerificationLog
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年10月30日
	 */
	YcVerificationLog getYcVerificationLog(YcVerificationLog ycVerificationLog);
	/**
	 * 
	
	 * <p>Title: saveYcVerificationLog</p>  
	
	 * <p>Description:保存验证码日志记录 </p>  
	
	 * @param ycVerificationLog
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年10月30日
	 */
	int saveYcVerificationLog(YcVerificationLog ycVerificationLog);
	/**
	 * 
	
	 * <p>Title: modifyYcVerificationLog</p>  
	
	 * <p>Description:修改验证码日志记录 </p>  
	
	 * @param ycVerificationLog
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年10月30日
	 */
	int modifyYcVerificationLog(YcVerificationLog ycVerificationLog);
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
