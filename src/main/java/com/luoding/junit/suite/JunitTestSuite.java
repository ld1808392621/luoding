package com.luoding.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Date：16-9-27
 * Time：下午8:54
 *
 * @author ding.luo@corp.luoding .com
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestJunit1.class,
        TestJunit2.class
})
public class JunitTestSuite {
}
