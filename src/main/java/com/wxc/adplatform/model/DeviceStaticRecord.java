package com.wxc.adplatform.model;

public class DeviceStaticRecord {
	private int user_id;
	private String owner;
	private String device_code;
	
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
	public String getDevice_code() {
		return device_code;
	}
	public void setDevice_code(String device_code) {
		this.device_code = device_code;
	}
	
//	  `user_id` int(11) DEFAULT NULL,
//	  `owner` varchar(255) DEFAULT NULL,
//	  `device_code` varchar(32) DEFAULT NULL,
//	  `day` date DEFAULT NULL,
//	  `time` int(2) DEFAULT '0',
//	  `exposure` int(11) DEFAULT '0',
//	  `exposure_income` int(11) DEFAULT '0',
//	  `click` int(11) DEFAULT '0',
//	  `click_income` int(11) DEFAULT '0',
//	  `fans` int(11) DEFAULT '0',
//	  `fans_income` int(11) DEFAULT '0',

	
	
	
}
