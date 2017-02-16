package com.wxc.adplatform.model;

import java.util.Date;

public class BillingRecord2 {
	private int id;
	private int user_id;
	private int ad_id;
	private String open_id;
	private String device_code;
	private String owner;
	private int billing_type;
	private int cost_type;
	private int cost0;
	private int cost1;
	private int cost2;
	private int count0;
	private int count1;
	private int count2;
	private Date billing_time;
	private String billing_date;
	private String wxPublicId;
	
	private String user_name;
	private String ad_name;
	
	
	
	public int getCost0() {
		return cost0;
	}
	public void setCost0(int cost0) {
		this.cost0 = cost0;
	}
	public int getCost1() {
		return cost1;
	}
	public void setCost1(int cost1) {
		this.cost1 = cost1;
	}
	public int getCost2() {
		return cost2;
	}
	public void setCost2(int cost2) {
		this.cost2 = cost2;
	}
	public int getCount0() {
		return count0;
	}
	public void setCount0(int count0) {
		this.count0 = count0;
	}
	public int getCount1() {
		return count1;
	}
	public void setCount1(int count1) {
		this.count1 = count1;
	}
	public int getCount2() {
		return count2;
	}
	public void setCount2(int count2) {
		this.count2 = count2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public String getOpen_id() {
		return open_id;
	}
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}
	public String getDevice_code() {
		return device_code;
	}
	public void setDevice_code(String device_code) {
		this.device_code = device_code;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBilling_type() {
		return billing_type;
	}
	public void setBilling_type(int billing_type) {
		this.billing_type = billing_type;
	}
	public int getCost_type() {
		return cost_type;
	}
	public void setCost_type(int cost_type) {
		this.cost_type = cost_type;
	}
	public Date getBilling_time() {
		return billing_time;
	}
	public void setBilling_time(Date billing_time) {
		this.billing_time = billing_time;
	}
	public String getBilling_date() {
		return billing_date;
	}
	public void setBilling_date(String billing_date) {
		this.billing_date = billing_date;
	}
	public String getWxPublicId() {
		return wxPublicId;
	}
	public void setWxPublicId(String wxPublicId) {
		this.wxPublicId = wxPublicId;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	
//	 `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '费用记录表',
//	  `user_id` int(10) DEFAULT NULL COMMENT '广告主id',
//	  `ad_id` int(15) DEFAULT NULL COMMENT '广告id',
//	  `open_id` varchar(128) DEFAULT NULL COMMENT '用户微信id',
//	  `owner` varchar(255) DEFAULT NULL COMMENT '设备主ID',
//	  `device_code` varchar(255) DEFAULT NULL COMMENT '设备的唯一编号',
//	  `wx_public_id` varchar(255) DEFAULT NULL,
//	  `billing_type` int(1) DEFAULT NULL COMMENT '计费类型 0:扣款 1:增加',
//	  `cost_type` int(1) DEFAULT NULL COMMENT '费用类型 0：点击 1：吸粉 2：广告展示',
//	  `cost` int(20) DEFAULT NULL COMMENT '费用',
//	  `billing_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '记录时间',
//	  `billing_date` varchar(15) DEFAULT NULL COMMENT '时间精确到天',
	
}
