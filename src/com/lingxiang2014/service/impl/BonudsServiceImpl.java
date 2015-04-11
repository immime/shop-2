package com.lingxiang2014.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lingxiang2014.Page;
import com.lingxiang2014.Pageable;
import com.lingxiang2014.dao.BonudsDao;
import com.lingxiang2014.entity.Bonuds;
import com.lingxiang2014.entity.Bonuds.Type;
import com.lingxiang2014.entity.Member;
import com.lingxiang2014.service.BonudsService;

@Service("bonudsServiceImpl")
public class BonudsServiceImpl extends BaseServiceImpl<Bonuds, Long> implements BonudsService {

	@Resource(name = "bonudsDaoImpl")
	private BonudsDao bonudsDao;

	@Resource(name = "bonudsDaoImpl")
	public void setBaseDao(BonudsDao bonudsDao) {
		super.setBaseDao(bonudsDao);
	}

	@Transactional(readOnly = true)
	public Page<Bonuds> findPage(Member member, Pageable pageable) {
		return bonudsDao.findPage(member, pageable);
	}

	public List<Bonuds> findToday(Type type, Member member) {
		return bonudsDao.findToday(type, member);
	}

	public BigDecimal count(Member member, Type type) {
		return bonudsDao.count(member, type);
	}

	public List<Bonuds> findList(Member member, Type type) {
		return bonudsDao.findList(member, type);
	}

	public List<Bonuds> findList(Member member, Type type, Date beginDate, Date endDate) {
		return bonudsDao.findList(member, type, beginDate, endDate);
	}

	public BigDecimal count(Member member, Type type, Date beginDate, Date endDate) {
		return bonudsDao.count(member, type, beginDate, endDate);
	}

	public BigDecimal countBalance(Type type, Date beginDate, Date endDate) {
		return bonudsDao.countBalance(type, beginDate, endDate);
	}

}