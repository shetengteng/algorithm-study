package com.stt.base.search;

/**
 * Created by Administrator on 2019/2/28.
 */
public class Test {

	public static void main(String[] args) {

		int[] arr = {1,3,5,7,9,22,34,56,67,112};
		int re = -2;
//		re = Binary.search(arr,9);
//		re = Binary.search2(arr,9);

		int[] arr2 = {1,3,5,7,9,9,9,22,22,22,34,56,67,112};
//		re = Binary2.search01(arr2,22);
//		re = Binary2.search01_1(arr2,22);
//		re = Binary2.search02(arr2,22);
//		re = Binary2.search02_1(arr2,22);
//		re = Binary2.search03(arr2,11);
		re = Binary2.search04(arr2,11);
		System.out.println(re);
	}

}
