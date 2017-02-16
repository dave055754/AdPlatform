package com.wxc.adplatform.model;

import java.util.Date;

public class FinanceDayList {
//	  "consumeAmount": 424,
//      "withdrawAmount": 424,
//      "rechargeAmount": 424,
//      "incomeAmount": 424,
//        "day": “2015-06-06”,
//       “create_time”:140526325468
	private int consumeAmount;
	private int withdrawAmount;
	private int rechargeAmount;
	private int incomeAmount;
	private String create_time;
	private Date day;
	
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public int getConsumeAmount() {
		return consumeAmount;
	}
	public void setConsumeAmount(int consumeAmount) {
		this.consumeAmount = consumeAmount;
	}
	public int getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(int withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	public int getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(int rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public int getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(int incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	
	
}
