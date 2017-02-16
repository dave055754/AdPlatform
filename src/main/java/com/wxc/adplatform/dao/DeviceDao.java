package com.wxc.adplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.Account;
import com.wxc.adplatform.model.AdRecord;
import com.wxc.adplatform.model.CheckFansPrint;
import com.wxc.adplatform.model.Device;
import com.wxc.adplatform.model.DeviceMainWxInfo;
import com.wxc.adplatform.model.DeviceSupport;
import com.wxc.adplatform.model.DeviceV2;
import com.wxc.adplatform.model.Finance;
import com.wxc.adplatform.model.MerchantInfo;
import com.wxc.adplatform.model.PayPrintRecord;
import com.wxc.adplatform.model.WxpublicDeviceBind;

@Repository
public interface DeviceDao {
	List<DeviceSupport> getSupportDeviceModel(
			DeviceSupport.DEVICETYPE deviceType);

	void addWxAction(AdRecord adRecord);

	void updateWxAction(AdRecord adRecord);
	// Device getDeviceInfoById(@Param("deviceId") String deviceId);

	void addScreenAction(List<AdRecord> adRecord);

	void addClickAction(AdRecord adRecord);

	void addDevice(Device device);

	int updateDeviceCity(@Param("deviceCode") String deviceCode,
			@Param("formatted_address") String formatted_address,
			@Param("code") String code);

	void addDeviceAd(@Param("deviceCode") String deviceCode,
			@Param("adId") Integer adId);

	/**查询设备主code计费使用**/
	List<Device> findDeviceOwner(@Param("device_code") String device_code);
	
	
	Device  getDeviceByCode(@Param("code") String code);
	
	Device  getDeviceByDeviceCode(@Param("code") String code);
	
	
	Integer findUserClickRecord(@Param("openId") String openId, @Param("adId") int adId);

	int addUser(@Param("owner") String owner, @Param("userToken") String userToken);

	int getDeviceAdByDate(@Param("adId") Integer adId, @Param("devicecode") String devicecode);

	String getOwnerByDeviceCode(@Param("deviceCode") String deviceCode);

	int setMainWxOrder(@Param("deviceCode") String deviceCode,
			@Param("mainWxOrder") Integer mainWxOrder);

	List<DeviceMainWxInfo> getDeviceMainWxOrderList(@Param("offset") Integer offset, 
			@Param("pageSize") Integer pageSize, @Param("owner") String owner);
	
	void setDeviceMainWxName(@Param("wxName")  String wxName, @Param("deviceCode")  String deviceCode);
	
	DeviceMainWxInfo getDeviceMainWxInfo (@Param("deviceCode")  String deviceCode);

	List<DeviceMainWxInfo> getDeviceYestodayIncome(@Param("owner") String owner);

	void updateDeviceAcceptAdStatus(@Param("deviceCode") String deviceCode,
			@Param("accept_ad_status") Integer accept_ad_status);

	Integer getDeviceAcceptAdStatus(@Param("deviceCode") String deviceCode);

	void deleteAppidofDevice(@Param("deviceCode") String deviceCode);
	
	
	void addDeviceV2(DeviceV2 listDevice);
	
	Integer addDevicePayRecord(Finance finance);
	
	WxpublicDeviceBind findDevicecodeAndAppidBind(@Param("appid") String appid,
			@Param("device_code") String device_code);
	
	void addDevicecodeAndAppidBind(WxpublicDeviceBind wxdevicebind);
	
	Integer addPayPrintRecord(PayPrintRecord finance);

	public Integer getPayPrintRecordCount(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd
			);
	
	
	public List<PayPrintRecord> getPayPrintRecord(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd,
			@Param("begin") int begin,
			@Param("count") int count
			);
	
	void deleteOtherDevice(@Param("deviceCode") String deviceCode);

	List<String> getDeviceByCodeByOwner(@Param("owner") String owner);

	List<PayPrintRecord> getdayBeforeList(@Param("startTime") String startTime,@Param("endTime") String endTime);
	
	Integer getDayofMerchantByCount(@Param("dayTime") String dayTime);
	
	List<MerchantInfo> getDayofMerchant(@Param("dayTime") String dayTime,@Param("begin") int begin,
			@Param("count") int count);
	
	Integer getMerchantListByCount(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd);
	
	List<MerchantInfo> getWeekofMerchant(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd,
			@Param("begin") int begin,
			@Param("count") int count);
	
	List<MerchantInfo> getMonthofMerchant(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd,
			@Param("begin") int begin,
			@Param("count") int count);
	
	Integer getTotalofMerchantByCount();
	
	List<MerchantInfo> getTotalofMerchant(
			@Param("begin") int begin,
			@Param("count") int count);
	
	MerchantInfo getRankMerchant(@Param("merchant_account") String merchant_account);
	
	void addCheckAdRecord(AdRecord adRecord);
	
	Integer getCheckAdRecord(AdRecord adRecord);
	
	Integer getCheckAdRecordCount();
	
	List<AdRecord> getCheckAdRecordList(
			@Param("begin") int begin,
			@Param("count") int count);
	
	void delCheckAdRecord(AdRecord adRecord);
	
	void delCheckAdRecordAll();
	
	public Integer getCheckFansPrintCount(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd
			);
	
	public List<CheckFansPrint> getCheckFansPrintList(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd,
			@Param("begin") int begin,
			@Param("count") int count
			);

	Account getAccountIdByOwner(@Param("owner") String owner);

	void addAccountExtend(
			@Param("account_id") Integer account_id, 
			@Param("owner") String owner, 
			@Param("org_id") String org_id,
			@Param("org_name") String org_name);
	
}
