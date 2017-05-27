package com.luoding.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date：16-8-26
 * Time：下午5:28
 *
 * @author ding.luo@corp.luoding .com
 */
public class PatternTest {

    public static void main(String [] args){
        String str  = "172.19.0.102";

        Pattern pattern = Pattern.compile("^172\\.19\\..*");
        Matcher matcher = pattern.matcher(str);


        System.out.println(matcher.matches());
    }
}
