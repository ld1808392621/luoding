package com.luoding.proxy;

/**
 * author: ding.luo
 * time: 17-2-15 下午4:30
 */
public class A implements ProxyInterface {

    @Override
    public String print(String name) {
        System.out.println(name);
        return "hello";
    }
}
