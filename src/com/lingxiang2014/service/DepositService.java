package com.lingxiang2014.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;
import com.lingxiang2014.entity.Deposit;
import com.lingxiang2014.entity.Deposit.Type;
import com.lingxiang2014.entity.Member;

public interface DepositService extends BaseService<Deposit, Long> {

    Page<Deposit> findPage(Member member, Pageable pageable);

    BigDecimal count(Member member, Type type, Date beginDate, Date endDate);

    List<Deposit> findList(Member member, Type type, Date beginDate, Date endDate);

	BigDecimal countBalance(Type type, Date beginDate, Date endDate);

}