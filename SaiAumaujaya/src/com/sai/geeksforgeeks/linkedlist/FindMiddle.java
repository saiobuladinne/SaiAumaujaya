package com.sai.geeksforgeeks.linkedlist;


public class FindMiddle {
	public Node head; // head of list

	public void addToTheLast(Node node) {
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}
	
	Node reverse(Node head) {
		Node current = head;
		Node prev = null ;
		Node next;
		while(current.next!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		current.next = prev;
		head = current;
		return head;
	}
	
	//https://www.youtube.com/watch?v=NC2hGWsyeLo youtube link for this
	public void rotate(Node head,int k)
    {
		if(k<1) {
			return;
		}
		Node current = head;
		Node kthNode= null ;
		for(int i=1;i<k && current!=null;i++) {
			
			current = current.next;
		}
		if(current==null) {
			 return;
		}
		kthNode = current;
		while(current.next!=null) {
			current = current.next;
		}
		current.next = head;
		head = kthNode.next;
		kthNode.next=null;
		
		while (head != null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
	
	public void reverseLLByGroupofKSize(Node head,int k)
    {
		if(k<1) {
			return;
		}
		Node current = head;
		Node kthNode= null ;
		for(int i=1;i<k && current!=null;i++) {
			
			current = current.next;
		}
		if(current==null) {
			 return;
		}
		kthNode = current;
		while(current.next!=null) {
			current = current.next;
		}
		current.next = head;
		head = kthNode.next;
		kthNode.next=null;
		
		while (head != null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}
