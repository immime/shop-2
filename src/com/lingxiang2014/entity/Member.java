package com.lingxiang2014.entity;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.lingxiang2014.entity.MemberAttribute.Type;
import com.lingxiang2014.interceptor.MemberInterceptor;
import com.lingxiang2014.util.JsonUtils;

@Entity
@Table(name = "lx_member")
@SequenceGenerator(name = "sequenceGenerator", sequenceName = "lx_member_sequence")
public class Member extends BaseEntity {

	private static final long serialVersionUID = 1533130686714725835L;

	/*
	 * 调用BeanUtils.copyProperties方法是后，不需要复制的属性
	 */
	public static String[] NOT_COPY_PROPERTIES = new String[] { "number", "username", "point", "amount", "balance", "registerIp", "loginIp", "loginDate", "safeKey", "deposits", "inMessages", "outMessages", "leftChildren", "midChildren", "rightChildren", "parent", "qq;", "password2", "idCard", "banks", "top", "children", "myPeople", "isLeaf", "staticDevidedBonuds", "staticBonudsRank", "bSystemAccounts", "leftResults", "rightResults", "leftRemainResults", "rightRemainResults", "todayResults", "todayDuiPengBonuds", "passwordProtections", "isOpenPasswordProtections", "leve","isComplate","leftMember","rightMember"};

	public enum Gender {

		male,

		female
	}
	
	public enum Zone {

		left,

		right
	}

	public static final String PRINCIPAL_ATTRIBUTE_NAME = MemberInterceptor.class.getName() + ".PRINCIPAL";

	public static final String USERNAME_COOKIE_NAME = "username";

	public static final int ATTRIBUTE_VALUE_PROPERTY_COUNT = 10;

	public static final String ATTRIBUTE_VALUE_PROPERTY_NAME_PREFIX = "attributeValue";

	public static final Integer MAX_FAVORITE_COUNT = 10;

	private String number;

	private String username;

	private String password;

	private String email;

	private Long point;

	private BigDecimal amount;

	private BigDecimal balance;// 现金币（可以提现)

	private BigDecimal balance1;// 报单币（只能由现金币转换成报单币，不能提现）

	private BigDecimal balance2;// 复投币（只能由现金币转换成报单币，不能提现）

	private BigDecimal balance3;// 理财币（只能由现金币转换成报单币，不能提现）

	private Boolean isEnabled;

	private Boolean isLocked;

	private Integer loginFailureCount;

	private Date lockedDate;

	private String registerIp;

	private String loginIp;

	private Date loginDate;

	private String name;

	private Gender gender;

	private Date birth;

	private String address;

	private String zipCode;

	private String phone;

	private String mobile;

	private String attributeValue0;

	private String attributeValue1;

	private String attributeValue2;

	private String attributeValue3;

	private String attributeValue4;

	private String attributeValue5;

	private String attributeValue6;

	private String attributeValue7;

	private String attributeValue8;

	private String attributeValue9;

	private SafeKey safeKey;

	private Area area;

	private MemberRank memberRank;

	private Set<Deposit> deposits = new HashSet<Deposit>();

	private Set<Message> inMessages = new HashSet<Message>();

	private Set<Message> outMessages = new HashSet<Message>();

	private Member leftChildren;// 左边线

	private Member midChildren;// 中间线

	private Member rightChildren;// 右边线

	private Member parent;// 我的推荐人

	private String qq;// QQ号码

	private String password2;// 二级密码

	private String idCard;// 身份证号

	private Set<Bank> banks = new HashSet<Bank>();

	private Member top;// 我上面的人

	private Set<Member> children = new HashSet<Member>();

	private Integer myPeople;// 我直接推荐的人数

	private Boolean isLeaf;// 是否是叶子节点。false：不是 true：是

	private BigDecimal staticDevidedBonuds;// 静态分红已分金额

	private StaticBonudsRank staticBonudsRank;// 静态分红等级

	private Boolean isStaticDevideBonuds;// 是否享有静态分红的权限

	private Boolean isSignInBonuds;// 是否享有签到奖的权限

	private Boolean isStaticBonuds;// 是否享有静态提成的权限

	private Boolean isSalesBonuds;// 是否享有直推奖的权限

