package com.wxc.adplatform.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.SjWithdraw;
import com.wxc.adplatform.model.Withdraw;
import com.wxc.adplatform.model.Withdraw.STATUS;

@Repository
public interface WithdrawDao {

	List<Withdraw> findUnCheckList(
			@Param(value = "offset") Integer offset,
			@Param(value = "pageSize") Integer pageSize, 
			@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime,
			@Param(value = "searchName") String searchName,
			@Param(value = "status") String status,
			@Param(value = "is_sj") String is_sj);

	Integer findRows(
			@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime,
			@Param(value = "searchName") String searchName,
			@Param(value = "status") String status,
			@Param(value = "is_sj") String is_sj);

	int updateWithdrawStatus(
			@Param(value = "id") Integer id, 
			@Param(value = "status") STATUS status, 
			@Param(value = "bill_id") String bill_id,
			@Param(value = "withdraw_reason") String withdraw_reason,
			@Param(value = "loginUserId") Integer loginUserId);
	
	
	List<Withdraw> findAdIncomeList(
			@Param(value = "startTime") Date startTime,
			@Param(value = "endTime") Date endTime,
			@Param(value = "searchName") String searchName,
			@Param(value = "status") String status);

	Withdraw getUserIdById(
			@Param(value = "id") Integer id);
	
	String getThirdAccountOrgByUserId(
			@Param(value = "user_id") Integer user_id);
	
	public List<Withdraw> getAllWithdrawListUncheck();

	void addWithdraw2Finance(Withdraw w);

	void updateFinanceWithdrawStatus(
			@Param(value = "user_id") Integer user_id, 
			@Param(value = "start_str") String start_str, 
			@Param(value = "end_str") String end_str, 
			@Param(value = "withdraw_status") STATUS withdraw_status, 
			@Param(value = "withdrawed") Integer withdrawed);

	List<SjWithdraw> getSjWithdrawList(
			@Param(value = "offset") Integer offset, 
			@Param(value = "pageSize") Integer pageSize);

	Integer getUserIdByThirdAccountOrg(@Param(value = "third_account_org") String third_account_org);

	Integer getIncome(@Param(value = "userId") Integer userId);

	Integer getSbzConsume(@Param(value = "userId") Integer userId);

	Integer getSbzIncome(@Param(value = "userId") Integer userId);

	Integer getSjWithdrawListRows();

	Integer getWithdrawedAmount(@Param(value = "userId") Integer userId);

}
