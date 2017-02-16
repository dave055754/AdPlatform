package com.wxc.adplatform.model;

import java.util.List;

public class MerchantResult {
	private String statistics_time;
	private List<MerchantRecord> merchantResult;

	public String getStatistics_time() {
		return statistics_time;
	}

	public void setStatistics_time(String statistics_time) {
		this.statistics_time = statistics_time;
	}

	public List<MerchantRecord> getMerchantResult() {
		return merchantResult;
	}

	public void setMerchantResult(List<MerchantRecord> merchantResult) {
		this.merchantResult = merchantResult;
	}

}
