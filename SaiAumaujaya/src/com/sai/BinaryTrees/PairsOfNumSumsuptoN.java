
package com.sai.BinaryTrees;

import java.util.Arrays;
import java.util.HashSet;

public class PairsOfNumSumsuptoN {
	public static void main(String[] args) {
		int sum=8;
		int[] result = {0,0,0,0};
		//boolean array = checkIfExistsOofN2(result,sum);
		//boolean ex = checkIfExistsNlogN(result,sum);
		boolean compliment = checkIfExistsUsingCompliment(result,sum);
		System.out.println(compliment);
	}
	
	/**
	 * o(n) complexity by using compliments saving into separate hashset
	 * [1,2,3,4] 7,6,5 - compliments saving into separate hashset
	 * @param result
	 * @param sum
	 * @return
	 */
	private static boolean checkIfExistsUsingCompliment(int[] result, int sum) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<result.length-1;i++) {
			if(set.contains(result[i])) {
				return true;
			}
			else {
				set.add(sum-result[i]); //compliments adding to set
			}
		}
		
		return false;
	}
	
	/**
	 * o(nlogn) complexity by using high and low ends
	 * [1,2,3,4] 1-will be low.. 4 will be high.. 1 move towards middle if sum of (1 and 4) is less.. than result sum and 4 move towards middle if sum of(1,4) is grater than result sum
	 * @param result
	 * @param sum
	 * @return
	 */
	private static boolean checkIfExistsNlogN(int[] result, int sum) {
		
		int low=0;
		int high = result.length-1;
		//this case all numbers have to be sorted.
		Arrays.sort(result); //log n
		
		while(true) {  // n
			if(low==high) {
				return false;
			}
			if(result[low]+result[high]== sum) {
				return true;
			}else if(result[low]+result[high] < sum){
				low++;
			}else if(result[low]+result[high] > sum){
				high--;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * o(n)*2 complexity by using two loops
	 * @param result
	 * @param sum
	 * @return
	 */
	private static boolean checkIfExistsOofN2(int[] result, int sum) {
		
		for(int i=0;i<result.length-1;i++) {
			for(int j=i+1;j<result.length-1;j++) {
				if(result[j]+result[i] == sum) {
					return true;
				}
			}
		}
		return false;
	}

}
