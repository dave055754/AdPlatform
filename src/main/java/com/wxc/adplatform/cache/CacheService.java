package com.wxc.adplatform.cache;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxc.adplatform.dao.AdDao;
import com.wxc.adplatform.dao.AdScheduleDao;
import com.wxc.adplatform.dao.CustomDao;
import com.wxc.adplatform.dao.DeviceDao;
import com.wxc.adplatform.dao.WxPublicDao;
import com.wxc.adplatform.dao.wx.PushMsg2DeviceDao;
import com.wxc.adplatform.model.Account;
import com.wxc.adplatform.model.Area;
import com.wxc.adplatform.model.Custom;
import com.wxc.adplatform.model.Device;
import com.wxc.adplatform.model.DeviceAd;
import com.wxc.adplatform.model.DeviceAddress;
import com.wxc.adplatform.model.DeviceMainWxInfo;
import com.wxc.adplatform.model.WxPublic;
import com.wxc.adplatform.model.wx.GetUseridResult;
import com.wxc.adplatform.service.v2.WxTokenServiceV2;
import com.wxc.adplatform.service.wx.WxTokenService;
import com.wxc.adplatform.util.CacheKeyPrefixConst;
import com.wxc.adplatform.util.JsonUtils;


/**
 * 
 * CacheService(对缓存的增删改查)
 * 
 * @author lvyongwen
 * @date 2015年9月15日 下午12:58:42
 * @version [1.0, 2015年9月15日]
 * @since version 1.0
 * @see [相关类/方法]
 */
