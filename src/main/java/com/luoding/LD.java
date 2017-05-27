package com.luoding;

import java.util.concurrent.Callable;

public class LD {

    public static void main(String [] args){

        Callable callable ;

        System.out.println(System.getenv("HADOOP_HOME"));
        int[] array = {1, 8, 6, 18, 5, 7, 19, 13, 9, 12, 14, 20, 10, 16, 17, 4, 3, 2, 15, 11};

        quickSort(array,0,array.length-1);
        for(int i:array){
            System.out.println(i);
        }
    }

    public static void quickSort(int []number,int start,int end){

        if(start>=end){
            return;
        }

        int mark = number[start];
        int position = start;
        int i = start;
        int j = end;

        while(i<j){

            while(i<j){
                if(number[j]<mark){
                    number[position] = number[j];
                    position = j;
                    break;
                }
                j--;
            }

            while(i<j){
                if(number[i]>mark){
                    number[position] = number[i];
                    position = i;
                    break;
                }
                i++;
            }
        }

        number[position] = mark;
        quickSort(number, start, position-1);
        quickSort(number, position+1, end);
    }
}
