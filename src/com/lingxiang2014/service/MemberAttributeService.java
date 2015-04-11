/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.service;

import java.util.List;

import com.lingxiang2014.entity.MemberAttribute;

public interface MemberAttributeService extends BaseService<MemberAttribute, Long> {

	Integer findUnusedPropertyIndex();

	List<MemberAttribute> findList();

	List<MemberAttribute> findList(String cacheRegion);

}