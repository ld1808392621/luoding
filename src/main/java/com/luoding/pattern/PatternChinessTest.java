package com.luoding.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 18083 on 16-10-20.
 */
public class PatternChinessTest {

    public static void main(String [] args){

        String name = "罗丁1d";
        String name1 = "wd罗丁d";
        String name2 = "d1罗丁";
        String name3 = "罗丁";
        Pattern pattern = Pattern.compile(".*[\\u4e00-\\u9fa5]+?[a-zA-Z0-9]+?.*");
        Pattern pattern1 = Pattern.compile(".*[a-zA-Z0-9]+?[\\u4e00-\\u9fa5]+?.*");

//        Matcher matcher = pattern.matcher(name);
//        Matcher matcher1 = pattern1.matcher(name2);
//        System.out.println(matcher.find());
//        System.out.println(matcher1.find());
        Matcher matcher2 = pattern1.matcher(name3);
        System.out.println(matcher2.find());
        //System.out.println(matcher.lookingAt());  //开始部分匹配
        //System.out.println(matcher.matches());    //整个匹配


    }
}
