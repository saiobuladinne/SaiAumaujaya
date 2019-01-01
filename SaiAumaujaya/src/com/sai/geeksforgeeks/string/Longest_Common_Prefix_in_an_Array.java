package com.sai.geeksforgeeks.string;

import java.util.Scanner;

public class Longest_Common_Prefix_in_an_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//geeksforgeeks
		//geeks
		//geek
		//geezer
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int m = 0; m < testCases; m++) {
			int arraySize = sc.nextInt();
			String[] array = new String[arraySize];
			sc.nextLine();
			int minlength=arraySize+1;
			for(int k=0;k<arraySize;k++){
				array[k] = sc.next();
			}
			minlength = array[0].length();
			for(int f=1;f<arraySize;f++){
				minlength = Math.min(minlength, array[f].length());
			}
			
			String prefix = getLongestCommonPrefix(arraySize, array, minlength);
			if(prefix.isEmpty()){
				 System.out.println("-1");
				}else{
				   
				   System.out.println(prefix);
				}
		}
	}

	private static String getLongestCommonPrefix(int arraySize, String[] array, int minlength) {
		int countChar=0;
		for(int i=0;i<minlength;i++){
			countChar++;
			char c = array[0].charAt(i);
			for(int j=1;j<arraySize;j++){
				String s1 = array[j];
				if(s1.charAt(i)!=c){
					return array[j].substring(0, i);
				}
			}
		}
		return array[0].substring(0, countChar);
	}

}

