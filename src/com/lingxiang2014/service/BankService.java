
package com.lingxiang2014.service;

import java.util.List;

import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;
import com.lingxiang2014.entity.Bank;
import com.lingxiang2014.entity.Member;

public interface BankService extends BaseService<Bank, Long> {

    Page<Bank> findPage(Pageable pageable, Member member);

    List<Bank> findListByMember(Member member);
    
}