package com.wxc.adplatform.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckDao {
	
    //////////////收入
	public Integer findRecordDevicePrice(
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	
	public Integer findDeviceWxIncome(@Param("day") String day );
	public Integer findDeviceIncome(@Param("day") String day );
	public Integer findFinanceIncome(	
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);

	
	//////////////支出
	public Integer findRecordPrice(
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	
	public Integer findActionStatisticCost(@Param("day") String day );
	public Integer findFinanceConsume(	
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
}
