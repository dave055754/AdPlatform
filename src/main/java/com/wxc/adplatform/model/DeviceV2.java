package com.wxc.adplatform.model;

import java.util.Date;

public class DeviceV2 {
	private int id;
	private String deviceCode;
	private String uuid;
	private String deviceModel;
	private int ownerType;
	private int isOnline;
	private int isOwner;
	private int ownerId;
	private String imei;
	private String sysVersion;
	private String appVersion;
	private String address;
	private String addressCode;
	private int sex;
	private int locationRoom;
	private String longitude;
	private String latitude;
	private Date updateTime;
	private Date createTime;
	private int paperNum;
	private Date supdateTime;
	private int batery;
	
	
	
	
	public int getBatery() {
		return batery;
	}
	public void setBatery(int batery) {
		this.batery = batery;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getPaperNum() {
		return paperNum;
	}
	public void setPaperNum(int paperNum) {
		this.paperNum = paperNum;
	}
	public Date getSupdateTime() {
		return supdateTime;
	}
	public void setSupdateTime(Date supdateTime) {
		this.supdateTime = supdateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public int getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(int ownerType) {
		this.ownerType = ownerType;
	}
	public int getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}
	public int getIsOwner() {
		return isOwner;
	}
	public void setIsOwner(int isOwner) {
		this.isOwner = isOwner;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getSysVersion() {
		return sysVersion;
	}
	public void setSysVersion(String sysVersion) {
		this.sysVersion = sysVersion;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getLocationRoom() {
		return locationRoom;
	}
	public void setLocationRoom(int locationRoom) {
		this.locationRoom = locationRoom;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	public Device DeviceV2toAdDevice(){
		Device device = new Device();
		device.setDevice_code(deviceCode);
		//device.setDeviceCity(deviceCity);
		device.setDevicecode(deviceCode);
		//device.setDeviceIndustry(deviceIndustry);
		device.setDeviceLoc(address);
		device.setDeviceModel(deviceModel);
		//device.setDeviceName(deviceName);
		device.setDeviceType(Device.DEVICETYPE.ZHI);
		device.setLat(latitude);
		device.setLng(longitude);
		//device.setLocale(locale);
		//device.setMonitorType(monitorType);
		device.setOwner(""+ownerId);
		//device.setShopBusiness(shopBusiness);
		//device.setTemplateType(templateType);
		
		return device;
	}
	
	
}
