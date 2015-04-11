package com.lingxiang2014.dao;

import java.math.BigDecimal;

import com.lingxiang2014.entity.MemberRank;

public interface MemberRankDao extends BaseDao<MemberRank, Long> {

    boolean nameExists(String name);

    boolean amountExists(BigDecimal amount);

    MemberRank findDefault();

    MemberRank findByAmount(BigDecimal amount);

}