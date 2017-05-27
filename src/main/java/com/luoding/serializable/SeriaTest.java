package com.luoding.serializable;

import java.io.*;
import java.util.Collection;

/**
 * author: ding.luo
 * time: 17-2-21 下午9:50
 */
public class SeriaTest {

    public static void main(String [] args) throws IOException, ClassNotFoundException {
        A a = new A();
        a.a = 12;

        ByteArrayOutputStream bytes1 = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bytes1);
        out.writeObject(a);

        ByteArrayInputStream inByte = new ByteArrayInputStream(bytes1.toByteArray());
        ObjectInputStream in = new ObjectInputStream(inByte);
        A b = (A) in.readObject();
        System.out.println(b.a);
    }


    @SafeVarargs
    public static <T> Collection<T> doSomething(T... entries){
        return null;
    }
}
