package com.wxc.adplatform.model;

import java.util.List;

public class ListSp {
	private Integer sp_id;
	private Integer sp_price;
	private Integer sp_price_fake;
	private Integer sp_price_device;
	private String ad_type;
	private Integer ad_id;
	public List<ListSpValue> listSpValue;

	public Integer getSp_price_device() {
		return sp_price_device;
	}

	public void setSp_price_device(Integer sp_price_device) {
		this.sp_price_device = sp_price_device;
	}

	public Integer getSp_id() {
		return sp_id;
	}

	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}

	public Integer getSp_price() {
		return sp_price;
	}

	public void setSp_price(Integer sp_price) {
		this.sp_price = sp_price;
	}

	public Integer getSp_price_fake() {
		return sp_price_fake;
	}

	public void setSp_price_fake(Integer sp_price_fake) {
		this.sp_price_fake = sp_price_fake;
	}

	public String getAd_type() {
		return ad_type;
	}

	public void setAd_type(String ad_type) {
		this.ad_type = ad_type;
	}

	public Integer getAd_id() {
		return ad_id;
	}

	public void setAd_id(Integer ad_id) {
		this.ad_id = ad_id;
	}

	public List<ListSpValue> getListSpValue() {
		return listSpValue;
	}

	public void setListSpValue(List<ListSpValue> listSpValue) {
		this.listSpValue = listSpValue;
	}

}