package com.sai.geeksforgeeks.string;

import java.util.Scanner;

/**
 * Correct Answer.Correct Answer
	Execution Time:0.07
 * @author programmer
 *
 */
public class Reverse_words_in_a_given_string {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int z = 0; z <= testCases; z++) {
			String s1 = sc.nextLine();
			if(!s1.isEmpty()){
			splitonDOT(s1);
			}
		}
	}
	
	private static void splitonDOT(String s1) {
		StringBuilder sb = new StringBuilder();
		String[] split = s1.split("\\.");
		String test="";
		for(int i=split.length-1;i>=0;i--) {
			sb.append(split[i]+".");
		}
		if(!sb.toString().isEmpty()) {
			test=sb.substring(0,sb.length()-1);
		}
		System.out.println(test);
	}
	
	/*This is given number of strign with dots, then reversr it..
	 * public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int z = 0; z < testCases; z++) {
			int lines=sc.nextInt();
				
			for(int f=0;f<lines;f++) {
				sc.nextLine();	
			String s1 = sc.next();
			String s2 = sc.next();
			
			splitonDOT(s1);
			System.out.println();
			splitonDOT(s2);
			
			}
		}	

	}

	private static void splitonDOT(String s1) {
		StringBuilder sb = new StringBuilder();
		String[] split = s1.split("\\.");
		for(int i=split.length-1;i>=0;i--) {
			sb.append(split[i]+".");
		}
		if(!sb.toString().isEmpty()) {
			sb.substring(0,sb.length()-1);
		}
		System.out.println(sb);
	}*/

}
