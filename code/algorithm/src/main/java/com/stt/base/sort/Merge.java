package com.stt.base.sort;

/**
 * 归并排序
 * Created by Administrator on 2019/2/26.
 */
public class Merge {

	public static void sort(int[] arr){
		int n = arr.length;
		if(n <= 1){
			return;
		}
		sort(arr,0,n-1);
	}

	/**
	 * @param arr
	 * @param start 开始索引
	 * @param end 结束索引
	 */
	public static void sort(int[] arr,int start,int end){
		// 递归终止条件
		if(start >= end) {
			return;
		}
		int middle = (start + end) / 2;
		// 分治递归
		sort(arr,start,middle);
		sort(arr,middle+1,end);
		// 合并结果
		merge(arr,start,middle,end);
	}

	/**
	 * 进行合并操作
	 * @param arr
	 * @param start
	 * @param middle
	 * @param end
	 */
	public static void merge(int[] arr,int start,int middle,int end){
		// 申请一个临时变量用于存储结果
		int[] tmp = new int[end-start+1];
		// 左边子数组的起始点与右子数组的起始点
		int lStart = start,rStart = middle+1,k = 0;
		for(;lStart<=middle && rStart<=end;){
			if (arr[lStart] <= arr[rStart]) {
				tmp[k] = arr[lStart];
				lStart ++;
			}else{
				tmp[k] = arr[rStart];
				rStart ++;
			}
			k++;
		}
		// 判断哪个子数组有剩余
		// 假定左边没有满
		int reStart = lStart,reEnd = middle;
		if(lStart > middle){
			// 左边满了，那么就是右边没有满
			reStart = rStart;
			reEnd = end;
		}
		// 将剩余的放入
		for(;reStart<=reEnd;reStart++,k++){
			tmp[k] = arr[reStart];
		}
		// 将tmp替换掉arr中的部分
		for(int i = 0;i<end-start+1;i++){
			arr[start+i] = tmp[i];
		}
	}
}
