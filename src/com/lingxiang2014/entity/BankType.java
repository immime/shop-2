package com.lingxiang2014.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lx_bankType")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "lx_bankType_sequence")
public class BankType extends BaseEntity {
    
    private static final long serialVersionUID = -8023178382846762828L;

    private String fullName;//类型的全称
    
    private String shortName;//类型的简称
    
    private Boolean isEnabled;//是否启用
    
    private BigDecimal feeRate;//提现手续费比率
    
    private Set<Bank> banks = new HashSet<Bank>();
    
    @Column(nullable = false, precision = 27, scale = 12)
    public BigDecimal getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    @OneToMany(mappedBy = "bankType", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("createDate desc")
    public Set<Bank> getBanks() {
        return banks;
    }

    public void setBanks(Set<Bank> banks) {
        this.banks = banks;
    }

    @NotNull
    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @NotNull
    @Column(nullable = false)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @NotNull
    @Column(nullable = false)
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    
    
}
