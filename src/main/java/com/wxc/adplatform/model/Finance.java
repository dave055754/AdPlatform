package com.wxc.adplatform.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Finance {
	private Integer id;
	private Integer userId;
	private Integer amount;
	private String withdraw_reason;
	private String sequence_number;
	private Date create_time;
	private Date update_time;
	private String transaction_id;

	private Integer vertifyed;
	private Integer withdrawed;

	private String public_wx_name;

	private Date day;
	private Integer income_amount;
	private Integer fans;
	private Integer type_wx;

	/** 商家名称 */
	private String realname;

	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public enum TYPE {
		CONSUME, WITHDRAW, RECHARGE, INCOME, HAND_RECHARGE, SJ_INCOME, SBZ_CONSUME, SBZ_INCOME
	};

	private TYPE type;

	public enum WITHDRAWSTATUS {
		FAILED, SUCCESS, WAIT
	};

	private WITHDRAWSTATUS withdraw_status;

	public String getWithdraw_reason() {
		return withdraw_reason;
	}

	public String getSequence_number() {
		return sequence_number;
	}

	public void setSequence_number(String sequence_number) {
		this.sequence_number = sequence_number;
	}

	public void setWithdraw_reason(String withdraw_reason) {
		this.withdraw_reason = withdraw_reason;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public WITHDRAWSTATUS getWithdraw_status() {
		return withdraw_status;
	}

	public void setWithdraw_status(WITHDRAWSTATUS withdraw_status) {
		this.withdraw_status = withdraw_status;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getPublic_wx_name() {
		return public_wx_name;
	}

	public void setPublic_wx_name(String public_wx_name) {
		this.public_wx_name = public_wx_name;
	}

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getVertifyed() {
		return vertifyed;
	}

	public void setVertifyed(Integer vertifyed) {
		this.vertifyed = vertifyed;
	}

	public Integer getWithdrawed() {
		return withdrawed;
	}

	public void setWithdrawed(Integer withdrawed) {
		this.withdrawed = withdrawed;
	}

	public Integer getIncome_amount() {
		return income_amount;
	}

	public void setIncome_amount(Integer income_amount) {
		this.income_amount = income_amount;
	}

	public Integer getFans() {
		return fans;
	}

	public void setFans(Integer fans) {
		this.fans = fans;
	}

	public Integer getType_wx() {
		return type_wx;
	}

	public void setType_wx(Integer type_wx) {
		this.type_wx = type_wx;
	}

}
