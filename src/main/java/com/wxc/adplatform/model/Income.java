package com.wxc.adplatform.model;

import java.util.Date;

public class Income  {
	private Date day;
	private Date create_time;
	private Integer income;
	private Integer id;
//	"id": 262,           
//    "day": “2016-07-05”,
//    "income": 111,
//    "create_time": “2016-07-05 15:21:20”
	
	
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Integer getIncome() {
		return income;
	}
	public void setIncome(Integer income) {
		this.income = income;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
