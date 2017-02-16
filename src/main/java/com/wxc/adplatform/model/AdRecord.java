package com.wxc.adplatform.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdRecord {
	private int id;
	private int adId;
	private String deviceId;
	private String wxUserId;
	private String wxPublicId;
	private int count;
	private String owner;
	private int charge;
	private int price;
	private int price_device;
	private int billingId;
	private int billingIdDevice;
	

	//计算单价使用
	private String spArea;
	private int spSex;
	//行业
	private String spIndustry;
	private String os;
	private ACTION action;
	private Date actionTime;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBillingId() {
		return billingId;
	}
	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}
	public int getBillingIdDevice() {
		return billingIdDevice;
	}
	public void setBillingIdDevice(int billingIdDevice) {
		this.billingIdDevice = billingIdDevice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice_device() {
		return price_device;
	}
	public void setPrice_device(int price_device) {
		this.price_device = price_device;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public enum ACTION{
		PRINT, CLICK, EXPOSURE
	}

	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getSpArea() {
		return spArea;
	}
	public void setSpArea(String spArea) {
		this.spArea = spArea;
	}

	
	public int getSpSex() {

		return spSex;
	}
	public void setSpSex(int spSex) {
		this.spSex = spSex;
	}
	public String getSpIndustry() {
		return spIndustry;
	}
	public void setSpIndustry(String spIndustry) {
		this.spIndustry = spIndustry;
	}
	
	
	
	public String getWxPublicId() {
		return wxPublicId;
	}
	public void setWxPublicId(String wxPublicId) {
		this.wxPublicId = wxPublicId;
	}
	public int getAdId() {
		return adId;
	}
	public void setAdId(int adId) {
		this.adId = adId;
	}
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getWxUserId() {
		return wxUserId;
	}
	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ACTION getAction() {
		return action;
	}
	public void setAction(ACTION action) {
		this.action = action;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getActionTime() {
		return actionTime;
	}
	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}
	
	
	
}
