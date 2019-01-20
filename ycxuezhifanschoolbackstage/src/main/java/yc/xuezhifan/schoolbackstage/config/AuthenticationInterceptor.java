package yc.xuezhifan.schoolbackstage.config;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import io.jsonwebtoken.Claims;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.constants.CurrentSchoolConstants;
import yc.xuezhifan.schoolbackstage.constants.TokenConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.school.service.YcSchoolService;
import yc.xuezhifan.schoolbackstage.utils.TokenUtils;

public class AuthenticationInterceptor implements HandlerInterceptor {
	@Autowired
	private YcSchoolService schoolService;

	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 *
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        SchoolLogin methodAnnotation = method.getAnnotation(SchoolLogin.class);
        // 有 @SchoolLogin 注解，需要认证
        if (methodAnnotation != null) {
            // 判断是否存在令牌信息，如果存在，则允许登录
            String accessToken = (String) request.getSession().getAttribute(TokenConstants.ACCESS_TOKEN);
            if (null == accessToken) {
                response.sendRedirect("/school/toLogin");
                return false;
            }
            Claims claims = TokenUtils.parseJWT(accessToken);
            String schoolName = claims.getId();
            YcSchool school = schoolService.findByAccessToken(schoolName);
            if (school == null) {
                throw new RuntimeException("用户不存在，请重新登录");
            }
            // 当前登录用户@CurrentUser（带学校信息）
            request.setAttribute(CurrentSchoolConstants.CURRENT_USER, school);
            return true;
        }else{
            return true;
        }
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
