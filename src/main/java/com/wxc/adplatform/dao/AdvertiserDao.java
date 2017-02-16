package com.wxc.adplatform.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.Custom;
import com.wxc.adplatform.model.Finance;
import com.wxc.adplatform.model.NoticesBean;
import com.wxc.adplatform.model.UserStatisticBean;

@Repository
public interface AdvertiserDao {
	public List<Finance> findFinanceDetails(@Param("userId") String userId,
			@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize);

	public Integer countDetails(@Param("userId") String userId,
			@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize
			);

	public Custom findBalance(@Param("userId") String userId);
	
	public Integer countPublishList(@Param("adId") Integer adId, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate);

	public List<UserStatisticBean> publishList(
			@Param("adId") Integer adId,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate,
			@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize);

	public Integer countNoticesStatus(@Param("userId") String userId);
	
	/**查询时间戳**/
	public Date findTimestamp(@Param("userId") String userId);
	
	/**插入通知状态**/
	public Integer addNoticesTimestamp(@Param("userId") String userId);
	
	/**更新通知状态**/
	public Integer updateNoticesTimestamp(@Param("userId") String userId);
	
	public Integer countNotices(@Param("userId") String userId);
	
	public List<NoticesBean> findNotices(@Param("userId") String userId);
	
	public Integer findNoticesByTime(@Param("userId") String userId,@Param("timeStamp") Date timeStamp);
	
	public List<UserStatisticBean> findStatisticsList(
			@Param("userId") String userId,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate,
			@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize);
	
	public List<Map<String, Object>> wxProvince(
			@Param("adSchedule_id") Integer adSchedule_id,
			@Param("startDate")String startDate,
			@Param("endDate")String endDate, 
			@Param("loginId")Integer loginId);
	
	public List<Map<String, Object>> wxSex(
			@Param("adSchedule_id") Integer adSchedule_id,
			@Param("startDate")String startDate,
			@Param("endDate")String endDate, 
			@Param("loginId")Integer loginId);
	
	public List<Map<String, Object>> wxOsType(
			@Param("adSchedule_id") Integer adSchedule_id,
			@Param("startDate")String startDate,
			@Param("endDate")String endDate, 
			@Param("loginId")Integer loginId);

}
