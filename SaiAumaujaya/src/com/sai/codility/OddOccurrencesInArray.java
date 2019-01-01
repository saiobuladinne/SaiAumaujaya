package com.sai.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OddOccurrencesInArray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        int testCases=sc.nextInt();
        for(int i=0;i<testCases;i++){
        	int arraySize=sc.nextInt();
        	int[] array=new int[arraySize];
        	for(int f=0;f<arraySize;f++){
        		array[f] = sc.nextInt();
            }
        	OddOccurrences(array);
        }	
	}

	private static int OddOccurrences(int[] array) {
		if(array.length==0) {
			return 0;
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<array.length;i++) {
			
			if(map.get(array[i])!=null) {
				map.remove(array[i]);
			}else {
				map.put(array[i], i);
			}
				
		}
		return map.keySet().iterator().next().intValue();
		
	}

}
