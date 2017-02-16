package com.wxc.adplatform.model;

import java.util.Date;

public class AdScheduleVO extends AdSchedule {
	/** 搜索条件：创建时间，开始 */
	private Date startCreateTime;
	/** 搜索条件：创建时间，结束 */
	private Date endCreateTime;
	
	private Integer clickCount;
	private Integer exposureCount;
	private Integer printCount;
	private Integer costCount;

	public Integer getClickCount() {
		return clickCount;
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
}
