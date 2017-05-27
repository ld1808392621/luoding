package com.luoding.map;

import java.util.Set;
import java.util.TreeMap;

/**
 * Date：16-8-11
 * Time：下午5:35
 *
 * @author ding.luo@corp.luoding .com
 */
public class TreeMapTest {

    public static void main(String [] args){

        TreeMap<Integer,String> maps = new TreeMap<Integer, String>();
        maps.put(1,"1");
        maps.put(5,"5");
        maps.put(2,"2");
        maps.put(12,"12");
        maps.put(10,"10");
        maps.put(8,"8");
        maps.put(6,"6");
        Set<Integer> sets = maps.keySet();
        for(Integer i:sets){
            System.out.println(i);
        }

    }
}
