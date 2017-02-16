package com.wxc.adplatform.model;

/**
 * 设备广告模板
 * 
 * @author liuhui
 * 
 */
public class DeviceAd {
	/** 机器所绑定的这组广告的ID */
	private Integer id;
	private String devicecode;
	private Integer adId;
	private String area;
	private String tag;
	private Integer quota;
	private Integer createUserId;
	private Integer adScheduleId;
	private Integer charge;
	private Integer adtype;
	//
	private String adUrl;
	
	//APPID
	private String appid;
	
	//条抓你地址
	private String redirectUrl;
	
	

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAdUrl() {
		return adUrl;
	}

	public void setAdUrl(String adUrl) {
		this.adUrl = adUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdtype() {
		return adtype;
	}

	public void setAdtype(Integer adtype) {
		this.adtype = adtype;
	}

	public Integer getCharge() {
		return charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}

	public String getDevicecode() {
		return devicecode;
	}

	public void setDevicecode(String devicecode) {
		this.devicecode = devicecode;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getQuota() {
		return quota;
	}

	public void setQuota(Integer quota) {
		this.quota = quota;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getAdScheduleId() {
		return adScheduleId;
	}

	public void setAdScheduleId(Integer adScheduleId) {
		this.adScheduleId = adScheduleId;
	}

}
