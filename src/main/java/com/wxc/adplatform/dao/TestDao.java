package com.wxc.adplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.Custom;
import com.wxc.adplatform.model.DeviceAd;
import com.wxc.adplatform.model.Withdraw;
import com.wxc.adplatform.model.WxPublic;

@Repository
public interface TestDao {

	void addAccountExtend(@Param(value = "account_id") Integer account_id, @Param(value = "owner") String owner,
			@Param(value = "org_id") String org_id, @Param(value = "org_name") String org_name);

	Custom getCustom(@Param(value = "owner") String owner);

	String getOrgid(@Param(value = "org_id") String org_id);

	String getOwnerByDevicecode(@Param(value = "devicecode") String devicecode);

	Integer getScheduleIdByAdname(@Param(value = "adname") String adname);

	Integer getCostByScheduleId(@Param(value = "scheduleId") Integer scheduleId);

	Integer updatePrintPlus(@Param(value = "cost") Integer cost, @Param(value = "scheduleId") Integer scheduleId);

	Integer getQuota(@Param(value = "scheduleId") Integer scheduleId);

	Integer updateAdflag(@Param(value = "adflag") Integer adflag, @Param(value = "scheduleId") Integer scheduleId);

	Integer getPrintPlus(@Param(value = "scheduleId") Integer scheduleId);

	String getCityByArea(@Param(value = "area") String area);

	List<DeviceAd> getSuitableWxAd();

	void updateFinanceByTime(@Param(value = "start_date") String sdate1,@Param(value = "end_date")  String sdate2,
			@Param(value = "userId") int userId);

	List<Withdraw> getAllWithdrawList();

	void updateWithdrawedToZero();

	public List<WxPublic> getWxPublics();

	public void updateWxFollowUrl(
			@Param("wxFollowUrl") String wxFollowUrl,
			@Param("wxAppid") String wxAppid);

}
