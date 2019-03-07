package com.stt.base.graph;

/**
 * Created by Administrator on 2019/3/7.
 */
public class Test {

	public static void main(String[] args) {

		Graph graph = new Graph(8);
		graph.addEdge(0,1);
		graph.addEdge(0,3);
		graph.addEdge(1,2);
		graph.addEdge(1,4);
		graph.addEdge(2,5);
		graph.addEdge(3,4);
		graph.addEdge(4,5);
		graph.addEdge(4,6);
		graph.addEdge(5,7);
		graph.addEdge(6,7);

//		int[] prev = graph.bfs(0, 4);
//		graph.print(prev,0,5);

		int[] prev = graph.dfs(0,6);
		graph.print(prev,0,6);


	}

}
