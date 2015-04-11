/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

public interface CacheService {

	String getDiskStorePath();

	int getCacheSize();

	void clear();

}