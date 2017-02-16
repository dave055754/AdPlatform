package com.wxc.adplatform.model;

/**
 * 设备的详细地址和城市编码
 * 
 * @author liuhui
 *
 */
public class DeviceAddress {
	private String formatted_address;
	private String city;

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
