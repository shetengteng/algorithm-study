package com.stt.base.sort;

/**
 * 快速排序
 * Created by Administrator on 2019/2/27.
 */
public class Quick2 {

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
	 * 获取分区点位置 注意：需要先左移动，因为pivot使用的是start的位置
	 * @param arr
	 * @param start
	 * @param end
	 * @return 返回分区点的最终位置
	 */
	private static int partition(int[] arr,int start,int end){
		int pivot = arr[start];
		int left = start,right = end;
		while(left < right){
			// 右边不断操作，左移动
			while(arr[right] > pivot && left < right){
				right --;
			}
			// 当arr[right] < pivot 的时候，将arr[left] 覆盖为 arr[right]
			if(left < right){
				// 第一次右移动的时候，需要覆盖，覆盖的元素是arr[start]
				arr[left] = arr[right];
				left ++;
			}
			// 此时arr[right]的值有2份，并且当前右侧停止，等待左侧右移动
			while(arr[left] < pivot && left < right){
				// 不断的左移动
				left ++;
			}
			if(left < right){
				// 左移动停止，说明当前arr[left] > pivot
				// 需要将之前的重复值的当前arr[right] 进行覆盖
				arr[right] = arr[left];
				right --;
			}
		}
		// 全部停止后，说明left和right相同，并且left的右边是大于pivot，且此时arr[left]是有重复的
		// 一旦左移动和右移动有停止赋值，就会有双份数据产生，在最后的时候将最后一个重复的数据替换为pivot
		arr[left] = pivot;
		return left;
	}


}
