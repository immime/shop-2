/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.dao.impl;

import org.springframework.stereotype.Repository;

import com.lingxiang2014.dao.AdDao;
import com.lingxiang2014.entity.Ad;

@Repository("adDaoImpl")
public class AdDaoImpl extends BaseDaoImpl<Ad, Long> implements AdDao {

}