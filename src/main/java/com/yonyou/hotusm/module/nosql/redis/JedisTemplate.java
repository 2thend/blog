package com.yonyou.hotusm.module.nosql.redis;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;

@Repository("jedisTemplate")
public class JedisTemplate {

    private static final Logger log = LoggerFactory.getLogger(JedisTemplate.class);

    @Autowired
    private RedisDataSource     redisDataSource;

    public void disconnect() {
    	Jedis Jedis = redisDataSource.getRedisClient();
        Jedis.disconnect();
    }

    /**
     * 设置单个值
     * 
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) {
        String result = null;

        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.set(key, value);
        } catch (Exception e) {
        	e.printStackTrace();
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    /**
     * 获取单个值
     * 
     * @param key
     * @return
     */
    public String get(String key) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }

        boolean broken = false;
        try {
            result = Jedis.get(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    
    /**
     * 是否存在这个key
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        Boolean result = false;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.exists(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    /**
     * 
     *    @return Status code reply, specifically: "none" if the key does not exist "string" if the key
     *         contains a String value "list" if the key contains a List value "set" if the key
   	 *         contains a Set value "zset" if the key contains a Sorted Set value "hash" if the key
     *         contains a Hash value
     */
    public String type(String key) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.type(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    /**
     * 设置某一个缓存在一个时间段后自动删除
     * 
     * @param key
     * @param unixTime
     * @return
     */
    public Long expire(String key, int seconds) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.expire(key, seconds);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    /**
     * 设置某一个缓存在某个时间点失效
     * 
     * @param key
     * @param unixTime
     * @return
     */
    public Long expireAt(String key, long unixTime) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.expireAt(key, unixTime);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    /**
     * 
     * 返回指定的可以的这个缓存剩下的存活时间,如果设置缓存没有设置expire的话,那么返回-1,如果不存在
     * 这个key的话,那么返回-2(在2.8以前的版本,这两种情况全部返回-1)
     * @param key
     * @return
     */
    public Long ttl(String key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.ttl(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    /**
     * 
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public boolean setbit(String key, long offset, boolean value) {

        Jedis Jedis = redisDataSource.getRedisClient();
        boolean result = false;
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.setbit(key, offset, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    /**
     * 
     * @param key
     * @param offset
     * @return
     */
    public boolean getbit(String key, long offset) {
        Jedis Jedis = redisDataSource.getRedisClient();
        boolean result = false;
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;

        try {
            result = Jedis.getbit(key, offset);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    
    /**
     * 
     * 设置某一段字符串的缓存
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public long setrange(String key, long offset, String value) {
        Jedis Jedis = redisDataSource.getRedisClient();
        long result = 0;
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.setrange(key, offset, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    
    /**
     * 返回字符串的某一段
     * @param key
     * @param startOffset
     * @param endOffset
     * @return
     */
    public String getrange(String key, long startOffset, long endOffset) {
        Jedis Jedis = redisDataSource.getRedisClient();
        String result = null;
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.getrange(key, startOffset, endOffset);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    
    /**
     * 返回指定key的值,并且
     * @param key
     * @param value
     * @return
     */
    public String getSet(String key, String value) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.getSet(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long setnx(String key, String value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.setnx(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    /**
     * 方法的重载  表示的是过期的时间
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public String setex(String key, int seconds, String value) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.setex(key, seconds, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long decrBy(String key, long integer) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.decrBy(key, integer);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long decr(String key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.decr(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long incrBy(String key, long integer) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.incrBy(key, integer);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long incr(String key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.incr(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long append(String key, String value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.append(key, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String substr(String key, int start, int end) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.substr(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long hset(String key, String field, String value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hset(key, field, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String hget(String key, String field) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hget(key, field);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long hsetnx(String key, String field, String value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hsetnx(key, field, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String hmset(String key, Map<String, String> hash) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hmset(key, hash);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public List<String> hmget(String key, String... fields) {
        List<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hmget(key, fields);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long hincrBy(String key, String field, long value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hincrBy(key, field, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Boolean hexists(String key, String field) {
        Boolean result = false;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hexists(key, field);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    /**
     * 删除缓存
     * @param key 键
     * @return
     */
    public Long del(String key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.del(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long hdel(String key, String field) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hdel(key, field);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long hlen(String key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hlen(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    
    /**
     * 返回一个指定key的Set集合
     * @param key
     * @return
     */
    public Set<String> hkeys(String key) {
        Set<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hkeys(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    /**
     * 返回指定key的List
     * @param key
     * @return
     */
    public List<String> hvals(String key) {
        List<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hvals(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    /**
     * 返回指定Key的map
     * @param key
     * @return
     */
    public Map<String, String> hgetAll(String key) {
        Map<String, String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.hgetAll(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    // ================list ====== l表示 list或 left, r表示right====================
    //在list中末尾增加一个数据
    public Long rpush(String key, String string) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.rpush(key, string);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    /**
     * 在List左边增加一个
     * @param key
     * @param string
     * @return
     */
    public Long lpush(String key, String string) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.lpush(key, string);

        } catch (Exception e) {
        	e.printStackTrace();
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    /**
     * 长度
     * @param key
     * @return
     */
    public Long llen(String key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.llen(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    /**
     * 显示list
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> lrange(String key, long start, long end) {
        List<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.lrange(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    /**
     * 截取list中的一部分
     * @param key
     * @param start
     * @param end
     * @return
     */
    public String ltrim(String key, long start, long end) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.ltrim(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String lindex(String key, long index) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.lindex(key, index);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String lset(String key, long index, String value) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.lset(key, index, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long lrem(String key, long count, String value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.lrem(key, count, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String lpop(String key) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.lpop(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String rpop(String key) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.rpop(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    //return 1 add a not exist value ,
    //return 0 add a exist value
    public Long sadd(String key, String member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.sadd(key, member);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<String> smembers(String key) {
        Set<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.smembers(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long srem(String key, String member) {
        Jedis Jedis = redisDataSource.getRedisClient();

        Long result = null;
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.srem(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String spop(String key) {
        Jedis Jedis = redisDataSource.getRedisClient();
        String result = null;
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.spop(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long scard(String key) {
        Jedis Jedis = redisDataSource.getRedisClient();
        Long result = null;
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.scard(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Boolean sismember(String key, String member) {
        Jedis Jedis = redisDataSource.getRedisClient();
        Boolean result = null;
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.sismember(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String srandmember(String key) {
        Jedis Jedis = redisDataSource.getRedisClient();
        String result = null;
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.srandmember(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zadd(String key, double score, String member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.zadd(key, score, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<String> zrange(String key, int start, int end) {
        Set<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.zrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zrem(String key, String member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {
            result = Jedis.zrem(key, member);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Double zincrby(String key, double score, String member) {
        Double result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zincrby(key, score, member);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zrank(String key, String member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrank(key, member);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zrevrank(String key, String member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrank(key, member);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<String> zrevrange(String key, int start, int end) {
        Set<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrange(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrangeWithScores(String key, int start, int end) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrangeWithScores(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrevrangeWithScores(String key, int start, int end) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrangeWithScores(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zcard(String key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zcard(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Double zscore(String key, String member) {
        Double result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zscore(key, member);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public List<String> sort(String key) {
        List<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.sort(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public List<String> sort(String key, SortingParams sortingParameters) {
        List<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.sort(key, sortingParameters);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zcount(String key, double min, double max) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zcount(key, min, max);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<String> zrangeByScore(String key, double min, double max) {
        Set<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrangeByScore(key, min, max);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<String> zrevrangeByScore(String key, double max, double min) {
        Set<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrangeByScore(key, max, min);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        Set<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrangeByScore(key, min, max, offset, count);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        Set<String> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrangeByScore(key, max, min, offset, count);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrangeByScoreWithScores(key, min, max);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrangeByScoreWithScores(key, max, min);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrangeByScoreWithScores(key, min, max, offset, count);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zremrangeByRank(String key, int start, int end) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zremrangeByRank(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zremrangeByScore(String key, double start, double end) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zremrangeByScore(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long linsert(String key, LIST_POSITION where, String pivot, String value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.linsert(key, where, pivot, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String set(byte[] key, byte[] value) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.set(key, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public byte[] get(byte[] key) {
        byte[] result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.get(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Boolean exists(byte[] key) {
        Boolean result = false;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.exists(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String type(byte[] key) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.type(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long expire(byte[] key, int seconds) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.expire(key, seconds);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long expireAt(byte[] key, long unixTime) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.expireAt(key, unixTime);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long ttl(byte[] key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.ttl(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public byte[] getSet(byte[] key, byte[] value) {
        byte[] result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.getSet(key, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long setnx(byte[] key, byte[] value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.setnx(key, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }
    
    /**
     * 设置在多少秒以后失效
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public String setex(byte[] key, int seconds, byte[] value) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.setex(key, seconds, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long decrBy(byte[] key, long integer) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.decrBy(key, integer);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long decr(byte[] key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.decr(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long incrBy(byte[] key, long integer) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.incrBy(key, integer);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long incr(byte[] key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.incr(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long append(byte[] key, byte[] value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.append(key, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public byte[] substr(byte[] key, int start, int end) {
        byte[] result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.substr(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long hset(byte[] key, byte[] field, byte[] value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hset(key, field, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public byte[] hget(byte[] key, byte[] field) {
        byte[] result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hget(key, field);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long hsetnx(byte[] key, byte[] field, byte[] value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hsetnx(key, field, value);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hmset(key, hash);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        List<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hmget(key, fields);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long hincrBy(byte[] key, byte[] field, long value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hincrBy(key, field, value);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Boolean hexists(byte[] key, byte[] field) {
        Boolean result = false;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hexists(key, field);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long hdel(byte[] key, byte[] field) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hdel(key, field);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long hlen(byte[] key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hlen(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<byte[]> hkeys(byte[] key) {
        Set<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hkeys(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Collection<byte[]> hvals(byte[] key) {
        Collection<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hvals(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Map<byte[], byte[]> hgetAll(byte[] key) {
        Map<byte[], byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.hgetAll(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long rpush(byte[] key, byte[] string) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.rpush(key, string);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long lpush(byte[] key, byte[] string) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.lpush(key, string);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long llen(byte[] key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.llen(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public List<byte[]> lrange(byte[] key, int start, int end) {
        List<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.lrange(key, start, end);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String ltrim(byte[] key, int start, int end) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.ltrim(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public byte[] lindex(byte[] key, int index) {
        byte[] result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.lindex(key, index);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public String lset(byte[] key, int index, byte[] value) {
        String result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.lset(key, index, value);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long lrem(byte[] key, int count, byte[] value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.lrem(key, count, value);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public byte[] lpop(byte[] key) {
        byte[] result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.lpop(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public byte[] rpop(byte[] key) {
        byte[] result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.rpop(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long sadd(byte[] key, byte[] member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.sadd(key, member);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<byte[]> smembers(byte[] key) {
        Set<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.smembers(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long srem(byte[] key, byte[] member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.srem(key, member);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public byte[] spop(byte[] key) {
        byte[] result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.spop(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long scard(byte[] key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.scard(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Boolean sismember(byte[] key, byte[] member) {
        Boolean result = false;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.sismember(key, member);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public byte[] srandmember(byte[] key) {
        byte[] result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.srandmember(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zadd(byte[] key, double score, byte[] member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zadd(key, score, member);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<byte[]> zrange(byte[] key, int start, int end) {
        Set<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrange(key, start, end);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zrem(byte[] key, byte[] member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrem(key, member);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Double zincrby(byte[] key, double score, byte[] member) {
        Double result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zincrby(key, score, member);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zrank(byte[] key, byte[] member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrank(key, member);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zrevrank(byte[] key, byte[] member) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrank(key, member);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<byte[]> zrevrange(byte[] key, int start, int end) {
        Set<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrange(key, start, end);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrangeWithScores(byte[] key, int start, int end) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrangeWithScores(key, start, end);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrevrangeWithScores(byte[] key, int start, int end) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrangeWithScores(key, start, end);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zcard(byte[] key) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zcard(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Double zscore(byte[] key, byte[] member) {
        Double result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zscore(key, member);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public List<byte[]> sort(byte[] key) {
        List<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.sort(key);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
        List<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.sort(key, sortingParameters);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zcount(byte[] key, double min, double max) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zcount(key, min, max);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
        Set<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrangeByScore(key, min, max);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count) {
        Set<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrangeByScore(key, min, max, offset, count);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrangeByScoreWithScores(key, min, max);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrangeByScoreWithScores(key, min, max, offset, count);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
        Set<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrangeByScore(key, max, min);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
        Set<byte[]> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrangeByScore(key, max, min, offset, count);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrangeByScoreWithScores(key, max, min);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count) {
        Set<Tuple> result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zrevrangeByScoreWithScores(key, max, min, offset, count);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zremrangeByRank(byte[] key, int start, int end) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zremrangeByRank(key, start, end);

        } catch (Exception e) {

            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long zremrangeByScore(byte[] key, double start, double end) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.zremrangeByScore(key, start, end);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }

    public Long linsert(byte[] key, LIST_POSITION where, byte[] pivot, byte[] value) {
        Long result = null;
        Jedis Jedis = redisDataSource.getRedisClient();
        if (Jedis == null) {
            return result;
        }
        boolean broken = false;
        try {

            result = Jedis.linsert(key, where, pivot, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            broken = true;
        } finally {
            redisDataSource.returnResource(Jedis, broken);
        }
        return result;
    }


}