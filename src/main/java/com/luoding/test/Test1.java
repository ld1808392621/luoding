package com.luoding.test;

import java.math.BigDecimal;

/**
 * Date：16-8-22
 * Time：下午8:00
 *
 * @author ding.luo@corp.luoding .com
 */
public class Test1 {

    public static void main(String[] args) {

        Integer integer = new Integer(1);
        String str = "257,132824508,20.0,5.4964523E10,2,2016-08-25 11:23:55";
        System.out.println(str.length());
        Double decimal1 = new Double("12.3");
        Double decimal2 = new Double("12.31");
        System.out.println(decimal1.compareTo(decimal2));


        /*short s1 = 1;
        //s1 = s1 + 1;
        s1+=1;*/


        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        System.out.println(f3 == f4);


        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja")
                .append("va1").toString();
        System.out.println(s2.intern() == s2);

        int i = 10;
        int j = 100;
        swap(i, j);
        System.out.println(i + "  " + j);
        A a1 = new A(10, 100);
        alter(a1);
        System.out.println(a1.getI());
        test1();
    }


    public static void test1() {

        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);   //false
        System.out.println(s1 == s5);   //true
        System.out.println(s1 == s6);   //false
        System.out.println(s1 == s6.intern());  //true
        System.out.println(s2 == s2.intern());  //false

    }

    public static void swap(int i, int j) {

        int temp = i;
        i = j;
        j = temp;
    }

    public static void alter(A a) {
        a.setI(1000);
    }

    static class A {
        private int i;
        private int j;

        A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }
}
