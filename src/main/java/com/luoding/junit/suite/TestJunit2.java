package com.luoding.junit.suite;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Date：16-9-27
 * Time：下午8:54
 *
 * @author ding.luo@corp.luoding .com
 */
public class TestJunit2 {

    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Robert";
        assertEquals(message,messageUtil.salutationMessage());
    }
}