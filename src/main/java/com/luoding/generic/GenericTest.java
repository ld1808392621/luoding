package com.luoding.generic;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Date：16-9-7
 * Time：下午8:57
 *
 * @author ding.luo@corp.luoding .com
 */
public class GenericTest {

    public static void main(String []args){

        List<?>[] ls = new List<?>[10];
        List<String> ls1 = new ArrayList<>();
        ls[0] = ls1;
        if(ls[0] instanceof List<?>){
            System.out.println("hello");
        }
        GenericTest test = new GenericTest();
        //B a = test.getT();


    }


    public <T> T getT(){
        T a = (T)new A();
        return a;
    }
}
