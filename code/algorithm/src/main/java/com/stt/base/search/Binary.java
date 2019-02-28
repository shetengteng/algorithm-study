package com.stt.base.search;

/**
 * 二分查找
 * Created by Administrator on 2019/2/28.
 */
public class Binary {

	/**
	 * 非递归实现，返回对应的索引
	 *
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int search(int[] arr,int value){
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
//			int middle = (low + high) / 2;
			int middle = low + ((high - low)>>1);
			if(arr[middle] == value){
				return middle;
			}
			if(arr[middle] < value){
				low = middle+1;
			}else{
				high = middle-1;
			}
		}
		return -1;
	}

	/**
	 * 递归实现
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int search2(int[] arr,int value){
		int low = 0;
		int high = arr.length;
		return search(arr,low,high,value);
	}

	public static int search(int[] arr,int low,int high,int value){
		if(low>high){
			return -1;
		}
		int middle = low + ((high-low) >> 1);
		if(arr[middle] == value){
			return middle;
		}
		if(arr[middle] < value){
			return search(arr,middle+1,high,value);
		}
		if(arr[middle] > value){
			return search(arr,low,middle-1,value);
		}
		return -1;
	}

}
