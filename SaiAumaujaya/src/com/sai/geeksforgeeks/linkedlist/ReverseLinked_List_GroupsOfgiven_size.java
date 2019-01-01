package com.sai.geeksforgeeks.linkedlist;

import java.util.Scanner;

public class ReverseLinked_List_GroupsOfgiven_size {
	static Node head;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		FindMiddle fm = new FindMiddle();
		while(t-->0){
			int n=sc.nextInt();
			head=null;
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            fm.addToTheLast(head);
            for (int i=1;i<n;i++) {
                int a = sc.nextInt();
                fm.addToTheLast(new Node(a));
			}
			int k=sc.nextInt();
			//GfG g=new GfG();
			fm.rotate(head,k);
		}
	}

}
