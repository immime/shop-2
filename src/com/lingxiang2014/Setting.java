package com.lingxiang2014;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

public class Setting implements Serializable {

	private static final long serialVersionUID = -1478999889661796840L;

	public enum RoundType {

		roundHalfUp,

		roundUp,

		roundDown
	}

	public enum CaptchaType {

		memberLogin,

		memberRegister,

		adminLogin,

		findPassword,

		resetPassword,

		other
	}

	public enum AccountLockType {

		member,

		admin
	}

	public static final String CACHE_NAME = "setting";

	public static final Integer CACHE_KEY = 0;

	private static final String SEPARATOR = ",";

	private static final String SEPARATOR1 = ";";

	private String siteName;

	private String siteUrl;

	private String logo;

	private String kefuQQ;

	private String address;

	private String phone;

	private String zipCode;

	private String email;

	private String certtext;

	private Boolean isSiteEnabled;

	private String siteCloseMessage;

	private Integer priceScale;

	private RoundType priceRoundType;

	private Boolean isRegisterEnabled;

	private Boolean isDuplicateEmail;

	private String disabledUsername;

	private Integer usernameMinLength;

	private Integer usernameMaxLength;

	private Integer passwordMinLength;

	private Integer passwordMaxLength;

	private Long registerPoint;

	private String registerAgreement;

	private Boolean isEmailLogin;

	private CaptchaType[] captchaTypes;

	private AccountLockType[] accountLockTypes;

	private Integer accountLockCount;

	private Integer accountLockTime;

	private Integer safeKeyExpiryTime;

	private Integer uploadMaxSize;

	private String uploadImageExtension;

	private String uploadFlashExtension;

	private String uploadMediaExtension;

	private String uploadFileExtension;

	private String imageUploadPath;

	private String flashUploadPath;

	private String mediaUploadPath;

	private String fileUploadPath;

	private String smtpFromMail;

	private String smtpHost;

	private Integer smtpPort;

	private String smtpUsername;

	private String smtpPassword;

	private String currencySign;

	private String currencyUnit;

	private Double defaultPointScale;

	private Boolean isDevelopmentEnabled;

	private Boolean isInvoiceEnabled;

	private Boolean isTaxPriceEnabled;

	private Double taxRate;

	private String cookiePath;

	private String cookieDomain;

	private Boolean isCnzzEnabled;

	private String cnzzSiteId;

	private String cnzzPassword;

	private Boolean isSignIn;// 是否开启签到
	private Boolean isWithraw;//是否开启提现
	private BigDecimal withrawMinMoney;//每次提现的最低金额
	private Integer signInType;//签到奖领取的方式：1:按金额领取 2:按比率领取 3：随机领取

	private BigDecimal minSignInMoney;//如果签到奖是随机领取，那么随机领取的金额不能少于这个金额。

	private BigDecimal signInMoneyRate;// 如果是按比率领取签到奖，那就是获取这里设置的每天领取签到的比率和投资额乘积
	
	private BigDecimal maxSignInMoney;//如果签到奖是随机领取，那么随机领取的金额不能多余这个金额。
	
	private BigDecimal signInMoney;// 如果是按金额领取签到奖，那就是获取这里设置的每天领取签到的金额

	private BigDecimal staticBonuds;// 静态分红比率

	private BigDecimal salesBonuds;// 销售分红比率

	private BigDecimal duiPengBonuds;// 对碰分红比率

	private BigDecimal leaderBonuds;// 领导分红比率

	private BigDecimal huzhuBonuds;// 互助奖分红比率

	private BigDecimal jianDianBonuds;// 见点奖分红比率

	private BigDecimal managerBonuds;// 见点奖的分红比率

	private Integer managerBonudsLeve;// 见点奖的层数

	private BigDecimal todayStaticBonuds;// 静态分红比率

	private BigDecimal todaySalesBonuds;// 销售分红比率

	private BigDecimal todayDuiPengBonuds;// 对碰分红比率

	private BigDecimal todayLeaderBonuds;// 领导分红比率

	private BigDecimal todayHuzhuBonuds;// 互助奖分红比率

	private BigDecimal todayJianDianBonuds;// 见点奖分红比率
	
	private BigDecimal todayManagerBonuds;

