package com.luoding.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author: ding.luo
 * time: 17-2-15 下午4:30
 */
public class ATest {

    public static void main(String [] args){

        A a = new A();
        ProxyInterface proxyInterface = (ProxyInterface) Proxy.newProxyInstance(ATest.class.getClassLoader(), new Class[]{ProxyInterface.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理开始");
                        Object result = method.invoke(a,args);
                        System.out.println("代理结束");
                        return "luoding";
                    }
                });
        System.out.println(proxyInterface.print("hello"));
    }
}
