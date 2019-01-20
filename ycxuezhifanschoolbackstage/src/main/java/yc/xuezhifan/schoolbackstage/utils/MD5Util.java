package yc.xuezhifan.schoolbackstage.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
* @author zhaochuanjing
* @version 创建时间：2018年8月3日 下午5:16:34
* 
*/
public class MD5Util {
	
	//对明文字符串做MD5加密
	public static String md5(String str) {
		return DigestUtils.md5Hex(str);
	}
	
	//盐值
	private static final String salt = "lover1314";
	
	/*
	 * 两次MD5:第一次,把用户输入的密码做一次MD5向服务端传递
	 * 把用户输入的密码转化成form表单提交时候的密码
	 */
	public static String inputPassToFormPass(String inputPass) {
		//更改盐值
		String str = ""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
		//在做一次加盐
		return md5(str);
	}
	

	/*
	 * 第二次MD5加密: 把form里面的加密过的password 转化成 存入DB里的密码
	 */
	public static String formPassToDBPass(String formPass, String salt) {
		//更改盐值
		String str = ""+salt.charAt(0)+salt.charAt(2)+formPass+salt.charAt(4)+salt.charAt(3);
		//在做一次加盐
		return md5(str);
	}
	
	//把上面两个加密过程合在一起,新建一个随机的两次加密方法
	public static String inputPassToDBPass(String inputPass, String saltDB) {
		String formPass = inputPassToFormPass(inputPass);
		String dbPass = formPassToDBPass(formPass, saltDB);
		return dbPass;
	}
}
