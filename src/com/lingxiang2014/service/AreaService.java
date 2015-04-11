/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

import java.util.List;

import com.lingxiang2014.entity.Area;

public interface AreaService extends BaseService<Area, Long> {

	List<Area> findRoots();

	List<Area> findRoots(Integer count);

}