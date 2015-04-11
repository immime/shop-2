package com.lingxiang2014.dao;

import java.math.BigDecimal;
import java.util.List;

import com.lingxiang2014.entity.StaticBonudsRank;

public interface StaticBonudsRankDao extends BaseDao<StaticBonudsRank, Long> {

    boolean nameExists(String name);

    boolean amountExists(BigDecimal amount);
    
    boolean everyAmountExists(BigDecimal everyAmount);

    StaticBonudsRank findDefault();

    StaticBonudsRank findByAmount(BigDecimal amount);

    List<StaticBonudsRank> findLTEQ(Integer myPeople);
}