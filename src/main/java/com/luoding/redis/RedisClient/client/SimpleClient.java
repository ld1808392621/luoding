package com.luoding.redis.RedisClient.client;

import redis.clients.util.SafeEncoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Date：16-7-4
 * Time：下午9:52
 *
 * @author ding.luo@corp.luoding .com
 */
public class SimpleClient {

    private static final byte CR= '\r';
    private static final byte LF = '\n';
    public static final byte DOLLAR_BYTE = '$';
    public static final byte ASTERISK_BYTE = '*';
    public static final byte PLUS_BYTE = '+';
    public static final byte MINUS_BYTE = '-';
    public static final byte COLON_BYTE = ':';

    public static int count = 0;

    public static void main(String [] args) throws IOException {
        set();
    }

    public static void set() throws IOException {

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("10.66.5.44",6379),5000);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        byte[] buffer = new byte[1024];

        //*3\r\n
        buffer[count++] = ASTERISK_BYTE;
        buffer[count++] = '3';
        buffer[count++] = CR;
        buffer[count++] = LF;
        //$3\r\n
        buffer[count++] = DOLLAR_BYTE;
        buffer[count++] = '3';   //这里必须是一个字符
        buffer[count++] = CR;
        buffer[count++] = LF;
        flush(outputStream,buffer);
        //get\r\n
        outputStream.write(SafeEncoder.encode("set"));
        buffer[count++] = CR;
        buffer[count++] = LF;
        //$3\r\n
        buffer[count++] = DOLLAR_BYTE;
        buffer[count++] = '3';   //这里必须是一个字符
        buffer[count++] = CR;
        buffer[count++] = LF;
        flush(outputStream,buffer);

        //age\r\n
        outputStream.write(SafeEncoder.encode("set"));
        buffer[count++] = CR;
        buffer[count++] = LF;

        //$2\r\n
        buffer[count++] = DOLLAR_BYTE;
        buffer[count++] = '2';   //这里必须是一个字符
        buffer[count++] = CR;
        buffer[count++] = LF;
        flush(outputStream,buffer);

        //12\r\n
        outputStream.write(SafeEncoder.encode("12"));
        buffer[count++] = CR;
        buffer[count++] = LF;
        flush(outputStream,buffer);

        buffer = new byte[1024];
        int size = inputStream.read(buffer);
        responseDeal(buffer,size);
        inputStream.close();
        outputStream.close();
        socket.close();
    }

    public static void get(){
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("192.168.0.5",6379),5000);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            byte[] buffer = new byte[1024];
            buffer[count++] = ASTERISK_BYTE;
            buffer[count++] = '2';
            buffer[count++] = CR;
            buffer[count++] = LF;
            buffer[count++] = DOLLAR_BYTE;
            buffer[count++] = '3';   //这里必须是一个字符
            buffer[count++] = CR;
            buffer[count++] = LF;
            flush(outputStream,buffer);
            outputStream.write(SafeEncoder.encode("get"));
            buffer[count++] = CR;
            buffer[count++] = LF;
            flush(outputStream,buffer);
            buffer[count++] = DOLLAR_BYTE;
            buffer[count++] = '5';
            buffer[count++] = CR;
            buffer[count++] = LF;
            flush(outputStream,buffer);

            outputStream.write(SafeEncoder.encode("name1"));
            buffer[count++] = CR;
            buffer[count++] = LF;
            flush(outputStream,buffer);

            buffer = new byte[1024];
            int size = inputStream.read(buffer);
            responseDeal(buffer,size);
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void flush(OutputStream outputStream,byte[] buffer){
        try {
            outputStream.write(buffer,0,count);
            count = 0;
        } catch (IOException e) {


        }
    }

    public static void responseDeal(byte[] buffer,int size){

        int count = 0;
        char c = (char) buffer[count];
        switch(c){
            case ':':
                break;
            case '+':
                count++;
                byte[] tmp2 = new byte[128];
                int j = 0;
                while(true){
                    byte b = buffer[count++];
                    if(b == '\r'){
                        break;
                    }else{
                        tmp2[j++] = b;
                    }
                }

                System.out.println(new String(tmp2));
            case '*':
                break;
            case '$':
                count++;
                int len = buffer[count] -  '0';
                count = count+2;
                byte[] tmp = new byte[64];
                for(int i=0;i<=len;i++){
                    tmp[i] = buffer[count+i];
                }
                System.out.println(new String(tmp));
                break;
            case '-':
                count++;
                byte[] tmp1 = new byte[128];
                int i = 0;
                while(true){
                    byte b = buffer[count++];
                    if(b == '\r'){
                        break;
                    }else{
                        tmp1[i++] = b;
                    }
                }

                System.out.println(new String(tmp1));
        }
    }
}
