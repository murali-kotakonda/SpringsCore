package com.mythri;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		System.out.println("After Complition -- afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
		System.out.println("Post Handler -- postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		System.out.println("Pre Handler -- preHandle");
		return true;
	}
}
