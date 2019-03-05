package com.stt.base.tree;

/**
 * Created by Administrator on 2019/3/5.
 */
public class Test {

	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(55);
		tree.insert(77);
		tree.insert(1);
		tree.insert(3);
		System.out.println(tree);

	}
}
