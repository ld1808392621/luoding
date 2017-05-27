package com.luoding.String;

import org.h2.util.StringUtils;

/**
 * Date：16-10-13
 * Time：下午3:36
 *
 * @author ding.luo@corp.luoding .com
 */
public class StringCombineTest {

    public static void main(String [] args){

        String name ="luo di\\ng";
        String [] parts = name.split("\\s+");
        System.out.println(parts.length);
        System.out.println(parts[1]);

        System.out.println(StringUtils.arrayCombine(parts,'|'));
    }
}
