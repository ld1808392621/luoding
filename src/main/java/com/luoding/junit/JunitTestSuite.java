package com.luoding.junit;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Date：16-9-27
 * Time：下午8:28
 *
 * @author ding.luo@corp.luoding .com
 */
public class JunitTestSuite {
    public static void main(String[] a) {
        // add the test's in the suite
        TestSuite suite = new TestSuite(TestJunit1.class, TestJunit2.class);
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println("Number of test cases = " + result.runCount());
    }
}