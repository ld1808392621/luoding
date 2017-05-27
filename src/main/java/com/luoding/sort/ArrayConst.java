package com.luoding.sort;

import scala.collection.mutable.HashTable;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Date：16-9-21
 * Time：下午2:30
 *
 * @author ding.luo@corp.luoding .com
 */
public class ArrayConst {

    public static void main(String [] args){

        List<Integer> list = new ArrayList<Integer>();
        Random r = new Random();
        while(list.size()<20){
            Integer data = r.nextInt(20)+1;
            if(list.contains(data)){

            }else{

            }
            list.add(data);
            System.out.println(data);
        }

        System.out.println(list.toString());
        ConcurrentHashMap hashMap;
        Hashtable hashtable;
    }
}
