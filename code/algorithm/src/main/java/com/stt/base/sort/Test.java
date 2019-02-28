package com.stt.base.sort;

import java.util.Arrays;

/**
 * Created by ttshe2 on 2019/2/26.
 */
public class Test {

    public static void main(String[] args) {
        int[] a = {9,3,7,1,3,12,5,6};
//        Bubble.sort(a);
//        Insertion.sort2(a);
//        Selection.sort(a);
//        Merge.sort(a);
//        Quick.sort(a);
//        Quick2.sort(a);
        Counting.sort(a);
        System.out.println(Arrays.toString(a));

    }

}
