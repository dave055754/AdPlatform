package com.wxc.adplatform.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 用户注册信息<br>
 * @version 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Custom
{
	/** 用户id */
	private int id;
	
	/** 用户手机号 */
	private String phoneNumber;
	/** user_name用户手机号 */
	private String user_name;
	
	/** 用户邮箱 */
	private String email;
	
	/** 用户唯一标识 */
	private String userToken;
	
	/** 用户密码 */
	private String password;
	/** 用户密码 */
	private String newPassword;
	/** 用户头像URL */
	private String headImageUrl;
	
	/** 用户注册时间 */
	private Date registTime;
	private Date regist_time;
	
	private String nickName;
	/** 真实姓名 */
	private String realname;
	
	private String sj_owner;
	
	public String getSj_owner() {
		return sj_owner;
	}

	public void setSj_owner(String sj_owner) {
		this.sj_owner = sj_owner;
	}

	/**
	 * MERCHENT 设备主
	 * AD 广告主
	 * SJ 商家
	 * @author Administrator
	 *
	 */
	public enum ROLE{
		MERCHENT,AD,SJ
	};
	
	private ROLE role;
	
	public enum ADMINROLE{
		ADMIN,USER
	};
	private ADMINROLE adminRole;
	
	public enum USERTYPE{
		WXC,WEB
	};
	
	private USERTYPE userType;
	private int status;
	private String accessToken;
	private int balance;
	private int yesterdayCost;
	private String thirdAccount;
	private String thirdAccountOrg;
	private int recharge_count;
	
	
	
	
	
	
	
	
	
	/** 用户在线广告数 */
	private Integer userOnlineAdCount;
	
	public Integer getUserOnlineAdCount() {
		return userOnlineAdCount;
	}

	public void setUserOnlineAdCount(Integer userOnlineAdCount) {
		this.userOnlineAdCount = userOnlineAdCount;
	}

	public Date getRegist_time() {
		return regist_time;
	}

	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getRecharge_count() {
		return recharge_count;
	}

	public void setRecharge_count(int recharge_count) {
		this.recharge_count = recharge_count;
	}

	public String getThirdAccountOrg() {
		return thirdAccountOrg;
	}

	public void setThirdAccountOrg(String thirdAccountOrg) {
		this.thirdAccountOrg = thirdAccountOrg;
	}

	public ROLE getRole() {
		return role;
	}

	public void setRole(ROLE role) {
		this.role = role;
	}

	public ADMINROLE getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(ADMINROLE adminRole) {
		this.adminRole = adminRole;
	}

	public USERTYPE getUserType() {
		return userType;
	}

	public void setUserType(USERTYPE userType) {
		this.userType = userType;
	}

	public int getYesterdayCost() {
		return yesterdayCost;
	}

	public void setYesterdayCost(int yesterdayCost) {
		this.yesterdayCost = yesterdayCost;
	}

	public String getThirdAccount() {
		return thirdAccount;
	}

	public void setThirdAccount(String thirdAccount) {
		this.thirdAccount = thirdAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getHeadImageUrl() {
		return headImageUrl;
	}

	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}



	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getRegistTime()
	{
		return registTime;
	}

	public void setRegistTime(Date registTime)
	{
		this.registTime = registTime;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

}
