package com.wxc.adplatform.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 数据库表对应实体
 * 
 * @author Administrator
 *
 */
public class MerchantInfoRecord {

	// 商家账号
	private String merchant_account;
	private String device_code;
	private String user_id;
	private int finance_id;
	private String owner;
	public int getFinance_id() {
		return finance_id;
	}

	public void setFinance_id(int finance_id) {
		this.finance_id = finance_id;
	}

	// 打印次数
	private int count;
	// 打印花费
	private int amount;

	private Date create_time;

	private Date statistics_time;

	public String getMerchantAccount() {
		return merchant_account;
	}

	public void setMerchantAccount(String merchantAccount) {
		this.merchant_account = merchantAccount;
	}

	public String getDevice_code() {
		return device_code;
	}

	public void setDevice_code(String device_code) {
		this.device_code = device_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getStatistics_time() {
		return statistics_time;
	}

	public void setStatistics_time(Date statistics_time) {
		this.statistics_time = statistics_time;
	}
}
