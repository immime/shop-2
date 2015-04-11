/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.dao;

import java.util.List;

import com.lingxiang2014.entity.Tag;
import com.lingxiang2014.entity.Tag.Type;

public interface TagDao extends BaseDao<Tag, Long> {

	List<Tag> findList(Type type);

}