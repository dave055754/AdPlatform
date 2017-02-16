package com.wxc.adplatform.model;

import java.util.Date;

public class AccountNums {
	/** 主键ID */
	private Integer id;
	/** 日期 */
	private Date date;
	/** 新增帐号数*/
	private Integer newAccounts;
	/** 无余额帐号数 */
	private Integer noMoneyAccounts;
	/** 少于30元帐号数 */
	private Integer less30Accounts;
	/** 注册帐号数 */
	private Integer registerAccounts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getNewAccounts() {
		return newAccounts;
	}
	public void setNewAccounts(Integer newAccounts) {
		this.newAccounts = newAccounts;
	}
	public Integer getNoMoneyAccounts() {
		return noMoneyAccounts;
	}
	public void setNoMoneyAccounts(Integer noMoneyAccounts) {
		this.noMoneyAccounts = noMoneyAccounts;
	}
	public Integer getLess30Accounts() {
		return less30Accounts;
	}
	public void setLess30Accounts(Integer less30Accounts) {
		this.less30Accounts = less30Accounts;
	}
	public Integer getRegisterAccounts() {
		return registerAccounts;
	}
	public void setRegisterAccounts(Integer registerAccounts) {
		this.registerAccounts = registerAccounts;
	}

	
}
