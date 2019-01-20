package yc.xuezhifan.schoolbackstage.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 

* <p>Title: FastJsonHttpMessageConverterEx.java </p> 

* <p>Description: 继承 FastJsonHttpMessageConverter</p> 

* <p>Copyright: Copyright (c) 2018年10月16日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月16日  

* @version 1.0
 */
public class FastJsonHttpMessageConverterEx extends FastJsonHttpMessageConverter {
	public FastJsonHttpMessageConverterEx() {
        // 在这里配置fastjson特性
        // fastjson 默认是不转换 null 值的。还是时间戳 timestamp的格式转换成自定义格式。
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");    // 自定义时间格式
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect); // 禁止循环引用检测
        this.setFastJsonConfig(fastJsonConfig);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return super.supports(clazz);
    }
}
