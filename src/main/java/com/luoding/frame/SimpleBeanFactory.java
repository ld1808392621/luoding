package com.luoding.frame;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-21 下午9:17
 */
public class SimpleBeanFactory {

    public static void main(String[] args) {

        Resource resource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        DruidDataSource dataSource = (DruidDataSource) beanFactory.getBean("dataSource");
        System.out.println(dataSource.getActiveCount());
        beanFactory.addBeanPostProcessor(new BeanA());
        BeanA beanA = (BeanA) beanFactory.getBean("testBean");
        beanFactory.destroySingletons();
        DefaultListableBeanFactory defaultListableBeanFactory;

        FileSystemXmlApplicationContext applicationContext;

        BeforeAdvice beforeAdvice;

        JdkRegexpMethodPointcut pointcut;

        DefaultPointcutAdvisor advisor;

        ProxyFactoryBean proxyFactoryBean;

        AbstractApplicationContext applicationContext1;
        ApplicationContext applicationContext2;
    }

}
