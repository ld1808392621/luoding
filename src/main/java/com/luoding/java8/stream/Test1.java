package com.luoding.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author: ding.luo
 * time: 17-5-27 上午12:45
 */
public class Test1 {

    public static void main(String [] args) {

        long list = Stream.of("a","b","c").collect(Collectors.toList()).stream().count();

        List<A> as = new ArrayList<>();
        as.add(new A(1));
        List<B> bs = as.stream().map(a -> {
            return new B();
        }).collect(Collectors.toList());
        System.out.println(bs.size());
    }
}
