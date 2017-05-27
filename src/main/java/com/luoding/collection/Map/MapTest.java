package com.luoding.collection.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-30 下午2:17
 */
public class MapTest {

    static{
        i=4;
    }
    private static int i = 0;

    public static void main(String [] args){

        Map<String,String> maps = new HashMap<>();
        maps.put("name","name1");
        maps.put("name","name2");

        Map<String,String> treeMap = new TreeMap<>();

        maps.putAll(null);

        ConcurrentHashMap map;
    }
}
