package com.luoding.thread;

import java.util.concurrent.*;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-30 上午11:03
 */
public class CallableTest {

    public static Executor executor = Executors.newFixedThreadPool(2);
    Executor executor1 = Executors.newCachedThreadPool();

    public static void main(String [] args){

        CompletionService completionService = new ExecutorCompletionService<>(executor);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                if(2>1){
                    System.out.println("hello");
                    throw new Exception("hello");
                }
                return null;
            }
        };

        completionService.submit(callable);
        try {
            Future<String> task = completionService.take();
            System.out.println(task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
