package com.luoding.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * author: ding.luo@corp.luoding .com
 * time: 17-1-10 下午3:17
 */
public class NumberTest {

    public static void main(String [] args){

        BigDecimal bigDecimal = new BigDecimal("123");
        BigDecimal bigDecimal1 = new BigDecimal(10);
        System.out.println(bigDecimal1.divide(bigDecimal,2, RoundingMode.CEILING));

        Double d1 = new Double("3");
        Double d2 = new Double("10");
        System.out.println(Double.valueOf(new DecimalFormat("#.000").format(10.0/3)));
        System.out.println(10.0/3);

        System.out.println( (3.4333 - 3.4333)==0);

        String str = "hello";
        System.out.println(str.equals(null));
    }
}
