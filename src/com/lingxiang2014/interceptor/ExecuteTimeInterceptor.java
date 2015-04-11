package com.lingxiang2014.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(ExecuteTimeInterceptor.class);

	private static final String START_TIME_ATTRIBUTE_NAME = ExecuteTimeInterceptor.class.getName() + ".START_TIME";
	public static final String EXECUTE_TIME_ATTRIBUTE_NAME = ExecuteTimeInterceptor.class.getName() + ".EXECUTE_TIME";
	private static final String REDIRECT_VIEW_NAME_PREFIX = "redirect:";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Long startTime = (Long) request.getAttribute(START_TIME_ATTRIBUTE_NAME);
		if (startTime == null) {
			startTime = System.currentTimeMillis();
			request.setAttribute(START_TIME_ATTRIBUTE_NAME, startTime);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Long executeTime = (Long) request.getAttribute(EXECUTE_TIME_ATTRIBUTE_NAME);
		if (executeTime == null) {
			Long startTime = (Long) request.getAttribute(START_TIME_ATTRIBUTE_NAME);
			Long endTime = System.currentTimeMillis();
			executeTime = endTime - startTime;
			request.setAttribute(START_TIME_ATTRIBUTE_NAME, startTime);
		}

		if (modelAndView != null) {
			String viewName = modelAndView.getViewName();
			if (!StringUtils.startsWith(viewName, REDIRECT_VIEW_NAME_PREFIX)) {
				modelAndView.addObject(EXECUTE_TIME_ATTRIBUTE_NAME, executeTime);
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("[" + handler + "] executeTime: " + executeTime + "ms");
		}
	}

}