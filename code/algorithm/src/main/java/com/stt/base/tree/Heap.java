package com.stt.base.tree;

/**
 * Created by Administrator on 2019/3/5.
 */
public class Heap {

	// 存储的数组，从1开始
	private int[] array;
	// 堆可以存储的最大个数
	private int capacity;
	// 堆中已经存储的个数
	private int count;

	public Heap(){}

	public Heap(int capacity){
		array = new int[capacity+1];
		this.capacity = capacity;
		this.count = 0;
	}

	public boolean insert(int data){
		if(count >= capacity){
			return false;
		}
		// 从1开始
		int index = count+1;
		array[index] = data;
		count ++;
		// 和父节点比较
		int parentIndex = index / 2;

		while(parentIndex > 0 && array[index] > array[parentIndex]){

			int tmp = array[index];
			array[index] = array[parentIndex];
			array[parentIndex] = tmp;

			index = parentIndex;
			parentIndex = index / 2;

		}
		return true;

//          简洁写法
//			++count;
//			array[count] = data;
//			int i = count;
//			while (i/2 > 0 && array[i] > array[i/2]) {
//				int tmp = array[i];
//				array[i] = array[i/2];
//				array[i/2] = tmp;
//				i = i/2;
//			}

	}

	public void removeMax(){
		if(count == 0){
			return;
		}
		// 将堆顶元素用最后一个元素替换
		array[1]=array[count];
		// 将最后一个元素重置
		array[count] = 0;
		count --;
		// 调整堆关系
		heapify(count,1);
	}

	/**
	 * 从上往下堆化
	 * @param n 调整的堆的范围，
	 * @param i 要调整的子顶堆的最大节点位置的索引（该位置的值不一定是最大的）
	 */
	private void heapify(int n,int i){

		while(true){

			int maxIndex = i;

			int childIndex = maxIndex*2;
			int childIndex2 = maxIndex*2 + 1;

			// 从左右子节点找到最大的那个
			if(childIndex <= n && array[maxIndex] < array[childIndex]){
				maxIndex = childIndex;
			}
			if(childIndex2 <= n && array[maxIndex] < array[childIndex2]) {
				maxIndex = childIndex2;
			}
			// 说明左右节点都比maxIndex小，maxIndex没有变化
			if(maxIndex == i){
				break;
			}
			// 将i和maxIndex进行替换
			int tmp = array[maxIndex];
			array[maxIndex] = array[i];
			array[i] = tmp;
			// 往下一个节点移动
			i = maxIndex;
		}
	}

	public void build(int[] array){
		this.capacity = array.length+1;
		this.array = new int[capacity];
		this.count = array.length;

		for(int i = 1;i<=count;i++){
			this.array[i] = array[i-1];
		}
		// 对array进行堆处理,选中堆化开始的点，n/2
		for(int i = count / 2;i >=1;i--){
			heapify(count,i);
		}
	}

	public int[] sort(int[] arr){
		build(arr);
		return sort();
	}

	public int[] sort(){
		int k = count;
		while(k>1){
			// 从小到大排序，将最大的放在最后
			int tmp = array[1];
			array[1] = array[k];
			array[k] = tmp;
			k--;
			// 对当前的堆进行堆优化
			heapify(k,1);
		}
		return array;
	}

}
