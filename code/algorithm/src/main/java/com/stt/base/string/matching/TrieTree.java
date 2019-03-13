package com.stt.base.string.matching;

/**
 * 使用字典树查询
 * Created by Administrator on 2019/3/12.
 */
public class TrieTree {
	/**
	 *先定义根节点
 	 */
	private Node root = new Node('/');

	public TrieTree insert(String str){
		int m = str.length();
		Node p = root;
		for(int i=0;i<m;i++){
			int index = str.charAt(i) - 'a';
			// 表示下一个节点是空，需要创建该节点
			if(p.children[index] == null){
				Node n = new Node(str.charAt(i));
				p.children[index] = n;
			}
			p = p.children[index];
		}
		p.isEndingChar = true;
		return this;
	}

	public boolean find(String str){
		Node p = root;
		int m = str.length();
		for(int i=0;i<m;i++){
			int index = str.charAt(i) - 'a';
			if(p.children[index] == null){
				return false;
			}
			p = p.children[index];
		}
		// 从trie树root遍历m层得到的节点，如果isEndingChar=true,表示匹配到
		// 否则表示str是前缀
		return p.isEndingChar;
	}

	class Node{
		char data;
		/**
		 *表示有个字符串在此处结尾
 		 */
		boolean isEndingChar = false;
		/**
		 *存储下一个节点，下标是下一个字符的字母序号
 		 */
		Node[] children = new Node[26];
		Node(char data){
			this.data = data;
		}
	}
}