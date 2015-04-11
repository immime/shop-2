package com.lingxiang2014.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

/**
 * 奖金
 * 
 * @author blackboy2015
 * 
 */
@Entity
@Table(name = "lx_bonuds")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "lx_bonuds_sequence")
public class Bonuds extends BaseEntity {

	private static final long serialVersionUID = -8323452873046981882L;

	public enum Type {

		signInBonuds,

		staticBonuds,

		salesBonuds,

		duiPengBonuds,

		leaderBonuds,

		huzhuBonuds,

		jianDianBonuds,

		serviceBonuds,

		managerBonuds,
	}

	private Type type;

	private BigDecimal balance;

	private String operator;

	private String memo;

	private Member member;

	@Column(nullable = false, updatable = false)
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column(nullable = false, updatable = false, precision = 21, scale = 6)
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Column(updatable = false)
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(updatable = false,length=8000)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, updatable = false)
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}