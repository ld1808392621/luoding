package com.luoding.ssdb;

import org.nutz.ssdb4j.SSDBs;
import org.nutz.ssdb4j.spi.Response;
import org.nutz.ssdb4j.spi.SSDB;

import java.io.IOException;
import java.util.Map;

/**
 * Date：16-5-24
 * Time：下午7:48
 *
 * @author ding.luo@corp.luoding .com
 */
public class SSDBTest {

    public static void main(String [] args) throws IOException {

        ssdbSimpleTest();
    }


    public static void  ssdbSimpleTest() throws IOException {
        SSDB ssdb = SSDBs.simple("192.168.230.128",8888,3000);
       /* Response response = ssdb.hgetall("wctrl-1-190000032101085361-1");
        Map<String, String> maps = response.mapString();
        for(String key:maps.keySet()){
            System.out.println(key);
            String value = maps.get(key);
            System.out.println(value);
        }*/

        ssdb.zset("name1","luoding",2);
        ssdb.zset("name1","luoding1",3);
        ssdb.zset("name1","luoding2",5);
        ssdb.zset("name1","luoding4",6);
        ssdb.zset("name1","luoding5",10);
        ssdb.zset("name1","luoding5",12);
        ssdb.zset("name1","luoding7",15);
        ssdb.zset("name1","luoding8",16);

        Response response = ssdb.zrange("name",4,2);
        Map<String,String> maps = response.mapString();

        response = ssdb.zscan("name1","name1",4,15,3);
        Map<String,String>maps1 = response.mapString();
        ssdb.close();

    }

    public static void ssdbPoolTest(){

    }
}
