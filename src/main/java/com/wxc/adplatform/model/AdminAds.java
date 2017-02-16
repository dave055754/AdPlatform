package com.wxc.adplatform.model;

public class AdminAds {
	private int publishingAds;
	private int noPassAds;
	private int waitingAds;
	private int vertifiedAds;
	private int endAds;
	private int yesterdayCostSum;
	
	
	public int getYesterdayCostSum() {
		return yesterdayCostSum;
	}
	public void setYesterdayCostSum(int yesterdayCostSum) {
		this.yesterdayCostSum = yesterdayCostSum;
	}
	public int getPublishingAds() {
		return publishingAds;
	}
	public void setPublishingAds(int publishingAds) {
		this.publishingAds = publishingAds;
	}
	public int getNoPassAds() {
		return noPassAds;
	}
	public void setNoPassAds(int noPassAds) {
		this.noPassAds = noPassAds;
	}
	public int getWaitingAds() {
		return waitingAds;
	}
	public void setWaitingAds(int waitingAds) {
		this.waitingAds = waitingAds;
	}
	public int getVertifiedAds() {
		return vertifiedAds;
	}
	public void setVertifiedAds(int vertifiedAds) {
		this.vertifiedAds = vertifiedAds;
	}
	public int getEndAds() {
		return endAds;
	}
	public void setEndAds(int endAds) {
		this.endAds = endAds;
	}
	
	
	
//	public enum TYPE {
//		CONSUME, WITHDRAW, RECHARGE
//	};
//	private TYPE type;
//
//	"publishingAds": 234,
//    "noPassAds": 34,
//    "waitingAds": 345，    
//    "vertifiedAds": 345 ,
//    “endAds”:325
	
}
