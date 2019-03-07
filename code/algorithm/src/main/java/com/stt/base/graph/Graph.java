package com.stt.base.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图，邻接表实现
 * Created by Administrator on 2019/3/7.
 */
public class Graph {
	/**
	 * 顶点个数
	 */
	private int count;
	/**
	 * 领接表，使用下标表示点
	 */
	private LinkedList<Integer>[] adj;

	public Graph(int count){
		this.count = count;
		adj = new LinkedList[count];
		for(int i = 0;i<count;i++){
			adj[i] = new LinkedList<>();
		}
	}

	/**
	 * 无向图一条边存储2次
	 * @param start
	 * @param end
	 */
	public void addEdge(int start,int end){
		adj[start].add(end);
		adj[end].add(start);
	}

	/**
	 * 广度优先算法
	 * 返回路径
	 * @param start
	 * @param end
	 * @return
	 */
	public int[] bfs(int start,int end){
		if(start == end){
			return null;
		}
		// 存储已被访问的点
		boolean[] visited = new boolean[count];
		// 存储访问队列，从头部返回k层点，从尾部添加k+1层点
		Queue<Integer> queue = new LinkedList<>();
		// 存储结果路径
		int[] prev = new int[count];
		// 结果路径初始化为-1
		for(int i=0;i<count;i++){
			prev[i] = -1;
		}
		// 将start节点放入
		visited[start] = true;
		queue.add(start);
		while(!queue.isEmpty()){
			// 弹出k层节点
			int current = queue.poll();
			// 遍历k+1层节点
			for(int i=0;i<adj[current].size();i++){
				int next = adj[current].get(i);
				// 如果当前节点已经访问过，则不进行操作，防止循环图
				if(visited[next]){
					continue;
				}
				// 设置下一个节点被当前节点访问
				prev[next] = current;
				// 找到该节点
				if(end == next){
					return prev;
				}
				// next节点已经被访问过，不是end节点
				visited[next] = true;
				// 将next节点放入queue，等待访问next的下一层关联节点
				queue.add(next);
			}
		}
		return prev;
	}

	/**
	 * 打印从start到end的路径
	 * @param prev
	 * @param start
	 * @param end
	 */
	public void print(int[] prev,int start,int end){
		if(prev == null){
			System.out.println("prev is null no route");
		}
		if(prev[end] != -1 && start != end){
			print(prev,start,prev[end]);
		}
		System.out.println("->"+end);
	}

	boolean found = false;

	/**
	 * 深度优先算法
	 * @param start
	 * @param end
	 * @return
	 */
	public int[] dfs(int start,int end){
		if(start == end){
			return null;
		}
		boolean[] visited = new boolean[count];
		int[] prev = new int[count];
		for(int i=0;i<count;i++){
			prev[i] = -1;
		}
		recursiveDfs(start,end,prev,visited);
		return prev;
	}

	private void recursiveDfs(int k,int end,int[] prev,boolean[] visited){
		if(found){
			return;
		}
		visited[k] = true;
		if(k == end){
			found = true;
			return;
		}
		// 从k的下层开始查找
		for(int i=0;i<adj[k].size();i++){
			int next = adj[k].get(i);
			if(visited[next]){
				continue;
			}
			prev[next] = k;
			recursiveDfs(next,end,prev,visited);
		}
	}

}
