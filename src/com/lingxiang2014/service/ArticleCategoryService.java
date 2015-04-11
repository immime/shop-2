/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

import java.util.List;

import com.lingxiang2014.entity.ArticleCategory;

public interface ArticleCategoryService extends BaseService<ArticleCategory, Long> {

	List<ArticleCategory> findRoots();

	List<ArticleCategory> findRoots(Integer count);

	List<ArticleCategory> findRoots(Integer count, String cacheRegion);

	List<ArticleCategory> findParents(ArticleCategory articleCategory);

	List<ArticleCategory> findParents(ArticleCategory articleCategory, Integer count);

	List<ArticleCategory> findParents(ArticleCategory articleCategory, Integer count, String cacheRegion);

	List<ArticleCategory> findTree();

	List<ArticleCategory> findChildren(ArticleCategory articleCategory);

	List<ArticleCategory> findChildren(ArticleCategory articleCategory, Integer count);

	List<ArticleCategory> findChildren(ArticleCategory articleCategory, Integer count, String cacheRegion);

}