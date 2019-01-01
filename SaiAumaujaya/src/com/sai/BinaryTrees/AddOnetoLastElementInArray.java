package com.sai.BinaryTrees;

public class AddOnetoLastElementInArray {

	public static void main(String[] args) {

		int[] result = {9,9,9,9};
		int[] array = getArray(result);
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	
	public static int[] getArray(int[] a) {
		int carry=1;
		if(a.length>1) {
			int total=0;
			int[] result = new int[a.length];
			for(int i=a.length-1;i>=0;i--) {
				total = a[i]+carry;
				if(total ==10) {
					carry=1;
					result[i] = 0;
				}else {
					carry=0;
					result[i] = total %10;
				}
			}
			if(carry==1) {
				result = new int[a.length+1];
				result[0]=1;
				return result;
			}
			
			return result;
		}
		
		return a;
	}

}
