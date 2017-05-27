package com.luoding.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

/**
 * Date：16-9-7
 * Time：下午8:21
 *
 * @author ding.luo@corp.luoding .com
 */
public class RedisScanTest {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.231.48", 6379);
        String cursor = "0";
        ScanParams params = new ScanParams();
        params.count(100);
        params.match("*~/~*");
        while (true) {

            ScanResult<String> result = jedis.scan(cursor, params);
            cursor = new String(result.getCursorAsBytes());
            System.out.println(cursor);
            if ("0".equals(cursor)) {
                break;
            }
        }

        jedis.close();
    }
}
