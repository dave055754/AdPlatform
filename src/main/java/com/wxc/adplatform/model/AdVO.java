package com.wxc.adplatform.model;

import java.util.Date;

public class AdVO extends Ad {
	/** 搜索条件：创建时间，开始 */
	private Date startCreateTime;
	/** 搜索条件：创建时间，结束 */
	private Date endCreateTime;
	private String wxName;
	private String wxDesc;
	private String wxAppid;
	private String wxLogo;
	private String wxQrcode;
	private String wxUrl;
	private String wxDetailUrl;
	private String wxFollowUrl;
	private String wxArticleUrl;
	private String userId;
	
	private Integer exposure;
	private Integer cost;
	private Integer adcount;
	private Integer print;
	private Integer phoneExposure;
	private Integer click;
	
	/** 已发布广告（投放中） */
	private Integer published;
	/** 待审核广告 */
	private Integer unchecked;
	/** 审核未通过广告 */
	private Integer unpassed;
	
	private Integer clickCount;
	private Integer exposureCount;
	private Integer printCount;
	private Integer costCount;
	
	
	private long cacheTime;
	private String realname;
	
	
	// t_user_action_statistic

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public long getCacheTime() {
		return cacheTime;
	}

	public void setCacheTime(long cacheTime) {
		this.cacheTime = cacheTime;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public String getWxDetailUrl() {
		return wxDetailUrl;
	}

	public void setWxDetailUrl(String wxDetailUrl) {
		this.wxDetailUrl = wxDetailUrl;
	}

	public String getWxFollowUrl() {
		return wxFollowUrl;
	}

	public void setWxFollowUrl(String wxFollowUrl) {
		this.wxFollowUrl = wxFollowUrl;
	}

	public String getWxArticleUrl() {
		return wxArticleUrl;
	}

	public void setWxArticleUrl(String wxArticleUrl) {
		this.wxArticleUrl = wxArticleUrl;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public Integer getExposureCount() {
		return exposureCount;
	}

	public void setExposureCount(Integer exposureCount) {
		this.exposureCount = exposureCount;
	}

	public Integer getPrintCount() {
		return printCount;
	}

	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}

	public Integer getCostCount() {
		return costCount;
	}

	public void setCostCount(Integer costCount) {
		this.costCount = costCount;
	}

	public Date getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public String getWxUrl() {
		return wxUrl;
	}

	public void setWxUrl(String wxUrl) {
		this.wxUrl = wxUrl;
	}

	public String getWxName() {
		return wxName;
	}

	public void setWxName(String wxName) {
		this.wxName = wxName;
	}

	public String getWxDesc() {
		return wxDesc;
	}

	public void setWxDesc(String wxDesc) {
		this.wxDesc = wxDesc;
	}

	public String getWxAppid() {
		return wxAppid;
	}

	public void setWxAppid(String wxAppid) {
		this.wxAppid = wxAppid;
	}

	public String getWxLogo() {
		return wxLogo;
	}

	public void setWxLogo(String wxLogo) {
		this.wxLogo = wxLogo;
	}

	public String getWxQrcode() {
		return wxQrcode;
	}

	public void setWxQrcode(String wxQrcode) {
		this.wxQrcode = wxQrcode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getExposure() {
		return exposure;
	}

	public void setExposure(Integer exposure) {
		this.exposure = exposure;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getAdcount() {
		return adcount;
	}

	public void setAdcount(Integer adcount) {
		this.adcount = adcount;
	}

	public Integer getPrint() {
		return print;
	}

	public void setPrint(Integer print) {
		this.print = print;
	}

	public Integer getPhoneExposure() {
		return phoneExposure;
	}

	public void setPhoneExposure(Integer phoneExposure) {
		this.phoneExposure = phoneExposure;
	}

	public Integer getClick() {
		return click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	public Integer getPublished() {
		return published;
	}

	public void setPublished(Integer published) {
		this.published = published;
	}

	public Integer getUnchecked() {
		return unchecked;
	}

	public void setUnchecked(Integer unchecked) {
		this.unchecked = unchecked;
	}

	public Integer getUnpassed() {
		return unpassed;
	}

	public void setUnpassed(Integer unpassed) {
		this.unpassed = unpassed;
	}

}
