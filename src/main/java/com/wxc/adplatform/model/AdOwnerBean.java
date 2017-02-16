package com.wxc.adplatform.model;

import java.util.Date;

public class AdOwnerBean {
	private String owner;
	private int ad_id;
	private int people_count;
	private String action;
	private int price_device_amount;
	private int amount;
	private Date day;
	
//	 `ad_id` int(11) DEFAULT NULL COMMENT '广告id',
//	  `owner` varchar(64) DEFAULT NULL COMMENT '设备主',
//	  `people_count` int(11) DEFAULT '0' COMMENT '粉丝数量',
//	  `action` enum('PRINT','CLICK','EXPOSURE') DEFAULT 'EXPOSURE' COMMENT '广告发生的动作：打印，点击，曝光',
//	  `price_device_amount` int(11) DEFAULT '0' COMMENT '设备主分润金额',
//	  `amount` int(11) DEFAULT '0' COMMENT '金额',
//	  `day` date DEFAULT NULL COMMENT '日期',
	  

	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public int getPeople_count() {
		return people_count;
	}
	public void setPeople_count(int people_count) {
		this.people_count = people_count;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getPrice_device_amount() {
		return price_device_amount;
	}
	public void setPrice_device_amount(int price_device_amount) {
		this.price_device_amount = price_device_amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
	
}
