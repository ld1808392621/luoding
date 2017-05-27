package com.luoding.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * author: ding.luo
 * time: 17-2-21 下午11:04
 */
public class ReflectTest {

    public static void main(String [] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        String s = String.class.newInstance();

        String s1 = String.class.getConstructor(String.class).newInstance("hello");
        System.out.println(s1);

        A a = new A();
        Method method = a.getClass().getMethod("setAge",Long.class);
        System.out.println(null == method);


    }
}