	private BigDecimal boundsRate;// 每天进来的资金多少比例用于静态分红

	private BigDecimal aRate;// 静态分红，进入A系统的分配比率

	private BigDecimal bRate;// 静态分红，进入B系统的分配比率

	private BigDecimal cRate;// 静态分红，进入C系统的分配比率

	private BigDecimal bSystemLeave;// 进入B系统 复投币账户的金额要满足最低金额

	private Boolean isXianjin;// 现金币账户
	private Boolean isBaodan; // 报单币账户
	private Boolean isFutou; // 复投币账户
	private Boolean isLicai; // 理财币账户
	private Boolean isXjtbd; // 现金币->报单币
	private Boolean isXjtft; // 现金币->复投币
	private Boolean isXjtlc; // 现金币->理财币
	private Boolean isBdtft; // 报单币->复投币
	private Boolean isBdtlc; // 报单币->理财币
	private Boolean isBftli; // 复投币->理财币
	private Boolean isBdtxj; // 报单币->现金币
	private Boolean isFttxj; // 复投币->现金币
	private Boolean isLctxj; // 理财币->现金币
	private Boolean isFttbd; // 复投币->报单币
	private Boolean isLctbd; // 理财币->报单币
	private Boolean isLctft; // 理财币->复投币

	private BigDecimal xianjinRate; // 现金币账户(手续费)
	private BigDecimal baodanRate; // 报单币账户(手续费)
	private BigDecimal futouRate; // 复投币账户(手续费)
	private BigDecimal licaiRate; // 理财币账户(手续费)
	private BigDecimal xjTbdRate; // 现金币->报单币(手续费)
	private BigDecimal xjTftRate; // 现金币->复投币(手续费)
	private BigDecimal xjTlcRate; // 现金币->理财币(手续费)
	private BigDecimal bdTftRate; // 报单币->复投币(手续费)
	private BigDecimal bdTlcRate; // 报单币->理财币(手续费)
	private BigDecimal bfTliRate; // 复投币->理财币(手续费)
	private BigDecimal bdTxjRate; // 报单币->现金币(手续费)
	private BigDecimal ftTxjRate; // 复投币->现金币(手续费)
	private BigDecimal lcTxjRate; // 理财币->现金币(手续费)
	private BigDecimal ftTbdRate; // 复投币->报单币(手续费)
	private BigDecimal lcTbdRate; // 理财币->报单币(手续费)
	private BigDecimal lcTftRate; // 理财币->复投币(手续费)

	private String memberNumberPrefix;// 会员编号的前缀

	private Integer memberNumberLength;// 会员编号的长度

	private String defaultPassword;// 默认一级密码

	private String defaultPassword1;// 默认二级密码

	private String referer;// 浏览器请求头的referer信息。用来限制外链的访问

	private Boolean isOpenReferer;// 是否开启检测请求头的referer信息

	private String ignoreUrl;// 哪些需要过滤的请求连接，不检测请求头

	private String announce;// 公告
	
	private BigDecimal zero = new BigDecimal(0);//0
	
	private BigDecimal percent = new BigDecimal(100);//
	
	

	public Integer getManagerBonudsLeve() {
		return managerBonudsLeve;
	}

	public void setManagerBonudsLeve(Integer managerBonudsLeve) {
		this.managerBonudsLeve = managerBonudsLeve;
	}

	@Length(max = 200)
	public String getIgnoreUrl() {
		return ignoreUrl;
	}

