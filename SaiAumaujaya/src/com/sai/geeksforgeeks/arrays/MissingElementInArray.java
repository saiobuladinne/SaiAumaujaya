package com.sai.geeksforgeeks.arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MissingElementInArray {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int testCases=sc.nextInt();
        for(int i=0;i<testCases;i++){
        	int arraySize=sc.nextInt();
        	int[] array=new int[arraySize];
        	for(int f=0;f<arraySize-1;f++){
        		array[f] = sc.nextInt();
            }
        	int x1 = array[0];
        	int x2=1;
        	for(int j=1;j<arraySize;j++){
        		x1 = x1 ^ array[j];
            }
        	for(int k=2;k<arraySize+1;k++){
        		x2 = x2 ^ k;
            }
        	int missing_element = x1 ^ x2; 
        	System.out.println(missing_element);
        }
		
	
	}
	/*
	//This could be a overflow because of int.. use XOR for this kind 
	public static void main (String[] args) {
    	Scanner sc = new Scanner(System.in);
        int testCases=sc.nextInt();
        for(int i=0;i<testCases;i++){
            int arraySize=sc.nextInt();
            int actualSum = 0;
            for(int j=0;j<arraySize-1;j++){
                actualSum = actualSum + sc.nextInt();
            }
            int overAllSum = (arraySize*(arraySize+1))/2;
            int missingElement = overAllSum-actualSum;
            System.out.println(missingElement);
        }    
	}
	*/
}
