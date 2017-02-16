package com.wxc.adplatform.model;

public class ErrorCode {
	public static String PARAM_ERROR = "01000400";
	public static String PARAM_ERROR_STR = "账号或密码不能为空";

	public static String USER_PASS_ERROR = "01010004";
	public static String USER_PASS_ERROR_STR = "账号或密码错误";

	/** 参数为空错误码，统一用这个 */
	public static String PARAM_NULL = "01000411";
	/** 参数为空错误码描述，统一用这个 */
	public static String PARAM_NULL_STR = "参数不能为空";

	public static String PARAM_TYPE_ERROR = "01000412";
	public static String PARAM_TYPE_ERROR_STR = "参数类型错误";

	/** 没有权限 */
	public static String PERMISSION_DENIED = "01000413";
	/** 没有权限 */
	public static String PERMISSION_DENIED_STR = "没有权限";
	
	public static String PIC_DOWNLOAD_ERROR = "01000414";
	public static String PIC_DOWNLOAD_ERROR_STR = "图片下载失败";
	
	public static String NAME_REPEAT_ERROR = "01000415";
	public static String NAME_REPEAT_ERROR_STR = "名称不能重复";

}
