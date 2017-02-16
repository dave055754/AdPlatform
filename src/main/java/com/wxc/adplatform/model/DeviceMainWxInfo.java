package com.wxc.adplatform.model;

public class DeviceMainWxInfo {
	private String device_name;
	private String device_loc;
	private String device_code;
	private Integer main_wx_order;
	private String main_wx_name;
	private Integer device_yestoday_income;
	private String accept_ad_status;

	public String getAccept_ad_status() {
		return accept_ad_status;
	}

	public void setAccept_ad_status(String accept_ad_status) {
		this.accept_ad_status = accept_ad_status;
	}

	public Integer getMain_wx_order() {
		return main_wx_order;
	}

	public void setMain_wx_order(Integer main_wx_order) {
		this.main_wx_order = main_wx_order;
	}

	public Integer getDevice_yestoday_income() {
		return device_yestoday_income;
	}

	public void setDevice_yestoday_income(Integer device_yestoday_income) {
		this.device_yestoday_income = device_yestoday_income;
	}

	public String getDevice_loc() {
		return device_loc;
	}

	public void setDevice_loc(String device_loc) {
		this.device_loc = device_loc;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getDevice_code() {
		return device_code;
	}

	public void setDevice_code(String device_code) {
		this.device_code = device_code;
	}

	public String getMain_wx_name() {
		return main_wx_name;
	}

	public void setMain_wx_name(String main_wx_name) {
		this.main_wx_name = main_wx_name;
	}

}
