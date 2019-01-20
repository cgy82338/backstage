package yc.xuezhifan.schoolbackstage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 

* <p>Title: CurrentSchool.java </p> 

* <p>Description: </p> 

* <p>Copyright: Copyright (c) 2018年10月28日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月28日  

* @version 1.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentSchool {

}