	private Boolean isDuiPengBonuds;// 是否享有静态分红的权限

	private Boolean isLeaderBonuds;// 是否享有平衡奖的权限

	private Boolean isHuzhuBonuds;// 是否享有互助的权限

	private Boolean isJianDianBonuds;// 是否享有见点奖的权限

	private Boolean isServiceBonuds;// 是否享有服务奖的权限

	private Set<BSystemAccount> bSystemAccounts = new HashSet<BSystemAccount>();

	private BigDecimal leftResults;// 左边业绩

	private BigDecimal rightResults;// 右边业绩

	private BigDecimal leftRemainResults;// 左边剩余业绩

	private BigDecimal rightRemainResults;// 右边剩余业绩

	private Integer leftMember;

	private Integer rightMember;
	
	private BigDecimal todayResults;// 今天的业绩

	private BigDecimal todayDuiPengBonuds;// 当天平衡奖分的金额

	private Set<PasswordProtection> passwordProtections = new HashSet<PasswordProtection>();// 密保

	private Boolean isOpenPasswordProtections;// 是否开启密保（针对提现）

	private Date activeDate;// 会员激活账户的时间

	private Integer leve;// 是第几层的会员
	
	private Boolean isComplate;//是否完善过资料
	
	@Transient
	private BigDecimal allBonuds;//总分红
	
	public BigDecimal getAllBonuds() {
		return allBonuds;
	}

	public void setAllBonuds(BigDecimal allBonuds) {
		this.allBonuds = allBonuds;
	}

	public Integer getLeftMember() {
		return leftMember;
	}

	public void setLeftMember(Integer leftMember) {
		this.leftMember = leftMember;
	}

	public Integer getRightMember() {
		return rightMember;
	}

	public void setRightMember(Integer rightMember) {
		this.rightMember = rightMember;
	}
	public Integer getLeve() {
		return leve;
	}

