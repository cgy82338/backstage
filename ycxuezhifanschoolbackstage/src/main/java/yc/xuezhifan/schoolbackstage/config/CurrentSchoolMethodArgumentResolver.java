package yc.xuezhifan.schoolbackstage.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.constants.CurrentSchoolConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;

/**
 * 

* <p>Title: CurrentSchoolMethodArgumentResolver.java </p> 

* <p>Description: 继承HandlerMethodArgumentResolver</p> 

* <p>Copyright: Copyright (c) 2018年10月28日</p>
 
* @email zhuangzhuang@xuezhifan.com

* @author zhuangzhuang 

* @date 2018年10月28日  

* @version 1.0
 */
public class CurrentSchoolMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return parameter.getParameterType().isAssignableFrom(YcSchool.class)
	            && parameter.hasParameterAnnotation(CurrentSchool.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// TODO Auto-generated method stub
		 	YcSchool ycSchool = (YcSchool) webRequest.getAttribute(CurrentSchoolConstants.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
	        if (ycSchool != null) {
	            return ycSchool;
	        }
	        throw new MissingServletRequestPartException(CurrentSchoolConstants.CURRENT_USER);
	}

}
