/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.lingxiang2014.dao;

import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;
import com.lingxiang2014.entity.Member;
import com.lingxiang2014.entity.Message;

public interface MessageDao extends BaseDao<Message, Long> {

	Page<Message> findPage(Member member, Pageable pageable);

	Page<Message> findDraftPage(Member sender, Pageable pageable);

	Long count(Member member, Boolean read);

	void remove(Long id, Member member);

}