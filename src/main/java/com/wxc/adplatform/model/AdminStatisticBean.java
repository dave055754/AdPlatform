package com.wxc.adplatform.model;

import java.util.Date;

public class AdminStatisticBean {
	private int print;
	private int exposure;
	private int click;
	private Date day;
	
	public int getExposure() {
		return exposure;
	}
	public void setExposure(int exposure) {
		this.exposure = exposure;
	}
	public int getPrint() {
		return print;
	}
	public void setPrint(int print) {
		this.print = print;
	}
	
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
      
	
	
}
