package com.wxc.adplatform.model;

/**
 * 设备主收入
 * 
 * @author liuhui
 *
 */
public class DeviceIncome {

	/** 微信吸粉收入 */
	private Double clickIncome;
	/** 品牌banner收入 */
	private Double fansIncome;

	public Double getClickIncome() {
		return clickIncome;
	}

	public void setClickIncome(Double clickIncome) {
		this.clickIncome = clickIncome;
	}

	public Double getFansIncome() {
		return fansIncome;
	}

	public void setFansIncome(Double fansIncome) {
		this.fansIncome = fansIncome;
	}

}
