package com.sai.geeksforgeeks.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations_of_a_given_string {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int testCases = 1;
		for (int z = 0; z < testCases; z++) {
			String s = "ABCD";
			for(int i=0;i<s.length();i++) {
				if(s.length()>3) {
					System.out.println(s.length()-1);System.out.println(s.length()-3);
					char charAt = s.charAt(i);
					String substring = s.substring(s.length()-3, s.length());
					List<String> ls3 = get3Combinations(substring, charAt);
					for(int j=0;j<ls3.size();j++) {
						sb.append(charAt+ls3.get(j)+" ");
					}
					System.out.println(sb.toString());
				}
				
			}
			
			
			System.out.println(sb.toString());
		}	
	}

	private static List<String> get3Combinations(String s, char charAt) {
		List<String> ls3 = new ArrayList<String>();
		List<String> ls = getCombinationsFor2(s.replace(""+charAt, ""));
		for(int j=0;j<ls.size();j++) {
			//sb.append(charAt+ls.get(j)+" ");
			ls3.add(charAt+ls.get(j)+" ");
		}
		return ls3;
	}

	private static List<String> getCombinationsFor2(String s) {
		List<String> ls = new ArrayList<String>();
		char charAt0 = s.charAt(0);
		char charAt1 = s.charAt(1);
		ls.add(""+charAt0+charAt1);
		ls.add(""+charAt1+charAt0);
		return ls;
	}

}
