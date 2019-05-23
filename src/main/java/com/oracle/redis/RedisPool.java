package com.oracle.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
	private static volatile JedisPool pool;
	
	public static JedisPool getJedis() {
		if(pool==null) {
			synchronized(RedisPool.class) {
				if(pool==null) {
					JedisPoolConfig config=new JedisPoolConfig();
					config.setMaxIdle(20);
					config.setMaxTotal(200);
					config.setMaxWaitMillis(8000);
					config.setTestOnBorrow(true);
					
					pool=new JedisPool(config,"192.168.50.14",6380,1000,"tiger");
				}
			}
		}
		
		return pool;
		
	}
	
	public static void test() {
		System.out.println(pool.getNumActive()+":"+pool.getNumIdle());
		
	}
	
	public static void close() {
		pool.close();
	}
}
