package com.luoding.json;

import net.sf.json.JSONObject;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-12-20 下午7:52
 */
public class NetJsonTest {

    public static void main(String [] args){

        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonObject.getString("123"));
    }
}
