package com.sai.codility;

import java.util.Scanner;

public class RotateArrayByKtimes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println(42%5);
        int testCases=sc.nextInt();
        for(int i=0;i<testCases;i++){
        	int arraySize=sc.nextInt();
        	int[] array=new int[arraySize];
        	for(int f=0;f<arraySize;f++){
        		array[f] = sc.nextInt();
            }
        	rotateArray(array,42);
        }	
	}

	
	
	public static int[] rotateArray(int[] A, int K) {
		//iF k NODES can be divided by N size then no rotation needed
		//for example n=5, k=5, after 5 rotations array will be same.. k%N = 0, then no rotations required
		//or else remainder will be the K, then only new K rotations required, thats the logic behind
		if(A.length==0) {
			return A;
		}
		int[] B=new int[A.length];
		if(K>=A.length) {
			if(K%A.length==0) {
				return A;
			}
			else {
				K = K%A.length;
			}
		}
			int l = A[A.length-(A.length-K)];
			int i = 0;
				for(int j=A.length-K;j<A.length;j++) {
					B[i]=A[j];
					i++;
				}
				for(int z=0;z<A.length-K;z++) {
					B[i]=A[z];
					i++;
				}
		return B;
    }
}
