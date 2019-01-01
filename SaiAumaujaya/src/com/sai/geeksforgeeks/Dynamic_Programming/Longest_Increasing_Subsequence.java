package com.sai.geeksforgeeks.Dynamic_Programming;

import java.util.Scanner;

public class Longest_Increasing_Subsequence {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int z = 0; z < testCases; z++) {
			
			int n = sc.nextInt();
			int[] array =new int[n];
			for(int a=0;a<n;a++){
				array[a] = sc.nextInt();
			}
			int count = getSize(n,array);
			System.out.println(count);
		}
	}

	private static int getSize(int n, int[] array) {
		for (int i = 0; i < n; i++) {
			
		}
		return 0;
	}

}
