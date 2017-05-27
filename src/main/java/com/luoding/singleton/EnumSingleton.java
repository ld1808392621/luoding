package com.luoding.singleton;

/**
 * Date：16-8-14
 * Time：下午2:58
 *
 * @author ding.luo
 */
public enum EnumSingleton {

    //唯一的实例
    INSTANCE;

    public void sayHello(){
        System.out.println("hello");
    }
}
