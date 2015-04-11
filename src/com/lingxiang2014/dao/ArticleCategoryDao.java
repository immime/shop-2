/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.dao;

import java.util.List;

import com.lingxiang2014.entity.ArticleCategory;

public interface ArticleCategoryDao extends BaseDao<ArticleCategory, Long> {

	List<ArticleCategory> findRoots(Integer count);

	List<ArticleCategory> findParents(ArticleCategory articleCategory, Integer count);

	List<ArticleCategory> findChildren(ArticleCategory articleCategory, Integer count);

}