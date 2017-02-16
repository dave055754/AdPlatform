package com.wxc.adplatform.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.Ad;
import com.wxc.adplatform.model.AdDetail;
import com.wxc.adplatform.model.AdVO;
import com.wxc.adplatform.model.Area;
import com.wxc.adplatform.model.DeviceAd;
import com.wxc.adplatform.model.Income;
import com.wxc.adplatform.model.ListSp;
import com.wxc.adplatform.model.ListSpValue;
import com.wxc.adplatform.model.SpTextDesc;
import com.wxc.adplatform.model.SpTypeValue;

/**
 * 广告持久层操作
 * 
 */
@Repository
public interface AdDao {

	List<AdVO> findAdList(@Param(value = "id") Integer id, @Param(value = "offset") Integer offset,
			@Param(value = "pageSize") Integer pageSize, @Param(value = "loginUserId") Integer loginUserId,
			@Param(value = "checkflag") Integer checkflag, @Param(value = "startCreateTime") Date startCreateTime,
			@Param(value = "endCreateTime") Date endCreateTime,
			@Param(value = "searchName") String searchName
			);

	Integer findRows(@Param(value = "id") Integer id, @Param(value = "pageSize") Integer pageSize,
			@Param(value = "loginUserId") Integer loginUserId, @Param(value = "checkflag") Integer checkflag,
			@Param(value = "startCreateTime") Date startCreateTime,
			@Param(value = "endCreateTime") Date endCreateTime,
			@Param(value = "searchName") String searchName
			);

	int addAd(@Param(value = "ad") AdVO ad);

	AdVO findAdDetail(@Param(value = "id") Integer id, @Param(value = "loginUserId") Integer loginUserId);

	Integer checkAd(@Param(value = "id") Integer id, @Param(value = "checkflag") Integer checkflag,
			@Param(value = "reason") String reason, @Param(value = "loginUserId") Integer loginUserId);

	Integer deleteAd(@Param(value = "id") Integer id, @Param(value = "loginUserId") Integer loginUserId);

	Integer updateAd(@Param(value = "id") Integer id, @Param(value = "loginUserId") Integer loginUserId,
			@Param(value = "name") String name, @Param(value = "startDate") String startDate,
			@Param(value = "endDate") String endDate);

	List<String> findName(@Param(value = "name") String name, @Param(value = "loginUserId") Integer loginUserId);

	Integer onoff(@Param("id") Integer id, @Param("loginUserId") Integer loginUserId, @Param("onoff") Integer onoff);

	List<AdVO> getWxStatisticCount();

	List<Integer> getDeviceStatisticCount();

	List<Integer> getBrandStatisticCount();

	Integer getPublishedAdCount(@Param("loginUserId") Integer loginUserId);

	Integer getUncheckedAdCount(@Param("loginUserId") Integer loginUserId);

	Integer getUnpassedAdCount(@Param("loginUserId") Integer loginUserId);

	List<AdVO> getAdSchedules(@Param("loginUserId") Integer loginUserId);

	AdVO getBannerAd();

	List<AdVO> getWxAd();

	List<Income> getDeviceOwerIncomeList(@Param("user_id") String user_id, @Param("startDate") String startDate,

			@Param("endDate") String endDate);

	List<AdVO> findCountList();

	/** 查询广告主ID **/
	AdVO findUserId(@Param("id") Integer id);

	List<DeviceAd> getSuitableAd();

	List<DeviceAd> getSuitableWxAd();

	List<DeviceAd> findWxAdByPriceDesc(@Param("appid") String appid);
	
	DeviceAd findWxAdByWxPublic(@Param("appid") String appid);
	

	List<DeviceAd> getSuitableBannerAd();

	List<DeviceAd> getPublishedAds(String devicecode);

	List<String> findUpdateName(@Param(value = "name") String name, @Param(value = "loginUserId") Integer loginUserId,
			@Param(value = "id") Integer id);

	List<AdDetail> get_spid_typevalueid_list();

	SpTextDesc getTypevaluetextTypevaluedesc(Integer sp_type_value_id);

	List<AdDetail> get_typevalueid_valuetext_list();
	
	public void addPriceSp(ListSp ls);

	public void addSpTypeRelation(
			@Param(value = "sp_id") Integer sp_id,
			@Param(value = "sp_type_id")  String sp_type_id, 
			@Param(value = "sp_type_value_id")  Integer sp_type_value_id);

	public void addSpTypeValue(ListSpValue lsv);

	void deleteSpTypeRelationBySpId(@Param(value = "spId") Integer spId);

	void deleteSpBySpId(@Param(value = "sp_id") Integer sp_id);

	void updateAdDimension(@Param(value = "ad_area") String ad_area, @Param(value = "sex") String sex, 
			@Param(value = "os") String os, @Param(value = "industry") String industry,
			@Param(value = "adid") Integer adid);

	void addAdDefaultPrice(ListSp sp);

	void addSpTypeRelation2(@Param(value = "sp_id") Integer sp_id);

	List<Ad> getAdListByUserId(@Param(value = "loginUserId") Integer loginUserId);

	Integer getSpTypeValueIdByTypeValueDesc(@Param(value = "type_value_desc") String type_value_desc);

	String getAdDimensionDesc(@Param(value = "type_value_text") String type_value_text);
	
	String getAdDimensionText(@Param(value = "type_value_desc") String type_value_desc);
	
	public void addSpTypeValueforCharging(Area lsv);

	List<SpTypeValue> getIndustry();

	List<SpTypeValue> getSex();

	List<SpTypeValue> getOs();

	List<SpTypeValue> getAreacity();

	Integer getSpidByAdid(@Param(value = "ad_id") Integer ad_id);

	List<ListSp> getSpIdList();

	List<ListSpValue> getListSpValues(@Param(value = "sp_id") Integer sp_id);

	List<String> getAllCitycode();

	List<String> getAllIndustryText();

	Integer getSpTypeValueIdByTypeValueText(@Param(value = "text") String text);

	List<String> getAllSexText();

	List<String> getAllOsText();

	void deleteAllAdminSp();

	List<Integer> getAllAdminSpid();

	List<String> getAllProvinceCode();

	void updateAdParam(@Param(value = "charge") Integer charge, 
			@Param(value = "area") String area, 
			@Param(value = "area_city") String area_city, 
			@Param(value = "adid") Integer adid);

	Integer getSpRows();

	List<String> getUserOnlineAds(@Param(value = "loginUserId") Integer loginUserId);

	Integer getUserOnlineAdsCount(@Param(value = "id") Integer id);
	
	Ad getAdParam(@Param(value = "adid") Integer adid);

}
