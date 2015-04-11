package com.lingxiang2014.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;
import com.lingxiang2014.entity.Member;
import com.lingxiang2014.entity.Member.Zone;
import com.lingxiang2014.entity.MemberRank;

public interface MemberDao extends BaseDao<Member, Long> {

    boolean usernameExists(String username);

    boolean emailExists(String email);

    Member findByUsername(String username);

    List<Member> findListByEmail(String email);

    Page<Member> findChildrenPage(Member member, Pageable pageable);

    Member findLeaf(Integer index);

    boolean numberExists(String number);

    Member findLeaf(Member member, Integer count, Zone zone);

    List<Member> findListByNumber(String number);

    Member findByNumber(String number);

    List<Member> findTop(Member member);

    Member findLeftChild(Member member);

    Member findRightChild(Member member);

    List<Member> findMemberByDefaultMemberRank(Boolean isDefault);

    List<Member> findMember(Integer leve, Integer leve2, boolean isActive);

    Long count(MemberRank memberRank);

    List<Member> find(MemberRank memberRank);

    Member find(Member parent, Integer index, MemberRank memberRank);

	Member findLeaf(String number, Member member, Integer index, Zone zone);

	List<Member> findChildren(Member member, Zone zone);

	Member findLeafChild(Member member, Zone zone);

	Member findChild(Member member, Zone zone);

	long count(MemberRank membeRank, Date beginDate, Date endDate);

	BigDecimal countBalance(Integer type, Date beginDate, Date endDate);

}