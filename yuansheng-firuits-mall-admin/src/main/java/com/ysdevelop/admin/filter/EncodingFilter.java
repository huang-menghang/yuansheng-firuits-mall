package com.ysdevelop.admin.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.ysdevelop.common.utils.HttpUtils;

public class EncodingFilter extends OncePerRequestFilter {

	private String encoding;

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	class Utf8Request extends HttpServletRequestWrapper {

		HttpServletRequest request;

		public Utf8Request(HttpServletRequest request) {
			super(request);
			this.request = request;
		}

		@Override
		public String getParameter(String name) {
			// 得到原来的参数
			String value = request.getParameter(name);
			// 增强
			value = HttpUtils.getRequestParamterUtf8(value);
			// 返回增强后的内容
			System.out.println(value);
			return value;
		}

		// 重写getParameterValues方法
		@Override
		public String[] getParameterValues(String name) {
			try {
				String[] values = request.getParameterValues(name);
				// 对GET方法进行转码
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						// 对每一个元素进行转码
						values[i] = HttpUtils.getRequestParamterUtf8(values[i]);
					}
				}
				// 返回增强值
				return values;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);

		Utf8Request utf8Request = new Utf8Request(request);

		filterChain.doFilter(utf8Request, response);

	}

}
