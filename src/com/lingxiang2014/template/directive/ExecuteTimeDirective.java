/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.template.directive;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.lingxiang2014.interceptor.ExecuteTimeInterceptor;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component("executeTimeDirective")
public class ExecuteTimeDirective extends BaseDirective {

	private static final String VARIABLE_NAME = "executeTime";

	@SuppressWarnings("rawtypes")
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if (requestAttributes != null) {
			Long executeTime = (Long) requestAttributes.getAttribute(ExecuteTimeInterceptor.EXECUTE_TIME_ATTRIBUTE_NAME, RequestAttributes.SCOPE_REQUEST);
			if (executeTime != null) {
				setLocalVariable(VARIABLE_NAME, executeTime, env, body);
			}
		}
	}

}