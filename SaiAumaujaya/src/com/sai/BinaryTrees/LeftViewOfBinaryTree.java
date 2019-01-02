package com.sai.BinaryTrees;

class BinaryTreeLVOT {
	public Node addNode(int data, Node head) {
		Node tempHead = head;
		Node n = Node.newNode(data);
		if (head == null) {
			head = n;
			return head;
		}
		Node prev = null;
		while (head != null) {
			prev = head;
			if (head.data < data) {
				head = head.right;
			} else {
				head = head.left;
			}
		}
		if (prev.data < data) {
			prev.right = n;
		} else {
			prev.left = n;
		}
		return tempHead;
	}

	int maxLevel = 0;
	public void leftViewOfTree(Node head) {
		
		getLeftView(head,maxLevel);
		
	}

	private void getLeftView(Node node, int level) {

		if(node==null) {
			return;
		}
		
		if(level >= maxLevel) {
			System.out.println(node.data +" ");
			maxLevel++;
		}
		getLeftView(node.left,level+1);
		getLeftView(node.right,level+1);
	}
}

public class LeftViewOfBinaryTree {

	public static void main(String[] args) {
		// insert the Nodes from other File, not writing it here
		Node head = null;
		BinaryTreeLOT bt = new BinaryTreeLOT();
		head = bt.addNode(10, head);
		head = bt.addNode(15, head);
		head = bt.addNode(5, head);
		head = bt.addNode(7, head);
		head = bt.addNode(19, head);
		head = bt.addNode(20, head);
		head = bt.addNode(-1, head);
		BinaryTreeLVOT lot = new BinaryTreeLVOT();
		lot.leftViewOfTree(head);

	}
}
