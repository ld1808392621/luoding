package com.luoding.singleton;


import java.util.Date;

/**
 * Date：16-8-14
 * Time：下午2:59
 *
 * @author ding.luo@corp.luoding .com
 */
public class Test {

    public static void main(String[] args) {

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.sayHello();

        Object obj = new Object();

        Date date = new Date();
        //Timestamp timestamp = new Timestamp();
        Float f = null;
    }
}
