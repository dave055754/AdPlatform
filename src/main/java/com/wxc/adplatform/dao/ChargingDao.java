package com.wxc.adplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.BillingRecord;

@Repository
public interface ChargingDao {

	/** 判断按次扣费记录是否已存在，避免多次扣费 **/
	public Integer isExistChargingByDate(@Param("open_id") String open_id, @Param("device_code") String device_code,
			@Param("billing_date") String billing_date, @Param("costType")int  costType);
	
	public Integer isExistCharging(@Param("open_id") String open_id, @Param("device_code") String device_code,
			 @Param("costType")int  costType);
	
	public Integer isExistClickCharging(@Param("open_id") String open_id, @Param("ad_id") int ad_id);
	
	public Integer isExistExposureCharging(@Param("open_id") String open_id, @Param("ad_id") int ad_id);
	
	public Integer isExistPrintCharging(@Param("open_id") String open_id, @Param("wx_public_id") String public_id);

	/**
	 * 保存费用记录 
	 * @param billingRecord
	 */
	public void addCharging(BillingRecord billingRecord);
	
	public String getDeviceCityCode(@Param("device_code") String device_code);
	
	public List<BillingRecord> findClickBillingRecordByAdRecord(@Param("open_id") String open_id,
				@Param("wx_public_id") String public_id);
}
