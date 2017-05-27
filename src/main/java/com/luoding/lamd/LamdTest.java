package com.luoding.lamd;

import java.util.stream.Stream;

import static java.lang.System.*;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-9 上午6:33
 */
public class LamdTest {

    public static void main(String[] args) {

        Stream.generate(Math::random).limit(5).forEach(System.out::println);
        A a = () -> {
            System.out.println("hello");
        };
        test(() -> {
            System.out.println("hello");
        });
    }


    public static void test(A a) {

        a.say();
    }
}
