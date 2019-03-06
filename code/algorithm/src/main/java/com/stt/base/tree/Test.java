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

		Heap heap = new Heap(15);
		heap.insert(33);
		heap.insert(27);
		heap.insert(16);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(13);
		heap.insert(8);
		heap.insert(1);
		heap.insert(2);
		heap.insert(15);
		heap.insert(9);
		heap.insert(21);
		heap.insert(22);
		System.out.println(heap);

		heap.removeMax();
		System.out.println(heap);

		Heap heap1 = new Heap();
		heap1.build(new int[]{7,5,19,8,4,1,20,13,16});
		System.out.println(heap1);

		heap1.sort();
		System.out.println(heap1);

	}
}
