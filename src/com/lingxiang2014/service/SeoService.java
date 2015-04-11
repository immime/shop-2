/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

import com.lingxiang2014.entity.Seo;
import com.lingxiang2014.entity.Seo.Type;

public interface SeoService extends BaseService<Seo, Long> {

	Seo find(Type type);

	Seo find(Type type, String cacheRegion);

}