@Service
public class CacheService
{
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);
	
    @Autowired
    private JedisClient jedisClient;
    @Autowired
	private WxTokenService wxTokenService;
    @Autowired
	private WxTokenServiceV2 wxTokenServiceV2;
    @Autowired
    private PushMsg2DeviceDao pushMsg2DeviceDao;
    
    /** 注册用户信息缓存过期时间 */
    private static final int EXPIRE_TIME = 30 * 60;
    
    /** 一分钟只能发一次短信验证码 */
    private static final int ONE_MINUTE = 60;
    
    
    private static final String areaKey = "AD_AREA_LIST";
    private static final String gaode_map_key = "GAODE_MAP_KEY";
    private static final String deviceModelID = "DEVICE_MODEL_ID";
    private static final String get_userid_key = "USERID_KEY";
    private static final String get_weixinid_key = "WEIXINID_KEY";
    private static final String get_openid_key = "OPENID_KEY";
    private static final String get_clickappid_key = "CLICK_APPID_KEY";
    private static final String get_adprice_key = "AD_PRICE_KEY";
    private static final String get_device_key = "DEVICE_KEY";
    private static final String get_account_key = "ACCOUNT_KEY";
    
    
    public Custom getCustom(String accessToken)
    {
        String keyPattern = jedisClient.generateCacheKey(CacheKeyPrefixConst.CUSTOM, "*", accessToken);
        String[] cacheKeys = jedisClient.getCacheKeys(keyPattern);
        // 找不到key, 说明没有用户信息, 返回null
        if (ArrayUtils.isEmpty(cacheKeys))
        {
            return null;
        }
        return jedisClient.get(cacheKeys[0], Custom.class);
    }
    
    /**
     * 
     * isExistCustom(判断用户是否存在)
     * 
     * @param phoneNumber
     * @return
     * @return boolean 返回类型
     * @author lvyongwen
     * @date 2015年9月15日 下午8:48:14
     * @version [1.0, 2015年9月15日]
     * @since version 1.0
     */
    public boolean isExistCustom(String phoneNumber)
    {
        
        String keyPattern = jedisClient.generateCacheKey(CacheKeyPrefixConst.CUSTOM, phoneNumber, "*");
        String[] cacheKeys = jedisClient.getCacheKeys(keyPattern);
        // 找不到key, 说明没有用户信息, 返回null
        if (ArrayUtils.isEmpty(cacheKeys))
        {
            return false;
        }
        return jedisClient.get(cacheKeys[0], Custom.class) == null ? false : true;
    }
    
    /**
     * 
     * judgeSendValidateCodeBeyoud(判断发送验证码是否在一分钟之外)
     * 
     * @param phoneNumber
     * @return
     * @return boolean 返回类型
     * @author lvyongwen
     * @date 2015年9月15日 下午7:29:12
     * @version [1.0, 2015年9月15日]
     * @since version 1.0
     */
    public boolean judgeSendValidateCodeLimit(String phoneNumber)
    {
        String cacheKey = jedisClient.generateCacheKey(CacheKeyPrefixConst.SMS_MIN_LIMIT, phoneNumber);
        return jedisClient.get(cacheKey, Integer.class) == null ? false : true;
    }
    
    /**
     * 
     * putSendValidateCodeLimit(保存发送验证码的限制)
     * 
     * @param phoneNumber
     * @return void 返回类型
     * @author lvyongwen
     * @date 2015年9月15日 下午8:04:14
     * @version [1.0, 2015年9月15日]
     * @since version 1.0
     */
    public void putSendValidateCodeLimit(String phoneNumber)
    {
        String cacheKey = jedisClient.generateCacheKey(CacheKeyPrefixConst.SMS_MIN_LIMIT, phoneNumber);
        jedisClient.put(cacheKey, 1, ONE_MINUTE);
    }
    
    /**
     * 
     * putSendValidateCode(保存发送的验证码)
     * 
     * @param phoneNumber
     * @return void 返回类型
     * @author lvyongwen
     * @date 2015年9月15日 下午8:04:43
     * @version [1.0, 2015年9月15日]
     * @since version 1.0
     */
    public void putSendRegisterValidateCode(String phoneNumber, String validateCode)
    {
        String cacheKey =
            jedisClient.generateCacheKey(CacheKeyPrefixConst.REGIST_VALIDATE_CODE, phoneNumber, validateCode);
        jedisClient.put(cacheKey, validateCode, EXPIRE_TIME);
    }
    
    /**
     * 
     * putSendResetPwdValidateCode(发送重置密码的验证码)
     * 
     * @param phoneNumber
     * @param validateCode
     * @return void 返回类型
     * @author lvyongwen
     * @date 2015年9月15日 下午8:19:52
     * @version [1.0, 2015年9月15日]
     * @since version 1.0
     */
    public void putSendResetPwdValidateCode(String phoneNumber, String validateCode)
    {
        String cacheKey =
            jedisClient.generateCacheKey(CacheKeyPrefixConst.RESET_VALIDATE_CODE, phoneNumber, validateCode);
        jedisClient.put(cacheKey, validateCode, EXPIRE_TIME);
    }
    
    /**
     * 
     * checkRegisterCode(判断验证码是否有效)
     * 
     * @param phoneNumber
     * @param validateCode
     * @return
     * @return boolean 返回类型
     * @author lvyongwen
     * @date 2015年9月15日 下午8:25:29
     * @version [1.0, 2015年9月15日]
     * @since version 1.0
     */
    public boolean checkRegisterCode(String phoneNumber, String validateCode)
    {
        String cacheKey =
            jedisClient.generateCacheKey(CacheKeyPrefixConst.REGIST_VALIDATE_CODE, phoneNumber, validateCode);
        return StringUtils.isEmpty(jedisClient.get(cacheKey, String.class)) ? false : true;
    }
    
    /**
     * 
     * checkResetPwdCode(判断重置密码验证码是否正确)
     * 
     * @param phoneNumber
     * @param validateCode
     * @return
     * @return boolean 返回类型
     * @author lvyongwen
     * @date 2015年9月15日 下午8:28:01
     * @version [1.0, 2015年9月15日]
     * @since version 1.0
     */
    public boolean checkResetPwdCode(String phoneNumber, String validateCode)
    {
        String cacheKey =
            jedisClient.generateCacheKey(CacheKeyPrefixConst.RESET_VALIDATE_CODE, phoneNumber, validateCode);
        return StringUtils.isEmpty(jedisClient.get(cacheKey, String.class)) ? false : true;
    }
    
    /**
     * 
     * deleteRegisterCode(移除注册验证码)
     * 
     * @param phoneNumber
     * @param validateCode
     * @return void 返回类型
     * @author lvyongwen
     * @date 2015年9月15日 下午8:32:25
     * @version [1.0, 2015年9月15日]
     * @since version 1.0
     */
    public void deleteRegisterCode(String phoneNumber, String validateCode)
    {
        String cacheKey =
            jedisClient.generateCacheKey(CacheKeyPrefixConst.REGIST_VALIDATE_CODE, phoneNumber, validateCode);
        jedisClient.deleteKeys(cacheKey);
    }
    
    /**
     * 
     * deleteResetPwdCode(移除重置密码验证码)
     * 
     * @param phoneNumber
     * @param validateCode
     * @return void 返回类型
     * @author lvyongwen
     * @date 2015年9月15日 下午8:33:27
     * @version [1.0, 2015年9月15日]
     * @since version 1.0
     */
    public void deleteResetPwdCode(String phoneNumber, String validateCode)
    {
        String cacheKey =
            jedisClient.generateCacheKey(CacheKeyPrefixConst.RESET_VALIDATE_CODE, phoneNumber, validateCode);
        jedisClient.deleteKeys(cacheKey);
    }
    
    /**
     * 
     * deleteExistCustom(这里用一句话描述这个方法的作用)
     * 
     * @param phoneNumber
     * @param password
     * @return
     * @return boolean 返回类型
     * @author lvyongwen
     * @date 2015年9月15日 下午9:43:35
     * @version [1.0, 2015年9月15日]
     * @since version 1.0
     */
    public Custom deleteExistCustom(String phoneNumber, String password)
    {
        String keyPattern = jedisClient.generateCacheKey(CacheKeyPrefixConst.CUSTOM, phoneNumber, "*");
        String[] cacheKeys = jedisClient.getCacheKeys(keyPattern);
        // 找不到key, 说明没有用户信息, 返回null
        if (ArrayUtils.isEmpty(cacheKeys))
        {
            return null;
        }
        
        Custom custom = jedisClient.get(cacheKeys[0], Custom.class);
        if (custom == null)
        {
            return null;
        }
        
        if (custom.getPhoneNumber().equals(phoneNumber) && custom.getPassword().equals(password))
        {
            jedisClient.deleteKeys(cacheKeys[0]);
            return custom;
        }
        return null;
    }
    
    /**
     * 
     * updateCustom(更新用户缓存信息)
     * 
     * @param custom
     * @return void 返回类型
     * @author lvyongwen
     * @date 2015年9月16日 上午8:22:28
     * @version [1.0, 2015年9月16日]
     * @since version 1.0
     */
    public void updateCustom(Custom custom)
    {
        // 1. 查询用户信息
        String keyPattern = jedisClient.generateCacheKey(CacheKeyPrefixConst.CUSTOM, custom.getPhoneNumber(), "*");
        String[] cacheKeys = jedisClient.getCacheKeys(keyPattern);
        // 找不到key, 说明没有用户信息, 返回null
        if (ArrayUtils.isEmpty(cacheKeys))
        {
            return;
        }
        Custom customCache = jedisClient.get(cacheKeys[0], Custom.class);
        if (customCache == null)
        {
            return;
        }
        // 2. 更新用户信息
        if (!StringUtils.isEmpty(custom.getPassword()))
        {
            customCache.setPassword(custom.getPassword());
        }
        if (!StringUtils.isEmpty(custom.getEmail()))
        {
            customCache.setEmail(custom.getEmail());
        }
       
        if (!StringUtils.isEmpty(custom.getNickName()))
        {
            customCache.setNickName(custom.getNickName());
        }
        if (!StringUtils.isEmpty(custom.getPassword()))
        {
            customCache.setPassword(custom.getPassword());
        }
      
        // 3. 存入缓存
        jedisClient.put(cacheKeys[0], customCache);
    }
    
    /**
     * 
     * cacheCustom(缓存用户信息)
     * 
     * @param accessToken
     * @param phoneNumber
     * @param custom
     * @return void 返回类型
     * @author lvyongwen
     * @date 2015年9月16日 下午2:24:51
     * @version [1.0, 2015年9月16日]
     * @since version 1.0
     */
    public void cacheCustom(String accessToken, String phoneNumber, Custom custom)
    {
        String cacheKey = jedisClient.generateCacheKey(CacheKeyPrefixConst.CUSTOM, phoneNumber, accessToken);
        jedisClient.put(cacheKey, custom);
    }
    
    public void cacheDeliverCustom(String accessToken, String phoneNumber, Custom custom)
    {
        String cacheKey = jedisClient.generateCacheKey(CacheKeyPrefixConst.DELIVERCUSTOM, phoneNumber, accessToken);
        jedisClient.put(cacheKey, custom);
    }
    
    ///////////---------------
    public Custom deleteExistDeliverCustom(String phoneNumber, String password)
    {
        String keyPattern = jedisClient.generateCacheKey(CacheKeyPrefixConst.DELIVERCUSTOM, phoneNumber, "*");
        String[] cacheKeys = jedisClient.getCacheKeys(keyPattern);
        // 找不到key, 说明没有用户信息, 返回null
        if (ArrayUtils.isEmpty(cacheKeys))
        {
            return null;
        }
        
        Custom custom = jedisClient.get(cacheKeys[0], Custom.class);
        if (custom == null)
        {
            return null;
        }
        
        if (custom.getPhoneNumber().equals(phoneNumber) && custom.getPassword().equals(password))
        {
            jedisClient.deleteKeys(cacheKeys[0]);
            return custom;
        }
        return null;
    }
    
    
    public Custom getDeliverCustom(String accessToken)
    {
        String keyPattern = jedisClient.generateCacheKey(CacheKeyPrefixConst.DELIVERCUSTOM, "*", accessToken);
        String[] cacheKeys = jedisClient.getCacheKeys(keyPattern);
        // 找不到key, 说明没有用户信息, 返回null
        if (ArrayUtils.isEmpty(cacheKeys))
        {
            return null;
        }
        return jedisClient.get(cacheKeys[0], Custom.class);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public DeviceAddress getLocation(String location) {
    	String key = jedisClient.generateCacheKey(gaode_map_key, location);
    	DeviceAddress deviceAddress = jedisClient.get(key, DeviceAddress.class);
    	return deviceAddress;
    }
    
    public void putLocation(String location, DeviceAddress deviceAddress) {
    	String key = jedisClient.generateCacheKey(gaode_map_key, location);
    	jedisClient.put(key, deviceAddress, 30*24*60*60);
	}
    
    /**
     *  获得一个自增ID
     * @return id
     */
    public int getIncrementId() {
    	Integer id = jedisClient.get(deviceModelID, Integer.class);
    	if (id == null) {
    		id = 0;
    	}
    	jedisClient.put(deviceModelID, id + 1);
    	
    	return id;
	}
    
    public List<Area> getListArea(){
        return jedisClient.getList(areaKey, Area.class);
    }
    
    public void putListArea(List<Area> listArea){
        jedisClient.put(areaKey, listArea);
    }
    
	public void putUserId(String code, GetUseridResult result) {
		String key = jedisClient.generateCacheKey(get_userid_key, code);
    	jedisClient.put(key, result, 30*24*60*60);
	}
	
	public GetUseridResult getUserId(String code) {
		String key = jedisClient.generateCacheKey(get_userid_key, code);
		GetUseridResult result = jedisClient.get(key, GetUseridResult.class);
    	return result;
	}

	/**
	 * 注册验证码
	 * @param phoneNumber
	 * @param validateCode
	 */
	public void putRegisterCode(String phoneNumber, String validateCode) {
		String key = jedisClient.generateCacheKey(phoneNumber);
    	jedisClient.put(key, validateCode, 30*60);
	}
	
	public boolean getRegisterCode(String phoneNumber, String validateCode) {
		String originValidateCode = jedisClient.get(phoneNumber, String.class);
		if (validateCode.equals(originValidateCode)) {
			return true;
		}
		return false;
	}

	/**
	 * 改密验证码
	 * @param phoneNumber
	 * @param validateCode
	 */
	public void putResetPwdCode(String phoneNumber, String validateCode) {
		String key = jedisClient.generateCacheKey(phoneNumber);
    	jedisClient.put(key, validateCode, 30*60);
	}
	
	public boolean getResetPwdCode(String phoneNumber, String validateCode) {
		String originValidateCode = jedisClient.get(phoneNumber, String.class);
		if (validateCode.equals(originValidateCode)) {
			return true;
		}
		return false;
	}
	
	public String getOpenId(String userCode, String osType)
	{
		String openId = jedisClient.get(userCode, String.class);
		
		if (StringUtils.isEmpty(openId))
		{
			openId = wxTokenService.getOpenIdAndSaveUser(userCode, osType);
			if (!StringUtils.isEmpty(openId))
			{
				jedisClient.put(userCode, openId, 7200);
			}
		}
		return openId;
	}
	
	public String getOpenIdV2(String userCode, String osType)
	{
		String openId = jedisClient.get(userCode, String.class);
		//LOGGER.info("getOpenId, openId={}",openId);
		
		if (StringUtils.isEmpty(openId))
		{
			openId = wxTokenServiceV2.getOpenIdAndSaveUser(userCode, osType);
			if (!StringUtils.isEmpty(openId))
			{
				jedisClient.put(userCode, openId, 7200);
			}
		}
		return openId;
	}
	
	public void putWeixinId(String code, String weixinId) {
		String key = jedisClient.generateCacheKey(get_weixinid_key, code);
    	jedisClient.put(key, weixinId, 30*24*60*60);
	}
	
	public String getWeixinId(String code) {
		String key = jedisClient.generateCacheKey(get_weixinid_key, code);
		String weixinId = jedisClient.get(key, String.class);
    	return weixinId;
	}
	
	public void putOpenId(String code, String openId) {
		String key = jedisClient.generateCacheKey(get_openid_key, code);
		jedisClient.put(key, openId, 30*24*60*60);
	}
	
	public String getOpenId(String code) {
		String key = jedisClient.generateCacheKey(get_openid_key, code);
		String openId = jedisClient.get(key, String.class);
    	return openId;
	}
	
	/**
	 * 缓存点击appid的记录
	 * @param code
	 * @param statisticAppids
	 */
	public void putClickAppidRecord(String appid, Integer sa) {
		String key = jedisClient.generateCacheKey(get_clickappid_key, appid, System.currentTimeMillis() + "");
    	jedisClient.put(key, sa, 30*60);
	}
	
	public Integer getClickAppidRecord(String appid) {
		String[] keys = jedisClient.getCacheKeys(get_clickappid_key + "_" + appid + "_*");
    	return keys.length;
	}
	
	public void putAdPrice(String string, int sp_price) {
		String key = jedisClient.generateCacheKey(get_adprice_key + string);
		jedisClient.put(key, sp_price, 30*24*60*60);
	}
	
	public Integer getAdPrice(String string) {
		Integer price = jedisClient.get(get_adprice_key + string, Integer.class);
    	return price;
	}
	
	// 更新设备
	public void putDevice(String deviceCode, Device device) {
		String key = jedisClient.generateCacheKey(get_device_key + deviceCode);
		jedisClient.put(key, device, 3600);
	}
	
	public Device getDevice(String deviceCode) {
		Device device = jedisClient.get(jedisClient.generateCacheKey(get_device_key + deviceCode), Device.class);
		if (null != device) {
			return device;
		} else {
			device = deviceDao.getDeviceByDeviceCode(deviceCode);
			if (null != device) {
				jedisClient.put(jedisClient.generateCacheKey(get_device_key + deviceCode), device, 3600);
			}
		}
    	return device;
	}
	
	// 更新设备主id 账户扩展表
	public void putAccount(String owner, Account account) {
		String key = jedisClient.generateCacheKey(get_account_key + owner);
		jedisClient.put(key, account, 3600);
	}
	
	public Account getAccount(String owner) {
		Account account = jedisClient.get(jedisClient.generateCacheKey(get_account_key + owner), Account.class);
		if (null != account) {
			return account;
		} else {
			account = pushMsg2DeviceDao.getAccount(owner);
			if (null != account) {
				jedisClient.put(jedisClient.generateCacheKey(get_account_key + owner), account, 3600);
			}
		}
		return account;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	public void putWxUserToken (String key, String value){
		jedisClient.put(key, value, 3600);
	}
	
	public String getWxUserToken (String key){
        return jedisClient.get(key, String.class);
    }
	
	public void putCalc(String key,String value){
		jedisClient.put(key, value);
	}
	
	public String getCalc(String key){
		return jedisClient.get(key,  String.class);
	}
	
	public void putTaskAdRecordStart(String key,String value){
		jedisClient.put(key, value);
	}
	
	public String getTaskAdRecordStart(String key){
		return jedisClient.get(key,  String.class);
	}

	@Autowired
	private DeviceDao deviceDao;
	
	@Autowired
	private AdDao adDao;
	
	@Autowired
	private CustomDao customDao;
	
	@Autowired
	private WxPublicDao  wxPublicDao;
	
	@Autowired
	private AdScheduleDao  adScheduleDao;
	
	
	private static ReadWriteLock lockScheduleAllCount = new ReentrantReadWriteLock();
	
	private static ReadWriteLock lockLockBalance = new ReentrantReadWriteLock();
	
	
	//合适的广告、1分钟的缓存
	public List<DeviceAd> getSuitableWxAd(){
		String suitAd = jedisClient.get("suitableWxAd",  String.class);
		if (StringUtils.isEmpty(suitAd)){
			List<DeviceAd> listWxAd = adDao.getSuitableWxAd();
			jedisClient.put("suitableWxAd",  JsonUtils.obj2json(listWxAd), 60);
			return listWxAd;
		}else{
			List<DeviceAd>  listWxAd = JsonUtils.json2list(suitAd, DeviceAd.class);
			return listWxAd;
		}
		
	}
	
	
	public List<DeviceAd> updateSuitableWxAd(){
		List<DeviceAd> listWxAd = adDao.getSuitableWxAd();
		jedisClient.put("suitableWxAd", JsonUtils.obj2json(listWxAd), 60);
		return listWxAd;
	}
	
	
	public Integer getScheduleAllCount(int scheduleId){
		Integer scheduleAllCount = jedisClient.get("SCHEDULEALLCOUNT_"+scheduleId,  Integer.class);
		//从数据库里查
		if (scheduleAllCount==null || scheduleAllCount==0){
			Integer printPlus = adScheduleDao.getPrintPlusByScheduleId(scheduleId);
			jedisClient.put("SCHEDULEALLCOUNT_"+scheduleId,  printPlus);
			return printPlus;
		}
		
		return scheduleAllCount;
	}
	
	
	
	public void incScheduleAllCount(int scheduleId, int money){
		
		try {
			lockScheduleAllCount.readLock().lock();
			Integer scheduleAllCount = jedisClient.get("SCHEDULEALLCOUNT_"+scheduleId,  Integer.class);
			scheduleAllCount =  (scheduleAllCount==null?0:scheduleAllCount)+money;
			jedisClient.put("SCHEDULEALLCOUNT_"+scheduleId ,scheduleAllCount );
		
		} catch (Exception e) {
			LOGGER.error("incScheduleAllCount error:{}",e);
		}finally{
			lockScheduleAllCount.readLock().unlock();
        }
		
	}
	
	
	public Integer getLockBalance(int userId){
		Integer lockBalance = jedisClient.get("LOCKBALANCE_"+userId,  Integer.class);
		
		if (lockBalance==null){
			jedisClient.put("LOCKBALANCE_"+userId,  0);
		}
		
		
		return lockBalance;
	}
	
	
	
	public void incLockBalance(int userId, int money){
		
		try {
			lockLockBalance.readLock().lock();
			Integer lockBalance = jedisClient.get("LOCKBALANCE_"+userId,  Integer.class);
			
			lockBalance = (lockBalance==null?0:lockBalance)+money;
			jedisClient.put("LOCKBALANCE_"+userId ,lockBalance );
		
		} catch (Exception e) {
			LOGGER.error("incScheduleAllCount error:{}",e);
		}finally{
			lockLockBalance.readLock().unlock();
        }
		
	}
	
	
	
	public WxPublic getWxByAppid(String appid){
		String appidStr = jedisClient.get("APPID_"+appid, String.class);
		if (!StringUtils.isEmpty(appidStr)){
			return JsonUtils.json2obj(appidStr, WxPublic.class);
		}else{
			WxPublic wxPublic = wxPublicDao.getWxPublicByAppId(appid);
			 jedisClient.put("APPID_"+appid,JsonUtils.obj2json(wxPublic),3600);
			return wxPublic;
		}
	}
	
	
	
	//主微信号
	public DeviceMainWxInfo getDeviceMainWxInfo(String deviceCode){
		String deviceMainWxInfoStr = jedisClient.get("DeviceMainWxInfo_"+deviceCode, String.class);
		if (!StringUtils.isEmpty(deviceMainWxInfoStr)){
			return JsonUtils.json2obj(deviceMainWxInfoStr, DeviceMainWxInfo.class);
		}else{
			DeviceMainWxInfo deviceMainWxInfo =  deviceDao.getDeviceMainWxInfo(deviceCode);
			jedisClient.put("DeviceMainWxInfo_"+deviceCode, JsonUtils.obj2json(deviceMainWxInfo), 3600);
			return deviceMainWxInfo;
		}
	}
	
	public void updateDeviceMainWxInfo(String deviceCode, DeviceMainWxInfo deviceMainWxInfo){
		jedisClient.put("DeviceMainWxInfo_"+deviceCode, JsonUtils.obj2json(deviceMainWxInfo), 3600);
	}
	
	
	//获取用户信息
	public Custom findUserByUserId(int userId){
		String customStr = jedisClient.get("Custom_"+userId, String.class);
		if (!StringUtils.isEmpty(customStr)){
			return JsonUtils.json2obj(customStr,Custom.class);
		}else{
			Custom custom = customDao.findUserByUserId(userId);
			jedisClient.put("Custom_"+userId, JsonUtils.obj2json(custom), 3600);
			return custom;
		}
	}
	
	public int getUserPrintOrder(String openid){
		Integer orderRank = jedisClient.get("USERPRINTORDER_"+openid, Integer.class);
		if (orderRank!=null){
			return orderRank;
		}else{
			return 0;
		}
	}
	
	public void incUserPrintOrder(String openid){
		Integer orderRank = jedisClient.get("USERPRINTORDER_"+openid,  Integer.class);
		
		orderRank = (orderRank==null?0:orderRank)+1;
		jedisClient.put("USERPRINTORDER_"+openid ,orderRank,3600 );
	}
}
