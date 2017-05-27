package com.luoding.socket;

import com.luoding.redis.RedisClient.SocketClient;

import java.io.*;
import java.net.Socket;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-21 下午2:06
 */
public class SimpleClient {

    public static void main(String [] args){

        Socket socket = null;
        try {
            socket = new Socket("localhost",8080);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream out = socket.getOutputStream();
            while(true){
                String input = br.readLine();
                out.write(input.getBytes());
                try{
                    out.close();
                }catch (Exception e){

                }
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
