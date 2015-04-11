/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.template.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lingxiang2014.entity.ArticleCategory;
import com.lingxiang2014.service.ArticleCategoryService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component("articleCategoryRootListDirective")
public class ArticleCategoryRootListDirective extends BaseDirective {

	private static final String VARIABLE_NAME = "articleCategories";

	@Resource(name = "articleCategoryServiceImpl")
	private ArticleCategoryService articleCategoryService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		List<ArticleCategory> articleCategories;
		boolean useCache = useCache(env, params);
		String cacheRegion = getCacheRegion(env, params);
		Integer count = getCount(params);
		if (useCache) {
			articleCategories = articleCategoryService.findRoots(count, cacheRegion);
		} else {
			articleCategories = articleCategoryService.findRoots(count);
		}
		setLocalVariable(VARIABLE_NAME, articleCategories, env, body);
	}

}