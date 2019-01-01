package com.sai.geeksforgeeks.Dynamic_Programming;


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
}
