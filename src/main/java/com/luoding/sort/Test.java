package com.luoding.sort;

import java.util.Arrays;

/**
 * author: ding.luo
 * time: 17-2-16 上午10:21
 */
public class Test {

    public static void main(String [] args){

        int [] numbers = {3,4,2,1,4,7,12,11,9};
        quickSort(numbers,0,numbers.length-1);
        for(int a:numbers){
            System.out.println(a);
        }
        System.out.println(repeat(numbers));

        System.out.println(find(numbers,7,0,numbers.length));
    }

    public static void quickSort(int [] numbers,int start,int end){
        if(start>=end){
            return;
        }
        int tmp = numbers[start];
        int i = start+1;
        int j = end;
        int position = start;
        while(i<j){
            while(i<j){
                if(numbers[j]<tmp){
                    numbers[position] = numbers[j];
                    position = j;
                    break;
                }
                j--;
            }
            while(i<j){
                if(numbers[i]>tmp){
                    numbers[position] = numbers[i];
                    position = i;
                    break;
                }
                i++;
            }
        }
        numbers[position] = tmp;
        quickSort(numbers,start,position-1);
        quickSort(numbers, position+1, end);
    }

    public static boolean repeat(int [] numbers){
        byte[] bytes = new byte[16];
        for(int i:numbers){
            int index = i/8;
            int c = 8 - i%8 -1;
            byte b = bytes[index];
            int tmp = 1<<c;
            int t = tmp & b;
            if(t == tmp){
                return true;
            }
            bytes[index] = (byte) (tmp | b);
        }
        return false;
    }

    public static int find(int [] numbers,int number,int start,int end){

        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(numbers[mid] == number){
            return mid;
        }else{
            if(numbers[mid]>number){
                return find(numbers,number,start,mid-1);
            }else{
                return find(numbers,number,mid+1,end);
            }
        }
    }
}
