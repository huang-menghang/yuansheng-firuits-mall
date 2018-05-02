package com.ysdevelop.shop.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;




import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.shop.annotation.IgnoreAuth;

public class AuthorizationInterceptor implements HandlerInterceptor {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		IgnoreAuth annotation = null;
		if (handler instanceof HandlerMethod) {
			annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
		} else {
			return true;
		}
		// 如果有注解则需要校验
		if (annotation != null) {
			return true;
		}
		// 如果没有则需要权限校验
		Cookie[] cookies = request.getCookies();
		boolean isAuth = checkAuth(cookies, request);
		if (!isAuth) {
			if(HttpUtils.isAjaxRequest(request)){
				throw new WebServiceException(CodeMsg.MEMBER_UNLOGIN);
			}
			String url = request.getContextPath()+"/member/login?rurl="+request.getRequestURL();
			String requestQuery = request.getQueryString();
			if(requestQuery != null){
				url = url+"?"+requestQuery;
			}
			logger.info("重新走回的url:"+url);
			HttpUtils.redirectUrl(request, response, url);
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	private boolean checkAuth(Cookie[] cookies, HttpServletRequest request) {
		Cookie tokenCookie = null;
		if(cookies == null || cookies.length == 0){
			return false;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(Constant.TOKEN_NAME)) {
				tokenCookie = cookie;
			}
		}
		if (tokenCookie == null) {
			return false;
		}
		String token = tokenCookie.getValue();
		if (request.getSession().getAttribute(token) == null) {
			return false;
		}
		return true;

	}

}