package com.luoding.singleton;

/**
 * author: ding.luo
 * time: 17-2-21 下午11:41
 */
public class A {

    private static volatile A a = null;

    private A() {
        throw new RuntimeException("该类是单列");
    }

    public static A getInstance() {

        if (null == a) {
            synchronized (A.class) {
                if (null == a) {
                    a = new A();
                }
            }
        }

        return a;
    }
}
