package com.sai.geeksforgeeks.arrays;

import java.util.Scanner;

public class Subarray_With_Given_Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int j = 0; j < testCases; j++) {
			int arraySize = sc.nextInt();
			int equalSum = sc.nextInt();
			int[] array = new int[arraySize];
			for(int i=0;i<arraySize;i++){
				array[i] = sc.nextInt();
			}
			int currPointer=0;
			int lastIndex=0;
			//calculate(array,currPointer,equalSum,lastIndex);
			subArraySum(array,arraySize,equalSum);
		}	
	}

	static int subArraySum(int arr[], int n, int sum) {
		int curr_sum = arr[0], start = 0, i;

		// Pick a starting point
		for (i = 1; i <= n; i++) {
			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > sum && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum, then return true
			if (curr_sum == sum) {
				int p = i;
				System.out.println((start+1) + " " + p);
				return 1;
			}

			// Add this element to curr_sum
			if (i < n)
				curr_sum = curr_sum + arr[i];

		}

		System.out.println("-1");
		return 0;
	}
	
	private static void calculate(int[] array, int currPointer,int equalSum,int lastIndex) {
		int hor = equalSum;
		for(int i=currPointer;i<array.length;i++){
			int diff = hor-array[i];
			if(diff>array[i+1]){
				hor = diff;
				continue;
			}else if(diff<array[i+1]){
				currPointer = currPointer+1;
				calculate(array,currPointer,equalSum,lastIndex);
				break;
			}else if(diff == array[i+1]){
				lastIndex= i+1;
				System.out.println(currPointer+1 + " " +(lastIndex+1));
				break;
			}
		}
	}

}
