package com.sai.ideserve.arrays;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Majority element is which occurs more then the n/2 times in an array where n is the size of the array
 * @author programmer
 *
 */
public class Majority_Element {
	private static PrintWriter out;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(new BufferedOutputStream(System.out));
		while (!sc.hasNext()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int testCases = sc.nextInt();
		for (int i = 0; i < testCases; i++) {
			int[] array = new int[sc.nextInt()];
			for (int j = 0; j < array.length; j++) {
				array[j] = sc.nextInt();
			}
			Integer solutions = getMajorityElement(array);
			System.out.println(solutions);
		}
	}
	//1st approach using a hashmap: save the count of each and every number in an array and give the element which occurs more than n/2 time
	//Above approach time and space: o(n)
	//2nd Appraoch using boer's moore algorithm where you use count and element, check below code for that
	private static Integer getMajorityElement(int[] array) {
		
		int count=0;
		int element=0;
		for(int i=0;i<array.length;i++) {
			if(count==0) {
				element=array[i];
				count=1;
				continue;
			}else {
				if(element==array[i]) {
					
					count++;
				}else {
					count--;
				}
			}
		}
		if(count==0) {
			return (Integer) null;
		}
		for(int j=0;j<array.length;j++) {
			if(element==array[j]) {
				count++;
			}
		}
		if(count>(array.length)/2) {
			return element;
		}
		
		return null;
	}

}
