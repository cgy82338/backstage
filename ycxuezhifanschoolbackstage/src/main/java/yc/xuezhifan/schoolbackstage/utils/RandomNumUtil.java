package yc.xuezhifan.schoolbackstage.utils;

/**
 * 

* <p>Title: RandomNumUtil.java </p> 

* <p>Description: 随机生成不超过19位数字</p> 

* <p>Copyright: Copyright (c) 2018年9月22日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年9月22日  

* @version 1.0
 */
public class RandomNumUtil {

	/**
     * 随机生产 factor 位的数字，最大不超过 19位，因为long的最大值为19位
     * @param factor
     * @return
     */
    public static Long randomNum(int factor){
        return new Double((Math.random() + 1) * Math.pow(10, factor - 1)).longValue();
    }
    
    
    /**
     * 随机生产8位的数字
     * @param factor
     * @return
     */
    public static int randomNum(){
    	return (int) new Double((Math.random() + 1) * Math.pow(10, 8 - 1)).longValue();
    }
    

  
}
