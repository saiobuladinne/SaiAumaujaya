package com.sai.udemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Frequently_Occured_InArray {

	public static void main(String[] args) {

		MoreTimeTaking();	
	}
	
	private static void MoreTimeTaking() {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int z = 0; z < testCases; z++) {
			int arraySize = sc.nextInt();
			int k = sc.nextInt();
			int[] array = new int[arraySize];
			for(int arr=0;arr<arraySize;arr++) {
				array[arr]=sc.nextInt();
			}
			Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
			int maxCount=0;
			for(int i=0;i<arraySize;i++) {
				if(hash.containsKey(array[i])) {
					Integer integer = hash.get(array[i]);
					hash.put(array[i], integer+1);
					maxCount = Math.max(maxCount, integer+1);
				}else {
					hash.put(array[i], 1);
				}
			}
			for (Entry<Integer, Integer> entry : hash.entrySet()) {
	            if (entry.getValue().equals(maxCount)) {
	                System.out.println(entry.getKey());
	                break;
	            }
	        }
		}
	}

}
