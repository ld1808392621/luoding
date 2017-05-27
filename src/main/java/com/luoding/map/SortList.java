package com.luoding.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date：16-8-12
 * Time：下午5:37
 *
 * @author ding.luo@corp.luoding .com
 */
public class SortList {

    public static void main(String [] args){
        List<Double> ds = new ArrayList();
        ds.add(1.2);
        ds.add(2.1);
        ds.add(0.3);
        ds.add(0.4);
        ds.add(0.1);
        Collections.sort(ds);
        for(Double d:ds){
            System.out.println(d);
        }

        Collections.reverse(ds);
        for(Double d:ds){
            System.out.println(d);
        }
    }
}
