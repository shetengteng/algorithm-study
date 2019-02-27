package com.stt.base.sort;

/**
 * 快速排序
 * Created by Administrator on 2019/2/27.
 */
public class Quick {

	// 快速排序实现1，算法导论中实现方式
	public static void sort(int[] arr){
		int n = arr.length;
		if(n <= 1){
			return;
		}
		sort(arr,0,n-1);
	}

	/**
	 * @param arr
	 * @param start 开始位置
	 * @param end 结束位置
	 */
	public static void sort(int[] arr,int start,int end ){
		if(start >= end){
			return;
		}
		// 排序后分区点的最终位置
		int pivotIndex = partition(arr,start,end);
		// 对pivot点不进行处理
		sort(arr,start,pivotIndex-1);
		sort(arr,pivotIndex+1,end);
	}

	/**
	 * 获取分区点位置
	 * @param arr
	 * @param start
	 * @param end
	 * @return 返回分区点的最终位置
	 */
	private static int partition(int[] arr,int start,int end){
		// 默认使用当前分区的后一个作为pivot
		int i = start;
		for(int j = start;j<end;j++){
			// 遍历，找到比pivot小的元素，进行交换
			if(arr[j] < arr[end]){
				// 此时的arr[i]比arr[j]大，交换顺序，i的左边比arr[i]小，i的右边比arr[i]大
				// arr[i] 比 arr[end]大
				swap(arr,i,j);
				i++;
			}
		}
		// 最后i的位置就是pivot左右数值的分界点位置，arr[i]是大于arr[end]的，交换顺序
		swap(arr,i,end);
		return i;
	}


	private static void swap(int[] arr,int i,int j){
		if(i == j) {
			return;
		}
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
