package com.sai.geeksforgeeks.arrays;
import java.util.Scanner;

/*
 * Given a number N, the task is to find the maximum 0’s between two immediate 1’s in binary representation of given n. Return -1 if binary representation contains less than two 1’s.

Examples:

Input : N = 47
Output: 1
as binary of N = 47 is 101111

Input : N = 549
Output: 3
as binary of n = 549 is 1000100101 

Input : N = 1030
Output: 7
as binary of N = 1030 is 10000000110

Input : N = 8
Output: -1
as there is only one 1 in binary representation of 8.
 * 
 */
public class MaximumBinaryGapGeeksForGeeks {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int j = 0; j < testCases; j++) {
			int N = sc.nextInt();
		
		String binaryString = Integer.toBinaryString(N);
		int numberOfTrailingZeros = Integer.numberOfTrailingZeros(N);
		
		String[] split = binaryString.split("");
		int maxCounter = 0;
		int max=0;
		int numOfones = 0;
		boolean end= false;
		for(int i=0;i<split.length-(numberOfTrailingZeros);i++){
			
			if(Integer.parseInt(split[i]) == 0){
				//maxCounter = maxCounter+1;
				max = Math.max(max, maxCounter+1);
				maxCounter++;
				if(i==split.length-1){
					end=true;
				}
			}else{
				maxCounter = 0;
				numOfones++;
				//findMaxRec(A, maxCounter)
				//map.put(maxCounter, maxCounter);
			}
			if(end){
				max=Math.max(max,0);
			}
		}
		if(numOfones<2){
			max=-1;
		}
		System.out.println(max);
		}
		
	}
	
	 public static int findMaxRec(int A[], int n)
	    {
	      // if size = 0 means whole array
	      // has been traversed
	      if(n == 1)
	        return A[0];
	         
	        return Math.max(A[n-1], findMaxRec(A, n-1));
	    }

}