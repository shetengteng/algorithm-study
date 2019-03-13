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

		TrieTree trieTree = new TrieTree();
		trieTree.insert("hello").insert("his").insert("see").insert("so").insert("her");
		System.out.println(trieTree.find("hi"));
		System.out.println(trieTree.find("his"));

		AC ac = new AC();
		AC.Node root = ac.generateTrie(new String[]{"abcd","bcd","c"});
		ac.handle("abcdefghijkbcsxxxscssscbcdsss");
//		ac.match("abcdefghijkbcsxxxscssscbcdsss");
		System.out.println(root);
//
//		匹配起始下标 2; 长度 1
//		匹配起始下标 0; 长度 4
//		匹配起始下标 1; 长度 3
//		匹配起始下标 12; 长度 1
//		匹配起始下标 18; 长度 1
//		匹配起始下标 22; 长度 1
//		匹配起始下标 24; 长度 1
//		匹配起始下标 23; 长度 3
	}
}
