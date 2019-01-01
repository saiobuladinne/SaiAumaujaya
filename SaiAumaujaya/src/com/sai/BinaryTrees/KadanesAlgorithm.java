package com.sai.BinaryTrees;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class KadanesAlgorithm {
	private static PrintWriter out;

	public static void main(String[] args) {
		// code
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(new BufferedOutputStream(System.out));
		while (!sc.hasNext()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int arraySize = sc.nextInt();
			int[] array = new int[arraySize];
			List<Integer> tempList = new ArrayList<Integer>();
			HashMap<Integer, List<Integer>> tempMap = new HashMap<Integer, List<Integer>>();
			int maxSum = 0;
			int curSum = 0;

			for (int j = 0; j < arraySize; j++) {
				array[j] = sc.nextInt();
			}
			// [1,2,-1,3,2,6] //[23 23 -98 5]
			for (int k = 0; k < arraySize; k++) {
				if (k == 0) {
					maxSum = maxSum + array[k];
					tempList.add(array[k]);
					continue;
				}
				if (array[k] < 0) {
					int ultimateSum=0;
					for(int l=0;l<tempList.size();l++) {
						ultimateSum = ultimateSum + tempList.get(l);
					}
					maxSum = ultimateSum;
				}
				curSum = maxSum + array[k];
				if (curSum >= maxSum) {
					tempList.add(array[k]);
					maxSum = curSum;
					if (k == arraySize - 1) {
						if (tempMap.isEmpty()) {
							// tempMap.clear();
							tempMap.put(maxSum, tempList);
							tempList = new ArrayList<Integer>();
							maxSum = 0;
							continue;
						}
						Iterator<Entry<Integer, List<Integer>>> iterator = tempMap.entrySet().iterator();
						while (iterator.hasNext()) {
							Integer key = iterator.next().getKey();
							if (key != null && maxSum > key) {
								tempMap.clear();
								tempMap.put(maxSum, tempList);
								tempList = new ArrayList<Integer>();
								maxSum = 0;
							}
						}
					}
				} else {
					if (tempMap.isEmpty()) {
						// tempMap.clear();
						tempMap.put(maxSum, tempList);
						tempList = new ArrayList<Integer>();
						maxSum = 0;
						continue;
					}
					Iterator<Entry<Integer, List<Integer>>> iterator = tempMap.entrySet().iterator();
					while (iterator.hasNext()) {
						Integer key = iterator.next().getKey();
						if (key != null && maxSum > key) {
							tempMap.clear();
							tempMap.put(maxSum, tempList);
							tempList = new ArrayList<Integer>();
							maxSum = 0;
						}
					}
				}
				// tempMap.put(maxSum, tempList);
			}
			//out.print(tempMap.entrySet().iterator().next().getKey());
			System.out.println(tempMap.entrySet().iterator().next().getKey());
		}
		sc.close();

	}
}
