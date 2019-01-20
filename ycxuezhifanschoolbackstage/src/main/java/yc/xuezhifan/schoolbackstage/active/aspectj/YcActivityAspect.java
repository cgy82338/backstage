package yc.xuezhifan.schoolbackstage.active.aspectj;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

import yc.xuezhifan.schoolbackstage.active.bean.YcActivityLog;
import yc.xuezhifan.schoolbackstage.active.service.YcActivityLogService;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**
 * 
 * 
 * <p>
 * Title: YcActivityAspect.java
 * </p>
 * 
 * <p>
 * Description: 活动报名日志
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018年9月7日
 * </p>
 * 
 * @email xiaoxiao@xuezhifan.com
 * 
 * @author xiaoxiao
 * 
 * @date 2018年9月7日
 * 
 * @version 1.0
 */

@Aspect
@Component
public class YcActivityAspect {

	@Autowired
	private YcActivityLogService ycActivityLogService;

	/**
	 * 添加日志详情方法的切入点
	 */
	@Pointcut("execution(* yc.xuezhifan.schoolbackstage.active.service.YcActivityService.insertActivity(..))")
	public void ActivitybrowseLog() {
	}

	/**
	 * 删除日志详情方法的切入点
	 */
	@Pointcut("execution(* yc.xuezhifan.schoolbackstage.active.service.YcActivityService.deleteActivity(..))")
	public void activityDeleteLog() {
	}
	
	/**
	 * 修改日志方法切入点
	 */
	@Pointcut("execution(* yc.xuezhifan.schoolbackstage.active.service.YcActivityService.modify(..))")
	public void activiteUpdateLog() {
		
	}
	
	/**
	 * 获取详情后置通知
	 */
	@AfterReturning(value = "activiteUpdateLog()", argNames = "object", returning = "object")
	public void updateAdvice(JoinPoint joinPoint, Object object) {
		YcSchool ycSchool = (YcSchool) getHttpServletRequest().getAttribute("CurrentSchool");
		if (ycSchool == null) {
			return;
		}
		// 获取方法名
		String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);
		YcActivityLog ycActivityLog = new YcActivityLog();
		//设置发布人
		ycActivityLog.setYc_admin_id(ycSchool.getId());
		ycActivityLog.setYc_log_remark(opContent);
		ycActivityLog.setYc_activity_log_id(UUIDFactory.random());
		ycActivityLog.setYc_browse_time(new Date());
		ycActivityLog.setYc_ip(getIpAddr(getHttpServletRequest()));
		ycActivityLogService.insertLog(ycActivityLog);


	}
	/**
	 * 获取详情后置通知
	 */
	@AfterReturning(value = "ActivitybrowseLog()", argNames = "object", returning = "object")
	public void browseAdvice(JoinPoint joinPoint, Object object) {
		YcSchool ycSchool = (YcSchool) getHttpServletRequest().getAttribute("CurrentSchool");
		if (ycSchool == null) {
			return;
		}
		// 获取方法名
		String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);
		YcActivityLog ycActivityLog = new YcActivityLog();
		//设置发布人
		ycActivityLog.setYc_admin_id(ycSchool.getId());
		ycActivityLog.setYc_log_remark(opContent);
		ycActivityLog.setYc_activity_log_id(UUIDFactory.random());
		ycActivityLog.setYc_browse_time(new Date());
		ycActivityLog.setYc_ip(getIpAddr(getHttpServletRequest()));
		ycActivityLogService.insertLog(ycActivityLog);

	}
	
	/**
	 * 获取详情后置通知
	 */
	@AfterReturning(value = "activityDeleteLog()", argNames = "object", returning = "object")
	public void deleteAdvice(JoinPoint joinPoint, Object object) {
		YcSchool ycSchool = (YcSchool) getHttpServletRequest().getAttribute("CurrentSchool");
		if (ycSchool == null) {
			return;
		}
		// 获取方法名
		String methodName = joinPoint.getSignature().getName();
		// 获取操作内容
		String opContent = optionContent(joinPoint.getArgs(), methodName);
		YcActivityLog ycActivityLog = new YcActivityLog();
		//设置发布人
		ycActivityLog.setYc_admin_id(ycSchool.getId());
		ycActivityLog.setYc_log_remark(opContent);
		ycActivityLog.setYc_activity_log_id(UUIDFactory.random());
		ycActivityLog.setYc_browse_time(new Date());
		ycActivityLog.setYc_ip(getIpAddr(getHttpServletRequest()));
		ycActivityLogService.insertLog(ycActivityLog);

	}

	/**
	 * 使用Java反射来获取被拦截方法(insert、update)的参数值， 将参数值拼接为操作内容
	 * 
	 * @param args
	 * @param mName
	 * @return
	 */
	private String optionContent(Object[] args, String mName) {
		if (args == null) {
			return null;
		}
		StringBuffer rs = new StringBuffer();
		rs.append(mName);
		String className = null;
		int index = 1;
		// 遍历参数对象
		for (Object info : args) {
			// 获取对象类型
			className = info.getClass().getName();
			className = className.substring(className.lastIndexOf(".") + 1);
			rs.append("[参数" + index + "，类型:" + className + "，值:");
			// 获取对象的所有方法
			Method[] methods = info.getClass().getDeclaredMethods();
			// 遍历方法，判断get方法
			for (Method method : methods) {
				String methodName = method.getName();
				// 判断是不是get方法
				if (methodName.indexOf("get") == -1) {// 不是get方法
					continue;// 不处理
				}
				Object rsValue = null;
				try {
					// 调用get方法，获取返回值
					rsValue = method.invoke(info);
				} catch (Exception e) {
					continue;
				}
				// 将值加入内容中
				rs.append("(" + methodName + ":" + rsValue + ")");
			}
			rs.append("]");
			index++;
		}
		return rs.toString();
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

	/**
	 * 请求参数拼装
	 * 
	 * @param paramsArray
	 * @return
	 */
	@SuppressWarnings("unused")
	private String argsArrayToString(Object[] paramsArray) {
		String params = "";
		if (paramsArray != null && paramsArray.length > 0) {
			for (int i = 0; i < paramsArray.length; i++) {
				Object jsonObj = JSON.toJSON(paramsArray[i]);
				params += jsonObj.toString() + " ";
			}
		}
		return params.trim();
	}

}
