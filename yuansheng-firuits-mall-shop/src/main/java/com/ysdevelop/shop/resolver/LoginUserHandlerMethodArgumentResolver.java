package com.ysdevelop.shop.resolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.shop.annotation.LoginUser;
import com.ysdevelop.shop.entity.Member;

public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		System.out.println("是否需要参数");
		return parameter.getParameterType().isAssignableFrom(Member.class) && parameter.hasParameterAnnotation(LoginUser.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
			throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		System.out.println("开始获取token");
		String token = HttpUtils.getCookieValue(request, Constant.TOKEN_NAME);
		if (token == null) {
			return null;
		}
		System.out.println(token);
		Member loginMember = null;
		loginMember = (Member) request.getSession().getAttribute(token);
		System.out.println(loginMember);
		return loginMember;
	}

}

