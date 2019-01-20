package yc.xuezhifan.schoolbackstage.utils;

import java.util.UUID;

/**
 * 唯一标识工具类
 * @author liuke
 * @date   2018年7月24日
 *
 */
public class UuidUtil {
	
	public static String[] chars = new String[] { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };
	/**
	 * 生成21位班级群id
	 * @param flag b："班级" j:"家长群"
	 * @return
	 */
	
	
	public static  String greater(char flag){	
		Long time=System.currentTimeMillis();
		String result=flag+String.valueOf(time)+getRandom();
                return result;
	}
	/**
	 * 生成20位 唯一标识 包含数字及大写字母；
	 * @return
	 */
	public static  String getUuid(){	
		Long time=System.currentTimeMillis();
		String result=String.valueOf(time)+getRandom();
                return result;
	}
	
	public static String getRandom() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
        String str = uuid.substring(i * 4, i * 4 + 4);
        int x = Integer.parseInt(str, 16);
        shortBuffer.append(chars[x % 36]);
        }
		return shortBuffer.toString();
		
	}
	
	/**
     * 随机生产8位的数字
     * @param factor
     * @return
     */
    public static String randomNum(){
    	return String.valueOf((int) new Double((Math.random() + 1) * Math.pow(10, 8 - 1)).longValue());
    }
}
