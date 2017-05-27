package com.luoding.redis;

import org.nutz.ssdb4j.SSDBs;
import org.nutz.ssdb4j.spi.SSDB;

import java.io.*;

/**
 * Date：16-5-19
 * Time：下午8:14
 *
 * 客史数据初始化
 * @author ding.luo@corp.luoding .com
 */
public class RedisValueInit {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("new_2.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//        Jedis jedis = new Jedis("192.168.231.48",6379);
        SSDB ssdb = SSDBs.simple("192.168.231.48",8888,3000);
        try {
            String line = "";
            while (true) {
                line = br.readLine();
                if (null == line || "".equals(line)) {
                    break;
                }
                System.out.println(line);
                String data = line.split("\\s+")[2];
                String[] fields = data.split(";");
                String key = fields[0].split(":")[1];
                String field = fields[1].split(":")[1];
                String value = fields[2].split(":")[1];
                ssdb.hset(key,field,value);
            }
            br.close();
            ssdb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
