package com.luoding.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * author: ding.luo
 * time: 17-2-22 下午5:14
 */
public class Socket2 {

    public static void main(String [] args) throws IOException {

        Socket socket = new Socket("localhost",9000);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        out.write("hello".getBytes());
        byte [] bytes = new byte[1024];
        int size = in.read(bytes);
        System.out.println(new String(bytes,0,size)+"---client");
    }
}
