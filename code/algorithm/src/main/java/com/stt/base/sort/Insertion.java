package com.stt.base.sort;

/**
 * 插入排序,比冒泡快，虽然都是复杂度都是O(n^2)
 * Created by ttshe2 on 2019/2/25.
 */
public class Insertion {

    public static void sort(int[] arr){
        int n = arr.length;
        if(n <= 1){
            return;
        }
        // 从1开始
        for(int i = 1; i < n ;i++) {
            // 将 a[i] 放入 a[i-1] a[i-2] ... 注意：而a[i-1] a[i-2] ... 的子序列是已排序好的
            for(int j = i; j >0; j--){
                // 当前比前一个小，那么替换位置,依次替换，而非直接插入
                if(arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }else{
                    // 一旦碰到相同的，或者比自己小的，就说明位置找到了，不需要替换了
                    break;
                }
            }
        }
    }

    /**
     * 优化操作，减少替换操作，只在找到位置进行替换操作
     * @param arr
     */
    public static void sort2(int[] arr){
        int n = arr.length;
        if(n <= 1){
            return;
        }
        for(int i = 1; i < n ; i++){
            int tmp = arr[i];
            int j = i-1;
            for(; j>=0; j--){
                if(tmp < arr[j]){
                    // 不断向后移动
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            // 都移动完成后，将tmp进行插入
            arr[j+1] = tmp;
        }
    }

}
