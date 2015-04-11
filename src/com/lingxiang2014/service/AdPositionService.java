/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

import com.lingxiang2014.entity.AdPosition;

public interface AdPositionService extends BaseService<AdPosition, Long> {

	AdPosition find(Long id, String cacheRegion);

}