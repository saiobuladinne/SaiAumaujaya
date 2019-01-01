package com.sai.BinaryTrees;

class Node1{
	int key;
	String name;
	Node1 leftChild;
	Node1 rightChild;
	
	Node1(int key, String name){
		this.key = key;
		this.name = name;
	}
	
	public String toString() {
		return name+" has key "+key;
	}
}
public class BinaryTree {

	Node1 root;
	
	public void addNode(int key, String name) {
		Node1 newNode= new Node1(key,name);
		if(root == null) {
			root = newNode;
		}else {
			Node1 focusNode=root;
			Node1 parent;
			
			while(true){
				parent = focusNode;
				if(key< focusNode.key) {
					focusNode = focusNode.leftChild;
					if(focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				}else {
					focusNode = focusNode.rightChild;
					if(focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	//Traversal : inOrder(smallest number first: which first left most from root, if null reached jump to parent)
	//ascending Order
	
	public void inOrderTraverseTree(Node1 focusNode) {
		//recursion is used
		if(focusNode !=null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	//Traversal : preOrder(start with root and get smallest number first: which first left most from root,
	//if null reached jump to parent)
		//ascending Order
		
		public void preOrderTraverseTree(Node1 focusNode) {
			//recursion is used
			if(focusNode !=null) {
				System.out.println(focusNode);
				preOrderTraverseTree(focusNode.leftChild);
				preOrderTraverseTree(focusNode.rightChild);
			}
		}
		
		//Traversal : postOrder(start with root and get smallest number first: which first left most from root, if null reached jump to parent)
				//ascending Order
			public void postOrderTraverseTree(Node1 focusNode) {
					//recursion is used
					if(focusNode !=null) {
						postOrderTraverseTree(focusNode.leftChild);
						postOrderTraverseTree(focusNode.rightChild);
						System.out.println(focusNode);
					}
				}
			
		public Node1 findNode(int key)	{
			
			Node1 focusNode=root;
			
			while(focusNode !=null && focusNode.key !=key) {
				if(key > focusNode.key) {					
					focusNode = focusNode.rightChild;
				}else {
				focusNode = focusNode.leftChild;
				}
			}
			return focusNode;
		}
		
		public boolean deleteNode(int key)	{
			
			Node1 focusNode=root;
			Node1 parent = root;
			
			boolean isItaLeftChild=true;
			
			while(focusNode.key !=key) {
				parent=focusNode;
				if(key < focusNode.key) {
					isItaLeftChild=true;
					focusNode = focusNode.leftChild;
				}else {
					isItaLeftChild=false;
					focusNode = focusNode.rightChild;
				}
				if(focusNode == null) {
					return false;
				}
			}
			
			if(focusNode.leftChild == null && focusNode.rightChild == null) {
				if(focusNode == root) {
					root=null;
				}else if(isItaLeftChild) {
					parent.leftChild=null;
				}else {
					parent.rightChild=null;
				}
			}
			else if(focusNode.rightChild == null) {
				if(focusNode == root) {
					root = focusNode.leftChild;
				}else if(isItaLeftChild) {
					parent.leftChild = focusNode.leftChild;
				}else {
					parent.rightChild = focusNode.leftChild;
				}
					
			}else if(focusNode.leftChild == null)
			{
				if(focusNode == root) {
					root = focusNode.rightChild;
				}else if(isItaLeftChild) {
					parent.leftChild = focusNode.rightChild;
				}else {
					parent.rightChild = focusNode.leftChild;
				}
			}
			else {
				Node1 replacement  = getReplacementNode(focusNode);
				if(focusNode == root) {
					root = replacement;
				}else if(isItaLeftChild) {
					parent.leftChild = replacement;
				}else {
					parent.rightChild= replacement;
					replacement.leftChild = focusNode.leftChild;
				}
			}
			
			return true;
		}
		
		public Node1 getReplacementNode(Node1 replacedNode) {
			Node1 replacementParent = replacedNode;
			Node1 replacement = replacedNode;
			
			Node1 focusNode = replacedNode.rightChild;
			while(focusNode !=null) {
				replacementParent = replacement;
				replacement = focusNode;
				focusNode = focusNode.leftChild;
			}
			if(replacement != replacedNode.rightChild) {
				replacementParent.leftChild = replacement.rightChild;
				replacement.rightChild = replacedNode.rightChild;
			}
			return replacement;
		}

	public static void main(String[] args) {
		
		BinaryTree theTree = new BinaryTree();
		/*theTree.addNode(8, "Boss");
		theTree.addNode(3, "Vice President");
		theTree.addNode(6, "Office Manager");
		theTree.addNode(4, "Secretary");
		theTree.addNode(7, "Sales Manager");
		theTree.addNode(8, "Test1");
		theTree.addNode(10, "Test2");
		theTree.addNode(14, "Test3");
		theTree.addNode(13, "Test4");*/
		
		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Vice President");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(85, "SalesMan 1");
		
		//theTree.preOrderTraverseTree(theTree.root);
		//theTree.postOrderTraverseTree(theTree.root);
		
		//Node findNode = theTree.findNode(68);
		theTree.deleteNode(15);
		//theTree.inOrderTraverseTree(theTree.root);
		//System.out.println(findNode);
	}

}

