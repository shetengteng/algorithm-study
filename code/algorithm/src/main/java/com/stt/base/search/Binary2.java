package com.stt.base.search;

/**
 * 二分查找 变形问题
 * Created by Administrator on 2019/2/28.
 */
public class Binary2 {

	/**
	 * 问题1：相同元素中返回第一个满足的元素
	 *
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int search01(int[] arr,int value){
		int low = 0;
		int high = arr.length -1;
		while(low <= high){
			int middle = low + ((high - low)>>1);
			if(value < arr[middle]){
				high = middle - 1;
			}else if(value > arr[middle]){
				low = middle + 1;
			}else {
				// 查询到相同的元素的时候，判断是否是第一个，或者前一个是否是value
				// 如果不是，将high前进一位，继续查找
				if(middle == 0 || arr[middle-1] != value){
					return middle;
				}else{
					high = middle - 1;
				}
			}
		}
		return -1;
	}

	/**
	 * 更加易于理解的
	 *
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int search01_1(int[] arr,int value){
		int low = 0;
		int high = arr.length - 1;
		boolean flag = false;
		int middle = -1;
		while(low <= high){
			middle = low + ((high - low) >> 1);
			if(value == arr[middle]){
				flag = true;
				break;
			}
			if(value < arr[middle]){
				high = middle - 1;
				continue;
			}
			if(value > arr[middle]){
				low = middle + 1;
			}
		}
		if(flag){
			// 表示得到了其中一个
			while(true){
				if(middle == 0){
					return middle;
				}
				if(arr[middle-1] != value){
					return middle;
				}
				middle --;
			}
		}
		return -1;
	}

	/**
	 * 查找匹配到的相同元素的最后一个
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int search02(int[] arr,int value){
		int low = 0;
		int high = arr.length - 1;
		boolean flag = false;
		int middle = -1;
		while(low <= high){
			middle = low + ((high - low) >> 1);
			if(value == arr[middle]){
				flag = true;
				break;
			}
			if(value < arr[middle]){
				high = middle - 1;
				continue;
			}
			if(value > arr[middle]){
				low = middle + 1;
			}
		}
		if(flag){
			// 表示得到了其中一个
			while(true){
				if(middle == arr.length - 1){
					return middle;
				}
				if(arr[middle+1] != value){
					return middle;
				}
				middle ++;
			}
		}
		return -1;
	}

	public static int search02_1(int[] arr,int value){
		int low = 0;
		int high = arr.length -1;
		while(low <= high){
			int middle = low + ((high - low)>>1);
			if(value < arr[middle]){
				high = middle - 1;
			}else if(value > arr[middle]){
				low = middle + 1;
			}else {
				// 查询到相同的元素的时候，判断是否是第一个，或者前一个是否是value
				// 如果不是，将high前进一位，继续查找
				if(middle == arr.length -1 || arr[middle+1] != value){
					return middle;
				}else{
					low = middle + 1;
				}
			}
		}
		return -1;
	}

	/**
	 * 查找第一个大于等于value的值的索引
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int search03(int[] arr,int value){
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			int middle = low + ((high - low)>>1);
			if(value <= arr[middle]){
				// 当value小于当前的区域的时候
				if(middle == 0 || value > arr[middle-1]){
					return middle;
				}else{
					high = middle - 1;
				}
			}else{
				low = middle + 1;
			}
		}
		return -1;
	}

	/**
	 * 查找最后一个小于等于value的索引
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int search04(int[] arr,int value){
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			int middle = low +((high - low)>>1);
			if(value >= arr[middle]){
				if(middle == arr.length - 1 || value < arr[middle + 1] ){
					return middle;
				}else{
					low = middle + 1;
				}
			}else{
				high = middle - 1;
			}
		}
		return -1;
	}

}
