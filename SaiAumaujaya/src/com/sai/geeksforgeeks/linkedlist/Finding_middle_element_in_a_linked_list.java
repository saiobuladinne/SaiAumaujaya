package com.sai.geeksforgeeks.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Finding_middle_element_in_a_linked_list {

	public static void main(String[] args) {
		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			FindMiddle llist = new FindMiddle();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}
			Finding_middle_element_in_a_linked_list gfgobj = new Finding_middle_element_in_a_linked_list();
			// llist.head = new GFG().Middle(llist.head);
			System.out.println(gfgobj.getMiddle(llist.head));
			// llist.printList();
			t--;
		}
	}

	private int getMiddle(Node head) {
		int middle=0;
		Node temp = head;
		List<Integer> ls = new ArrayList<Integer>();
		
		while (temp.next != null) {
			ls.add(temp.data);
			temp = temp.next;
		}
		ls.add(temp.data);
		if(ls==null || ls.isEmpty()){
		    return -1;
		}
		if(ls.size()%2==0) {
			middle=ls.get(((ls.size()-1)/2)+1);
		}else {
			middle=ls.get(ls.size()/2);
		}
		System.out.println(middle);
		return middle;
	}
}
