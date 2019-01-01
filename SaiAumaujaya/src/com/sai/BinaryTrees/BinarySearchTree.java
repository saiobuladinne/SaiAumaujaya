package com.sai.BinaryTrees;

/* * Node class contains the Binary Tree Node Structure.  
 * (int Data, left reference & right reference)   
 */
class Node1 {
	Node1 left;
	Node1 right;
	int data;
}

/*
 * Tree class contains the necessary functions to make the operations.
 */
class Tree {
	Node1 root;

	/*
	 * Tree class constructor
	 */
	public Tree() {
		root = null;
	}

	/*
	 * getNewNode() method to generate a new node
	 */
	public Node1 getNewNode(int key) {
		Node1 a = new Node1();
		a.left = null;
		a.right = null;
		a.data = key;
		return a;
	}

	/*
	 * insert method is used to insert the element in Binary Search Tree
	 */
	public Node1 insert(Node1 node, int key) {
		if (node == null)
			return getNewNode(key);
		if (key < node.data)
			node.left = insert(node.left, key);
		else
			node.right = insert(node.right, key);
		return node;
	}

	public boolean searchNode(Node1 node, int key) {
		boolean found = false;
		if (node == null)
			return false;
		if (key < node.data)
			found = searchNode(node.left, key);
		else if (key > node.data)
			found = searchNode(node.right, key);
		else
			found = true;
		return found;
	}

	public Node1 getParentOfGivenNode(Node1 node, int key) {
		Node1 parentNode = null;
		if (node == null)
			return null;
		if (key == node.data)
			return parentNode;

		while (node != null) {

			if (key < node.data) {
				parentNode = node;
				node = node.left;
			} else if (key > node.data) {
				parentNode = node;
				node = node.right;
			} else {
				break;
			}
		}
		if (node == null) {
			parentNode = null;
		} else if (parentNode == null) {
			parentNode = null;
		}
		return parentNode;
	}

	public Node1 getSiblingOfGivenNode(Node1 node, int key) {
		Node1 parentNode = null;
		if (node == null)
			return null;

		while (node != null) {

			if (key < node.data) {
				parentNode = node;
				node = node.left;
			} else if (key > node.data) {
				parentNode = node;
				node = node.right;
			} else {
				break;
			}
		}
		if (node == null) {
			System.out.println("Value could not find in Tree");
			return null;
		} else if (parentNode == null) {
			System.out.println("Sibling of root is null");
			return null;
		} else {
			if (parentNode.left != null && key == parentNode.left.data) {
				return parentNode.right;
			} else {
				return parentNode.left;
			}
		}
	}

	/*
	 * getSuccessor() method returns the Successor node of given node 1) We check
	 * the node which is to be return the successor node. Successor node would
	 * always be present in right sub tree of given node.
	 * 
	 * 2) If right subtree of node exists, we move towards left of it, till we get
	 * left leaf node, that's successor node.
	 * 
	 * 3) When Tree is empty, we return null value.
	 */
	public Node1 getSuccessor(Node1 node) {
		if (node == null)
			return node;
		node = node.right;
		if (node == null)
			return null;
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public boolean checkIfBinaryTree(Node1 root) {

		int MIN=Integer.MIN_VALUE;
		int MAX=Integer.MAX_VALUE;
		boolean isBst=isBST(root,MIN,MAX);
		return isBst;
	}

	private boolean isBST(Node1 root, int MIN, int MAX) {
		boolean bst=true;
		if(root==null) {
			return true;
		}
		if(root.data<MIN || root.data>MAX) {
			return false;
		}
		bst = isBST(root.left,MIN,root.data);
		bst = isBST(root.right,root.data,MAX);
		return bst;
	}

	

}

/*
 * BST class to initiate the operation.
 */
public class BinarySearchTree {
	public static void main(String[] args) {
		Tree a = new Tree();
		Node1 root = null;
		root = a.insert(root, 12);
		root = a.insert(root, 5);
		root = a.insert(root, 15);
		root = a.insert(root, 3);
		root = a.insert(root, 7);
		root = a.insert(root, 8);
		root = a.insert(root, 9);
		root = a.insert(root, 13);
		root = a.insert(root, 20);
		System.out.println(root);

		boolean found = a.searchNode(root, 18);
		System.out.println(found);

		Node1 parentOfGivenNode = a.getParentOfGivenNode(root, 20);
		System.out.println(parentOfGivenNode.data);

		Node1 siblingOfGivenNode = a.getSiblingOfGivenNode(root, 0);
		if (siblingOfGivenNode != null) {
			System.out.println(siblingOfGivenNode.data);
		} else {
			System.out.println(siblingOfGivenNode);
		}

		int height = getTreeHeight(root);
		if (height > 0) {
			System.out.println(height - 1);
		} else {
			System.out.println(-1);
		}
		
		boolean checkIfBinaryTree = a.checkIfBinaryTree(root);
		System.out.println(checkIfBinaryTree);
		
	}

	private static int getTreeHeight(Node1 node) {
		int h = 0;
		if (node == null) {
			return 0;
		}
		int leftHeight = getTreeHeight(node.left);
		int rightHeight = getTreeHeight(node.right);
		if (leftHeight > rightHeight) {
			h = 1 + leftHeight;
		} else {
			h = 1 + rightHeight;
		}
		return h;
	}
}