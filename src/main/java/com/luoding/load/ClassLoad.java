package com.luoding.load;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-2 下午7:31
 */
public class ClassLoad {

    private static final A a = new A("a");
    static {
        System.out.println("static");
    }
    private static final A a1 = new A("a1");

    public ClassLoad(){
        System.out.println("init");
    }
}
