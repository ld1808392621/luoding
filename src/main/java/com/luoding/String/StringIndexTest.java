package com.luoding.String;

/**
 * Date：16-10-17
 * Time：下午8:20
 *
 * @author ding.luo@corp.luoding .com
 */
public class StringIndexTest {

    public static void main(String [] args){

        String str = "wctrl-3-CDB6967D-E37E-41E9-B2A4-561A48AE28C7-1";

        int index1 = str.indexOf("-",6);
        System.out.println(index1);
        System.out.println(str instanceof String);
    }
}
