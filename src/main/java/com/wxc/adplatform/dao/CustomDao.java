package com.wxc.adplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.Custom;
import com.wxc.adplatform.model.DeviceIncome;

@Repository
public interface CustomDao {
	public Custom findUser(@Param("phoneNumber") String phoneNumber,@Param("password") String password);
	
	public Custom getUserByToken(@Param("token") String token);
	
	public void setUserToken(@Param("userId") int userId, @Param("token") String token);
	
	
	public Integer isExistUser(@Param(value = "nameName") String nameName);
	
	public void addUser(Custom user);
	
	public void resetPwd(@Param("userId") int userId,
			@Param("newPassword") String newPassword);
	
	public Custom findUserByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	public Custom findUserByUserId(@Param("userId") int userId);
	
	public int updateUserBalance(@Param("total_fee") int total_fee,@Param("userId") int userId);
	
	public int  updateChangeUserBalance(@Param("balance") int balance,@Param("userId") int userId);
	
	public Custom findUserByThirdAccount(@Param("owner") String owner);
	
	public Integer countUserByThirdAccount(@Param("owner") String owner);
	
	public void addThirdAccount(@Param("owner") String owner,@Param("balance") int balance);
	
	public void updateThirdAccount(@Param("owner") String owner,@Param("balance") int balance,@Param("nickName") String nickName,@Param("headImageUrl") String headImageUrl);

	public int updateLockAmount(@Param("charge") Integer charge, @Param("createUserId") Integer createUserId);

	public int addUserFromWx(Custom custom);

	public int updateUserFromWx(Custom custom);

	public List<Custom> getThirdAccountOrg();

	public int getAcceptAdStatus(String orgcode);

	public DeviceIncome getWeixinAndBannerIncome(String owner);

	public int updateAcceptAdStatus(
			@Param("thirdAccount") String thirdAccount,
			@Param("accept_ad_status") Integer accept_ad_status);

	public Double getDevicerCount(String owner);
	
	public void addCustomByThird(Custom custom);
	
	public void updateDeviceAccount(@Param("owner") String owner,@Param("balance") int balance);
	
	public void updateAccountByPayPrint(@Param("userId") int userId,@Param("balance") int balance);
}
