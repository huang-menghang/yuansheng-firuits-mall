package com.ysdevelop.admin.aspect;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ysdevelop.admin.entity.ActionLog;
import com.ysdevelop.admin.service.ActionLogService;
import com.ysdevelop.common.utils.HttpUtils;

@Component
@Aspect
public class LogAspect {
	 @Autowired
	 private ActionLogService actionLogService;
	 
	private ActionLog log;
	
	public LogAspect() {
		log = new ActionLog();
	}

	
	@Before("execution(* com.ysdevelop.admin.controller..*(..))")
	public void before(JoinPoint joinPoint) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();  
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;  
        HttpServletRequest request = sra.getRequest();  
		log.setRequstUrl(request.getRequestURI());
		log.setRequestMethod(request.getMethod());
		log.setIp(HttpUtils.getIp(request));
		log.setOsAndBrowser(HttpUtils.getOsAndBrowserInfo(request));
		log.setRequestParams(HttpUtils.getRequestParamters(request));
		log.setRequestControllerMethod(joinPoint.getTarget().getClass().getName()+" "+joinPoint.getSignature().getName());
		Date date = new Date();
		log.setCreateTime(date);
		System.out.println(log.getRequestParams());
	}

	@AfterReturning(pointcut ="execution(* com.ysdevelop.admin.controller..*(..)) && !@annotation(org.springframework.web.bind.annotation.ResponseBody)",returning="ret")
	public void afterReturn(JoinPoint joinPoint,Object ret) {
		log.setResult(ret.toString());
		actionLogService.save(log);
	}
	
	@AfterReturning(pointcut ="execution(* com.ysdevelop.admin.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.ResponseBody)",returning="ret")
	public void afterReturnData(JoinPoint joinPoint,Object ret) {
		log.setResult("data");
		actionLogService.save(log);
	}
	
	@AfterThrowing(pointcut ="execution(* com.ysdevelop.admin.controller..*(..))",throwing="ret")
	public void afterThrow(JoinPoint joinPoint,Object ret) {
		log.setException(ret.getClass().getName());
		actionLogService.save(log);
	}
	
}
