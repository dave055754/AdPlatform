package com.wxc.adplatform.model;

public class Device {
	public enum DEVICETYPE {
		WXPRINT,ZHI
	}

	private int deviceId;
	private DEVICETYPE deviceType;
	private String deviceName;
	private String deviceModel;
	private String deviceLoc;
	private String deviceIndustry;
	private String device_code;
	
	public String getDevice_code() {
		return device_code;
	}
	public void setDevice_code(String device_code) {
		this.device_code = device_code;
	}

	/*
	 * 设备后台参数
	 */
	/** 设备类型 */
	private String deviceTypeId;
	/** 设备主编号 */
	private String devicecode;
	/** 设备地理位置 纬度 */
	private String lat;
	/** 设备地理位置 经度 */
	private String lng;
	/** 设备所用语言：zh_CN:简体中文；en_US：英文； */
	private String locale;
	/** 设备屏幕尺寸：07:7寸；22:22寸；42:42寸； */
	private String monitorType;
	/** 设备所有者，orgcode加密后的值 */
	private String owner;
	/** 设备所处店的业务 例如餐饮 */
	private String shopBusiness;
	/** 设备所处的店的业务具体小类 */
	private String shopType;
	/** 广告模板类型 */
	private String templateType;
	/** 设备主登录账号 */
	private String orgName;
	
	
	//城市的city
	private String deviceCity;
	private String deviceProvince;
	
	

	
	
	public String getDeviceProvince() {
		return deviceProvince;
	}
	public void setDeviceProvince(String deviceProvince) {
		this.deviceProvince = deviceProvince;
	}
	public String getDeviceCity() {
		return deviceCity;
	}
	public void setDeviceCity(String deviceCity) {
		this.deviceCity = deviceCity;
	}
	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public DEVICETYPE getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DEVICETYPE deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceLoc() {
		return deviceLoc;
	}

	public void setDeviceLoc(String deviceLoc) {
		this.deviceLoc = deviceLoc;
	}

	public String getDeviceIndustry() {
		return deviceIndustry;
	}

	public void setDeviceIndustry(String deviceIndustry) {
		this.deviceIndustry = deviceIndustry;
	}

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getDevicecode() {
		return devicecode;
	}

	public void setDevicecode(String devicecode) {
		this.devicecode = devicecode;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getMonitorType() {
		return monitorType;
	}

	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getShopBusiness() {
		return shopBusiness;
	}

	public void setShopBusiness(String shopBusiness) {
		this.shopBusiness = shopBusiness;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
