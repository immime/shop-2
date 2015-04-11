/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

import java.util.List;

import com.lingxiang2014.Filter;
import com.lingxiang2014.Order;
import com.lingxiang2014.entity.Navigation;
import com.lingxiang2014.entity.Navigation.Position;

public interface NavigationService extends BaseService<Navigation, Long> {

	List<Navigation> findList(Position position);

	List<Navigation> findList(Integer count, List<Filter> filters, List<Order> orders, String cacheRegion);

}