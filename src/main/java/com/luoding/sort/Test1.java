package com.luoding.sort;

import com.luoding.integer.IntegerTest;
import com.luoding.load.inter.InterfaceTest;
import com.luoding.thread.test;
import scala.languageFeature;
import sun.net.www.content.image.x_xbitmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * author: ding.luo
 * time: 17-3-6 下午4:21
 */
public class Test1 {

    public static void main(String[] args) {


        Random random = new Random(System.currentTimeMillis());
        int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(20);
        }

        //test1(array,0,size-1);
        test2(array);
        for (int i : array) {
            System.out.println(i);
        }

        int[][] a1 = {
                {1, 2},
                {1, 2},
                {1, 2}
        };
        int[][] a2 = {
                {1, 2},
                {1, 2},
        };

        int[][] result = maxtrix(a1, a2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }

        System.out.println(fb(800));
        test2();
        test3();
        System.out.println(multiple(15,12));
    }

    public static void test2(int[] array) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j >= 0; j--) {
                if (j > 0 && array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else if (j > 0 && array[j] > array[j - 1]) {
                    break;
                }
            }
        }
    }


    public static void test1(int[] array, int start, int end) {

        if (start > end) {
            return;
        }
        int low = start;
        int large = end;
        int position = start;
        int mark = array[position];
        while (low < large) {

            while (low < large) {
                if (array[large] < mark) {
                    array[position] = array[large];
                    position = large;
                    break;
                }
                large--;
            }

            while (low < large) {
                if (array[low] > mark) {
                    array[position] = array[low];
                    position = low;
                    break;
                }
                low++;

            }
        }

        array[position] = mark;
        test1(array, start, position - 1);
        test1(array, position + 1, end);
    }


    public static int[][] maxtrix(int[][] a1, int[][] a2) {

        if (a2.length != a1[0].length) {
            throw new IllegalArgumentException("两个矩阵不能相乘");
        }
        int[][] result = new int[a1.length][a2[0].length];
        int col = a1.length;
        int row = a2[0].length;
        int size = a2.length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int sum = 0;
                for (int index = 0; index < size; index++) {
                    sum += a1[i][index] * a2[index][j];
                }
                result[i][j] = sum;
            }

        }

        return result;
    }

    public static int fb(int i) {
        int[][] init = {
                {1, 1},
                {1, 0}
        };
        int[][] init1 = {{1, 1}};
        if (i == 1 || i == 2) {
            return 1;
        }
        int n = i - 2;
        String str = Integer.toBinaryString(n);
        int[][] result = new int[2][2];

        for (int index = 0; index < str.length(); index++) {
            char c = str.charAt(index);
            switch (c) {
                case '0':
                    if (index == 0) {
                        break;
                    } else {
                        result = maxtrix(result, result);
                    }
                    break;
                case '1':
                    if (index == 0) {
                        result = init;
                    } else {
                        result = maxtrix(result, result);
                        result = maxtrix(result, init);
                    }
                    break;
            }
        }

        result = maxtrix(init1, result);
        System.out.println(result[0][0]);
        return 0;
    }


    public static void test2() {

        String str = "1234567";
        String units1 = "亿万个";
        String units2 = "千百拾";
        int size = str.length() / 4 + (str.length() % 4 == 0 ? 0 : 1);
        String[] strs = new String[size];
        int i=0;
        while(str.length()>4){
            strs[i++] = str.substring(str.length()-4,str.length());
            str = str.substring(0,str.length()-4);
            System.out.println(str);
        }
        strs[i] = str;
        String[] strs1 = new String[size];
    }

    public static void toChiness(){

    }

    public static void test3(){

        for(int i=10000;i<999999;i++){
            if(selfCheck(i)){
                continue;
            }else if(exCheck(i,i*i)){
                continue;
            }else{
                System.out.println(i);
                System.out.println(i*i);
            }
        }
    }

    public static boolean exCheck(int n,int exn){
        String s1 = Integer.toString(n);
        String s2 = Integer.toString(exn);
        int len = s1.length();
        for(int i=0;i<len;i++){
            if(s2.indexOf(s1.charAt(i)+"")>0){
                return true;
            }
        }
        return false;
    }
    /**
     * 判断一个数字中是否有重复的数字
     * @param n
     */
    public static boolean selfCheck(int n){

        String s = Integer.toString(n);
        int[] ins = {0,0,0,0,0,0,0,0,0,0};
        int len = s.length();
        for(int i =0;i<len;i++){
            char c = s.charAt(i);
            int index = (int)(c - '0');
            if(ins[index]>0){
                return true;
            }else{
                ins[index]++;
            }
        }
        return false;
    }


    public static int divisor(int n,int m){

        if(m==0){
            return n;
        }
        int p = n%m;
        return divisor(m,p);
    }

    public static int multiple(int n,int m){

        int p = divisor(n,m);
        return (n*m)/p;
    }

}
