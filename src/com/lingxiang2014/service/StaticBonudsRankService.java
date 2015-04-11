package com.lingxiang2014.service;

import java.math.BigDecimal;
import java.util.List;

import com.lingxiang2014.entity.StaticBonudsRank;

public interface StaticBonudsRankService extends BaseService<StaticBonudsRank, Long> {

    boolean nameExists(String name);

    boolean nameUnique(String previousName, String currentName);

    boolean amountExists(BigDecimal amount);
    
    boolean everyAmountExists(BigDecimal amount);

    boolean amountUnique(BigDecimal previousAmount, BigDecimal currentAmount);

    StaticBonudsRank findDefault();

    StaticBonudsRank findByAmount(BigDecimal amount);


    List<StaticBonudsRank> findLTEQ(Integer myPeople);

}