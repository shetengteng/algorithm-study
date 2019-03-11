package com.stt.base.string.matching;

/**
 * 字符串匹配 BM 算法
 * Created by Administrator on 2019/3/9.
 */
public class BM {

	/**
	 * 表示自定义字符串匹配数组的大小
	 */
	private static final int SIZE = 256;

	public int[] generateBC(String modeStr){
		int[] bc = new int[SIZE];
		// 初始化bc，为-1 表示没有匹配到
		for(int i=0;i<SIZE;i++){
			bc[i] = -1;
		}
		// 将模式串中的字母匹配到bc中
		for(int i=0;i<modeStr.length();i++){
			// 计算模式串中每个字符对应的ascii
			int ascii = (int)modeStr.charAt(i);
			bc[ascii] = i;
		}
		return bc;
	}

	/**
	 * 生成好后缀串匹配数组，下标是好后缀子串长度，
	 * 值是好后缀子串在模式前缀串（除去好后缀串剩下的子串）的最后位置
	 * @param modeStr
	 * @param prefix 注意：prefix需要在函数外部初始化
	 * @return
	 */
	public int[] generateGS(String modeStr,boolean[] prefix){
		int m = modeStr.length();
		int[] suffix = new int[m];
		// 初始化都为-1 实际使用suffix是从下标1开始，0没有使用到
		for(int i=0;i<m;i++){
			suffix[i] = -1;
			prefix[i] = false; // 表示模式串的前缀和好后缀子串相同 为true
		}
		for(int i=0;i<m-1;i++){
			// 好后缀的长度k
			for(int j=i,k=0;j>=0;j--){
				// 使用动态规划不断移动到最优解，由于会不断到最优解，那么需要记录第一次为j为0时，prefix[k]=true
				if(modeStr.charAt(j) == modeStr.charAt(m-1-k)){
					suffix[++k] = j;
					if(j==0){
						prefix[k] = true;
					}
				}else{
					break;
				}
			}
		}
		return suffix;
	}

	/**
	 * 进行匹配，返回匹配的第一个索引位置，-1表示没有找到
	 * @param modeStr
	 * @param mainStr
	 * @return
	 */
	public int handle(String modeStr,String mainStr){
		int[] bc = generateBC(modeStr);
		int m = modeStr.length();
		int n = mainStr.length();
		for(int i=0;i<=n-m;){
			// i 表示主串与模式串匹配的第一个字符
			// 模式串从后往前匹配
			int bad = -1;
			for(int j=m-1;j>=0;j--){
				// 找到第一个不匹配的坏字符
				if(mainStr.charAt(i+j)!=modeStr.charAt(j)){
					bad = j;
					break;
				}
			}
			// 匹配成功：说明找到了模式串在主串完全相同子串的位置
			if(bad == -1){
				return i;
			}
			// 否则移动到模式串倒着数第一个和坏字符串匹配的位置
			int x = bad - bc[(int)mainStr.charAt(i+bad)];
			i += x > 0 ? x : 1;
		}
		return -1;
	}

	/**
	 * 增加坏字符，好后缀
	 * @param modeStr
	 * @param mainStr
	 * @return
	 */
	public int handle2(String modeStr,String mainStr){
		int m = modeStr.length();
		int n = mainStr.length();
		int[] bc = generateBC(modeStr);
		boolean[] prefix = new boolean[m];
		int[] suffix = generateGS(modeStr,prefix);
		for(int i=0;i<=n-m;){
			// i 表示主串与模式串匹配的第一个字符
			// 模式串从后往前匹配
			int bad = -1;
			for(int j=m-1;j>=0;j--){
				// 找到第一个不匹配的坏字符
				if(mainStr.charAt(i+j)!=modeStr.charAt(j)){
					bad = j;
					break;
				}
			}
			// 匹配成功：说明找到了模式串在主串完全相同子串的位置
			if(bad == -1){
				return i;
			}
			// 否则移动到模式串倒着数第一个和坏字符串匹配的位置(坏字符情况)
			int x = bad - bc[(int)mainStr.charAt(i+bad)];
			// 好后缀情况下
			int y = 0;
			// 好后缀的长度
			int gsl = m-1-bad;
			if(gsl>0){
				if(suffix[gsl]!=-1){
					y = bad - suffix[gsl] +1;
				}else{
					boolean flag = false;
					// 判断子串是否是模式串的前缀，否则是前缀的子串没有意义
					for(int r=bad+2;r<m;r++){
						// 子串是模式串前缀有意义
						if(prefix[m-r]){
							y = r;
							flag = true;
							break;
						}
					}
					if(!flag){
						y = m;
					}
				}
			}
			i += Math.max(x,y);
		}
		return -1;
	}
}
