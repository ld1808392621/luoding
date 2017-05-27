package com.luoding.String;

/**
 * Date：16-10-13
 * Time：下午2:39
 *
 * @author ding.luo@corp.luoding .com
 */
public class StringBuilderTest {

    public static void main(String [] args){

        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("luoding").append("hello");
        System.out.println(stringBuilder.toString());
    }
}
