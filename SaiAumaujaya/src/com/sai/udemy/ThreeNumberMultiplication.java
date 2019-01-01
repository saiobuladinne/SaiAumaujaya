package com.sai.udemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This program, prints only the first occurence, if you want to print all combinations in the array, then loop through hash map we have and print all combinations of the target
 * @author programmer
 *
 */
public class ThreeNumberMultiplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int z = 0; z < testCases; z++) {
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
			Map<Integer,List> hash = new HashMap<Integer,List>();
			
			for(int i=0;i<arraySize;i++) {
				if(target %array[i] !=0) {
					continue;
				}
				for(int j=i+1;j<arraySize-1;j++) {
					List<Integer> ls = new ArrayList<Integer>();
					if(target %array[j] !=0 || target %(array[i]*array[j]) !=0) {
						continue;
					}
					int req = target/(array[i]*array[j]);
					if(!hash.containsKey(req)) {
						ls.add(array[i]);
						ls.add(array[j]);
						hash.put(req, ls);
					}else {
						List list = hash.get(array[j]);
						for(int lst=0;lst<list.size();lst++) {
							System.out.print(list.get(lst)+" ");
						}
						System.out.print(array[j]);
						break;
					}
				}
			}
			System.out.println();
		}
	}

}
