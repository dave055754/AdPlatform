package com.wxc.adplatform.model;

import java.util.List;

public class MerchantRecord {
	private String owner;
	private List<MerchantInfo> merchantRecord;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<MerchantInfo> getMerchantRecord() {
		return merchantRecord;
	}

	public void setMerchantRecord(List<MerchantInfo> merchantRecord) {
		this.merchantRecord = merchantRecord;
	}

}
