package com.luoding.String;

/**
 * Date：16-10-13
 * Time：下午3:23
 *
 * @author ding.luo@corp.luoding .com
 */
public class StringSplitTest {

    public static void main(String [] args){

        String str = "luo|ding";
        String[] strs = str.split("\\|");
        for(String s:strs){
            System.out.println(s);
        }

        str = "192.168.2";
        String [] parts = str.split("\\.");
        System.out.println(parts.length);

    }
}
