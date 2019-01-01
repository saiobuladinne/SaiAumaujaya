package com.sai.geeksforgeeks.string;

import java.util.Scanner;

public class Longest_Distinct_characters_in_string {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = 1;
		int max=0;
		for (int z = 0; z < testCases; z++) {
			String s="geeksforgeeks";
			String[] s1 = s.split("");
			String s2 = new String("");
			
			for (int i = 0; i < s1.length-1; i++) {
				s2=s1[i];
				for( int j=i+1;j<s1.length;j++) {
					if(!s2.contains(s1[j])) {
						s2=s2+s1[j];
					}else {
						break;
					}
				}
				int x= s2.length();
				if(x>max) {
					max=x;
				}
			}
			 System.out.println(max);
		}
	}

}
