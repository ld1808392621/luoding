package com.luoding.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.HashMap;
import java.util.Map;

/**
 * author: ding.luo
 * time: 17-3-10 下午2:09
 */
public class Test {

    public static void main(String[] args) {

        Long result = (Long) AviatorEvaluator.exec("1+3+2");
        System.out.println(AviatorEvaluator.execute("1+3+2"));
        System.out.println(result);
        String name = "luoding";
        System.out.println(AviatorEvaluator.exec("'hello ' + name", name));
        System.out.println(AviatorEvaluator.execute("string.contains" +
                "(\"test\", string.substring('hello', 1, 2))"));
        String expression = "a-(b-c)>100";
        Expression compliedExp = AviatorEvaluator.compile(expression);
        Map<String, Object> map = new HashMap<>();
        map.put("a", 1000);
        map.put("b", 100);
        map.put("c", 10);
        compliedExp.execute(map);
        System.out.println(compliedExp.execute(map));

        //555416362
        //290779209
        //1063903
        //233859437
        Expression expression1 = AviatorEvaluator.compile("0 | ( 11&0)|(1|0)");

        long t1 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            expression1.execute();
        }
        System.out.println(System.nanoTime() - t1);

        String ex1 = "a&&b&&c";
        Expression expression2 = AviatorEvaluator.compile(ex1,true);
        map = new HashMap<>();
        map.put("a", true);
        map.put("b", true);
        map.put("c", true);
        //100469453
        //256803070
        //5865061371
        long t2 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            expression2.execute(map);
        }
        System.out.println(System.nanoTime() - t2);

    }


}
