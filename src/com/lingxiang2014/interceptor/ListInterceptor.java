package com.lingxiang2014.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lingxiang2014.util.WebUtils;

public class ListInterceptor extends HandlerInterceptorAdapter {

	private static final String REDIRECT_VIEW_NAME_PREFIX = "redirect:";

	private static final String LIST_QUERY_COOKIE_NAME = "listQuery";

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (modelAndView != null && modelAndView.isReference()) {
			String viewName = modelAndView.getViewName();

			if (StringUtils.startsWith(viewName, REDIRECT_VIEW_NAME_PREFIX)) {
				String listQuery = WebUtils.getCookie(request, LIST_QUERY_COOKIE_NAME);
				if (StringUtils.isNotEmpty(listQuery)) {
					if (StringUtils.startsWith(listQuery, "?")) {
						listQuery = listQuery.substring(1);
					}
					if (StringUtils.contains(viewName, "?")) {
						modelAndView.setViewName(viewName + "&" + listQuery);
					} else {
						modelAndView.setViewName(viewName + "?" + listQuery);
					}
					WebUtils.removeCookie(request, response, LIST_QUERY_COOKIE_NAME);
				}
			}
		}
	}

}