package com.luoding.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisAskDataException;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Date：16-5-19
 * Time：上午12:01
 *
 * @author ding.luo@corp.luoding .com
 */
public class RedisTest {

    public static void main(String[] args) {

        final JedisPool jedisPool = new JedisPool("192.168.14.48",6379);

        final String key = "zset";

        for(int n=0;n<100;n++){
            final int index = n;
            Thread t0 = new Thread(() -> {
                String id = Thread.currentThread().getId()+"";
                Jedis jedis = jedisPool.getResource();
                for(int i=index*10000;i<(index+1)*10000;i++){
                    jedis.zadd(key,i,id+i);
                }
                System.out.println("t0");
            });
            t0.start();
        }
    }
}
