package yc.xuezhifan.schoolbackstage.school.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchoolLoginLog;
import yc.xuezhifan.schoolbackstage.school.mapper.YcSchoolLoginLogMapper;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;


/**
 * <p>
 * Title: YcSchoolLoginAspect.java
 * </p>
 *
 * <p>
 * Description: 学校登录日志
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2018年12月28日
 * </p>
 *
 * @author xiaoyu
 * @version 1.0
 * @email xiaoyu@xuezhifan.com
 * @date 2018年12月28日
 */
@Aspect
@Component
public class YcSchoolLoginAspect {

    @Autowired
    YcSchoolLoginLogMapper mapper;

    /**
     * 添加日志详情方法的切入点
     */
    @Pointcut("execution(* yc.xuezhifan.schoolbackstage.school.service.YcSchoolService.login(..))")
    public void insertLoginLog() {
    }

    /**
     * 获取详情后置通知
     */
    @AfterReturning(value = "insertLoginLog()", argNames = "object", returning = "object")
    public void updateAdvice(JoinPoint joinPoint, Object object) {

        YcSchool ycSchool = (YcSchool) object;
        if (ycSchool == null) {
            return;
        }
        // 接收到请求，记录请求内容
        //            获取本机ip
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            YcSchoolLoginLog loginLog = new YcSchoolLoginLog();
            loginLog.setId(UUIDFactory.random());
            loginLog.setYc_school_id(ycSchool.getId());
            loginLog.setYc_school_login_time(new Date());
            loginLog.setYc_school_log_ip(ip);
            mapper.insertSchoolLoginLog(loginLog);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    private HttpServletRequest getHttpServletRequest() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        if (ra == null) {
            return null;
        }
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        if (request != null) {
            return request;
        }
        return null;
    }

    /**
     * 获取登录用户远程主机ip地址
     *
     * @param request
     * @return
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
