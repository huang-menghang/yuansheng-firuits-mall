package com.ysdevelop.common.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.ysdevelop.common.utils.ExceptionUtil;
import com.ysdevelop.common.utils.HttpUtils;

@ControllerAdvice
public class WebExceptionHandler {
	Logger logger = Logger.getLogger(this.getClass());

	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		ModelAndView mv = new ModelAndView();
		String exceptionMessage = ExceptionUtil.getExceptionMessage(ex);
		logger.info("进入异常绑定类");
		logger.info(ex.getClass());
		System.out.println(exceptionMessage);
		logger.error(exceptionMessage);
		Map<String, Object> model = new HashMap<String, Object>();
		if (HttpUtils.isAjaxRequest(request)) {
			FastJsonJsonView view = new FastJsonJsonView();
			if (ex instanceof BindException) {
				BindException e = (BindException) ex;
				List<ObjectError> errors = e.getAllErrors();
				for (ObjectError objectError : errors) {
					System.out.println(objectError.getDefaultMessage());
				}
				ObjectError error = errors.get(0);
				String msg = error.getDefaultMessage();
				model.put("code", -1);
				model.put("msg", msg);
				view.setAttributesMap(model);
				mv.setView(view);
			} 
			else if(ex instanceof WebServiceException){
				WebServiceException e = (WebServiceException)ex;
				model.put("code", e.getCm().getCode());
				model.put("msg", e.getMessage());
				view.setAttributesMap(model);
				mv.setView(view);
			}
			else {
				model.put("code", -1);
				model.put("msg", "系统内部错误");
				view.setAttributesMap(model);
				mv.setView(view);
			}
			return mv;
		}
		model.put("ex", ex);
		if (exceptionMessage.contains("Subject does not have permission")) {
			return new ModelAndView("common/noAccess", model);
		}
		// 再错误日志表中添加数据
		return new ModelAndView("common/500", model);
	}

}
