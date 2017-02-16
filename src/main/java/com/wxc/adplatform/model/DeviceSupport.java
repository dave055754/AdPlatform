package com.wxc.adplatform.model;

public class DeviceSupport {
	private int id;
	public enum DEVICETYPE{
		WXPRINT
	};
	private DEVICETYPE deviceType;
	private String deviceModel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DEVICETYPE getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(DEVICETYPE deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	
	
	
}
