package com.wxc.adplatform.model;

import java.util.List;

public class AdDimensionList {

	private List<SpTypeValue> os;
	private List<SpTypeValue> sex;
	private List<SpTypeValue> areacity;
	private List<SpTypeValue> deviceScene;

	public List<SpTypeValue> getOs() {
		return os;
	}

	public void setOs(List<SpTypeValue> os) {
		this.os = os;
	}

	public List<SpTypeValue> getSex() {
		return sex;
	}

	public void setSex(List<SpTypeValue> sex) {
		this.sex = sex;
	}

	public List<SpTypeValue> getAreacity() {
		return areacity;
	}

	public void setAreacity(List<SpTypeValue> areacity) {
		this.areacity = areacity;
	}

	public List<SpTypeValue> getDeviceScene() {
		return deviceScene;
	}

	public void setDeviceScene(List<SpTypeValue> deviceScene) {
		this.deviceScene = deviceScene;
	}

}
