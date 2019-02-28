package com.stt.base.sort;

/**
 * 计数排序，特殊的桶排序，有数据要求，要求数据可以用数组的下标来表示
 * 如果数据是小数，那么可以乘以相依10^x,转换为整数，如果是负数，可以加上10^k转换为相依的正整数
 *
 * Created by Administrator on 2019/2/28.
 */
public class Counting {

	public static void sort(int[] arr){
		int n = arr.length;
		if(n <= 1){
			return;
		}
		// 查找最大值，生成桶
		int max = arr[0];
		for(int i = 1;i < n;i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		// 生成依次计数桶
		int[] countArr = new int[max+1];
		// 设置数组初始值 0
		for(int i = 0;i < max+1;i++){
			countArr[i] = 0;
		}
		for(int i = 0;i < n;i++){
			countArr[arr[i]] ++;
		}
		// 对计数桶内容依次累加
		for(int i = 1;i < max+1;i++){
			countArr[i] += countArr[i-1];
		}
		// 声明一个结果
		int[] re = new int[n];
		for(int i = 0;i < n;i++){
			countArr[arr[i]] -= 1;
			int index = countArr[arr[i]];
			// index 不可以是负数
			re[index] = arr[i];
		}
		// 将结果拷贝
		for(int i =0;i<n;i++){
			arr[i] = re[i];
		}
	}
}
