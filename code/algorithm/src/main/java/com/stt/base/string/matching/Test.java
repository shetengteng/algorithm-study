package com.stt.base.string.matching;

/**
 * Created by Administrator on 2019/3/9.
 */
public class Test {
	public static void main(String[] args) {

		BM bm  = new BM();
//		int re = bm.handle("ssa","fdfssadsdsf");
		int re = bm.handle2("GTAGCGGCG","GTTATAGCTGATCGCGGCGTAGCGGCGAA");
		System.out.println(re);

		KMP kmp = new KMP();
//		int[] nexts = kmp.generateNexts("ababacd");
		re = kmp.handle("GTAGCGGCG","GTTATAGCTGATCGCGGCGTAGCGGCGAA");
		System.out.println(re);

	}
}
