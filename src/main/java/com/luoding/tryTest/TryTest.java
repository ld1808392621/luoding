package com.luoding.tryTest;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-10-30 下午4:31
 */
public class TryTest {

    public static A a=new A("init");

    public static void main(String [] args){

        a = tryTest();

    }

    public static A tryTest(){

        try{

            System.out.println("开始");
            return new A("first");
        }catch (Exception e){
           System.out.println("exception");
        }finally {
            new A("second");
        }
         return new A("return");
    }
}
