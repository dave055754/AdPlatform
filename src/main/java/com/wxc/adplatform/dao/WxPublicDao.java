package com.wxc.adplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.WxPublic;

@Repository
public interface WxPublicDao {

	// int addWxPublic(@Param(value = "wxPublic") WxPublic wxPublic,
	// @Param(value = "loginUserId") Integer loginUserId);

	List<WxPublic> getWxPublicList(Integer loginUserId);

	int addWxPublic(@Param(value = "wxAppid") String wxAppid, @Param(value = "wxName") String wxName,
			@Param(value = "wxDesc") String wxDesc, @Param(value = "wxUrl") String wxUrl,
			@Param(value = "loginUserId") Integer loginUserId, @Param(value = "wxLogo") String wxLogo,
			@Param(value = "wxQrcode") String wxQrcode, @Param(value = "wxDetailUrl") String wxDetailUrl,
			@Param(value = "wxFollowUrl") String wxFollowUrl, @Param(value = "wxArticleUrl") String wxArticleUrl);
	
	WxPublic getWxPublicByAppId(@Param(value = "wxAppid") String wxAppid);
	
	Integer getAppidAndDeviceCode(@Param(value = "appid") String appid, @Param(value = "deviceCode") String deviceCode);

	String getAppidByAdid(@Param(value = "id") Integer id);

	List<String> getDevicecodeByAppid(@Param(value = "appid") String appid);

	List<String> getAppidByAdscheduleid(@Param(value = "adScheduleId") Integer adScheduleId);

	List<String> getAppidByUserId(@Param(value = "userId") Integer userId);

	void deleteAppidDevicecode(@Param(value = "appid") String appid);

	List<String> getAppidByDevicecode(@Param(value = "deviceCode") String deviceCode);

	void addStatisticAppid(
			@Param(value = "appid") String appid, 
			@Param(value = "openId") String openId, 
			@Param(value = "clickTime") String clickTime);

	List<String> getAllAppid();

	void updateWxArticleUrl(
			@Param("wxAppid") String wxAppid, 
			@Param("wxArticleUrl") String wxArticleUrl, 
			@Param("wxDetailUrl") String wxDetailUrl, 
			@Param("userId") Integer userId,
			@Param("wxFollowUrl") String wxFollowUrl);

}