package com.stt.base.back_track;

/**
 * 八皇后问题
 * 8x8棋盘，8个子，每行一个棋子，每一行，每一列，斜线都不能有棋子，列出所有的可能性
 * 使用回溯
 * Created by Administrator on 2019/3/22.
 */
public class EightQueen {

	/**
	 * 下标表示行
	 * 值表示queen存储在哪一列
	 */
	int[] result = new int[8];

	public void calculate(int row){
		// 8个queen都放好了
		if(row == 8){
			// 每次等于8都打印出result
			printResult(result);
			return;
		}
		for(int column = 0;column < 8;column ++){
			// 每一行有8列，那么就有8种情况可以放置
			// 从第一行开始的8种情况，每次打印出result后，其他情况覆盖该result结果
			// 注意这里的for循环不是同步进行的，按照顺序依次往下，result没有冲突，公用一个
			if(handleColumn(row,column)){
				result[row] = column;
				// 计算下一行
				calculate(row + 1);
			}
		}
	}

	/**
	 * 判断当前行该列是否可以放置queen
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean handleColumn(int row,int column){
		// 左上角
		int leftup = column -1;
		// 右上角
		int rightup = column +1;

		//从row-1往上排查
		for(int i=row-1;i>=0;i--){
			// 该列有queen
			if(result[i] == column){
				return false;
			}
			// 左上角
			if(leftup >=0 && result[i] == leftup){
				return false;
			}
			// 右上角
			if(rightup < 8 && result[i] == rightup){
				return false;
			}
			leftup--;
			rightup++;
		}
		return true;
	}

	public void printResult(int[] re){
		int n = re.length;
		for(int row = 0;row < n; row++){
			for(int column=0;column < n;column++){
				if(re[row]!=column){
					System.out.print("*");
				}else{
					System.out.print("Q");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
