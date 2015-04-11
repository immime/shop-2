
package com.lingxiang2014.dao;

import java.util.List;

import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;
import com.lingxiang2014.entity.Bank;
import com.lingxiang2014.entity.Member;

public interface BankDao extends BaseDao<Bank, Long> {

    Page<Bank> findPage(Pageable pageable, Member member);

    List<Bank> findListByMember(Member member);

}