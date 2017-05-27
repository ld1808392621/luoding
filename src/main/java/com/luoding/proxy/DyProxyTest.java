package com.luoding.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-29 下午11:19
 */
public class DyProxyTest {

    public static void main(String[] args) {

        ProxyA a = new ProxyA();

        ProxyInterface proxy1 = (ProxyInterface) Proxy.newProxyInstance(DyProxyTest.class.getClassLoader(), new Class[]{ProxyInterface.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return  method.invoke(a, args);
                    }
                });
        proxy1.print("luoding");

        List<String> list = getList(new ArrayList());
        System.out.println(list.size());
    }

    public static List getList(final List list) {
        return (List) Proxy.newProxyInstance(DyProxyTest.class.getClassLoader(), new Class[]{List.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("add".equals(method.getName())) {
                            throw new UnsupportedOperationException();
                        } else {
                            return method.invoke(list, args);
                        }
                    }
                });
    }
}
