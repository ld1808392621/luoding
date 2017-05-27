package com.luoding.test;

import org.apache.xml.resolver.apps.resolver;

import java.util.Vector;

/**
 * author: ding.luo
 * 递归实现字符串反转
 * time: 17-2-20 下午10:20
 */
public class Test2 {

    public static void main(String[] args) {

        System.out.println(reserver("gnidoul"));

        System.out.println(test());

        Vector vector = new Vector();
    }

    public static String reserver(String str){
        if(str.length() <=1){
            return str;
        }

        return reserver(str.substring(1)) + str.charAt(0);
    }


    public static int test(){

        int i = 10;
        try{
            return i;
        }catch (Exception e){

        }finally {
            i = 12;
            return i;
        }
    }
}
