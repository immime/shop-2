package com.lingxiang2014.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;
import com.lingxiang2014.entity.Admin;
import com.lingxiang2014.entity.Member;
import com.lingxiang2014.entity.Member.Zone;
import com.lingxiang2014.entity.MemberRank;

public interface MemberService extends BaseService<Member, Long> {

    boolean usernameExists(String username);

    boolean usernameDisabled(String username);

    boolean emailExists(String email);

    boolean emailUnique(String previousEmail, String currentEmail);

    void save(Member member, Admin operator);

    void update(Member member, Integer modifyPoint, BigDecimal modifyBalance, String depositMemo, Admin operator);

    Member findByUsername(String username);

    List<Member> findListByEmail(String email);

    boolean isAuthenticated();

    Member getCurrent();

    String getCurrentUsername();

    Member findByUserName(String username);

    Page<Member> findChildrenPage(Member member, Pageable pageable);

    /**
     * 查找叶子节点
     * 
     * @param index
     *            :第index个叶子节点
     * @return
     */
    Member findLeaf(Integer index);

    boolean numberExists(String number);
    
    String getMemberNumber(String currentNumber);

    Member findLeaf(Member member, Integer count, Zone zone);

    List<Member> findListByNumber(String number);

    Member findByNumber(String number);

    List<Member> findTop(Member member);

    Member findLeftChild(Member member);

    Member findRightChild(Member member);

    List<Member> findMemberByDefaultMemberRank(Boolean isDefault);

    /**
     * 查找（leve1-leve2）层到leve层之间的会员
     * @param leve
     * @param leve2
     * @param isActive 是否激活
     * @return
     */
    List<Member> findMember(Integer leve, Integer leve2, boolean isActive);
    
    /**
     * 统计某个会员等级的会员人数
     * @param memberRank
     * @return
     */
    Long count(MemberRank memberRank);
    
    List<Member> find(MemberRank memberRank);

    Member find(Member parent, Integer index, MemberRank membeRank);

	Member findLeaf(String number, Member member, Integer index, Zone zone);

	/**
	 * 查找某个会员某个区域下的所有会员
	 * @param member 会员
	 * @param zone 区域
	 * @return
	 */
	List<Member> findChildren(Member member, Zone zone);

	Member findLeafChild(Member member, Zone zone);

	Member findChild(Member member, Zone zone);

	long count(MemberRank memberRank, Date beginDate, Date endDate);

	BigDecimal countBalance(Integer type, Date beginDate, Date endDate);

}