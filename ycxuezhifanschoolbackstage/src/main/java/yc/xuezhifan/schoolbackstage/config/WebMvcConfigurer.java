package yc.xuezhifan.schoolbackstage.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 

* <p>Title: WebMvcConfigurer.java </p> 

* <p>Description: 添加拦截器、配置 FastJsonHttpMessageConverterEx</p> 

* <p>Copyright: Copyright (c) 2018年10月17日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月17日  

* @version 1.0
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @SchoolLogin 注解 决定是否需要登录
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

   public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentSchoolMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastJsonHttpMessageConverterEx());
        super.configureMessageConverters(converters);
    }

    @Bean
    public FastJsonHttpMessageConverterEx fastJsonHttpMessageConverterEx() {
        return new FastJsonHttpMessageConverterEx();
    }

    @Bean
    public CurrentSchoolMethodArgumentResolver currentSchoolMethodArgumentResolver() {
        return new CurrentSchoolMethodArgumentResolver();
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
