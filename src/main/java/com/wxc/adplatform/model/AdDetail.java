package com.wxc.adplatform.model;

public class AdDetail {

	private Integer sp_id;
	private Integer sp_price;
	private Integer sp_type_value_id;
	private String sp_type_id;
	private String type_value_text;
	
	private String sex;
	private String area;
	private String industry;

	public String getSp_type_id() {
		return sp_type_id;
	}

	public void setSp_type_id(String sp_type_id) {
		this.sp_type_id = sp_type_id;
	}

	public Integer getSp_type_value_id() {
		return sp_type_value_id;
	}

	public void setSp_type_value_id(Integer sp_type_value_id) {
		this.sp_type_value_id = sp_type_value_id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Integer getSp_id() {
		return sp_id;
	}

	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}

	public Integer getSp_price() {
		return sp_price;
	}

	public void setSp_price(Integer sp_price) {
		this.sp_price = sp_price;
	}

	public String getType_value_text() {
		return type_value_text;
	}

	public void setType_value_text(String type_value_text) {
		this.type_value_text = type_value_text;
	}

}
