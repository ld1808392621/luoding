package com.luoding.junit.base;

/**
 * Date：16-9-27
 * Time：下午7:53
 *
 * @author ding.luo@corp.luoding .com
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestJunit {

    String message = "Hello World";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        message = "hello world";
        assertEquals(message,messageUtil.printMessage());
    }
}