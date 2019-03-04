package com.stt.base.tree;

/**
 * 二叉查找树，左边子树节点比当前节点小，右边子树节点比当前节点大
 * Created by Administrator on 2019/3/4.
 */
public class BinarySearchTree {

	private Node tree;

	public Node find(int data){
		Node p = tree;
		while(p!=null){
			if(data == p.data){
				return p;
			}
			if(data < p.data){
				p = p.left;
				continue;
			}
			if(data > p.data){
				p = p.right;
			}
		}
		return null;
	}

	public void insert(int data){
		if(tree == null){
			tree = new Node(data);
			return;
		}
		Node p = tree;
		while(p != null){
			if(p.data == data){
				return;
			}
			if(data < p.data){
				if(p.left == null){
					p.left = new Node(data);
					return;
				}
				p = p.left;
			}
			if(data > p.data){
				if(p.right == null){
					p.right = new Node(data);
					return;
				}
				p = p.right;
			}
		}
	}

	public void delete(int data){
		// 先指向根节点
		Node p = tree;
		// 查询得到data的父节点
		Node pp = null;
		while(p != null){
			if(data == p.data){
				break;
			}
			pp = p;
			p = data > p.data ? p.right : p.left;
		}
		// 没有找到
		if(p == null){
			return;
		}

		// 要删除的节点有左右子节点
		if(p.right != null && p.left != null){
			Node minP = p;
			Node min = minP.right;
			// 找到右子树中最小的节点
			// 在右子树的左子树进行遍历，得到最小点，左边比右边小
			while(min.left != null){
				minP = min;
				min = minP.left;
			}
			// 说明min.left 为null，那么在右子树的最小节点就找到了
			p.data = min.data;
			p = min;
			pp = minP;
		}

		// 删除节点是叶子节点，或者只有一个子节点
		Node child = null;
		if(p.left != null){
			child = p.left;
		}
		if(p.right != null){
			child = p.right;
		}

		// 删除的是根节点
		if(pp == null){
			tree = child;
		}else if(pp.left == p){
			pp.left = child;
		}else {
			pp.right = child;
		}
	}

	public static class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int data){
			this.data = data;
		}
	}
}
