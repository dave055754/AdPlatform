package com.wxc.adplatform.model;

/**
 * 添加微信返回模型
 * 
 * @author liuhui
 *
 */
public class AddWeixinResult {
	private String code;
	private ResultMap map;

	public class ResultMap {
		private String data;

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ResultMap getMap() {
		return map;
	}

	public void setMap(ResultMap map) {
		this.map = map;
	}

}
