package com.wxc.adplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.Sp;
import com.wxc.adplatform.model.SpInfo;

/**
 * 价格持久层操作
 * 
 */
@Repository
public interface SpDao {

	List<Sp> getSpList(@Param("ad_id") int ad_id);
	
	List<SpInfo> getSpInfoList(@Param("sp_id") int sp_id);
	
	List<Sp> getPlatSpList();
}
