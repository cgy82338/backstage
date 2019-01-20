package yc.xuezhifan.schoolbackstage.smsmoible.service;

import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcOrder;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

/**
 * @author zhaochuanjing
 * @data 2018年8月18日 上午11:17:30
 * 
 */
public interface ISMSService {

	/**
	 *  发送短信验证码
	 * @param phone 手机号
	 * @param code 验证码
	 */
	 boolean send(String phone, String code);
	 /**
	  * 
	 
	  * <p>Title: passwordSend</p>  
	 
	  * <p>Description:发送初始密码 </p>  
	 
	  * @param phone
	  * @param code
	  * @return 
	 
	  * @email xiaoke@xuezhifan.com
	 
	  * @author xiaoke
	 
	  * @date 2018年10月30日
	  */
	 boolean passwordSend(String phone, String code);
	 /**
	  * 
	 
	  * <p>Title: checkCode</p>  
	 
	  * <p>Description:校验注册验证码 </p>  
	 
	  * @param phone
	  * @param code
	  * @return 
	 
	  * @email xiaoke@xuezhifan.com
	 
	  * @author xiaoke
	 
	  * @date 2018年11月1日
	  */
	 boolean checkCode(String phone, String code);
	/**
	 * 
	
	 * <p>Title: modifyPasswordsend</p>  
	
	 * <p>Description:发送修改密码验证码 </p>  
	
	 * @param phone
	 * @param code
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月1日
	 */
	boolean modifyPasswordsend(String phone, String code);
	
	/**
	 * 
	
	 * <p>Title: checkPasswordCode</p>  
	
	 * <p>Description:验证修改密码验证码 </p>  
	
	 * @param phone
	 * @param code
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月1日
	 */
	boolean checkPasswordCode(String phone, String code);
	
	/**
	 * 
	
	 * <p>Title: sendTreasurer</p>  
	
	 * <p>Description:财务有问题时发生短信给财务负责人 </p>  
	
	 * @param phone
	 * @param ycOrder
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月16日
	 */
	boolean sendTreasurer(String phone, YcOrder ycOrder);
	/**
	 * 
	
	 * <p>Title: delete</p>  
	
	 * <p>Description:供测试删除短信发送记录 </p>  
	
	 * @param phone
	 * @param string 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月21日
	 */
	void delete(String phone, String string);
	/**
	 * 
	
	 * <p>Title: bindingAlipay</p>  
	
	 * <p>Description:绑定支付宝验证码 </p>  
	
	 * @param phone 手机号
	 * @param code 验证码
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月28日
	 */
	boolean bindingAlipay(String phone, String code);
	/**
	 * 
	
	 * <p>Title: checkedBindAlipay</p>  
	
	 * <p>Description:验证支付宝绑定验证码 </p>  
	
	 * @param phone
	 * @param code
	 * @return 
	
	 * @email xiaoke@xuezhifan.com
	
	 * @author xiaoke
	
	 * @date 2018年11月28日
	 */
	boolean checkedBindAlipay(String phone, String code);

	/**
	 *

	 * <p>Title: shareSend</p>

	 * <p>Description:发送分享信息</p>

	 * @param user
	 * @param childname
	 * @return

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke

	 * @date 2018年10月30日
	 */
	boolean shareSend(YcUser user,String childname);

	/**
	 *

	 * <p>Title: checkShareCode</p>

	 * <p>Description:验证分享信息</p>

	 * @param phone
	 * @param code
	 * @return

	 * @email xiaoke@xuezhifan.com

	 * @author xiaoke

	 * @date 2018年10月30日
	 */
//	boolean checkShareCode(String phone, String code);
}
