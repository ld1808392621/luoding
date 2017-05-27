package com.luoding.mq.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Date：16-9-9
 * Time：下午5:26
 *
 * @author ding.luo@corp.luoding .com
 */
public class Test {

    private final static String QUEUE_NAME = "hello";

    public static void main(String [] args){

        Map<String,String> maps = new HashMap<String,String>();
        maps.put("key","12");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(maps);

        JSONObject json = JSON.parseObject(jsonStr);
        System.out.println(json.getInteger("key")>10);
    }
}
