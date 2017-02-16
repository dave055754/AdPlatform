package com.wxc.adplatform.model;

public class CheckFansPrint {
	private String deviceId;
	private String wxUserId;
	private String wxPublicId;
	private String owner;
	private String actionTime;

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

	public String getWxPublicId() {
		return wxPublicId;
	}

	public void setWxPublicId(String wxPublicId) {
		this.wxPublicId = wxPublicId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

}
