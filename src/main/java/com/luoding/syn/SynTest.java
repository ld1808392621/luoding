package com.luoding.syn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: ding.luo
 * time: 17-2-21 下午9:41
 */
public class SynTest {

    public static void main(String [] args){


        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
    }
}
