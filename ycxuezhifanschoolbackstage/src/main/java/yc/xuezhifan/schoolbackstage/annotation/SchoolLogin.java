package yc.xuezhifan.schoolbackstage.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 

* <p>Title: SchoolLogin.java </p> 

* <p>Description: 在需要登录验证的Controller的方法上使用此注解</p> 

* <p>Copyright: Copyright (c) 2018年10月28日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月28日  

* @version 1.0
 */
@Target({ElementType.METHOD})// 可用在方法名上
@Retention(RetentionPolicy.RUNTIME)// 运行时有效
public @interface SchoolLogin {
}

