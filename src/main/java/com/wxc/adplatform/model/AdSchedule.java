package com.wxc.adplatform.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdSchedule {
	/** 主键ID */
	private Integer id;
	/** 广告名称 */
	private String name;
	/** 广告计划限额 */
	private Integer quota;
	/** 广告曝光量 */
	private Integer exposure;
	/** 广告点击量 */
	private Integer click;
	/** 广告花费 */
	private Integer cost;
	/** 广告打印量 */
	private Integer print;
	/** 广告状态 */
	private Integer adflag;
	/** 广告计划开关 */
	private Integer onoff;
	/** 充值金额 */
	private Integer amount;
	/** 创建者 */
	private Integer createUserId;
	/** 更新者 */
	private Integer updateUserId;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;

	private int charge_plus;
	private int click_plus;
	private int print_plus;

	public int getCharge_plus() {
		return charge_plus;
	}

	public void setCharge_plus(int charge_plus) {
		this.charge_plus = charge_plus;
	}

	public int getClick_plus() {
		return click_plus;
	}

	public void setClick_plus(int click_plus) {
		this.click_plus = click_plus;
	}

	public int getPrint_plus() {
		return print_plus;
	}

	public void setPrint_plus(int print_plus) {
		this.print_plus = print_plus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuota() {
		return quota;
	}

	public void setQuota(Integer quota) {
		this.quota = quota;
	}

	public Integer getExposure() {
		return exposure;
	}

	public void setExposure(Integer exposure) {
		this.exposure = exposure;
	}

	public Integer getClick() {
		return click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getPrint() {
		return print;
	}

	public void setPrint(Integer print) {
		this.print = print;
	}

	public Integer getAdflag() {
		return adflag;
	}

	public void setAdflag(Integer adflag) {
		this.adflag = adflag;
	}

	public Integer getOnoff() {
		return onoff;
	}

	public void setOnoff(Integer onoff) {
		this.onoff = onoff;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
