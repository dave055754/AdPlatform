package com.wxc.adplatform.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wxc.adplatform.model.wx.WxCustomUser;

/**
 * 
 * WxUserDao(微信处理数据库相关操作)
 * @author lvyongwen
 * @date 2015年7月21日 下午2:42:49 
 * @version  [1.0, 2015年7月21日]
 * @since  version 1.0
 * @see [相关类/方法]
 */
@Repository
public interface WxUserDao
{
    /**
     * 
     * inUpWxCustomInfo(插入或者更新wx用户的信息)
     * @param customUser
     * @return void  返回类型 
     * @author lvyongwen
     * @date 2015年7月11日 下午2:49:54 
     * @version  [1.0, 2015年7月11日]
     * @since  version 1.0
     */
    void inUpWxCustomInfo(WxCustomUser customUser);
    
    WxCustomUser getWxCustomInfo(@Param(value = "wxUserId")  String wxUserId);
    
}
