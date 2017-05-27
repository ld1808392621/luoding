package com.luoding.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-3 下午8:14
 */
public class ThreadTest {

    private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

    public static void main(String [] args){

        Thread t = new Thread(){
            @Override
            public void run(){
                while(true){
                    try {
                        Thread.sleep(1000);
                        System.out.println("sleep");
                    } catch (InterruptedException e) {
                        System.out.println("线程中断");
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        t.start();
        try {
            queue.put("hello");
            queue.put("hello");
            queue.put("hello");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.interrupt();
        t.interrupt();
        t.interrupt();
        t.interrupt();

        try {
            queue.put("hello");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
