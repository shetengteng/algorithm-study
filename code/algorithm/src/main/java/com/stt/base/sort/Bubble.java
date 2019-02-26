package com.stt.base.sort;

/**
 * 冒泡排序
 * Created by ttshe2 on 2019/2/25.
 */
public class Bubble {

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
}
