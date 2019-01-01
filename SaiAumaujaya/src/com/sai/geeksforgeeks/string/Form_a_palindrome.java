package com.sai.geeksforgeeks.string;

import java.util.Scanner;

public class Form_a_palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int z = 0; z < testCases; z++) {
			String string = sc.nextLine();
			int count=0;
			StringBuilder sb = new StringBuilder();
			if(string.equalsIgnoreCase(sb.append(string).reverse().toString())){
			count=0;	
			}else {
			count = getCount(string, count);
			}
			System.out.println(count);
			
		}
	}

	private static int getCount(String string, int count) {
		for (int i = 0; i < string.length() - 1; i++) {
			for (int j = string.length() - 1; j >= 0; j--) {
				if(i!=0 && (i==j || (j-i<=0))) {
					count++;
					return count;
				}
				if(!(string.charAt(i)==string.charAt(j))) {
					count++;
				}else {
					//i++;
				}
				i++;
			}
		}
		return count;
	}
}

