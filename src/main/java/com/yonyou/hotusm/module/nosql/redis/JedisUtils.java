package com.yonyou.hotusm.module.nosql.redis;

import redis.clients.jedis.Jedis;


@SuppressWarnings("unused")
public class JedisUtils {
	
		private static final String OK_CODE = "OK";
	    private static final String OK_MULTI_CODE = "+OK";
	    
	    public JedisUtils() {}
	    
	    public static boolean isStatusOk(String status)
	    {
	     return (status != null) && (("OK".equals(status)) || ("+OK".equals(status)));
	    }
	    

	 public static void destroyJedis(Jedis jedis)
	    {
	      if ((jedis != null) && (jedis.isConnected())) {
	        try {
	          try {
	            jedis.quit();
	          }
	          catch (Exception e) {}
	          jedis.disconnect();
	        }
	        catch (Exception e) {}
	      }
	    }
	    
}
