package com.wxc.adplatform.model;

import java.util.List;

/**
 * 高德地图返回模型
 * 
 * @author liuhui
 * 
 */
public class GaodeMapResult {
	private String status;
	private String info;
	private String infocode;
	private List<ResultMap> regeocodes;

	public class ResultMap {
		private Object formatted_address;
		private GaodeMap addressComponent;


		public Object getFormatted_address() {
			return formatted_address;
		}

		public void setFormatted_address(Object formatted_address) {
			this.formatted_address = formatted_address;
		}

		public GaodeMap getAddressComponent() {
			return addressComponent;
		}

		public void setAddressComponent(GaodeMap addressComponent) {
			this.addressComponent = addressComponent;
		}

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public List<ResultMap> getRegeocodes() {
		return regeocodes;
	}

	public void setRegeocodes(List<ResultMap> regeocodes) {
		this.regeocodes = regeocodes;
	}

}
