package com.yonyou.hotusm.common.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


/**
 * 缓存工具类
 * @author Hotusm
 *
 */
public class CacheUtils {
	
	private static CacheManager cacheManager=SpringContextHolder.getBean("cacheManager");
	
	private static final String SYS_CACHE="sysCache";
	
	//获取缓存 没有的话就生成一个 并且返回
	public static Cache getCache(String cacheName){
		Cache cache=cacheManager.getCache(cacheName);
		if(cache!=null){
			return cache;
		}
		cacheManager.addCache(cacheName);
		cache=cacheManager.getCache(cacheName);
		cache.getCacheConfiguration().setEternal(true);
		return cache;
	}
	//将缓存键值插入到
	public static void put(String cacheName,String key,String value){
		Element element=new Element(key,value);
		getCache(cacheName).put(element);
	}
	
	public static void put(String key,String value){
		
		Element element=new Element(key,value);
		getCache(SYS_CACHE).put(element);
	}
	//根据 缓存名和键获取变量
	public static Object get(String cacheName,String key){
		Element element=getCache(cacheName).get(key);
		
		return element==null?null:element.getObjectValue();
	}
	//根据键获取缓存中的值
	public static Object get(String key){
		return get(SYS_CACHE,key);
	}
	//删除缓存
	public static void remove(String key){
		remove(SYS_CACHE, key);
	}
	
	public static void remove(String cacheName,String key){
		if(get(key)==null){
			return;
		}
		getCache(cacheName).remove(key);
	}
	
}
