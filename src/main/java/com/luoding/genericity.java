package com.luoding;

import java.util.ArrayList;
import java.util.List;

/**
 * Date：16-7-20
 * Time：下午9:59
 *
 * @author ding.luo@corp.luoding .com
 */
public class genericity {

    public static void main(String [] args){

        List<Object> objs = new ArrayList();
        List<Integer> ls = new ArrayList<Integer>();
        ls.add(123);
        objs.add(ls);
        objs.add(123);
        for(Object obj:objs){
            if(obj instanceof List){
                System.out.println("list");
            }
            if(obj instanceof Integer){
                System.out.println("integer");
            }
        }
    }
}
