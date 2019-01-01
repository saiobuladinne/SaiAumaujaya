package com.sai.geeksforgeeks.arrays;

import java.util.Scanner;

public class Equilibrium_Point {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int j = 0; j < testCases; j++) {
			int arraySize = sc.nextInt();
			int[] array =new int[arraySize];
			for(int i=0;i<arraySize;i++) {
				array[i]= sc.nextInt();
			}
			
			int i=0;
			int n=arraySize-1;
			int startSum=array[i];
			int endSum = array[n];
			int counter=0;
			if(arraySize==1){
			    System.out.println(1);
			    continue;
			}
			if(arraySize==2) {
				System.out.println(-1);
				continue;
			}
			while(n!=2) {
				counter++;
				if(startSum==endSum && counter ==arraySize) {
					System.out.println(i+1);
					break;
				}
				else {
					if(startSum<endSum) {
						startSum = startSum+array[i+1];
						i++;
					}else {
						endSum = endSum+array[n-1];
						n--;
					}
				}
			}
			if(n==2) {
				System.out.println(-1);
			}
		}

	}

}