	public void setLeve(Integer leve) {
		this.leve = leve;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	public Set<Bank> getBanks() {
		return banks;
	}

	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	public Set<PasswordProtection> getPasswordProtections() {
		return passwordProtections;
	}

	public void setPasswordProtections(Set<PasswordProtection> passwordProtections) {
		this.passwordProtections = passwordProtections;
	}

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	public Set<BSystemAccount> getbSystemAccounts() {
		return bSystemAccounts;
	}

	public void setbSystemAccounts(Set<BSystemAccount> bSystemAccounts) {
		this.bSystemAccounts = bSystemAccounts;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@NotEmpty(groups = Save.class)
	@Pattern(regexp = "^[^\\s&\"<>]+$")
	@Column(nullable = false)
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

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
	public Member getLeftChildren() {
		return leftChildren;
	}

	public void setLeftChildren(Member leftChildren) {
		this.leftChildren = leftChildren;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public Member getMidChildren() {
		return midChildren;
	}

	public void setMidChildren(Member midChildren) {
		this.midChildren = midChildren;
	}

	@OneToOne(fetch = FetchType.LAZY)
	public Member getRightChildren() {
		return rightChildren;
	}

	public void setRightChildren(Member rightChildren) {
		this.rightChildren = rightChildren;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Member getParent() {
		return parent;
	}

	public void setParent(Member parent) {
		this.parent = parent;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Member getTop() {
		return top;
	}

	public void setTop(Member top) {
		this.top = top;
	}

	@NotEmpty(groups = Save.class)
	@Pattern(regexp = "^[0-9a-z_A-Z\\u4e00-\\u9fa5]+$")
	@Column(nullable = false, updatable = false, unique = true, length = 100)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotEmpty(groups = Save.class)
	@Pattern(regexp = "^[^\\s&\"<>]+$")
	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotEmpty
	@Email
	@Length(max = 200)
	@Column(nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Column(nullable = false)
	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getLeftResults() {
		return leftResults;
	}

	public void setLeftResults(BigDecimal leftResults) {
		this.leftResults = leftResults;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getRightResults() {
		return rightResults;
	}

	public void setRightResults(BigDecimal rightResults) {
		this.rightResults = rightResults;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getLeftRemainResults() {
		return leftRemainResults;
	}

	public void setLeftRemainResults(BigDecimal leftRemainResults) {
		this.leftRemainResults = leftRemainResults;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getRightRemainResults() {
		return rightRemainResults;
	}

	public void setRightRemainResults(BigDecimal rightRemainResults) {
		this.rightRemainResults = rightRemainResults;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getTodayResults() {
		return todayResults;
	}

	public void setTodayResults(BigDecimal todayResults) {
		this.todayResults = todayResults;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getBalance1() {
		return balance1;
	}

	public void setBalance1(BigDecimal balance1) {
		this.balance1 = balance1;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getBalance2() {
		return balance2;
	}

	public void setBalance2(BigDecimal balance2) {
		this.balance2 = balance2;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getBalance3() {
		return balance3;
	}

	public void setBalance3(BigDecimal balance3) {
		this.balance3 = balance3;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getTodayDuiPengBonuds() {
		return todayDuiPengBonuds;
	}

	public void setTodayDuiPengBonuds(BigDecimal todayDuiPengBonuds) {
		this.todayDuiPengBonuds = todayDuiPengBonuds;
	}

	@NotNull(groups = Save.class)
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getStaticDevidedBonuds() {
		return staticDevidedBonuds;
	}

	public void setStaticDevidedBonuds(BigDecimal staticDevidedBonuds) {
		this.staticDevidedBonuds = staticDevidedBonuds;
	}

	@NotNull
	@Column(nullable = false)
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Column(nullable = false)
	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	@Column(nullable = false)
	public Boolean getIsOpenPasswordProtections() {
		return isOpenPasswordProtections;
	}

	public void setIsOpenPasswordProtections(Boolean isOpenPasswordProtections) {
		this.isOpenPasswordProtections = isOpenPasswordProtections;
	}
	
	@Column(nullable = false)
	public Boolean getIsComplate() {
		return isComplate;
	}

	public void setIsComplate(Boolean isComplate) {
		this.isComplate = isComplate;
	}

	@Column(nullable = false)
	public Boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	@Column(nullable = false)
	public Boolean getIsStaticDevideBonuds() {
		return isStaticDevideBonuds;
	}

	public void setIsStaticDevideBonuds(Boolean isStaticDevideBonuds) {
		this.isStaticDevideBonuds = isStaticDevideBonuds;
	}

	@Column(nullable = false)
	public Boolean getIsSignInBonuds() {
		return isSignInBonuds;
	}

	public void setIsSignInBonuds(Boolean isSignInBonuds) {
		this.isSignInBonuds = isSignInBonuds;
	}

	@Column(nullable = false)
	public Boolean getIsStaticBonuds() {
		return isStaticBonuds;
	}

	public void setIsStaticBonuds(Boolean isStaticBonuds) {
		this.isStaticBonuds = isStaticBonuds;
	}

	@Column(nullable = false)
	public Boolean getIsSalesBonuds() {
		return isSalesBonuds;
	}

	public void setIsSalesBonuds(Boolean isSalesBonuds) {
		this.isSalesBonuds = isSalesBonuds;
	}

	@Column(nullable = false)
	public Boolean getIsDuiPengBonuds() {
		return isDuiPengBonuds;
	}

	public void setIsDuiPengBonuds(Boolean isDuiPengBonuds) {
		this.isDuiPengBonuds = isDuiPengBonuds;
	}

	@Column(nullable = false)
	public Boolean getIsLeaderBonuds() {
		return isLeaderBonuds;
	}

	public void setIsLeaderBonuds(Boolean isLeaderBonuds) {
		this.isLeaderBonuds = isLeaderBonuds;
	}

	@Column(nullable = false)
	public Boolean getIsHuzhuBonuds() {
		return isHuzhuBonuds;
	}

	public void setIsHuzhuBonuds(Boolean isHuzhuBonuds) {
		this.isHuzhuBonuds = isHuzhuBonuds;
	}

	@Column(nullable = false)
	public Boolean getIsJianDianBonuds() {
		return isJianDianBonuds;
	}

	public void setIsJianDianBonuds(Boolean isJianDianBonuds) {
		this.isJianDianBonuds = isJianDianBonuds;
	}

	@Column(nullable = false)
	public Boolean getIsServiceBonuds() {
		return isServiceBonuds;
	}

	public void setIsServiceBonuds(Boolean isServiceBonuds) {
		this.isServiceBonuds = isServiceBonuds;
	}

	@Column(nullable = false)
	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	@Column(nullable = false)
	public Integer getMyPeople() {
		return myPeople;
	}

	public void setMyPeople(Integer myPeople) {
		this.myPeople = myPeople;
	}

	public Date getLockedDate() {
		return lockedDate;
	}

	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	@Column(nullable = false, updatable = false)
	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Length(max = 200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Length(max = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Length(max = 200)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Length(max = 200)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(max = 200)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Length(max = 200)
	public String getAttributeValue0() {
		return attributeValue0;
	}

	public void setAttributeValue0(String attributeValue0) {
		this.attributeValue0 = attributeValue0;
	}

	@Length(max = 200)
	public String getAttributeValue1() {
		return attributeValue1;
	}

	public void setAttributeValue1(String attributeValue1) {
		this.attributeValue1 = attributeValue1;
	}

	@Length(max = 200)
	public String getAttributeValue2() {
		return attributeValue2;
	}

	public void setAttributeValue2(String attributeValue2) {
		this.attributeValue2 = attributeValue2;
	}

	@Length(max = 200)
	public String getAttributeValue3() {
		return attributeValue3;
	}

	public void setAttributeValue3(String attributeValue3) {
		this.attributeValue3 = attributeValue3;
	}

	@Length(max = 200)
	public String getAttributeValue4() {
		return attributeValue4;
	}

	public void setAttributeValue4(String attributeValue4) {
		this.attributeValue4 = attributeValue4;
	}

	@Length(max = 200)
	public String getAttributeValue5() {
		return attributeValue5;
	}

	public void setAttributeValue5(String attributeValue5) {
		this.attributeValue5 = attributeValue5;
	}

	@Length(max = 200)
	public String getAttributeValue6() {
		return attributeValue6;
	}

	public void setAttributeValue6(String attributeValue6) {
		this.attributeValue6 = attributeValue6;
	}

	@Length(max = 200)
	public String getAttributeValue7() {
		return attributeValue7;
	}

	public void setAttributeValue7(String attributeValue7) {
		this.attributeValue7 = attributeValue7;
	}

	@Length(max = 200)
	public String getAttributeValue8() {
		return attributeValue8;
	}

	public void setAttributeValue8(String attributeValue8) {
		this.attributeValue8 = attributeValue8;
	}

	@Length(max = 200)
	public String getAttributeValue9() {
		return attributeValue9;
	}

	public void setAttributeValue9(String attributeValue9) {
		this.attributeValue9 = attributeValue9;
	}

	@Embedded
	public SafeKey getSafeKey() {
		return safeKey;
	}

	public void setSafeKey(SafeKey safeKey) {
		this.safeKey = safeKey;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	public MemberRank getMemberRank() {
		return memberRank;
	}

	public void setMemberRank(MemberRank memberRank) {
		this.memberRank = memberRank;
	}

	@ManyToOne
	public StaticBonudsRank getStaticBonudsRank() {
		return staticBonudsRank;
	}

	public void setStaticBonudsRank(StaticBonudsRank staticBonudsRank) {
		this.staticBonudsRank = staticBonudsRank;
	}

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	public Set<Member> getChildren() {
		return children;
	}

	public void setChildren(Set<Member> children) {
		this.children = children;
	}

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	public Set<Deposit> getDeposits() {
		return deposits;
	}

	public void setDeposits(Set<Deposit> deposits) {
		this.deposits = deposits;
	}

	@OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	public Set<Message> getInMessages() {
		return inMessages;
	}

	public void setInMessages(Set<Message> inMessages) {
		this.inMessages = inMessages;
	}

	@OneToMany(mappedBy = "sender", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	public Set<Message> getOutMessages() {
		return outMessages;
	}

	public void setOutMessages(Set<Message> outMessages) {
		this.outMessages = outMessages;
	}

	@Transient
	public Object getAttributeValue(MemberAttribute memberAttribute) {
		if (memberAttribute != null) {
			if (memberAttribute.getType() == Type.name) {
				return getName();
			} else if (memberAttribute.getType() == Type.gender) {
				return getGender();
			} else if (memberAttribute.getType() == Type.birth) {
				return getBirth();
			} else if (memberAttribute.getType() == Type.area) {
				return getArea();
			} else if (memberAttribute.getType() == Type.address) {
				return getAddress();
			} else if (memberAttribute.getType() == Type.zipCode) {
				return getZipCode();
			} else if (memberAttribute.getType() == Type.phone) {
				return getPhone();
			} else if (memberAttribute.getType() == Type.mobile) {
				return getMobile();
			} else if (memberAttribute.getType() == Type.checkbox) {
				if (memberAttribute.getPropertyIndex() != null) {
					try {
						String propertyName = ATTRIBUTE_VALUE_PROPERTY_NAME_PREFIX + memberAttribute.getPropertyIndex();
						String propertyValue = (String) PropertyUtils.getProperty(this, propertyName);
						if (propertyValue != null) {
							return JsonUtils.toObject(propertyValue, List.class);
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}
			} else {
				if (memberAttribute.getPropertyIndex() != null) {
					try {
						String propertyName = ATTRIBUTE_VALUE_PROPERTY_NAME_PREFIX + memberAttribute.getPropertyIndex();
						return (String) PropertyUtils.getProperty(this, propertyName);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	@Transient
	public void setAttributeValue(MemberAttribute memberAttribute, Object attributeValue) {
		if (memberAttribute != null) {
			if (attributeValue instanceof String && StringUtils.isEmpty((String) attributeValue)) {
				attributeValue = null;
			}
			if (memberAttribute.getType() == Type.name && (attributeValue instanceof String || attributeValue == null)) {
				setName((String) attributeValue);
			} else if (memberAttribute.getType() == Type.gender && (attributeValue instanceof Gender || attributeValue == null)) {
				setGender((Gender) attributeValue);
			} else if (memberAttribute.getType() == Type.birth && (attributeValue instanceof Date || attributeValue == null)) {
				setBirth((Date) attributeValue);
			} else if (memberAttribute.getType() == Type.area && (attributeValue instanceof Area || attributeValue == null)) {
				setArea((Area) attributeValue);
			} else if (memberAttribute.getType() == Type.address && (attributeValue instanceof String || attributeValue == null)) {
				setAddress((String) attributeValue);
			} else if (memberAttribute.getType() == Type.zipCode && (attributeValue instanceof String || attributeValue == null)) {
				setZipCode((String) attributeValue);
			} else if (memberAttribute.getType() == Type.phone && (attributeValue instanceof String || attributeValue == null)) {
				setPhone((String) attributeValue);
			} else if (memberAttribute.getType() == Type.mobile && (attributeValue instanceof String || attributeValue == null)) {
				setMobile((String) attributeValue);
			} else if (memberAttribute.getType() == Type.checkbox && (attributeValue instanceof List || attributeValue == null)) {
				if (memberAttribute.getPropertyIndex() != null) {
					if (attributeValue == null || (memberAttribute.getOptions() != null && memberAttribute.getOptions().containsAll((List<?>) attributeValue))) {
						try {
							String propertyName = ATTRIBUTE_VALUE_PROPERTY_NAME_PREFIX + memberAttribute.getPropertyIndex();
							PropertyUtils.setProperty(this, propertyName, JsonUtils.toJson(attributeValue));
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				if (memberAttribute.getPropertyIndex() != null) {
					try {
						String propertyName = ATTRIBUTE_VALUE_PROPERTY_NAME_PREFIX + memberAttribute.getPropertyIndex();
						PropertyUtils.setProperty(this, propertyName, attributeValue);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Transient
	public void removeAttributeValue() {
		setName(null);
		setGender(null);
		setBirth(null);
		setArea(null);
		setAddress(null);
		setZipCode(null);
		setPhone(null);
		setMobile(null);
		for (int i = 0; i < ATTRIBUTE_VALUE_PROPERTY_COUNT; i++) {
			String propertyName = ATTRIBUTE_VALUE_PROPERTY_NAME_PREFIX + i;
			try {
				PropertyUtils.setProperty(this, propertyName, null);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
	}

	public void init() {
		setAmount(new BigDecimal(0));
		setBalance(new BigDecimal(0));
		setBalance1(new BigDecimal(0));
		setBalance2(new BigDecimal(0));
		setBalance3(new BigDecimal(0));

		setChildren(new HashSet<Member>());

		setDeposits(null);
		
		setTodayDuiPengBonuds(new BigDecimal(0));

		setInMessages(null);
		setIsEnabled(true);
		setIsLocked(false);
		setIsLeaf(true);
		setIsStaticDevideBonuds(false);
		setIsOpenPasswordProtections(false);
		setIsDuiPengBonuds(false);
		setIsHuzhuBonuds(false);
		setIsJianDianBonuds(false);
		setIsLeaderBonuds(false);
		setIsSalesBonuds(false);
		setIsServiceBonuds(false);
		setIsSignInBonuds(false);
		setIsStaticBonuds(false);
		setIsComplate(false);
		setLoginFailureCount(0);
		setLockedDate(null);
		setLoginDate(new Date());
		setLeftChildren(null);
		setLoginIp(null);
		setLeftRemainResults(new BigDecimal(0));
		setLeftResults(new BigDecimal(0));
		setLeftMember(0);
		setLeve(null);

		setMidChildren(null);
		setMyPeople(0);

		setOutMessages(null);

		setPasswordProtections(new HashSet<PasswordProtection>());
		
		setRightChildren(null);

		setRightRemainResults(new BigDecimal(0));
		setRightResults(new BigDecimal(0));
		setRightMember(0);
		
		setSafeKey(null);
		setStaticDevidedBonuds(new BigDecimal(0));

		setTodayDuiPengBonuds(new BigDecimal(0));
		setTodayResults(new BigDecimal(0));
	}

	@Override
	public String toString() {
		return "Member [number=" + number + ", username=" + username + ", password=" + password + ", email=" + email + ", point=" + point + ", amount=" + amount + ", balance=" + balance + ", balance1=" + balance1 + ", balance2=" + balance2 + ", balance3=" + balance3 + ", isEnabled=" + isEnabled + ", isLocked=" + isLocked + ", loginFailureCount=" + loginFailureCount + ", lockedDate=" + lockedDate + ", registerIp=" + registerIp + ", loginIp=" + loginIp + ", loginDate=" + loginDate + ", name=" + name + ", gender=" + gender + ", birth=" + birth + ", address=" + address + ", zipCode=" + zipCode + ", phone=" + phone + ", mobile=" + mobile + ", attributeValue0=" + attributeValue0 + ", attributeValue1=" + attributeValue1 + ", attributeValue2=" + attributeValue2 + ", attributeValue3="
				+ attributeValue3 + ", attributeValue4=" + attributeValue4 + ", attributeValue5=" + attributeValue5 + ", attributeValue6=" + attributeValue6 + ", attributeValue7=" + attributeValue7 + ", attributeValue8=" + attributeValue8 + ", attributeValue9=" + attributeValue9 + ", safeKey=" + safeKey + ", qq=" + qq + ", password2=" + password2 + ", idCard=" + idCard + ", myPeople=" + myPeople + ", isLeaf=" + isLeaf + ", staticDevidedBonuds=" + staticDevidedBonuds + ", staticBonudsRank=" + staticBonudsRank + ", isStaticDevideBonuds=" + isStaticDevideBonuds + ", isSignInBonuds=" + isSignInBonuds + ", isStaticBonuds=" + isStaticBonuds + ", isSalesBonuds=" + isSalesBonuds + ", isDuiPengBonuds=" + isDuiPengBonuds + ", isLeaderBonuds=" + isLeaderBonuds + ", isHuzhuBonuds=" + isHuzhuBonuds
				+ ", isJianDianBonuds=" + isJianDianBonuds + ", isServiceBonuds=" + isServiceBonuds + ", bSystemAccounts=" + bSystemAccounts + ", leftResults=" + leftResults + ", rightResults=" + rightResults + ", leftRemainResults=" + leftRemainResults + ", rightRemainResults=" + rightRemainResults + ", todayResults=" + todayResults + ", todayDuiPengBonuds=" + todayDuiPengBonuds + ", passwordProtections=" + passwordProtections + ", isOpenPasswordProtections=" + isOpenPasswordProtections + ", activeDate=" + activeDate + "]";
	}

}