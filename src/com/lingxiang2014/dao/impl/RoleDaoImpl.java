/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.dao.impl;

import org.springframework.stereotype.Repository;

import com.lingxiang2014.dao.RoleDao;
import com.lingxiang2014.entity.Role;

@Repository("roleDaoImpl")
public class RoleDaoImpl extends BaseDaoImpl<Role, Long> implements RoleDao {

}