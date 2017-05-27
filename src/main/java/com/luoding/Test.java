package com.luoding;

import com.luoding .pb.common.util.date.DateUtil;
import com.luoding.integer.IntegerTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date：16-5-19
 * Time：上午12:01
 *
 * @author ding.luo@corp.luoding .com
 */
public class Test {

    public static void main(String[] args) {


        ReentrantLock lock = new ReentrantLock();
        lock.tryLock();

        ConcurrentHashMap concurrentHashMap ;

        String str = "ndDVmiyahY2j\\TfnecggK0aV\\~lbEuBKx8";
        System.out.println(str.equals("ndDVmiyahY2jTfnecggK0aV~lbEuBKx8"));

        System.out.println(System.getProperty("myapplication.ip"));

        str = "deviceId////use creditCard//1464803969000//232492496";

        String[] strs = str.split("//");
        for (String s : strs) {
            System.out.println(s);
        }

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("hello");
        stringBuilder.append(" ");
        stringBuilder.append("world");
        System.out.println("stringBuilder   " + stringBuilder.toString());

        char[] ccs = "(orderState+F)&amp;(orderState+A)&amp;(orderState+C)".toCharArray();
        System.out.println(ccs.length);
        System.out.println(Boolean.parseBoolean(null));
        double time = System.currentTimeMillis();
        System.out.println(Double.valueOf(time).longValue());
        System.out.println("member//2000000004068522160//use phone".length());

        Date date = DateUtil.parseDate("2016-03-20 06:51:08", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date.getTime());

        List<String> list = new ArrayList<String>();
        list.add("luo");
        list.add("ding");
        System.out.println(list.toString());

        str = "2017-02-07   15:28:33";
        System.out.println(str.split("\\s+")[0]);


        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> maps = new HashMap<>();
        maps.put("name", "luoding");
        mapList.add(maps);
        maps.put("age", "123");
        mapList.add(maps);


        System.out.println(mapList.toString());
        StringBuffer buffer = new StringBuffer();
        StringBuilder stringBuilder1 = new StringBuilder();

       /* Executor executor = Executors.newScheduledThreadPool(3);
        Executor executor1 = Executors.newFixedThreadPool(10);
        executor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });*/

        test();


        String ss = "abcd";
        ss.substring(2);
        System.out.println(ss);
        int i = 2;
        int j = 3;
        j = (i & j)|i;
        i = (i&j);
        System.out.println(j+" "+i);
    }


    public static void test() {
        int[] array = new int[]{-2, -9, -3, -4, -6, -7, -6, -4};//示例数组
        int sum = 0;
        int start = 0;
        int end = 1;
        int newstart = 0;
        int big = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum <= 0) {
                sum = 0;
                newstart = i + 1;
            } else {
                if (sum > big) {
                    big = sum;
                    start = newstart;
                    end = i + 1;
                }
            }
        }
        for (int i = start; i < end; i++) {
            System.out.println(array[i]);
        }
    }
}
