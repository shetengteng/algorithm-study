package com.stt.base.back_track;

import java.util.*;

/**
 * 使用回溯解决背包问题
 * Created by Administrator on 2019/3/23.
 */
public class Backpack {

	// 存储最大的重量
	private int maxWeight = 0;

	// 输出结果的重量
	private int resultWeight = 0;

	// 输出放入背包的情况
	private Map<Integer,List<String>> re = new HashMap<>();

	Backpack(int maxWeight){
		this.maxWeight = maxWeight;
	}

	/**
	 * 开始往背包里面放置东西
	 * @param items
	 */
	public void putInto(int[] items){
		put(0,0,items,"");
		System.out.println("weight:"+resultWeight);
		System.out.println(re.get(resultWeight).toString());
	}

	/**
	 * @param curIndex 当前items的索引
	 * @param curWeight 当前重量
	 * @param items 要放入的物品的全集
	 * @param indexChain 物品选择的下标
	 */
	public void put(int curIndex,int curWeight,int[] items,String indexChain){
		// 终止条件：到达个数限制或者重量限制
		if(curIndex == items.length || curWeight == maxWeight){
			// 记录最优解，这里使用>=可以记录最优解的集合
			if(curWeight >= resultWeight){
				resultWeight = curWeight;
				if(!re.containsKey(resultWeight)){
					re.put(resultWeight,new ArrayList<>());
				}
				re.get(resultWeight).add(indexChain);
			}
			return;
		}
		int nextIndex = curIndex + 1;

		// 关键点：该curIndex物品放入背包中只有2种情况，放入和不放入
		// 情况1：本curIndex时的物品不放入
		put(nextIndex,curWeight,items,indexChain);

		// 情况2：在本curIndex物品不累加不超过背包大小时，放入
		int newWeight = curWeight + items[curIndex];
		if(newWeight <= maxWeight){
			put(nextIndex,newWeight,items,indexChain+"-"+curIndex);
		}
	}

}
