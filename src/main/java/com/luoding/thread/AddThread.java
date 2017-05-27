package com.luoding.thread;

/**
 * author: ding.luo
 * time: 17-3-6 下午3:32
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AddThread implements Runnable {
    private List<Double> list;

    public AddThread(List<Double> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; ++i) {
            list.add(Math.random());
        }
    }

    private static final int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) {
        List<Double> list1 = new CopyOnWriteArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        es.execute(new AddThread(list1));
        es.execute(new AddThread(list1));
        es.shutdown();
    }
}
