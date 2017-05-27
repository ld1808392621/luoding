package com.luoding.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * Date：16-9-23
 * Time：上午10:20
 *
 * @author ding.luo@corp.luoding .com
 */
public class RedisPipleTest {

    public static void main(String [] args){

        Jedis jedis = new Jedis("192.168.230.128",6379);
        Pipeline pipeline = jedis.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            pipeline.set("p" + i, "p" + i);
        }
        List<Object> results = pipeline.syncAndReturnAll();
        long end = System.currentTimeMillis();
        System.out.println("Pipelined SET: " + ((end - start)/1000.0) + " seconds");
        jedis.disconnect();
    }
}
