package com.luoding.frame.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-12-6 下午11:20
 */
public class AopTest {

    public static void main(String [] args){
        TargetImpl target = new TargetImpl();

        Advisor advisor = new Advisor() {
            @Override
            public Advice getAdvice() {
                return null;
            }

            @Override
            public boolean isPerInstance() {
                return false;
            }
        };
        ProxyFactory factory = new ProxyFactory(target);

        AfterAdvice afterAdvice;
        BeforeAdvice beforeAdvice;
        ThrowsAdvice throwsAdvice;
        ProxyFactoryBean proxyFactoryBean;

    }
}
