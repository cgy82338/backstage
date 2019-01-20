package yc.xuezhifan.schoolbackstage.smsmoible.util;

import java.util.Random;

/**
 * @author zhaochuanjing
 * @data 2018年8月18日 上午11:50:21
 * 
 */
public class CodeUtil {

	/**
	 * 生成随机码值，包含数字、大小写字母
	 * @return
	 */
	public static String getRandomCode(){
		String codeNum = "";
		int [] code = new int[3];
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			int num = random.nextInt(10) + 48;
			int uppercase = random.nextInt(26) + 65;
			int lowercase = random.nextInt(26) + 97;
			code[0] = num;
			code[1] = uppercase;
			code[2] = lowercase;
			codeNum+=(char)code[random.nextInt(3)];
		}
//		System.out.println(codeNum);
 
		return codeNum;
	}
	
	public static String createData(int length) {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(rand.nextInt(10));
		}
		return sb.toString();
	}

}
