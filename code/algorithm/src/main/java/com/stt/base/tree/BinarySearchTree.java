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
		Node current = tree;
		// 查询得到data的父节点
		Node parent = null;
		while(current != null){
			if(data == current.data){
				break;
			}
			parent = current;
			current = data > current.data ? current.right : current.left;
		}
		// 没有找到
		if(current == null){
			return;
		}

		// 要删除的节点有左右子节点
		if(current.right != null && current.left != null){
			Node minParent = current;
			Node min = minParent.right;
			// 找到右子树中最小的节点
			// 在右子树的左子树进行遍历，得到最小点，左边比右边小
			// 或者可以找到左子树最大的点也是可以的
			while(min.left != null){
				minParent = min;
				min = minParent.left;
			}
			// 说明min.left 为null，那么在右子树的最小节点就找到了
			// 只需要将data进行替换，left和right不需要替换
			current.data = min.data;
			// 将min给current，minParent给Parent
			// 接下来的操作是对min点的删除
			// 此时的min点就是叶子节点
			current = min;
			parent = minParent;
		}
		// 删除节点是叶子节点，或者只有一个子节点
		Node child = null;
		if(current.left != null){
			child = current.left;
		}
		if(current.right != null){
			child = current.right;
		}

		// 删除的是根节点
		if(parent == null){
			tree = child;
		}else if(parent.left == current){
			// 判断current在parent的具体位置，进行替换为child
			parent.left = child;
		}else {
			parent.right = child;
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
