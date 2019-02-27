package com.stt.base.sort;

/**
 * 选择排序
 * Created by ttshe2 on 2019/2/26.
 */
public class Selection {

    public static void sort(int[] arr){
        int n = arr.length;
        if(n <= 1){
            return;
        }
        for(int i = 0;i<n;i++){
            int min = i;
            for(int j = i+1;j<n;j++){
                // 找到最小的，并记录索引位置
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            // 进行替换操作
            if(min > i){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

}
