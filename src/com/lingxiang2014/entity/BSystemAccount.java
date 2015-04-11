package com.lingxiang2014.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "lx_bSystemAccount")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "lx_bSystemAccount_sequence")
public class BSystemAccount extends BaseEntity {

	private static final long serialVersionUID = 1533130686714725835L;

	private String number;

	private BSystemAccount leftChildren;// 左边线

	private BSystemAccount midChildren;// 中间线

	private BSystemAccount rightChildren;// 右边线

	private BSystemAccount parent;// 我的推荐人

	private BSystemAccount top;// 我上面的人

	private Set<BSystemAccount> children = new HashSet<BSystemAccount>();

	private Integer myPeople;// 我直接推荐的人数

	private Boolean isLeaf;// 是否是叶子节点。false：不是 true：是

	private Member member;

	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public BSystemAccount getLeftChildren() {
		return leftChildren;
	}

	public void setLeftChildren(BSystemAccount leftChildren) {
		this.leftChildren = leftChildren;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public BSystemAccount getMidChildren() {
		return midChildren;
	}

	public void setMidChildren(BSystemAccount midChildren) {
		this.midChildren = midChildren;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public BSystemAccount getRightChildren() {
		return rightChildren;
	}

	public void setRightChildren(BSystemAccount rightChildren) {
		this.rightChildren = rightChildren;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public BSystemAccount getParent() {
		return parent;
	}

	public void setParent(BSystemAccount parent) {
		this.parent = parent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public BSystemAccount getTop() {
		return top;
	}

	public void setTop(BSystemAccount top) {
		this.top = top;
	}

	@Column(nullable = false)
	public Boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	@Column(nullable = false)
	public Integer getMyPeople() {
		return myPeople;
	}

	public void setMyPeople(Integer myPeople) {
		this.myPeople = myPeople;
	}

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	public Set<BSystemAccount> getChildren() {
		return children;
	}

	public void setChildren(Set<BSystemAccount> children) {
		this.children = children;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Transient
	public void removeAttributeValue() {

	}

	public void init() {

		setChildren(new HashSet<BSystemAccount>());

		setIsLeaf(true);

		setLeftChildren(null);

		setMidChildren(null);
		setMyPeople(0);

		setRightChildren(null);

	}

	@Override
	public String toString() {
		return number;
	}

}