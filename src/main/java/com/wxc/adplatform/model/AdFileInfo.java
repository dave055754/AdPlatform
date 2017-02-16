package com.wxc.adplatform.model;

import java.util.Date;

public class AdFileInfo {
	
	private int id;
	private int user_id;
	private String owner;
	private String device_code;
	
	private Date action_time;
	private ADTYPE ad_type;
	
	public enum ADTYPE{
		PRINT, CLICK, EXPOSURE
	};
	
	private int ad_id;
	private int schedule_id;
	private String wx_public_id;
	private int count;
	
	private String industry;
	private String wx_user_id;
	private int sex;
	private String province;
	private String city;
	private String ostype;
	
	//0，不扣费，1是扣费
	private int billingType;
	
	private int price_ad;
	private int price_device;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getDevice_code() {
		return device_code;
	}
	public void setDevice_code(String device_code) {
		this.device_code = device_code;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getAction_time() {
		return action_time;
	}
	public void setAction_time(Date action_time) {
		this.action_time = action_time;
	}
	
	
	public String getWx_public_id() {
		return wx_public_id;
	}
	public void setWx_public_id(String wx_public_id) {
		this.wx_public_id = wx_public_id;
	}
	public ADTYPE getAd_type() {
		return ad_type;
	}
	public void setAd_type(ADTYPE ad_type) {
		this.ad_type = ad_type;
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getWx_user_id() {
		return wx_user_id;
	}
	public void setWx_user_id(String wx_user_id) {
		this.wx_user_id = wx_user_id;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getOstype() {
		return ostype;
	}
	public void setOstype(String ostype) {
		this.ostype = ostype;
	}
	public int getBillingType() {
		return billingType;
	}
	public void setBillingType(int billingType) {
		this.billingType = billingType;
	}
	public int getPrice_ad() {
		return price_ad;
	}
	public void setPrice_ad(int price_ad) {
		this.price_ad = price_ad;
	}
	public int getPrice_device() {
		return price_device;
	}
	public void setPrice_device(int price_device) {
		this.price_device = price_device;
	}
	
	
}
