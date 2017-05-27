package com.luoding.thread;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-12-13 下午1:58
 */
public class ThreadTest1 {

    public static void main(String[] args) throws InterruptedException {

        /*Thread t = new Thread(() -> {
            while(true){
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                    System.out.println("sleep");
                } catch (InterruptedException e) {
                    System.out.println("中断");
                    Thread.currentThread().interrupt();
                }
            }
        });

        //就是就是一个非常普通的方法
        t.run();
        t.start();
        Thread.sleep(2000);
        t.interrupt();
        Thread.sleep(2100);
        t.interrupt();
        Thread.sleep(2100);
        t.interrupt();
        Thread.sleep(2100);
        t.interrupt();*/


        Thread t = new Thread() {
            public void run() {
                while (true) {
                    System.out.println("hello");
                    try {
                        if(Thread.currentThread().isInterrupted()){
                            Thread.interrupted();
                            continue;
                        }
                        Thread.sleep(1000);
                        System.out.println("sleep");
                    } catch (InterruptedException e) {
                        System.out.println("中断");
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        //就是就是一个非常普通的方法
        t.start();
        Thread.sleep(2000);
        t.interrupt();
        Thread.sleep(2100);
        t.interrupt();
        Thread.sleep(2100);
        t.interrupt();
        Thread.sleep(2100);
        t.interrupt();
    }
}