	public void setIgnoreUrl(String ignoreUrl) {
		if (ignoreUrl != null) {
			ignoreUrl = ignoreUrl.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "");
		}
		this.ignoreUrl = ignoreUrl;
	}

	public String[] getIgnoreUrls() {
		return StringUtils.split(ignoreUrl, SEPARATOR);
	}

	@NotNull
	public Boolean getIsOpenReferer() {
		return isOpenReferer;
	}

	public void setIsOpenReferer(Boolean isOpenReferer) {
		this.isOpenReferer = isOpenReferer;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	@NotEmpty
	@Length(max = 200)
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	@NotEmpty
	@Length(max = 200)
	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}

	@NotEmpty
	@Length(max = 200)
	public String getDefaultPassword1() {
		return defaultPassword1;
	}

	public void setDefaultPassword1(String defaultPassword1) {
		this.defaultPassword1 = defaultPassword1;
	}

	@NotEmpty
	@Length(max = 200)
	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = StringUtils.removeEnd(siteUrl, "/");
	}

	@NotEmpty
	@Length(max = 200)
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Length(max = 200)
	public String getKefuQQ() {
		return kefuQQ;
	}

	public void setKefuQQ(String kefuQQ) {
		
		this.kefuQQ = kefuQQ;
	}

	@Length(max = 200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Length(max = 200)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(max = 200)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Email
	@Length(max = 200)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Length(max = 200)
	public String getCerttext() {
		return certtext;
	}

	public void setCerttext(String certtext) {
		this.certtext = certtext;
	}

	@NotNull
	public Boolean getIsSiteEnabled() {
		return isSiteEnabled;
	}

	public void setIsSiteEnabled(Boolean isSiteEnabled) {
		this.isSiteEnabled = isSiteEnabled;
	}

	@NotEmpty
	public String getSiteCloseMessage() {
		return siteCloseMessage;
	}

	public void setSiteCloseMessage(String siteCloseMessage) {
		this.siteCloseMessage = siteCloseMessage;
	}

	public String getAnnounce() {
		return announce;
	}

	public void setAnnounce(String announce) {
		this.announce = announce;
	}

	@NotNull
	@Min(0)
	@Max(3)
	public Integer getPriceScale() {
		return priceScale;
	}

	public void setPriceScale(Integer priceScale) {
		this.priceScale = priceScale;
	}

	@NotNull
	public RoundType getPriceRoundType() {
		return priceRoundType;
	}

	public void setPriceRoundType(RoundType priceRoundType) {
		this.priceRoundType = priceRoundType;
	}

	@NotNull
	public Boolean getIsRegisterEnabled() {
		return isRegisterEnabled;
	}

	public void setIsRegisterEnabled(Boolean isRegisterEnabled) {
		this.isRegisterEnabled = isRegisterEnabled;
	}

	@NotNull
	public Boolean getIsDuplicateEmail() {
		return isDuplicateEmail;
	}

	public void setIsDuplicateEmail(Boolean isDuplicateEmail) {
		this.isDuplicateEmail = isDuplicateEmail;
	}

	@Length(max = 200)
	public String getDisabledUsername() {
		return disabledUsername;
	}

	public void setDisabledUsername(String disabledUsername) {
		if (disabledUsername != null) {
			disabledUsername = disabledUsername.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "");
		}
		this.disabledUsername = disabledUsername;
	}

	@NotNull
	@Min(1)
	@Max(117)
	public Integer getUsernameMinLength() {
		return usernameMinLength;
	}

	public void setUsernameMinLength(Integer usernameMinLength) {
		this.usernameMinLength = usernameMinLength;
	}

	@NotNull
	@Min(1)
	@Max(117)
	public Integer getUsernameMaxLength() {
		return usernameMaxLength;
	}

	public void setUsernameMaxLength(Integer usernameMaxLength) {
		this.usernameMaxLength = usernameMaxLength;
	}

	@NotNull
	@Min(1)
	@Max(117)
	public Integer getPasswordMinLength() {
		return passwordMinLength;
	}

	public void setPasswordMinLength(Integer passwordMinLength) {
		this.passwordMinLength = passwordMinLength;
	}

	@NotNull
	@Min(1)
	@Max(117)
	public Integer getPasswordMaxLength() {
		return passwordMaxLength;
	}

	public void setPasswordMaxLength(Integer passwordMaxLength) {
		this.passwordMaxLength = passwordMaxLength;
	}

	@NotNull
	@Min(0)
	public Long getRegisterPoint() {
		return registerPoint;
	}

	public void setRegisterPoint(Long registerPoint) {
		this.registerPoint = registerPoint;
	}

	@NotEmpty
	public String getRegisterAgreement() {
		return registerAgreement;
	}

	public void setRegisterAgreement(String registerAgreement) {
		this.registerAgreement = registerAgreement;
	}

	@NotNull
	public Boolean getIsEmailLogin() {
		return isEmailLogin;
	}

	public void setIsEmailLogin(Boolean isEmailLogin) {
		this.isEmailLogin = isEmailLogin;
	}

	public CaptchaType[] getCaptchaTypes() {
		return captchaTypes;
	}

	public void setCaptchaTypes(CaptchaType[] captchaTypes) {
		this.captchaTypes = captchaTypes;
	}

	public AccountLockType[] getAccountLockTypes() {
		return accountLockTypes;
	}

	public void setAccountLockTypes(AccountLockType[] accountLockTypes) {
		this.accountLockTypes = accountLockTypes;
	}

	@NotNull
	@Min(1)
	public Integer getAccountLockCount() {
		return accountLockCount;
	}

	public void setAccountLockCount(Integer accountLockCount) {
		this.accountLockCount = accountLockCount;
	}

	@NotNull
	@Min(0)
	public Integer getAccountLockTime() {
		return accountLockTime;
	}

	public void setAccountLockTime(Integer accountLockTime) {
		this.accountLockTime = accountLockTime;
	}

	@NotNull
	@Min(0)
	public Integer getSafeKeyExpiryTime() {
		return safeKeyExpiryTime;
	}

	public void setSafeKeyExpiryTime(Integer safeKeyExpiryTime) {
		this.safeKeyExpiryTime = safeKeyExpiryTime;
	}

	@NotNull
	@Min(0)
	public Integer getUploadMaxSize() {
		return uploadMaxSize;
	}

	public void setUploadMaxSize(Integer uploadMaxSize) {
		this.uploadMaxSize = uploadMaxSize;
	}

	@Length(max = 200)
	public String getUploadImageExtension() {
		return uploadImageExtension;
	}

	public void setUploadImageExtension(String uploadImageExtension) {
		if (uploadImageExtension != null) {
			uploadImageExtension = uploadImageExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
		}
		this.uploadImageExtension = uploadImageExtension;
	}

	@Length(max = 200)
	public String getUploadFlashExtension() {
		return uploadFlashExtension;
	}

	public void setUploadFlashExtension(String uploadFlashExtension) {
		if (uploadFlashExtension != null) {
			uploadFlashExtension = uploadFlashExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
		}
		this.uploadFlashExtension = uploadFlashExtension;
	}

	@Length(max = 200)
	public String getUploadMediaExtension() {
		return uploadMediaExtension;
	}

	public void setUploadMediaExtension(String uploadMediaExtension) {
		if (uploadMediaExtension != null) {
			uploadMediaExtension = uploadMediaExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
		}
		this.uploadMediaExtension = uploadMediaExtension;
	}

	@Length(max = 200)
	public String getUploadFileExtension() {
		return uploadFileExtension;
	}

	public void setUploadFileExtension(String uploadFileExtension) {
		if (uploadFileExtension != null) {
			uploadFileExtension = uploadFileExtension.replaceAll("[,\\s]*,[,\\s]*", ",").replaceAll("^,|,$", "").toLowerCase();
		}
		this.uploadFileExtension = uploadFileExtension;
	}

	@NotEmpty
	@Length(max = 200)
	public String getImageUploadPath() {
		return imageUploadPath;
	}

	public void setImageUploadPath(String imageUploadPath) {
		if (imageUploadPath != null) {
			if (!imageUploadPath.startsWith("/")) {
				imageUploadPath = "/" + imageUploadPath;
			}
			if (!imageUploadPath.endsWith("/")) {
				imageUploadPath += "/";
			}
		}
		this.imageUploadPath = imageUploadPath;
	}

	@NotEmpty
	@Length(max = 200)
	public String getFlashUploadPath() {
		return flashUploadPath;
	}

	public void setFlashUploadPath(String flashUploadPath) {
		if (flashUploadPath != null) {
			if (!flashUploadPath.startsWith("/")) {
				flashUploadPath = "/" + flashUploadPath;
			}
			if (!flashUploadPath.endsWith("/")) {
				flashUploadPath += "/";
			}
		}
		this.flashUploadPath = flashUploadPath;
	}

	@NotEmpty
	@Length(max = 200)
	public String getMediaUploadPath() {
		return mediaUploadPath;
	}

	public void setMediaUploadPath(String mediaUploadPath) {
		if (mediaUploadPath != null) {
			if (!mediaUploadPath.startsWith("/")) {
				mediaUploadPath = "/" + mediaUploadPath;
			}
			if (!mediaUploadPath.endsWith("/")) {
				mediaUploadPath += "/";
			}
		}
		this.mediaUploadPath = mediaUploadPath;
	}

	@NotEmpty
	@Length(max = 200)
	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		if (fileUploadPath != null) {
			if (!fileUploadPath.startsWith("/")) {
				fileUploadPath = "/" + fileUploadPath;
			}
			if (!fileUploadPath.endsWith("/")) {
				fileUploadPath += "/";
			}
		}
		this.fileUploadPath = fileUploadPath;
	}

	@NotEmpty
	@Email
	@Length(max = 200)
	public String getSmtpFromMail() {
		return smtpFromMail;
	}

	public void setSmtpFromMail(String smtpFromMail) {
		this.smtpFromMail = smtpFromMail;
	}

	@NotEmpty
	@Length(max = 200)
	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	@NotNull
	@Min(0)
	public Integer getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}

	@NotEmpty
	@Length(max = 200)
	public String getSmtpUsername() {
		return smtpUsername;
	}

	public void setSmtpUsername(String smtpUsername) {
		this.smtpUsername = smtpUsername;
	}

	@Length(max = 200)
	public String getSmtpPassword() {
		return smtpPassword;
	}

	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	@NotEmpty
	@Length(max = 200)
	public String getCurrencySign() {
		return currencySign;
	}

	public void setCurrencySign(String currencySign) {
		this.currencySign = currencySign;
	}

	@NotEmpty
	@Length(max = 200)
	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	@NotNull
	@Min(0)
	@Digits(integer = 3, fraction = 3)
	public Double getDefaultPointScale() {
		return defaultPointScale;
	}

	public void setDefaultPointScale(Double defaultPointScale) {
		this.defaultPointScale = defaultPointScale;
	}

	@NotNull
	public Boolean getIsDevelopmentEnabled() {
		return isDevelopmentEnabled;
	}

	public void setIsDevelopmentEnabled(Boolean isDevelopmentEnabled) {
		this.isDevelopmentEnabled = isDevelopmentEnabled;
	}

	@NotNull
	public Boolean getIsInvoiceEnabled() {
		return isInvoiceEnabled;
	}

	public void setIsInvoiceEnabled(Boolean isInvoiceEnabled) {
		this.isInvoiceEnabled = isInvoiceEnabled;
	}

	@NotNull
	public Boolean getIsTaxPriceEnabled() {
		return isTaxPriceEnabled;
	}

	public void setIsTaxPriceEnabled(Boolean isTaxPriceEnabled) {
		this.isTaxPriceEnabled = isTaxPriceEnabled;
	}

	@NotNull
	@Min(0)
	@Digits(integer = 3, fraction = 3)
	public Double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Double taxRate) {
		this.taxRate = taxRate;
	}

	@NotEmpty
	@Length(max = 200)
	public String getCookiePath() {
		return cookiePath;
	}

	public void setCookiePath(String cookiePath) {
		if (cookiePath != null && !cookiePath.endsWith("/")) {
			cookiePath += "/";
		}
		this.cookiePath = cookiePath;
	}

	@Length(max = 200)
	public String getCookieDomain() {
		return cookieDomain;
	}

	public void setCookieDomain(String cookieDomain) {
		this.cookieDomain = cookieDomain;
	}

	public Boolean getIsCnzzEnabled() {
		return isCnzzEnabled;
	}

	public void setIsCnzzEnabled(Boolean isCnzzEnabled) {
		this.isCnzzEnabled = isCnzzEnabled;
	}

	public String getCnzzSiteId() {
		return cnzzSiteId;
	}

	public void setCnzzSiteId(String cnzzSiteId) {
		this.cnzzSiteId = cnzzSiteId;
	}

	public String getCnzzPassword() {
		return cnzzPassword;
	}

	public void setCnzzPassword(String cnzzPassword) {
		this.cnzzPassword = cnzzPassword;
	}

	public Map<String, String> getkefuQQs() {
		Map<String, String> map = new HashMap<String, String>();
		String[] qqWebNames = StringUtils.split(kefuQQ, SEPARATOR1);
		for (String qqWebName : qqWebNames) {
			String[] qqs = StringUtils.split(qqWebName, SEPARATOR);
			if (qqs != null && qqs.length == 2) {
				map.put(qqs[0], qqs[1]);
			}

		}

		return map;
	}

	public String[] getDisabledUsernames() {
		return StringUtils.split(disabledUsername, SEPARATOR);
	}

	public String[] getUploadImageExtensions() {
		return StringUtils.split(uploadImageExtension, SEPARATOR);
	}

	public String[] getUploadFlashExtensions() {
		return StringUtils.split(uploadFlashExtension, SEPARATOR);
	}

	public String[] getUploadMediaExtensions() {
		return StringUtils.split(uploadMediaExtension, SEPARATOR);
	}

	public String[] getUploadFileExtensions() {
		return StringUtils.split(uploadFileExtension, SEPARATOR);
	}

	public BigDecimal setScale(BigDecimal amount) {
		if (amount == null) {
			return null;
		}
		int roundingMode;
		if (getPriceRoundType() == RoundType.roundUp) {
			roundingMode = BigDecimal.ROUND_UP;
		} else if (getPriceRoundType() == RoundType.roundDown) {
			roundingMode = BigDecimal.ROUND_DOWN;
		} else {
			roundingMode = BigDecimal.ROUND_HALF_UP;
		}
		return amount.setScale(getPriceScale(), roundingMode);
	}

	@NotNull
	public Boolean getIsSignIn() {
		return isSignIn;
	}

	public void setIsSignIn(Boolean isSignIn) {
		this.isSignIn = isSignIn;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getSignInMoney() {
		return signInMoney;
	}

	public void setSignInMoney(BigDecimal signInMoney) {
		this.signInMoney = signInMoney;
	}
	
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getMinSignInMoney() {
		return minSignInMoney;
	}

	public void setMinSignInMoney(BigDecimal minSignInMoney) {
		this.minSignInMoney = minSignInMoney;
	}
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getMaxSignInMoney() {
		return maxSignInMoney;
	}

	public void setMaxSignInMoney(BigDecimal maxSignInMoney) {
		this.maxSignInMoney = maxSignInMoney;
	}

	
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getSignInMoneyRate() {
		return signInMoneyRate;
	}

	public void setSignInMoneyRate(BigDecimal signInMoneyRate) {
		this.signInMoneyRate = signInMoneyRate;
	}

	public Integer getSignInType() {
		return signInType;
	}

	public void setSignInType(Integer signInType) {
		this.signInType = signInType;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getbSystemLeave() {
		return bSystemLeave;
	}

	public void setbSystemLeave(BigDecimal bSystemLeave) {
		this.bSystemLeave = bSystemLeave;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getStaticBonuds() {
		return staticBonuds;
	}

	public void setStaticBonuds(BigDecimal staticBonuds) {
		this.staticBonuds = staticBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getSalesBonuds() {
		return salesBonuds;
	}

	public void setSalesBonuds(BigDecimal salesBonuds) {
		this.salesBonuds = salesBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getDuiPengBonuds() {
		return duiPengBonuds;
	}

	public void setDuiPengBonuds(BigDecimal duiPengBonuds) {
		this.duiPengBonuds = duiPengBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getLeaderBonuds() {
		return leaderBonuds;
	}

	public void setLeaderBonuds(BigDecimal leaderBonuds) {
		this.leaderBonuds = leaderBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getHuzhuBonuds() {
		return huzhuBonuds;
	}

	public void setHuzhuBonuds(BigDecimal huzhuBonuds) {
		this.huzhuBonuds = huzhuBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getJianDianBonuds() {
		return jianDianBonuds;
	}

	public void setJianDianBonuds(BigDecimal jianDianBonuds) {
		this.jianDianBonuds = jianDianBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getBoundsRate() {
		return boundsRate;
	}

	public void setBoundsRate(BigDecimal boundsRate) {
		this.boundsRate = boundsRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getTodayStaticBonuds() {
		return todayStaticBonuds;
	}

	public void setTodayStaticBonuds(BigDecimal todayStaticBonuds) {
		this.todayStaticBonuds = todayStaticBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getTodaySalesBonuds() {
		return todaySalesBonuds;
	}

	public void setTodaySalesBonuds(BigDecimal todaySalesBonuds) {
		this.todaySalesBonuds = todaySalesBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getTodayDuiPengBonuds() {
		return todayDuiPengBonuds;
	}

	public void setTodayDuiPengBonuds(BigDecimal todayDuiPengBonuds) {
		this.todayDuiPengBonuds = todayDuiPengBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getTodayLeaderBonuds() {
		return todayLeaderBonuds;
	}

	public void setTodayLeaderBonuds(BigDecimal todayLeaderBonuds) {
		this.todayLeaderBonuds = todayLeaderBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getTodayHuzhuBonuds() {
		return todayHuzhuBonuds;
	}

	public void setTodayHuzhuBonuds(BigDecimal todayHuzhuBonuds) {
		this.todayHuzhuBonuds = todayHuzhuBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getTodayJianDianBonuds() {
		return todayJianDianBonuds;
	}

	
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getTodayManagerBonuds() {
		return todayManagerBonuds;
	}

	public void setTodayManagerBonuds(BigDecimal todayManagerBonuds) {
		this.todayManagerBonuds = todayManagerBonuds;
	}

	public void setTodayJianDianBonuds(BigDecimal todayJianDianBonuds) {
		this.todayJianDianBonuds = todayJianDianBonuds;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getaRate() {
		return aRate;
	}

	public void setaRate(BigDecimal aRate) {
		this.aRate = aRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getbRate() {
		return bRate;
	}

	public void setbRate(BigDecimal bRate) {
		this.bRate = bRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getcRate() {
		return cRate;
	}

	public void setcRate(BigDecimal cRate) {
		this.cRate = cRate;
	}

	public Boolean getIsXianjin() {
		return isXianjin;
	}

	public void setIsXianjin(Boolean isXianjin) {
		this.isXianjin = isXianjin;
	}

	public Boolean getIsBaodan() {
		return isBaodan;
	}

	public void setIsBaodan(Boolean isBaodan) {
		this.isBaodan = isBaodan;
	}

	public Boolean getIsFutou() {
		return isFutou;
	}

	public void setIsFutou(Boolean isFutou) {
		this.isFutou = isFutou;
	}

	public Boolean getIsLicai() {
		return isLicai;
	}

	public void setIsLicai(Boolean isLicai) {
		this.isLicai = isLicai;
	}

	public Boolean getIsXjtbd() {
		return isXjtbd;
	}

	public void setIsXjtbd(Boolean isXjtbd) {
		this.isXjtbd = isXjtbd;
	}

	public Boolean getIsXjtft() {
		return isXjtft;
	}

	public void setIsXjtft(Boolean isXjtft) {
		this.isXjtft = isXjtft;
	}

	public Boolean getIsXjtlc() {
		return isXjtlc;
	}

	public void setIsXjtlc(Boolean isXjtlc) {
		this.isXjtlc = isXjtlc;
	}

	public Boolean getIsBdtft() {
		return isBdtft;
	}

	public void setIsBdtft(Boolean isBdtft) {
		this.isBdtft = isBdtft;
	}

	public Boolean getIsBdtlc() {
		return isBdtlc;
	}

	public void setIsBdtlc(Boolean isBdtlc) {
		this.isBdtlc = isBdtlc;
	}

	public Boolean getIsBftli() {
		return isBftli;
	}

	public void setIsBftli(Boolean isBftli) {
		this.isBftli = isBftli;
	}

	public Boolean getIsBdtxj() {
		return isBdtxj;
	}

	public void setIsBdtxj(Boolean isBdtxj) {
		this.isBdtxj = isBdtxj;
	}

	public Boolean getIsFttxj() {
		return isFttxj;
	}

	public void setIsFttxj(Boolean isFttxj) {
		this.isFttxj = isFttxj;
	}

	public Boolean getIsLctxj() {
		return isLctxj;
	}

	public void setIsLctxj(Boolean isLctxj) {
		this.isLctxj = isLctxj;
	}

	public Boolean getIsFttbd() {
		return isFttbd;
	}

	public void setIsFttbd(Boolean isFttbd) {
		this.isFttbd = isFttbd;
	}

	public Boolean getIsLctbd() {
		return isLctbd;
	}

	public void setIsLctbd(Boolean isLctbd) {
		this.isLctbd = isLctbd;
	}

	public Boolean getIsLctft() {
		return isLctft;
	}

	public void setIsLctft(Boolean isLctft) {
		this.isLctft = isLctft;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getXianjinRate() {
		return xianjinRate;
	}

	public void setXianjinRate(BigDecimal xianjinRate) {
		this.xianjinRate = xianjinRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getBaodanRate() {
		return baodanRate;
	}

	public void setBaodanRate(BigDecimal baodanRate) {
		this.baodanRate = baodanRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getFutouRate() {
		return futouRate;
	}

	public void setFutouRate(BigDecimal futouRate) {
		this.futouRate = futouRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getLicaiRate() {
		return licaiRate;
	}

	public void setLicaiRate(BigDecimal licaiRate) {
		this.licaiRate = licaiRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getXjTbdRate() {
		return xjTbdRate;
	}

	public void setXjTbdRate(BigDecimal xjTbdRate) {
		this.xjTbdRate = xjTbdRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getXjTftRate() {
		return xjTftRate;
	}

	public void setXjTftRate(BigDecimal xjTftRate) {
		this.xjTftRate = xjTftRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getXjTlcRate() {
		return xjTlcRate;
	}

	public void setXjTlcRate(BigDecimal xjTlcRate) {
		this.xjTlcRate = xjTlcRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getBdTftRate() {
		return bdTftRate;
	}

	public void setBdTftRate(BigDecimal bdTftRate) {
		this.bdTftRate = bdTftRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getBdTlcRate() {
		return bdTlcRate;
	}

	public void setBdTlcRate(BigDecimal bdTlcRate) {
		this.bdTlcRate = bdTlcRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getBfTliRate() {
		return bfTliRate;
	}

	public void setBfTliRate(BigDecimal bfTliRate) {
		this.bfTliRate = bfTliRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getBdTxjRate() {
		return bdTxjRate;
	}

	public void setBdTxjRate(BigDecimal bdTxjRate) {
		this.bdTxjRate = bdTxjRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getFtTxjRate() {
		return ftTxjRate;
	}

	public void setFtTxjRate(BigDecimal ftTxjRate) {
		this.ftTxjRate = ftTxjRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getLcTxjRate() {
		return lcTxjRate;
	}

	public void setLcTxjRate(BigDecimal lcTxjRate) {
		this.lcTxjRate = lcTxjRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getFtTbdRate() {
		return ftTbdRate;
	}

	public void setFtTbdRate(BigDecimal ftTbdRate) {
		this.ftTbdRate = ftTbdRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getLcTbdRate() {
		return lcTbdRate;
	}

	public void setLcTbdRate(BigDecimal lcTbdRate) {
		this.lcTbdRate = lcTbdRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getLcTftRate() {
		return lcTftRate;
	}

	public void setLcTftRate(BigDecimal lcTftRate) {
		this.lcTftRate = lcTftRate;
	}

	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getManagerBonuds() {
		return managerBonuds;
	}

	public void setManagerBonuds(BigDecimal managerBonuds) {
		this.managerBonuds = managerBonuds;
	}

	
	@Min(0)
	@Digits(integer = 12, fraction = 3)
	@Column(nullable = false, precision = 27, scale = 12)
	public BigDecimal getWithrawMinMoney() {
		return withrawMinMoney;
	}

	public void setWithrawMinMoney(BigDecimal withrawMinMoney) {
		this.withrawMinMoney = withrawMinMoney;
	}

	public String getMemberNumberPrefix() {
		return memberNumberPrefix;
	}

	public void setMemberNumberPrefix(String memberNumberPrefix) {
		this.memberNumberPrefix = memberNumberPrefix;
	}

	@NotNull
	@Min(1)
	public Integer getMemberNumberLength() {
		return memberNumberLength;
	}

	public void setMemberNumberLength(Integer memberNumberLength) {
		this.memberNumberLength = memberNumberLength;
	}

	public BigDecimal getZero() {
		return zero;
	}

	public void setZero(BigDecimal zero) {
		this.zero = zero;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public Boolean getIsWithraw() {
		return isWithraw;
	}

	public void setIsWithraw(Boolean isWithraw) {
		this.isWithraw = isWithraw;
	}
	
	
	
}