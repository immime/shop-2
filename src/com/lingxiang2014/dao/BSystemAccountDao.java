package com.lingxiang2014.dao;

import java.util.List;

import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;
import com.lingxiang2014.entity.BSystemAccount;

public interface BSystemAccountDao extends BaseDao<BSystemAccount, Long> {

    boolean usernameExists(String username);

    boolean emailExists(String email);

    BSystemAccount findByUsername(String username);

    List<BSystemAccount> findListByEmail(String email);

    Page<BSystemAccount> findChildrenPage(BSystemAccount bSystemAccount, Pageable pageable);

    BSystemAccount findLeaf(Integer index);

}