package com.sai.BinaryTrees;

import java.util.Arrays;
import java.util.HashSet;

public class PairsDifferencesEqualToSum {
	public static void main(String[] args) {
		int diff=2;
		int[] result = {1,5,3,4,2};
		boolean compliment = checkIfExistsUsingCompliment(result,diff);
		int count = returnCount(result,diff);
		System.out.println(count);
	}

	/**
	 * o(n) complexity by adding +1 to the result and then saving into separate hashset
	 * [1,2,3,4] 2,3,4 -  saving into separate hashset, check if it exists in hashset before you add it to hashset
	 * @param result
	 * @param sum
	 * @return
	 */
	private static int returnCount(int[] result, int diff) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		Arrays.sort(result);
		int count=0;
		for(int i=0;i<result.length;i++) {
			if(set.contains(result[i])) {
				count++;
				set.add(result[i]+diff); 
			}
			else {
				set.add(result[i]+diff); //compliments adding to set
			}
		}
		
		return count;
	}
	
	/**
	 * o(n) complexity by adding +1 to the result and then saving into separate hashset
	 * [1,2,3,4] 2,3,4 -  saving into separate hashset, check if it exists in hashset before you add it to hashset
	 * @param result
	 * @param sum
	 * @return
	 */
	private static boolean checkIfExistsUsingCompliment(int[] result, int diff) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<result.length-1;i++) {
			if(set.contains(result[i])) {
				set.add(result[i]+diff);												
				return true;
			}
			else {
				set.add(result[i]+diff); //compliments adding to set
			}
		}
		
		return false;
	}
}
