package com.luoding.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Date：16-6-30
 * Time：下午11:29
 *
 * @author ding.luo@corp.luoding .com
 */
public class FileTest {

    public static void main(String [] args){
        try {
            RandomAccessFile aFile = new RandomAccessFile("new_2.txt", "rw");
            FileChannel fileChannel  = aFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            int len = fileChannel.read(byteBuffer);
            while(-1 != len){
                byteBuffer.flip();
                System.out.print(new String(byteBuffer.array()));
                byteBuffer.clear();
                len = fileChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
