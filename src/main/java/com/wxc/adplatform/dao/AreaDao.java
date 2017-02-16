package com.wxc.adplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxc.adplatform.model.Area;

public interface AreaDao {
	public List<Area> getProvinces();

	public List<Area> getSubAreas(@Param("code") String code, @Param("level") int level);

	public Area getAreaById(@Param("code") String code);

	public String getAreaName(@Param("code") String code, @Param("level") int level);

	// public List<Area> getProvinceCity();

	public List<Area> getCities();

	public String getCodeByCity(String city);

	public String getProvinceCodeByArea(@Param("area") String area);

	public List<Area> getCityCodeListByProvinceCode(@Param("provinceCode") String provinceCode);
	
	public String getProvinceCodeByCityArea(@Param("city_code") String city_code);

}
