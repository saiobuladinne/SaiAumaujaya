package com.sai.codility;

import java.util.Arrays;
import java.util.Scanner;

public class FindMissingElement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        int testCases=sc.nextInt();
        for(int i=0;i<testCases;i++){
        	int arraySize=sc.nextInt();
        	int[] array=new int[arraySize];
        	for(int f=0;f<arraySize;f++){
        		array[f] = sc.nextInt();
            }
        	int findMissingElement = findMissingElement(array);
        	System.out.println(findMissingElement);
        }	
	}

	/**
	 * This is using XOR, but need a new array with +1 size then XOR will work
	 * @param array
	 * @return
	 */
	private static int findMissingElement(int[] array) {
        int[] copyOf = Arrays.copyOf(array, array.length+1);
        
      int x1 = copyOf[0];
    	int x2=1;
    	for(int j=1;j<copyOf.length;j++){
    		x1 = x1 ^ copyOf[j];
        }
    	for(int k=2;k<copyOf.length+1;k++){
    		x2 = x2 ^ k;
        }
    	int missing_element = x1 ^ x2;
		return missing_element;
	}

	
	
	/*
	 * 80% tests are passed, so will try to use the bit operatins now to find the number
	 * private static int findMissingElement(int[] array) {

		if(array==null || array.length<=0) {
			return 1;
		}
		int x = array.length+1;
		int n= x*(1+x)/2;
		int sum=0;
		for(int i=0;i<array.length;i++) {
			sum=sum+array[i];
		}
		System.out.println(n-sum);
		if(n<sum) {
			return 1;
		}
		return n-sum;
	}*/

}
