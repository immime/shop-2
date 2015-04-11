/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Decoder;

public class AccessDeniedFilter implements Filter {

	private static final String ERROR_MESSAGE = "Access denied!";

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.addHeader(new String(new BASE64Decoder().decodeBuffer("UG93ZXJlZEJ5"), "utf-8"), new String(new BASE64Decoder().decodeBuffer("U2hvcHh4Lm5ldA=="), "utf-8"));
		response.sendError(HttpServletResponse.SC_FORBIDDEN, ERROR_MESSAGE);
	}

}