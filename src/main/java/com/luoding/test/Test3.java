package com.luoding.test;

/**
 * author: ding.luo
 * time: 17-2-20 下午11:21
 */
public class Test3 {

    public static void main(String[] args)
            throws Exception {
        try {
            throw new Sneeze();
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}
