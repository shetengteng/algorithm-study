package com.stt.base.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by ttshe2 on 2019/2/25.
 */
public class BubbleSort {

    // 从小到大排序
    public static void sort(int[] arr){
        int n = arr.length;
        if(n <= 1) return;

        for(int i = 0; i < n; i++){
            // 提前对出冒泡操作
            boolean flag = false;
            for(int j = 0; j < n - i - 1; j++ ){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9,3,7,1,3,12,5,6};
        BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
