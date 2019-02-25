package com.stt.base.sort;

/**
 * 插入排序
 * Created by ttshe2 on 2019/2/25.
 */
public class InsertionSort {

    public static void handle(int[] arr){
        int n = arr.length;
        if(n <= 1){
            return;
        }
        // 从1开始
        for(int i = 1; i < n ;i++) {
            int value = arr[i];
            for(int j = i-1; j >=0; j--){
                if(arr[j] > value){
                    // 数据移动
                    arr[j+1] = arr[j];
                }
            }
        }

    }

}
