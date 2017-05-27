package com.luoding.parameter;

import org.omg.Dynamic.Parameter;

/**
 * author ding.luo@crop.luoding .com
 * time: 16-10-20 下午8:55
 */
public class ParameterTest {

    public static void main(String [] args){

        ParameterObject parameter = new ParameterObject("pre");
        System.out.println(parameter.getS());
        update(parameter);
        System.out.println(parameter.getS());

    }

    public static void update(ParameterObject parameter){

        parameter = new ParameterObject("after");
    }
}
