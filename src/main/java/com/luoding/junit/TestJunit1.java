package com.luoding.junit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date：16-9-27
 * Time：下午8:12
 *
 * @author ding.luo@corp.luoding .com
 */
public class TestJunit1 {

    @Test
    public void testAdd(){

        int num = 5;
        String temp = null;
        String str = "junit is work fine";

        assertEquals("junit is work fne",str);

        //check for false condition
        assertFalse(num > 6);

        //check for not null value
        assertNotNull(str);

    }
}
