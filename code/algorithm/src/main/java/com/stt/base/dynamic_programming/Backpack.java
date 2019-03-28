package com.stt.base.dynamic_programming;

/**
 * 使用动态规划解决0-1背包问题
 * 动态规划的另一种思路，与传统的动态规划思路不同
 *
 * Created by Administrator on 2019/3/23.
 */
public class Backpack {

	private int maxWeight = 0;

	Backpack(int maxWeight){
		this.maxWeight = maxWeight;
	}

	/**
	 * @param items 要放入的物品的重量
	 * @return 返回最大背包可以装载的数目
	 */
	public int handle(int[] items){
		int count = items.length;
		// 动态规划矩阵
		// y 轴 items的个数
		// x 轴 背包最大个数 + 1
		boolean[][] states = new boolean[count][maxWeight+1];
		// 表示第一个没有放入
		states[0][0] = true;
		// 这里的前提是items[0] 不大于maxWeight
		// 表示第一个放入
		states[0][items[0]] = true;
		// 遍历每一行
		for(int i=1;i<count;i++){
			// 不把第i个物品放入背包,记录i-1个物品在i层的情况的集合
			for(int j=0;j<=maxWeight;j++){
				if(states[i-1][j]){
					states[i][j] = states[i-1][j];
				}
			}
			// 将i层的物品与所有i层的情况集合相加，符合maxWeight的放入
			for(int j=0;j<=maxWeight - items[i];j++){
				// 上一层是true
				if(states[i-1][j]){
					// 将本层物品i放入
					states[i][items[i]+j] = true;
				}
			}
		}
		// 输出结果
		for(int i=maxWeight;i >=0;i--){
			if(states[count-1][i]){
				return i;
			}
		}
		return 0;
	}

	/**
	 * 动态规划方式二，优化转移矩阵，使用一维数组
	 * @param items
	 * @return
	 */
	public int handle2(int[] items){
		int count = items.length;
		// 默认值是false
		boolean[] states = new boolean[maxWeight+1];
		states[0] = true;
		states[items[0]] = true;
		for(int i=1;i<count;i++){
			// 注意：这里是j是从大到小
			// 从小到大的话，后面满足情况会设置为true，造成重复计算
			for(int j=maxWeight-items[i];j>=0;j--){
				if(states[j]){
					states[j+items[i]] = true;
				}
			}
		}
		for(int i=maxWeight;i>=0;i++){
			if(states[i]){
				return i;
			}
		}
		return 0;
	}

}
