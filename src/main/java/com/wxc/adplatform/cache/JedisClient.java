package com.wxc.adplatform.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wxc.adplatform.util.ExceptionLevel;
import com.wxc.adplatform.util.ExceptionMessage;
import com.wxc.adplatform.util.ExceptionUtils;
import com.wxc.adplatform.util.JsonUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.Transaction;




/**
 * 
 * jedis client操作类<br>
 * 
 * @author fanyaowu
 * @data 2014年10月10日
 * @version 1.0.0
 *
 */
public class JedisClient
{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JedisClient.class);

	// redis 服务器IP
	private String redisServerIp;

	// redis 服务器端口
	private int redisServerPort;
	
	private String password;

	private JedisPool jedisPool;
	
	private String exceptionUrl = "http://127.0.0.1:28030/platform/manager/exception";

	public JedisClient(String redisServerIp, int redisServerPort, String password)
	{
		super();
		this.redisServerIp = redisServerIp;
		this.redisServerPort = redisServerPort;
		this.password = password;

		JedisPoolConfig config = new JedisPoolConfig();

		// maxIdle: 链接池中最大空闲的连接数,默认为8.
		config.setMaxIdle(5);
		
		// minIdle: 连接池中最少空闲的连接数,默认为0.
		config.setMinIdle(1);
		
		// 最大连接数
		config.setMaxTotal(50);
		
		// 当连接池资源耗尽时，调用者最大阻塞的时间，超时将跑出异常。单位，毫秒数;默认为-1.表示永不超时.
		config.setMaxWaitMillis(1000 * 10);
		
		// minEvictableIdleTimeMillis: 连接空闲的最小时间，达到此值后空闲连接将可能会被移除。负值(-1)表示不移除，默认为半个小时，这里设置为5分钟
		config.setMinEvictableIdleTimeMillis(300000);

		// testOnBorrow: 向调用者输出链接资源时，是否检测是有有效，如果无效则从连接池中移除，并尝试继续获取。默认为false。
		config.setTestOnBorrow(true);

		// testOnReturn: 向连接池归还链接时，是否检测链接对象的有效性。默认为false。
		config.setTestOnReturn(true);

		if (!StringUtils.isEmpty(password)){
			jedisPool = new JedisPool(config, redisServerIp, redisServerPort, Protocol.DEFAULT_TIMEOUT, password);
		}else{
			jedisPool = new JedisPool(config, redisServerIp, redisServerPort, Protocol.DEFAULT_TIMEOUT);
		}
		
		
		
	}

	public String getRedisServerIp()
	{
		return redisServerIp;
	}

	public void setRedisServerIp(String redisServerIp)
	{
		this.redisServerIp = redisServerIp;
	}

	public int getRedisServerPort()
	{
		return redisServerPort;
	}

	public void setRedisServerPort(int redisServerPort)
	{
		this.redisServerPort = redisServerPort;
	}
	
	public JedisPool getJedisPool()
	{
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool)
	{
		this.jedisPool = jedisPool;
	}

	/**
	 * 
	 * 填充缓存<br>
	 *
	 * @param key
	 * @param value
	 * void
	 * @Author fanyaowu
	 * @data 2014年10月10日
	 * @exception 
	 * @version
	 *
	 */
	public void put(String key, Object value)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();

			jedis.set(key, JsonUtils.obj2json(value));
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to set cache key: {}",key);
			LOGGER.error(e.toString());
			
			// TODO 发送邮件
			ExceptionMessage exceptionMsg = ExceptionUtils.gernelExceptionMsg("NONE", "PLATFORM", "NO_VERSION", "SERVER",
					ExceptionLevel.CRITICAL, "Put cache info", ExceptionUtils.getStackTraceMsg(e));
			ExceptionUtils.sendExceptionMsg(exceptionUrl, exceptionMsg);
			
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * 指定时间失效, 时间为1970.1.1以来的秒数, 注意是秒, 不是毫秒<br>
	 * @param key
	 * @param value
	 * @param expireAtTime 1970.1.1 以来的秒数
	 * void
	 * @Author chenxiaojin
	 * @date 2015年1月15日
	 * @exception 
	 * @version
	 */
	public void put(String key, Object value, long expireAtTime)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();

			jedis.set(key, JsonUtils.obj2json(value));
			
			jedis.expireAt(key, expireAtTime);
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to set cache key: {}",key);
			
			// TODO 发送邮件
			
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * 
	 * 填充缓存<br>
	 *
	 * @param key
	 * @param value
	 * @param expireTime 缓存的过期时间，单位为S
	 * void
	 * @Author fanyaowu
	 * @data 2014年10月10日
	 * @exception 
	 * @version
	 *
	 */
	public void put(String key, Object value, int expireTime)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();

			jedis.set(key, JsonUtils.obj2json(value));
			
			jedis.expire(key, expireTime);
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to set cache key: {}",key);
			
			// TODO 发送邮件
			
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * 
	 * 读取缓存<br>
	 *
	 * @param key
	 * @param value
	 * void
	 * @Author fanyaowu
	 * @data 2014年10月10日
	 * @exception 
	 * @version
	 *
	 */
	public <T> T get(String key,  Class<T> clazz)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			String value = jedis.get(key);
			T t = JsonUtils.json2obj(value, clazz);
			
			return t;
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to get cache key: {}",key);
			LOGGER.error(e.toString());
			
			// TODO 发送邮件
			ExceptionMessage exceptionMsg = ExceptionUtils.gernelExceptionMsg("NONE", "PLATFORM", "NO_VERSION", "SERVER",
					ExceptionLevel.CRITICAL, "Get cache info", ExceptionUtils.getStackTraceMsg(e));
			ExceptionUtils.sendExceptionMsg(exceptionUrl, exceptionMsg);
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		
		return null;
	}
	
	/**
	 * 
	 * 获取某key的缓存，该key对应的缓存为list<br>
	 *
	 * @param key
	 * @param clazz
	 * @return
	 * List<T>
	 * @Author fanyaowu
	 * @data 2014年10月12日
	 * @exception 
	 * @version
	 *
	 */
	public <T>List<T> getList(String key,  Class<T> clazz)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			
			String value = jedis.get(key);
			
			List<T> tList = JsonUtils.json2list(value, clazz);
			
			return tList;
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to get cache key: {}",key);
			
			// TODO 发送邮件
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		
		return null;
	}
	
	/**
	 * 
	 * 获取某key的缓存，该key的缓存对应的map<br>
	 *
	 * @param key
	 * @param clazz
	 * @return
	 * Map<String,T>
	 * @Author fanyaowu
	 * @data 2014年10月12日
	 * @exception 
	 * @version
	 *
	 */
	public <T> Map<String,T> getMap(String key,  Class<T> clazz)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			
			String value = jedis.get(key);
			
			Map<String,T> tMap = JsonUtils.json2map(value, clazz);
			
			return tMap;
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to get cache key: {}",key);
			
			// TODO 发送邮件
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		
		return null;
	}
	
	
	public void clear(String key)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			
			jedis.del(key);
			
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to get cache key: {}",key);
			
			// TODO 发送邮件
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		
	}
	
	
	/**
	 * 
	 * 原子计数器加1<br>
	 *
	 * @param key
	 * @return  返回-1 表示错误
	 * Long
	 * @Author fanyaowu
	 * @data 2014年10月11日
	 * @exception 
	 * @version
	 *
	 */
	public Long atomIncrease(String key)
	{
		Jedis jedis = null;
		
		try
		{
			jedis = jedisPool.getResource();
			
			return jedis.incr(key);
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to atom increase 1 for cache key: {}",key);
			
			// TODO 发送邮件
			
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		
		// 返回-1 表示错误
		return -1L;
		
	}
	
	/**
	 * 
	 * 原子计数器加n<br>
	 *
	 * @param key
	 * @return  返回-1 表示错误
	 * Long
	 * @Author fanyaowu
	 * @data 2014年10月11日
	 * @exception 
	 * @version
	 *
	 */
	public Long atomIncrease(String key,int count)
	{
		Jedis jedis = null;
		
		try
		{
			jedis = jedisPool.getResource();
			
			return jedis.incrBy(key, count);
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to atom increase {} for cache key: {}",count,key);
			
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		
		// 返回-1 表示错误
		return -1L;
		
	}
	
	/**
	 * 
	 * 原子计数器减1<br>
	 *
	 * @param key 
	 * @return 返回-1 表示错误
	 * Long
	 * @Author fanyaowu
	 * @data 2014年10月11日
	 * @exception 
	 * @version
	 *
	 */
	public Long atomDecrease(String key)
	{
		Jedis jedis = null;
		
		try
		{
			jedis = jedisPool.getResource();
			
			return jedis.decr(key);
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to  atom decrease 1 for cache key: {}",key);
			
			// TODO 发送邮件
			
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		
		// 返回-1 表示错误
		return -1L;
		
	}
	
	/**
	 * 
	 * 原子计数器减n<br>
	 *
	 * @param key 
	 * @return 返回-1 表示错误
	 * Long
	 * @Author fanyaowu
	 * @data 2014年10月11日
	 * @exception 
	 * @version
	 *
	 */
	public Long atomDecrease(String key, int count)
	{
		Jedis jedis = null;
		
		try
		{
			jedis = jedisPool.getResource();
			
			return jedis.decrBy(key, count);
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to  atom decrease {} for cache key: {}",count,key);
			
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		
		// 返回-1 表示错误
		return -1L;
		
	}
	

	/**
	 * 
	 * 获取缓存key的原子计数值<br>
	 *
	 * @param key
	 * @return
	 * Long
	 * @Author fanyaowu
	 * @data 2014年10月11日
	 * @exception 
	 * @version
	 *
	 */
	public int getAtomCount(String key)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			
			String value = jedis.get(key);
			
			return Integer.valueOf(value);
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to get atom count for key: {}",key);
			
			// TODO 发送邮件
			
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		
		return 0;
	}
	
	/**
	 * 
	 * 获取缓存key的原子计数值<br>
	 *
	 * @param key
	 * @return
	 * Long
	 * @Author fanyaowu
	 * @data 2014年10月11日
	 * @exception 
	 * @version
	 *
	 */
	public Long getAtomCountWithLong(String key)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			
			String value = jedis.get(key);
			
			return null == value ? 0L : Long.valueOf(value);
			
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to get atom count for key: {}",key);
			
			// TODO 发送邮件
			
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		
		return 0L;
	}
	
	/**
	 * 
	 * 生成缓存key，参数之间用下划线分割<br>
	 *
	 * @param params
	 * @return
	 * String
	 * @Author fanyaowu
	 * @data 2014年7月20日
	 * @exception 
	 * @version
	 *
	 */
	public String generateCacheKey(String... params)
	{
		if (ArrayUtils.isEmpty(params))
		{
			return null;
		}

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < params.length; i++)
		{
			sb.append(params[i]);

			if ((params.length - i) > 1)
			{
				sb.append('_');
			}
		}
		// key全部采用大写
		return sb.toString().toUpperCase(Locale.US);

	}
	
	/**
	 * 获取缓存key<br>
	 * @param pattern
	 * @return
	 * String[]
	 * @Author chenxiaojin
	 * @date 2014年11月29日
	 * @exception 
	 * @version
	 */
	public String[] getCacheKeys(String pattern)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			
			Set<String> value = jedis.keys(pattern);
			
			if (!value.isEmpty())
			{
				return value.toArray(new String[value.size()]);
			}
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to get key by pattern: {}", pattern);
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		return null;
	}
	
	/**
	 * 根据key删除缓存<br>
	 * @param key
	 * void
	 * @Author chenxiaojin
	 * @date 2014年11月29日
	 * @exception 
	 * @version
	 */
	public void deleteKeys(String... key)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			
			jedis.del(key);
			
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to delete cache key: {}",key);
			
			// TODO 发送邮件
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
	}
	
	public int getActive()
	{
		return jedisPool.getNumActive();
	}
	
	/**
	 * 批量将对象放入缓存<br>
	 * @param keyValueMap
	 * void
	 * @Author chenxiaojin
	 * @date 2015年1月6日
	 * @exception 
	 * @version
	 */
	public void batchPut(Map<String, Object> keyValueMap)
	{
		Set<String> keySet = keyValueMap.keySet();
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			Pipeline pipeLine = jedis.pipelined();
			for (String key: keySet)
			{
				pipeLine.set(key, JsonUtils.obj2json(keyValueMap.get(key)));
			}
			pipeLine.sync();
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("[Redis] Failed to execute put multi key.Exception:{}", e);
			// TODO 发送邮件
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * 在事务中存放缓存<br>
	 * @param key
	 * @param value
	 * void
	 * @Author chenxiaojin
	 * @date 2015年1月6日
	 * @exception 
	 * @version
	 */
	public void transPut(String key, Object value)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			Transaction tx = jedis.multi();
			tx.set(key, JsonUtils.obj2json(value));
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("Failed to set cache key: {}",key);
			LOGGER.error(e.toString());
			
			// TODO 发送邮件
			ExceptionMessage exceptionMsg = ExceptionUtils.gernelExceptionMsg("NONE", "PLATFORM", "NO_VERSION", "SERVER",
					ExceptionLevel.CRITICAL, "Put cache info with transaction", ExceptionUtils.getStackTraceMsg(e));
			ExceptionUtils.sendExceptionMsg(exceptionUrl, exceptionMsg);
			
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * 批量获取缓存对象, 仅支持同一类型对象<br>
	 * @param clazz
	 * @param keys
	 * @return
	 * List<T>
	 * @Author chenxiaojin
	 * @date 2015年1月7日
	 * @exception 
	 * @version
	 */
	public <T>List<T> batchGet(Class<T> clazz, String... keys)
	{
		Jedis jedis = null;
		try
		{
			jedis = jedisPool.getResource();
			// 通过管道批量执行
			Pipeline pipeLine = jedis.pipelined();
			for (String key: keys)
			{
				pipeLine.get(key);
			}
			List<Object> objList = pipeLine.syncAndReturnAll();
			if (objList.isEmpty())
			{
				return null;
			}
			// 转换成对应对象
			List<T> resultList = new ArrayList<T>(20);
			for (Object obj : objList)
			{
				T t = JsonUtils.json2obj(obj.toString(), clazz);
				// 转换成功的对象才加入列表, 避免空指针异常
				if (null != t)
				{
					resultList.add(JsonUtils.json2obj(obj.toString(), clazz));
				}
			}
			return resultList;
		}
		catch (Exception e)
		{
			// 记录日志
			LOGGER.error("[Redis] Failed to execute get multi key.Exception:{}", e);
			// TODO 发送邮件
		}
		finally
		{
			jedisPool.returnResource(jedis);
		}
		return null;
	}
	public Jedis getJedis()
	{
		return jedisPool.getResource();
	}
	
}
