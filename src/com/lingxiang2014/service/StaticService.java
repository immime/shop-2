/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

import java.util.Map;

import com.lingxiang2014.entity.Article;

public interface StaticService {

	int build(String templatePath, String staticPath, Map<String, Object> model);

	int build(String templatePath, String staticPath);

	int build(Article article);

	int buildIndex();

	int buildOther();

	int buildAll();

	int delete(String staticPath);

	int delete(Article article);

	int deleteIndex();

	int deleteOther();

}