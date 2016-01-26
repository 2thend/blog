package com.yonyou.hotusm.module.nosql.redis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {

    private static final Logger log = LoggerFactory.getLogger(RedisDataSourceImpl.class);

    @Autowired
    private JedisSentinelPool    shardedJedisPool;

    public Jedis getRedisClient() {
        try {
            Jedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            log.error("getRedisClent error", e);
        }
        return null;
    }

    public void returnResource(Jedis shardedJedis) {
    	//shardedJedisPool.close();
        shardedJedisPool.returnResource(shardedJedis);
    }

    public void returnResource(Jedis shardedJedis, boolean broken) {
        if (broken) {
        	//shardedJedisPool.close();
        	shardedJedisPool.returnBrokenResource(shardedJedis);
        } else {
        	//shardedJedisPool.close();
            shardedJedisPool.returnResource(shardedJedis);
        }
    }
}