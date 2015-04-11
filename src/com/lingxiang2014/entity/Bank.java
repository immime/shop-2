package com.lingxiang2014.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "lx_bank")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "lx_bank_sequence")
public class Bank extends BaseEntity {

    private static final long serialVersionUID = 3836615414932272116L;

    private Member member;

    private String bankAccount;

    private BankType bankType;

    private String bankTrueName;

    private Boolean isDefault;
    
    private Area area;
    
    private String address;//开户地址

    
    
    @ManyToOne(fetch = FetchType.LAZY)
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Length(max = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty
    @NotNull
    @Column(nullable = false)
    public Boolean getIsDefault() {
	return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
	this.isDefault = isDefault;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Member getMember() {
	return member;
    }

    public void setMember(Member member) {
	this.member = member;
    }

    @NotNull
    @Column(nullable = false)
    public String getBankAccount() {
	return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
	this.bankAccount = bankAccount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public BankType getBankType() {
	return bankType;
    }

    public void setBankType(BankType bankType) {
	this.bankType = bankType;
    }

    @NotNull
    @Column(nullable = false)
    public String getBankTrueName() {
	return bankTrueName;
    }

    public void setBankTrueName(String bankTrueName) {
	this.bankTrueName = bankTrueName;
    }

}
