package com.luoding.junit;

import junit.framework.TestCase;

/**
 * Date：16-9-27
 * Time：下午7:36
 *
 * @author ding.luo@corp.luoding .com
 */
public class JavaTest extends TestCase {
    protected int value1, value2;

    // assigning the values
    protected void setUp(){
        value1=3;
        value2=3;
    }

    // test method to add two values
    public void testAdd(){
        double result= value1 + value2;
        assertTrue(result == 6);
    }
}