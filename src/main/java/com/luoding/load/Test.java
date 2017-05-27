package com.luoding.load;

import com.luoding.load.inter.InterfaceTest;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-2 下午7:32
 */
public class Test {

    public static void main(String [] args){

        //对于类中静态变量代码执行根据定义的先后顺序执行
        ClassLoad classLoad = new ClassLoad();
        System.out.println(InterfaceTest.name);
        //InterfaceTest.name = "hello";
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(c == (a+b));
        System.out.println(g == (a+b));
    }
}
