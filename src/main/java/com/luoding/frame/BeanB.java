package com.luoding.frame;

/**
 * author: ding.luo
 * time: 17-2-26 下午10:18
 */
public class BeanB {

    private BeanA beanA;

    public BeanA getBeanA() {
        return beanA;
    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }

    public void sayName(){
        System.out.println("b");
    }
}
