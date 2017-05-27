package com.luoding.collection.array;

import java.util.*;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-8 下午10:12
 */
public class Test {

    public static void main(String [] args){
        List<String> ls = new ArrayList<String>();
        ls.isEmpty();
        List<String> linkedList = new LinkedList<>();
        linkedList.add("luoding");
        Iterator<String> iterator = ls.iterator();
        Map<String,String> maps = new HashMap<>();
        System.out.println("hello");
        Test test = new Test();
        A a = test.new A();
        a.a = 10;
        System.out.println(a.a);


        ls = new ArrayList<>();
        for(int i=0;i<10;i++){
            ls.add(i+"hh");
        }
        System.out.println(ls.toString());
        System.out.println(ls.subList(0,10).toString());
        System.out.println(System.currentTimeMillis());
    }

    public class A{

        public int a;
    }
}
