package com.luoding.socket;

import sun.net.www.content.image.x_xbitmap;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-21 下午2:06
 */
public class SimpleServer {

    public static void main(String [] args){

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true){
                String temp = bufferedReader.readLine();
                System.out.println(temp);
                bufferedWriter.write("hello server "+System.currentTimeMillis());
                bufferedWriter.flush();
                bufferedWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
