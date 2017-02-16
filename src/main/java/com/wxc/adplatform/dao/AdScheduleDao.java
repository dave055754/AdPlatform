package com.wxc.adplatform.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.AdSchedule;
import com.wxc.adplatform.model.AdScheduleVO;

/**
 * 广告计划持久层操作
 * 
 */
@Repository
public interface AdScheduleDao {

	/**
	 * 广告计划列表
	 * 
	 * @param loginUserId
	 * @param endTime
	 * @param startTime
	 * 
	 * @return
	 */
	List<AdScheduleVO> findAdScheduleList(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize,
			@Param("loginUserId") Integer loginUserId, @Param("startCreateTime") Date startCreateTime,
			@Param("endCreateTime") Date endCreateTime,
			@Param("searchName") String searchName
			);

	Integer findRows(@Param("loginUserId") Integer loginUserId, @Param("startCreateTime") Date startCreateTime,
			@Param("endCreateTime") Date endCreateTime,
			@Param("searchName") String searchName
			);

	Integer addAdSchedule(@Param("name") String name, @Param("quota") Integer quota,
			@Param("loginUserId") Integer loginUserId, @Param("createTime") Date createTime);

	Integer updateAdSchedule(@Param("id") Integer id, @Param("loginUserId") Integer loginUserId,
			@Param("name") String name, @Param("quota") Integer quota);

	Integer onoff(@Param("id") Integer id, @Param("loginUserId") Integer loginUserId, @Param("onoff") Integer onoff);

	List<String> findName(@Param("name") String name, @Param("loginUserId") Integer loginUserId);

//	List<AdScheduleVO> findCountList();

	AdSchedule findAdScheduleById(@Param("adscheduleId") Integer adscheduleId);

	void editAdScheduleClickPlus(@Param("adscheduleId") Integer adscheduleId, @Param("click_plus") Integer click_plus);

	void editAdSchedulePrintPlus(@Param("adscheduleId") Integer adscheduleId, @Param("print_plus") Integer print_plus);

	void editAdScheduleExposurePlus(@Param("adscheduleId") Integer adscheduleId,
			@Param("charge_plus") Integer charge_plus);

	int getAllCount(@Param("adScheduleId") Integer adScheduleId);

	int getLockBalance(@Param("userId") Integer userId);

	int updateAdflag(@Param("adScheduleId") Integer adScheduleId, @Param("adflag") Integer adflag);

	int closeAllAdScheduleByUserId(@Param("userId") Integer userId);

	int updateChargePlus(@Param("charge") Integer charge, @Param("adScheduleId") Integer adScheduleId);

	int updateAdScheduleFlag(@Param("out_trade_no") String out_trade_no);

	List<String> findUpdateName(@Param("name") String name, @Param("loginUserId") Integer loginUserId,
			@Param("id") Integer id);

	List<Integer> getAllOffAdschedule();

	List<String> getAllOffAd();
	
	Integer getPrintPlusByScheduleId(@Param("scheduleId") Integer scheduleId);

}
