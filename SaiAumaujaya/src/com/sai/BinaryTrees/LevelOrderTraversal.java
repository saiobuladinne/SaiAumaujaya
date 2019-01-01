package com.sai.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	int data;
	Node left;
	Node right;
	
	public static Node newNode(int data){
        Node n = new Node();
        n.left = null;
        n.right = null;
        n.data = data;
        return n;
    }
}
class BinaryTreeLOT {
    public Node addNode(int data, Node head){
        Node tempHead = head;
        Node n = Node.newNode(data);
        if(head == null){
            head = n;
            return head;
        }
        Node prev = null;
        while(head != null){
            prev = head;
            if(head.data < data){
                head = head.right;
            }else{
                head = head.left;
            }
        }
        if(prev.data < data){
            prev.right = n;
        }else{
            prev.left = n;
        }
        return tempHead;
    }
    
    class IntegerRef{
        int height;
    }
    
    public int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight  = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
public class LevelOrderTraversal {

	
	public void levelOrder(Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		System.out.println();
		while(queue.size()>0) {
			root=queue.poll();
			System.out.println(root.data);
			
			if(root.left!=null) {
				queue.add(root.left);
			}
			if(root.right!=null) {
				queue.add(root.right);
			}
		}
	}
	
	public static void main(String[] args) {
		//insert the Nodes from other File, not writing it here
		 Node head = null;
		 BinaryTreeLOT bt = new BinaryTreeLOT();
	        head = bt.addNode(10, head);
	        head = bt.addNode(15, head);
	        head = bt.addNode(5, head);
	        head = bt.addNode(7, head);
	        head = bt.addNode(19, head);
	        head = bt.addNode(20, head);
	        head = bt.addNode(-1, head);
		LevelOrderTraversal lot = new LevelOrderTraversal();
		lot.levelOrder(head);
		
	}

}
