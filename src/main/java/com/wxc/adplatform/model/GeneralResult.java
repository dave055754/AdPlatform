package com.wxc.adplatform.model;

/**
 * 
 * 通用结果模型<br>
 * 
 * @author fanyaowu
 * @data 2014年7月13日
 * @version 1.0.0
 *
 */
public class GeneralResult {

	// 结果状态，true为成功，false为失败
	private boolean resultStatus;
	
	// 结果为失败时，填充的错误信息，可以为约定的错误码
	private String errorMessage;
	
	// 结果为true时的 业务数据，可为空
	private Object resultData;
	
	
	private String errorCode;
	
	
	

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public boolean isResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(boolean resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(Object resultData) {
		this.resultData = resultData;
	}
	
}
