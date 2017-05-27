package com.luoding.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-11-18 上午11:26
 */
public class IoTest {

    public static void main(String [] args){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
