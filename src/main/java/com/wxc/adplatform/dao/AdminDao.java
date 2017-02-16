package com.wxc.adplatform.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.AdOwnerBean;
import com.wxc.adplatform.model.AdRecord;
import com.wxc.adplatform.model.AdVO;
import com.wxc.adplatform.model.AdminStatisticBean;
import com.wxc.adplatform.model.AdminSumStatisticBean;
import com.wxc.adplatform.model.BillingRecord2;
import com.wxc.adplatform.model.Custom;
import com.wxc.adplatform.model.DeviceStaticRecord;
import com.wxc.adplatform.model.FeeSlipt;
import com.wxc.adplatform.model.Finance;
import com.wxc.adplatform.model.FinanceDayList;
import com.wxc.adplatform.model.ProvinceBean;
import com.wxc.adplatform.model.StaticOwnerAdIncome;
import com.wxc.adplatform.model.StaticRecord;
import com.wxc.adplatform.model.StaticYesterdayHour;
import com.wxc.adplatform.model.StaticYesterdayHourDevice;
import com.wxc.adplatform.model.StaticYesterdayHourWX;
import com.wxc.adplatform.model.TopStatistic;
import com.wxc.adplatform.model.YesterdayIncome;
import com.wxc.adplatform.model.YesterdayList;

@Repository
public interface AdminDao {

	public List<BillingRecord2> consumeList(
			@Param(value = "startDate") String startDate, 
			@Param(value = "endDate") String endDate,
			@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize);
	
	public List<Map<String, Object>>  countConsumeList(
			@Param(value = "startDate") String startDate, 
			@Param(value = "endDate") String endDate);
	
	public List<Map<String, Object>> findFinanceDetails(
			@Param("offset") Integer offset,
			@Param("type") String type,
			@Param("pageSize") Integer pageSize,
			@Param("startDate") String startDate,
			@Param("endDate") String endDate );
	
	public List<FinanceDayList> findFinanceDayList(
			@Param(value = "startDate") String startDate, 
			@Param(value = "endDate") String endDate);
	
	public Integer findDayAmount(	@Param("type")  String type,@Param("dayBefore") int dayBefore);
	public void insertDayList(@Param(value = "yesterdayAmout") YesterdayList yesterdayAmout);
	public void delDayList(@Param(value = "yesterdayAmout") YesterdayList yesterdayAmout);

	public Integer countDetails(
			@Param("type") String type,
			@Param(value = "startDate") String startDate, 
			@Param(value = "endDate") String endDate);

	public Integer findNewAccounts();	

	public Integer findRegisterAccounts();

	public Integer findLess30Accounts();

	public Integer findNoMoneyAccounts();

	/**
	 * @param adFlag
	 *            0：待审核，1：通过，2：未通过，3：已发布，4：投放结束
	 */
	public Integer findAds(@Param("adFlag") int adFlag);
	/**
	 * `platform` int(1) '投放平台  ''0'':''微信推广'',''1'':''设备广告''，2、品牌推广',
	 */
	public Integer findPublishAds(@Param("platform") int platform);
	
	public Integer findYesterdayTotalCost();

	public AdminSumStatisticBean findSumStatistics(
			@Param(value = "startDate") String startDate, 
			@Param(value = "endDate") String endDate
			);
	public List<AdminStatisticBean> findStatisticList(
			@Param(value = "startDate") String startDate, 
			@Param(value = "endDate") String endDate
			);
	
	public List<TopStatistic> findTopStatictis(
			@Param(value = "startDate") String startDate, 
			@Param(value = "endDate") String endDate,
			@Param(value = "platform") int platform
			);

	public Integer findSumIncome();
	public YesterdayIncome findYesterdayIncome();
	
	public Integer findRows(@Param(value = "offset") Integer offset, @Param(value = "pageSize") Integer pageSize,
			@Param(value = "searchKey") String searchKey, @Param(value = "startCreateTime") Date startCreateTime,
			@Param(value = "endCreateTime") Date endCreateTime, @Param(value = "checkflag") Integer checkflag);

	public List<AdVO> findVerifyAdList(@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize, @Param("searchKey") String searchKey,
			@Param("startCreateTime") Date startCreateTime, @Param("endCreateTime") Date endCreateTime,
			@Param("checkflag") Integer checkflag);

	public Integer approvalAd(@Param("id") Integer id, @Param("checkflag") Integer checkflag,@Param("reason") String reason);
	
	public AdVO findAdDetail(@Param(value = "id") Integer id);
	
	public Integer addNotice(@Param("ad_id") Integer ad_id,@Param("user_id") Integer user_id, @Param("notice_type") Integer notice_type,@Param("time") Date time,@Param("content") String content);
	
	//获取原始表内时间段内的广告列表
	public List<StaticRecord> findRecordAdIds(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd
			);
	public Integer findTypeClicks(
			@Param("device_code") String device_code,
			@Param("adId") int adId,
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd,
			@Param("type") String type
			);
	
