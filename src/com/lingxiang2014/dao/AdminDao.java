/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.dao;

import com.lingxiang2014.entity.Admin;

public interface AdminDao extends BaseDao<Admin, Long> {

	boolean usernameExists(String username);

	Admin findByUsername(String username);

}