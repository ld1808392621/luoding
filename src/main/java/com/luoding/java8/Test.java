package com.luoding.java8;

/**
 * author: ding.luo
 * time: 17-5-26 上午12:38
 */
public class Test {

    public static void main(String [] args){

        test1(name->System.out.println(name));
        InterfaceA a = (name)->System.out.println(name);
        InterfaceB b = () -> {
            System.out.println("hello");
            System.out.println("luoding");
        };
        System.out.println("hello");

        IterfaceC abstractA = (a1,b1,c1) -> System.out.println();
    }

    public static void test1(InterfaceA a) {
        a.print("luoding");
    }
}
