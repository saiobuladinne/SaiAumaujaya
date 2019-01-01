package com.sai.geeksforgeeks.arrays;

import java.util.Scanner;

public class Sort_Array_of_012s {

	public static void main(String[] args) {
		//TookMoreTime();
		usingSwitch();
		

	}

	/**
	 * Your program took more time than expected.Time Limit Exceeded
	 *  Expected Time Limit < 1.044sec
	 * Hint : Please optimize your code and submit again.
	 */
	private static void usingSwitch() {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int j = 0; j < testCases; j++) {
			int arraySize = sc.nextInt();
			int[] array =new int[arraySize];
			for(int i=0;i<arraySize;i++) {
				array[i]= sc.nextInt();
			}
			int high=arraySize-1;
			int low=0;int mid=0;
			while(mid<=high) {
				
				switch(array[mid]) {
				
				case 0:
					swap(array,low,mid);
					low++;mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					swap(array,mid,high);
					high--;
					break;
				}
			}
			for(int i=0;i<arraySize;i++){
				   System.out.print(array[i] + " ");
				}
			
			System.out.println();
		}
	}

	private static void swap(int[] array,int i, int j) {
		
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}

	/**
	 * 
	 * Your program took more time than expected.Time Limit Exceeded
	 * Expected Time Limit < 1.044sec
	 * Hint : Please optimize your code and submit again.
	 */
	private static void TookMoreTime() {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int j = 0; j < testCases; j++) {
			int arraySize = sc.nextInt();
			int[] temp =new int[arraySize];
			for(int i=0;i<arraySize;i++) {
				//array[i]= sc.nextInt();
				temp[sc.nextInt()]++;
			}
			for(int k=0;k<arraySize;k++) {
				int length = temp[k];
				for(int f=0;f<length;f++) {
					System.out.print(k + " ");
				}
			}
			System.out.println();
		}
	}

}
