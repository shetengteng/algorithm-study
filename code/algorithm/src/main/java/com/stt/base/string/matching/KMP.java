package com.stt.base.string.matching;

/**
 * Created by Administrator on 2019/3/11.
 */
public class KMP {


	/**
	 * 生成Next数组，下标是前缀结尾下标，+1就是前缀大小，值是该结尾范围内最长可匹配前缀字符串下标
	 * @param modeStr
	 * @return
	 */
	public int[] generateNexts(String modeStr){
		int m = modeStr.length();
		int[] next = new int[m];
		// 理论上应该是0，但是为了方便判断越界，同时为了方便判断第0位和第i位，这里设置为-1
		next[0] = -1;

		// j 表示 最长可匹配前缀子串尾字符下标
		// i 表示 前缀结尾字符下标
		// 从后往前的推导，计算next[i]时可以保证next[0]-next[i-1]已经计算过
		// 若以某一个结尾的子串不存在相同的前缀和后缀，这里重置为-1
		for(int i=1;i<m;i++){
			// j 是上一个的结果 如果没有匹配上值是-1
			int j = next[i-1];
			// 重点：此时j的值是next[i-1] 表示i-1的最长可匹配前缀，但是该前缀+b[i]不匹配b[j+1]
			// 那么寻找[0,i-1]的次最长可匹配前缀，次最长肯定是在最长可匹配前缀中的
			// 那么在最长可匹配前缀范围内的[0,j]再得到该范围的最长可匹配前缀进行匹配
			while(j != -1 && modeStr.charAt(i) != modeStr.charAt(j+1)){
				j = next[j];
			}
			if(modeStr.charAt(i) == modeStr.charAt(j+1)){
				next[i] = j+1;
			}else{
				next[i] = -1;
			}
		}
		return next;
	}

	public int handle(String modeStr,String mainStr){
		int[] next = generateNexts(modeStr);
		int n = mainStr.length();
		int m = modeStr.length();
		for(int i=0,j=0;i<n;i++){
			// 如果不相同,当前j的位置是坏字符
			while(j>0 && mainStr.charAt(i) != modeStr.charAt(j)){
				// 将j的位置更替为最长可匹配前缀子串最后一个字符索引+1，然后进行比较
				j = next[j-1]+1;
			}
			// 表示字符相同，如果不相同，则i++，j=0，然后再继续比较
			if(mainStr.charAt(i) == modeStr.charAt(j)){
				j++;
			}
			if(j==m){
				// 找到模式串的第一个元素的位置
				return i-m+1;
			}
		}
		return -1;
	}

}
