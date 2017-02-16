package com.wxc.adplatform.model;

/**
 * 分润列表model
 *
 */
public class FeeSlipt {
	/** id */
	private Integer id;
	/** 广告id */
	private Integer adid;
	/** 公众号名称 */
	private String adname;
	/** 业务类型 */
	private Integer adtype;
	/** 设备主数量 */
	private Integer ownerAmount;
	/** 分润金额 */
	private Integer feeSliptAmount;
	/** 指标（打印量） */
	private Integer printAmount;
	private String day;
	/** 广告主id */
	private Integer adser;
	/** 设备主 */
	private String owner;
	/** 设备主账号 */
	private String orgid;
	/** 设备主名称 */
	private String orgname;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public Integer getAdser() {
		return adser;
	}

	public void setAdser(Integer adser) {
		this.adser = adser;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getAdid() {
		return adid;
	}

	public void setAdid(Integer adid) {
		this.adid = adid;
	}

	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	public Integer getAdtype() {
		return adtype;
	}

	public void setAdtype(Integer adtype) {
		this.adtype = adtype;
	}

	public Integer getOwnerAmount() {
		return ownerAmount;
	}

	public void setOwnerAmount(Integer ownerAmount) {
		this.ownerAmount = ownerAmount;
	}

	public Integer getFeeSliptAmount() {
		return feeSliptAmount;
	}

	public void setFeeSliptAmount(Integer feeSliptAmount) {
		this.feeSliptAmount = feeSliptAmount;
	}

	public Integer getPrintAmount() {
		return printAmount;
	}

	public void setPrintAmount(Integer printAmount) {
		this.printAmount = printAmount;
	}

}
