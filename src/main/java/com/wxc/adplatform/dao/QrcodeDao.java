package com.wxc.adplatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.Qrcode;

@Repository
public interface QrcodeDao {

	int bindQrcode(@Param("devicecode") String devicecode,@Param("code")  String code);

	Qrcode getUnbindedQrcode();

	Qrcode getDeviceCode(String deviceCode);
	
	List<Qrcode> getDeviceCodeList(String deviceCode);
	
	Integer findNoBindQrcode();

	Integer saveQrcode(@Param("code") String code, @Param("qrcode_url") String filePath);

	void deleteQrcode(@Param("deviceCode") String deviceCode);

	String getOwnerByDeviceCode(@Param("deviceCode") String deviceCode);

	String getUserIdByOwner(@Param("owner") String owner);
}
