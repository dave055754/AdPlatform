package com.wxc.adplatform.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SJDao {
	
	public Integer findUserId(@Param("accountOrg") String accountOrg);
	
//	public Integer findFeeAmount(@Param("accountOrg") String accountOrg);
	
	public Integer findSJIncome(@Param("userId") String userId,
			@Param("start_date") String start_date,
			@Param("end_date") String end_date
			 );
	
	public Integer findWithdraw(@Param("userId") String userId,
			@Param("start_date") String start_date,
			@Param("end_date") String end_date);
	
	public void updateOwner(@Param("owner1") String owner1,@Param("owner2") String owner2);
	
	public String getRecordActionTime(@Param("owner") String owner);
	
	
	public Integer getJiageId(@Param("wxName") String wxName);
	
	public void updateRecordJiageById(@Param("adId") int adId);
	
	public void updateJiageById(@Param("adId") int adId);
	
}
