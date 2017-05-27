package com.luoding.junit.parameters;

/**
 * Date：16-9-27
 * Time：下午9:06
 *
 * @author ding.luo@corp.luoding .com
 */
public class PrimeNumberChecker {
    public Boolean validate(final Integer primeNumber) {
        for (int i = 2; i < (primeNumber / 2); i++) {
            if (primeNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}