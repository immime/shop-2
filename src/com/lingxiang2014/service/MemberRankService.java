package com.lingxiang2014.service;

import java.math.BigDecimal;

import com.lingxiang2014.entity.MemberRank;

public interface MemberRankService extends BaseService<MemberRank, Long> {

    boolean nameExists(String name);

    boolean nameUnique(String previousName, String currentName);

    boolean amountExists(BigDecimal amount);

    boolean amountUnique(BigDecimal previousAmount, BigDecimal currentAmount);

    MemberRank findDefault();

    MemberRank findByAmount(BigDecimal amount);

}