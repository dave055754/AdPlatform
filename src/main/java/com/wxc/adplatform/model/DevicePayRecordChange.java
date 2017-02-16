package com.wxc.adplatform.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DevicePayRecordChange {
	private String orderId;
	private String deviceId;
	private String owner;
	private String owner_org;
	private int money;
	private Date time;
	private String wxUserId;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getOwner_org() {
		return owner_org;
	}
	public void setOwner_org(String owner_org) {
		this.owner_org = owner_org;
	}
	public String getWxUserId() {
		return wxUserId;
	}
	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
}