	/**查询时间段总价
	 * @param adId
	 * @param billing_type
	 * @param costType  '费用类型 0：点击 1：吸粉 2：广告展示',
	 */
	public Integer findBillCost(
			@Param("device_code") String device_code,
			@Param("adId") int adId,
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd,
			@Param("billing_type") int billing_type,
			@Param("costType") int costType
			);
	
	
	public Integer findBillTimes(
			@Param("device_code") String device_code,
			@Param("adId") int adId,
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd,
			@Param("billing_type") int billing_type,
			@Param("costType") int costType
			);
	

	
	//获取原始表内时间段内的广告列表
	public List<DeviceStaticRecord> findRecordDevceCodes(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd
			);
	
	/**插入1小时内数据
	 */
	public Integer insertStaticRecord(
			List<StaticYesterdayHour> yesterdayHour
			);
	/**插入1小时内数据
	 */
	public Integer insertWX_statistic(
			List<StaticYesterdayHourWX> yesterdayHourWXs
			);
	
	public Integer insertDevice_income_statistic(
			List<StaticYesterdayHourDevice> yesterdayHourDevice
			);
	
	public Integer insertDayAdOwner(
			List<StaticOwnerAdIncome> dayOwnerAdIncomeList
			);

	public <T> Integer insertT(List<T> tList);
	
	public void deleteCurHourWX(@Param("dayTime") String dayTime,
			@Param("hour") int hour);
	
	public void deleteCurHour(@Param("dayTime") String dayTime,
			@Param("hour") int hour);
	
	public void deleteIncomeCurHour(@Param("dayTime") String dayTime,
			@Param("hour") int hour);
	
	public void deleteCurDayAdOwner(@Param("dayTime") String dayTime,
			@Param("hour") int hour
			);
	public void deleteCurDayAdOwnerByDay(@Param("dayTime") String dayTime
			);
	
	public void deleteCurDayProvinceByDay(@Param("dayTime") String dayTime
			);
	
	public void deleteCurDayT(@Param("dayTime") String dayTime
			);
	
	public  StaticYesterdayHourDevice getOwnerStatistic( @Param("owner") String owner);
	
	public  StaticYesterdayHourDevice ownerStatisticByAll(@Param("day") String day);
	
	public List<Integer> findUserIdByStatistic(@Param("dayTime") String dayTime);
	
	public List<Integer> findUserIdByDeviceStatistic(@Param("dayTime") String dayTime);
	
	public Integer findFinanceCostByUserId(@Param("userId") int userId,
			@Param("dayTime") String dayTime);
	
	public Integer findFinanceIncomeByUserId(@Param("userId") int userId,
			@Param("dayTime") String dayTime);
	
	public void addFinanceRecord(
			List<Finance> listFinance);
	
	public void delFinanceRecord(@Param("dayBefore") int dayBefore,
			@Param("type") String type
			 );
	
	public List<Finance> calDeviceOwnerIncome(@Param("dayBefore") int dayBefore);

	public List<Finance> calGGZconsume(@Param("dayBefore") int dayBefore);

	public Integer updateDateYesterdayCost(@Param("cost") int cost, @Param("userId") int userId,
			@Param("dayBefore") int dayBefore);
	
	
	public Integer countCustoms(@Param("role") String role, @Param("searchName") String searchName,
			@Param("startDate") String startDate, @Param("endDate") String endDate);
	public List<Custom>  findCustoms(
			@Param("role") String role,
			@Param(value = "offset") Integer offset, 
			@Param(value = "pageSize") Integer pageSize,
			@Param(value = "searchName") String searchName,
			@Param(value = "startDate") String startDate,
			@Param(value = "endDate") String endDate
		   );

	public Integer countRechargeLogs(@Param(value = "userID") Integer userID);
	
	public List<Integer> select_transaction_id(
			@Param(value = "transaction_id") String transaction_id);
	
	public Integer addBalance(
			@Param(value = "userID") Integer userID,
			@Param(value = "amount") Integer amount
			);
	
	public Integer addHandInputLog(
			@Param(value = "userID") Integer userID,
			@Param(value = "amount") Integer amount, 
			@Param(value = "transaction_id") String transaction_id, 
			@Param(value = "operater") String operater
			);
	
	public List<Map<String, Object>> getLogs(
			@Param(value = "offset") Integer offset, 
			@Param(value = "pageSize") Integer pageSize,
			@Param(value = "operater_name") String operater_name,
			@Param(value = "startDate") String startDate,
			@Param(value = "endDate") String endDate,
			@Param(value = "userID") Integer userID
		   );
	
	public int updateAdPriority(@Param("adId") Integer adId,
			@Param("priority") Integer priority);

//	public void addPriceSp(@Param("sp_price") Integer sp_price, @Param("sp_price_fake") Integer sp_price_fake, @Param("ad_type") String ad_type, @Param("ad_id") Integer ad_id);
	
