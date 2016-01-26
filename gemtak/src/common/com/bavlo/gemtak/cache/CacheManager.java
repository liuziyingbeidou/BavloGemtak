package com.bavlo.gemtak.cache;

/**
 * @description:cache Manager, get cache instance
 * @author:liming
 * @mail:liming@sogou-inc.com
 * @date:2014-5-5 下午7:48:41
 * @version:v1.0
 */
public class CacheManager {

	/**
	 * 缓存位置
	 * @author liming
	 *
	 */
	public enum CacheWhere{
		ehcache
	}
	
	private static CacheManager instance = new CacheManager();;
	
	public static CacheManager getInstance()
	{
		return instance;
	}
	
	/**
	 * 设置缓存
	 * @param key：缓存主�?	 * @param value：缓存内�?	 * @param cacheWhere：缓存位�?	 */
	public static void set(String key , Object value , CacheWhere cacheWhere){
		if (cacheWhere.equals(CacheWhere.ehcache)) {
			EhcacheHandler.getInstance().set(EhcacheHandler.FOREVER_CACHE,key, value);
		}
	}

}
