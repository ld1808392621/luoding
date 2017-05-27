package com.luoding.sort;

/**
 * Date：16-9-20
 * Time：下午1:49
 *
 * @author ding.luo@corp.luoding .com
 */
public class SortUtil {

    public static void main(String[] args) {

        int[] array = {1, 8, 6, 18, 5, 7, 19, 13, 9, 12, 14, 20, 10, 16, 17, 4, 3, 2, 15, 11};

        //baseInsertSort(array,0,array.length-1);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
        //mergeSort(array);
        fastSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void fastSort(int[] array, int start, int end) {

        //递归一定要有一个出口
        if(start>= end){
            return;
        }
        int sentinel = array[start];
        int low = start;
        int large = end;
        int position = start;
        while (low < large) {
            while (low < large) {
                if (array[large] < sentinel) {
                    array[position] = array[large];
                    position = large;
                    break;
                }
                large--;
            }
            while (low < large) {
                if (array[low] > sentinel) {
                    array[position] = array[low];
                    position = low;
                    break;
                }
                low++;
            }

        }
        array[position] = sentinel;
        fastSort(array, start, position - 1);
        fastSort(array, position + 1, end);
    }

    //以插入排序为基础
    public static void mergeSort(int[] array) {
        int len = array.length;
        int cap = 2;
        while (cap < len) {
            int start = cap;
            while (start < len) {
                baseInsertSort(array, start - cap, start);
                start += cap;
            }
            cap = cap * 2;
        }
        baseInsertSort(array, 0, len - 1);
    }

    //将最大的值往上放
    public static void bubbleSort(int[] array) {

        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void heapSort(int[] array) {
        int len = array.length;
        int[] tmp = new int[array.length];
        for (int i = 0; i < len; i++) {
            adjustHeap(array, i);
        }
    }

    public static void adjustHeap(int[] array, int offset) {

        int len = array.length;
        int cap = (array.length - offset) / 2;
        for (int i = 0; i < cap; i++) {
            int current = i + offset;
            int left = i * 2 + 1 + offset;
            int right = i * 2 + 2 + offset;
            if (left >= len) {
                break;
            } else {
                if (array[current] > array[left]) {
                    int tmp = array[current];
                    array[current] = array[left];
                    array[left] = tmp;
                }
            }
            if (right >= len) {
                break;
            } else {
                if (array[current] > array[right]) {
                    int tmp = array[current];
                    array[current] = array[right];
                    array[right] = tmp;
                }
            }
        }
    }

    public static void selectSort(int[] array) {

        //算则一个最小的值
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = i; j < len; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = min;
        }
    }

    public static void baseInsertSort(int[] array, int start, int end) {

        int tmp = 0;
        for (int i = start + 1; i <= end; i++) {
            //j之前的元素都是有序的
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }


    public static void shellSort(int[] array) {

        int len = array.length;
        int dk = len / 2;
        while (dk >= 1) {
            shellInsertSort(array, len, dk);
            dk = dk / 2;
        }
    }

    public static void shellInsertSort(int[] array, int len, int dk) {

        for (int i = dk; i < len; i++) {

            if (array[i] < array[i - dk]) {
                int tmp = array[i];
                int j = i - dk;
                while (array[j] > tmp) {
                    array[j + dk] = array[j];
                    j = j - dk;
                    if (j < 0) {
                        break;
                    }
                }
                array[j + dk] = tmp;
            }
        }
    }

}
