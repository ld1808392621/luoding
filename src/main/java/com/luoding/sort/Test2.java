package com.luoding.sort;

/**
 * author: ding.luo
 * time: 17-3-7 下午10:06
 */
public class Test2 {


    public static void main(String [] args){

        int [] a = {1,3,5,6,7};
        int [] b = {2,3,4};
        int [] c = new int[a.length+b.length];
        for(int i=0;i<a.length;i++){
            c[i] = a[i];
        }

        insert(c,b,a.length,b.length);
        a = null;

        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }

    }

    public static void insert(int [] a,int [] b,int m,int n){

        int len = m+n;
        int p1 = m-1;
        int p2 = n-1;
        while(len>=0){
            if(p1<0){
                for(;p2>=0;p2--){
                    a[len-1] = b[p2];
                    len--;
                }
                break;
            }
            if(p2<0){
                break;
            }
            if(a[p1]>=b[p2]){
                a[len-1] = a[p1];
                p1--;
            }else{
                a[len-1] = b[p2];
                p2--;
            }
            len--;
        }
    }
}