	public Integer withdrawCount(
			@Param(value = "startDate") String startDate,
			@Param(value = "endDate") String endDate);
	
	public List<Map<String, Object>> withdrawList(
			@Param(value = "offset") Integer offset, 
			@Param(value = "pageSize") Integer pageSize,
			@Param(value = "startDate") String startDate,
			@Param(value = "endDate") String endDate
		   );
	
	public Integer withdrawVertify(
			@Param(value = "order_id")  String order_id,
			@Param(value = "status")  String status,
			@Param(value = "remark")  String remark,
			@Param(value = "withdraw_reason")  String withdraw_reason
			);
	
	
	public Integer getHalfHourAdRecordCount(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd
			);
	
	public Integer getFansAdRecordCount(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd
			);
	
	public List<AdRecord> getHalfHourAdRecord(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd,
			@Param("begin") int begin,
			@Param("count") int count
			);
	
	public List<AdRecord> getHalfAdRecordByCheck(
			@Param("timeStart") String timeStart,
			@Param("timeEnd") String timeEnd,
			@Param("begin") int begin,
			@Param("count") int count
			);
	
	public  AdRecord  findAdRecordByBillingId(@Param("billingId") int billingId);
	
	public AdRecord  findAdRecordByBillingIdDevice(@Param("billingId") int billingId);
	
	
	public List<AdRecord> getAdRecord(@Param("start")int start, @Param("length") int length);

	public Double getAdminTodayIncome(@Param("owner") String owner);

	public List<Integer> getAllAdScheduleIdByUserId(@Param("userID") Integer userID);
	
	public void modifyVertifyStatus(@Param("userId") String userId,
			@Param("actionTime") Date actionTime
			);

	public Integer getIncomeAndSbzincome();

	public Integer getWithdrawAmount();

	public Integer yesAdConsume(
			@Param("yesDateStrStart") String yesDateStrStart,
			@Param("yesDateStrEnd") String yesDateStrEnd);
	
	public Integer yesRecharge(
			@Param("yesDateStrStart") String yesDateStrStart,
			@Param("yesDateStrEnd") String yesDateStrEnd);
	
	public Integer yesIncome(
			@Param("yesDateStrStart") String yesDateStrStart,
			@Param("yesDateStrEnd") String yesDateStrEnd);
	
	public Integer yesPicIncome(
			@Param("yesDateStrStart") String yesDateStrStart,
			@Param("yesDateStrEnd") String yesDateStrEnd);
	
	public Integer yesSJHB(
			@Param("yesDateStrStart") String yesDateStrStart,
			@Param("yesDateStrEnd") String yesDateStrEnd);
	
	public Integer yesAdWithdraw(
			@Param("yesDateStrStart") String yesDateStrStart,
			@Param("yesDateStrEnd") String yesDateStrEnd);

	public Integer getFeeSplitListRows(
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate, 
			@Param("searchName") String searchName);

	public List<FeeSlipt> getFeeSplitList(
			@Param("offset") Integer offset, 
			@Param("pageSize") Integer pageSize, 
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate,
			@Param("searchName") String searchName);
	
	public Integer getAdserFeeSplitDetailRows(
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate, 
			@Param("adid") Integer adid, 
			@Param("owner") String owner);
	
	public List<FeeSlipt> getAdserFeeSplitDetail(
			@Param("offset") Integer offset, 
			@Param("pageSize") Integer pageSize, 
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate, 
			@Param("adid") Integer adid, 
			@Param("owner") String owner);
	
	public Integer getSbzFeeSplitDetailRows(
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	
	public List<FeeSlipt> getSbzFeeSplitDetail(
			@Param("offset") Integer offset, 
			@Param("pageSize") Integer pageSize, 
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	
	public List<FeeSlipt> sbzFeeSplit(
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate,
			@Param("adid") Integer adid);

	public Integer getOwnerAmount(
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate, 
			@Param("adid") Integer adid);
	
	public AdOwnerBean findAdOwnerByDay(
			@Param("adId") int adId, 
			@Param("owner") String owner, 
			@Param("day") Date day);
	
	public Integer insertAdOwnerDay(
			@Param("staticOwnerAdIncome") StaticOwnerAdIncome staticOwnerAdIncome );
	
	public Integer updateAdOwnerDay(
			@Param("staticOwnerAdIncome") StaticOwnerAdIncome staticOwnerAdIncome );
	
	public ProvinceBean findSchedulePrvovinceDay(
			@Param("sheduleId") int sheduleId, 
			@Param("provinceCode") String provinceCode, 
			@Param("day") Date day);
	
	public Integer insertPrvovinceDay(
			@Param("staticOwnerAdIncome") StaticOwnerAdIncome staticOwnerAdIncome );
	
	public Integer updatePrvovinceDay(
			@Param("staticOwnerAdIncome") StaticOwnerAdIncome staticOwnerAdIncome );

	
	public List<FeeSlipt> getExportSbzFeeSplit(
			@Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	

}
