package com.luoding.redis.RedisClient;

import java.io.*;
import java.net.Socket;

/**
 * Date：16-6-29
 * Time：上午12:05
 *
 * @author ding.luo@corp.luoding .com
 */
public class SocketClient {

    public static void main(String [] args){

        try {
            Socket socket = new Socket("127.0.0.1",8080);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String send = br.readLine();
                byte[] buffer = new byte[1024];
                outputStream.write(send.getBytes());
                System.out.println("S: " + send);
                inputStream.read(buffer);
                String receive = new String(buffer);
                if("bye".equals(receive)){
                    break;
                }
                System.out.println("R: " + receive);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
