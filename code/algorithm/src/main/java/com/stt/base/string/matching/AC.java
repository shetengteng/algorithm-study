package com.stt.base.string.matching;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ac 自动机模式 多字符串匹配
 * Created by Administrator on 2019/3/12.
 */
public class AC {

	private Node root = new Node('/');

	public void handle(String mainStr){
		// 执行之前需要生成trie树
		int n = mainStr.length();
		Node parent = root;
		for(int i=0;i<n;i++){
			int index = mainStr.charAt(i) - 'a';
			// 判断节点对应的位置，在非root下找到合适的分支模式串起始节点
			while(parent != root){
				// 如果匹配到则出循环
				if(parent.children[index] != null){
					break;
				}
				// 没有匹配到，则去其他分支获取看是否可以匹配到
				parent = parent.fail;
			}
			Node current = parent.children[index];
			if(current == null){
				parent = root;
				continue;
			}
			// 记录当前移动的点，用于下次循环的起始查找点
			parent = current;
			// 找到对应的点，判断是否是最后节点
			while(current != root){
				if(current.isEndingChar){
					// 输出匹配项目
					int pos = i-current.length+1;
					System.out.println("匹配起始下标："+pos+" 长度："+current.length);
				}
				// 查询相同值的其他节点，判断是否是最后一个
				current = current.fail;
			}
		}
	}

	public Node generateTrie(String[] modeStrs){
		for (String modeStr : modeStrs) {
			insertTrieNode(modeStr);
		}
		buildFailuerPointer();
		return root;
	}

	private void insertTrieNode(String modeStr){
		int m = modeStr.length();
		Node p = root;
		for(int i=0;i<m;i++){
			int index = modeStr.charAt(i) - 'a';
			if(p.children[index] == null){
				Node n = new Node(modeStr.charAt(i));
				p.children[index] = n;
			}
			p = p.children[index];
		}
		p.isEndingChar = true;
		p.length = m;
	}

	/**
	 * 构建失效指针
	 */
	private void buildFailuerPointer(){
		Queue<Node> queue = new LinkedList<>();
		// 根的失效指针需要设置为null
		root.fail = null;
		queue.add(root);
		while(!queue.isEmpty()){
			// 获取头部元素
			Node parent = queue.poll();
			int size = parent.children.length;
			for(int i=0;i<size;i++){
				Node current = parent.children[i];
				if(current == null){
					continue;
				}
				// 父节点是root，那么就没有pc上一层节点可以查找失效指针
				if(parent == root){
					current.fail = root;
				}else{
					// 获取父层的失效指针，尝试在父层中是否有子串的匹配
					// 这样在遍历单个串时，如果到该子节点不匹配，尝试在失效指针，父级从其他子串路径去判断
					// 避免重复遍历
					Node branchParent = parent.fail;
					while(branchParent!=null){
						// 分支节点和当前节点相同，即不为null，说明相同，则失效指针指向该分支节点
						Node branchNode = branchParent.children[current.data - 'a'];
						if(branchNode != null){
							current.fail = branchNode;
							break;
						}
						// 如果该分支节点没有找到，则再去其他分支节点查找
						// 如果一直没有找到，那么最终branchParent是root,而root的fail是null
						// 这句是重点，类似于kmp中的j=next[j]
						branchParent = branchParent.fail;
					}
					// 此时fail为null，说明已经迭代到了root节点
					if(branchParent == null){
						current.fail = root;
					}
				}
				queue.add(current);
			}
		}
	}


	class Node{
		char data;
		/**
		 * 字符集包含26个字母
		 */
		Node[] children = new Node[26];
		/**
		 * 表示模式串的最后一个节点
		 */
		boolean isEndingChar=false;
		/**
		 * 当isEndingChar = true,记录长度，用于主串移动使用
		 */
		int length = -1;
		/**
		 * 失效指针
		 */
		Node fail = null;

		Node(char data){
			this.data = data;
		}
	}


}
