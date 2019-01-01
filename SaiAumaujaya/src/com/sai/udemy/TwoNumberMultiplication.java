package com.sai.udemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoNumberMultiplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int z = 0; z <= testCases; z++) {
			int arraySize = sc.nextInt();
			int target = sc.nextInt();
			if(target==0) {
				System.out.println("Cannot be zero");
				continue;
			}
			int[] array = new int[arraySize];
			for(int p=0;p<arraySize;p++) {
				array[p] = sc.nextInt();
			}
			Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
			
			for(int i=0;i<arraySize;i++) {
				if(array[i]==0 || !(target%array[i]==0)) {
					continue;
				}
				int req = target/array[i];
				if(!hash.containsValue(array[i])) {
					hash.put(i, req);
				}else {
					System.out.println((target/array[i]) + " "+ array[i]);
					//If you want to print the first two then break it or if you want to print all combinations don't break it
					break;
				}
			}
		}
	}

}
