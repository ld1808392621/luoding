package com.luoding.thread;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-11 下午7:04
 */
public class LocalThreadTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.set(Thread.currentThread().getName());
                    printId();
                }
            });
            t.setName("i"+i);
            t.start();
        }
    }

    public static void printId(){
        System.out.println(threadLocal.get());
    }

}
