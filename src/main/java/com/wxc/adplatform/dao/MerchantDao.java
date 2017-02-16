package com.wxc.adplatform.dao;

import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.MerchantInfoRecord;

/**
 * 商家费用记录持久层操作
 * 
 */
@Repository
public interface MerchantDao {

	void addMerchantRecord(MerchantInfoRecord merchantInfoRecord);
}
