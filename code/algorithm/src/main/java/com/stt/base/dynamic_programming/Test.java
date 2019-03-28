package com.stt.base.dynamic_programming;

/**
 * Created by Administrator on 2019/3/28.
 */
public class Test {

	public static void main(String[] args) {

		Backpack backpack = new Backpack(9);
//		int re = backpack.handle(new int[]{2,2,4,1,1,3});
		int re = backpack.handle2(new int[]{2,2,4,1,1,3});
		System.out.println(re);
	}

}
