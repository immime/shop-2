package com.lingxiang2014.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;
import com.lingxiang2014.entity.Bonuds;
import com.lingxiang2014.entity.Bonuds.Type;
import com.lingxiang2014.entity.Member;

public interface BonudsService extends BaseService<Bonuds, Long> {

    Page<Bonuds> findPage(Member member,Pageable pageable);

    List<Bonuds> findToday(Type type, Member member);

    BigDecimal count(Member member, Type type);

    public List<Bonuds> findList(Member member, Type type);

    List<Bonuds> findList(Member member, Type type, Date beginDate, Date endDate);

    BigDecimal count(Member member, Type type, Date beginDate, Date endDate);

	BigDecimal countBalance(Type type, Date beginDate, Date endDate);

}