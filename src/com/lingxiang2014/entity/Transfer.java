package com.lingxiang2014.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "lx_transfer")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "lx_transfer_sequence")
public class Transfer extends BaseEntity {

	private static final long serialVersionUID = 3006113974551711983L;

	public enum Type {
		xianjin, // 现金币账户
		baodan, // 报单币账户
		futou, // 复投币账户
		licai, // 理财币账户
		xjTbd, // 现金币->报单币
		xjTft, // 现金币->复投币
		xjTlc, // 现金币->理财币
		bdTft, // 报单币->复投币
		bdTlc, // 报单币->理财币
		bfTli, // 复投币->理财币
		bdTxj, // 报单币->现金币
		ftTxj, // 复投币->现金币
		lcTxj, // 理财币->现金币
		ftTbd, // 复投币->报单币
		lcTbd, // 理财币->报单币
		lcTft, // 理财币->复投币

	}
	
	public enum Method {
		exchange,//转换
		transform,转账
	}

	private Member fromMember;
	private BigDecimal oldFromBalance;
	private BigDecimal newFromBalance;

	private Member toMember;
	private BigDecimal oldToBalance;
	private BigDecimal newToBalance;

	private String memo;

	private BigDecimal balance;// 转账的金额

	private BigDecimal fee;// 手续费

	private BigDecimal balance1;// 实际到账的金额

	private Type type;
	
	private Method method;

	@ManyToOne(fetch = FetchType.LAZY)
	public Member getFromMember() {
		return fromMember;
	}

	public void setFromMember(Member fromMember) {
		this.fromMember = fromMember;
	}

	@Column(nullable = false, updatable = false, precision = 21, scale = 6)
	public BigDecimal getOldFromBalance() {
		return oldFromBalance;
	}

	public void setOldFromBalance(BigDecimal oldFromBalance) {
		this.oldFromBalance = oldFromBalance;
	}

	@Column(nullable = false, updatable = false, precision = 21, scale = 6)
	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	@Column(nullable = false, updatable = false, precision = 21, scale = 6)
	public BigDecimal getBalance1() {
		return balance1;
	}

	public void setBalance1(BigDecimal balance1) {
		this.balance1 = balance1;
	}

	@Column(nullable = false, updatable = false, precision = 21, scale = 6)
	public BigDecimal getNewFromBalance() {
		return newFromBalance;
	}

	public void setNewFromBalance(BigDecimal newFromBalance) {
		this.newFromBalance = newFromBalance;
	}

	@Column(nullable = false, updatable = false, precision = 21, scale = 6)
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Member getToMember() {
		return toMember;
	}

	public void setToMember(Member toMember) {
		this.toMember = toMember;
	}

	@Column(nullable = false, updatable = false, precision = 21, scale = 6)
	public BigDecimal getOldToBalance() {
		return oldToBalance;
	}

	public void setOldToBalance(BigDecimal oldToBalance) {
		this.oldToBalance = oldToBalance;
	}

	@Column(nullable = false, updatable = false, precision = 21, scale = 6)
	public BigDecimal getNewToBalance() {
		return newToBalance;
	}

	public void setNewToBalance(BigDecimal newToBalance) {
		this.newToBalance = newToBalance;
	}

	 @Column(updatable = false,length=8000)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	
}
