package com.wxc.adplatform.model;

import java.util.List;

/**
 * 获取部门成员返回模型
 * 
 * @author liuhui
 *
 */
public class GetDepartmentUserResult {
	private Integer errcode;
	private String errmsg;
	private List<UserList> userlist;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public List<UserList> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<UserList> userlist) {
		this.userlist = userlist;
	}

}
