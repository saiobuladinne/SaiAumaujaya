package com.sai.geeksforgeeks.arrays;

import java.util.Scanner;

public class Maximum_Sum_ncreasing_Subsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int m = 0; m < testCases; m++) {
			int arraySize = sc.nextInt();
			int[] array = new int[arraySize];
			int[] tempArray = new int[arraySize];
			for(int k=0;k<arraySize;k++){
				array[k] = sc.nextInt();
				tempArray[k] =array[k]; 
			}
			
			int curSum = 0;
			int maxSum=0;
			
			for(int i=1;i<arraySize;i++){
				for(int j=0;j<i;j++){
				if(array[i]>array[j] && tempArray[i]>array[j]){
					
				}else{
				    continue;
					}
				}
			}
			System.out.println(maxSum);
			
		}	
	}

}
