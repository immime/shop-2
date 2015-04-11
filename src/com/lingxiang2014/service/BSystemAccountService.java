
package com.lingxiang2014.service;

import java.util.List;

import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;
import com.lingxiang2014.entity.BSystemAccount;

public interface BSystemAccountService extends BaseService<BSystemAccount, Long> {

	boolean usernameExists(String username);

	boolean usernameDisabled(String username);

	boolean emailExists(String email);

	boolean emailUnique(String previousEmail, String currentEmail);

	BSystemAccount findByUsername(String username);

	List<BSystemAccount> findListByEmail(String email);

	BSystemAccount findByUserName(String username);

	Page<BSystemAccount> findChildrenPage(BSystemAccount bSystemAccount, Pageable pageable);

	/**
	 * 查找叶子节点
	 * @param index:第index个叶子节点
	 * @return
	 */
	BSystemAccount findLeaf(Integer index);

}