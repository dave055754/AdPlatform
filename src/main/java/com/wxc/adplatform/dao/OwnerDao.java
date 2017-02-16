package com.wxc.adplatform.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.DayIncome;
import com.wxc.adplatform.model.Finance;
import com.wxc.adplatform.model.WithdrawItem;

@Repository
public interface OwnerDao {
	
	public Integer findUserId(@Param("owner") String owner);
	public String getOwnerFromDeviceId(@Param("deviceId") String deviceId);
	
	public Integer findWithdrawAdIncome(@Param("userId") String userId, 
			@Param("start_date") String start_date, 
			@Param("end_date") String end_date
			);
	public Integer findWithdrawPrintIncome(@Param("userId") String userId, 
			@Param("start_date") String start_date, 
			@Param("end_date") String end_date);
	public Integer findWithdrawHBConsume(@Param("userId") String userId, 
			@Param("start_date") String start_date, 
			@Param("end_date") String end_date);
	
	
	public Integer findWithdrawAdIncomeAll(@Param("userId") String userId, 
			@Param("start_date") String start_date, 
			@Param("end_date") String end_date
			);
	public Integer findWithdrawPrintIncomeAll(@Param("userId") String userId, 
			@Param("start_date") String start_date, 
			@Param("end_date") String end_date);
	public Integer findWithdrawHBConsumeAll(@Param("userId") String userId, 
			@Param("start_date") String start_date, 
			@Param("end_date") String end_date);
	
	public List<Map<String, Object>> findWithdrawDate(@Param("userId") String userId );
	public Map<String, Object> findWithdrawing(@Param("userId") String userId );
	
	public Integer findYesterdayAdIncome(@Param("owner") String owner);
	public Integer findAllAdIncome(@Param("owner") String owner);
	public Integer findYesterdayPrintIncome(@Param("userId") String userId);
	public Integer findAllPrintIncome(@Param("userId") String userId);
	
	public Integer findyesterdaySJHB(@Param("userId") String userId);
	public Integer findallSJHB(@Param("userId") String userId);

	public  List<DayIncome> find7DayIncomeList(@Param("owner") String owner);
	public Integer findDaySJHB(@Param("userId") String userId, @Param("day") String day);
	
	
	public Integer admin_findWithdrawAdIncome();
	public Integer admin_findWithdrawPrintIncome();
	public Integer admin_findWithdrawHBConsume();
	
	
	
	public Integer admin_findYesterdayAdIncome();
	public Integer admin_findAllAdIncome();
	public Integer admin_findYesterdayPrintIncome();
	public Integer admin_findAllPrintIncome();
	public Integer admin_findyesterdaySJHB();
	public Integer admin_findallSJHB();
	public  List<DayIncome> admin_find7DayIncomeList();
	public Integer admin_findDaySJHB(@Param("day") String day);
	
	
	public Integer saveBankinfo(
			@Param("bank_name") String bank_name,
			@Param("bank_card") String bank_card,
			@Param("bank_account_name") String bank_account_name,
			@Param("userId") String userId,
			@Param("id_card") String id_card,
			@Param("type") String type, 
			@Param("phone") String phone
			);
	
	public Integer clearBankWorking(@Param("userId") String userId);
	
	public Map<String, Object>  findBankinfo(
			@Param("userId") String userId
			);
	
	public Integer insertWithdraw(
			@Param("bill_amout") int bill_amout,
			@Param("real_amout") int real_amout,
			@Param("fee_amount") int fee_amount,
			@Param("type") String type,
			@Param("userId") int userId,
			@Param("bankId") String bankId,
			@Param("startDate") String startDate,
			@Param("endDate") String endDate,
			@Param("is_sj") String isSj,
			@Param("weiXinName") String weiXinName
			);
	public Integer findWithdrawId();
	
	public Integer insertWithdrawToFinance(
			@Param("amount") int amount,
			@Param("userId") int userId,
			@Param("withdrawId") int withdrawId
			);
	public Integer updateWithdrawingStatus(
			@Param("userId") int userId
			);

	public List<Finance> incomeList(
			@Param("owner") String owner,
			@Param("userId") Integer user_id,
			@Param("start_date") String start_date,
			@Param("end_date") String end_date);
	
	public String findOwner(
			@Param("withdrawId") String withdrawId
			);
	
	public List<Map<String, Object>> getBankList(@Param("userId") Integer user_id );
	public List<WithdrawItem> withdrawList(@Param("userId") Integer userId);
	
	public Map<String, Object> withdrawDetail(@Param("withdrawId") String withdrawId);
	public Integer findWithdrawDetailAdIncome(
			@Param("userId") String userId,
			@Param("start_date") String start_date,
			@Param("end_date") String end_date
			);
	public Integer findWithdrawDetailPrintIncome(
			@Param("userId") String userId,
			@Param("start_date") String start_date,
			@Param("end_date") String end_date
			);
	public Integer findWithdrawDetailHBConsume(
			@Param("userId") String userId,
			@Param("start_date") String start_date,
			@Param("end_date") String end_date
			);
	
	public List<Finance> findWithdrawDetailPrintIncomeByday(
			@Param("userId") String userId,
			@Param("start_date") String start_date,
			@Param("end_date") String end_date
			);
	public List<Finance> findWithdrawDetailHBConsumeByday(
			@Param("userId") String userId,
			@Param("start_date") String start_date,
			@Param("end_date") String end_date
			);
	
	
	
	public void updateWithdrawMoney(@Param("billMoney") int billMoney, 
			@Param("realMoney") int realMoney,
			@Param("withdrawId") int withdrawId);
	
	public void updateFinanceByTime(
			@Param("start_date") String beginDate,
			@Param("end_date")  String endDate, 
			@Param("userId") int userId);
	
	public Integer getVertifyedCount(
			@Param("userId") Integer userId, 
			@Param("firstDate") String firstDate, 
			@Param("lastDate") String lastDate);
	
	public Integer getCurrentDayBeforeCount(
			@Param("todayDateStart") String todayDateStart,
			@Param("todayDateEnd") String todayDateEnd);
	
}
