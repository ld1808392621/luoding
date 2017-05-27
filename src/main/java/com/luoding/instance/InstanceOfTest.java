package com.luoding.instance;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-12-20 下午4:14
 */
public class InstanceOfTest {


    public static void main(String [] args){

        System.out.println(null instanceof String);


        JSONObject jsonObject = new JSONObject();
        List<String> rules = new ArrayList<>();
        rules.add("luoding");
        jsonObject.put("listStr", rules.toString());
        System.out.println(jsonObject.getString("123"));
        System.out.println(jsonObject.getString("listStr"));
        String str = jsonObject.getString("listStr").toString();
        Gson gson = new Gson();
        List<String> parseList = gson.fromJson("[\"luoding\",123]",new TypeToken<List<String>>(){}.getType());

        System.out.println(parseList.get(1));
    }
}
