package com.luoding.proxy;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-29 下午11:24
 */
public class ProxyA implements ProxyInterface {

    @Override
    public String print(String name) {
        System.out.println(name+"A");
        return "hello";
    }
}
