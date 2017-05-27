package com.luoding.thread;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * author: ding.luo
 * time: 17-2-22 上午10:40
 */
public class ThreadTest2 {

    public static void main(String [] args){

        int test = 123_345;
        System.out.println(test);

        Random random = new Random();
        System.out.println(random.nextInt(100));

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
                Random random = new Random();
                throw new IllegalArgumentException("hh");
            }
        });

    }
}
