/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

import com.lingxiang2014.entity.Log;

public interface LogService extends BaseService<Log, Long> {

	void clear();

}