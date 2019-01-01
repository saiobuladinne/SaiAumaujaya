package com.sai.geeksforgeeks.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Common_Elements_Array {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int z = 0; z < testCases; z++) {
			int n1 = sc.nextInt();
			int[] arrayN1 =new int[n1];
			int n2 = sc.nextInt();
			int[] arrayN2 =new int[n2];
			int n3 = sc.nextInt();
			int[] arrayN3 =new int[n3];
			for(int a=0;a<n1;a++){
				arrayN1[a] = sc.nextInt();
			}
			for(int b=0;b<n2;b++){
				arrayN2[b] = sc.nextInt();
			}
			for(int c=0;c<n3;c++){
				arrayN3[c] = sc.nextInt();
			}
			List<Integer> commonList = new ArrayList<Integer>();
			int currentPointer=0;
			int[] commonElements = getCommon(n1, arrayN1, n2, arrayN2, currentPointer,commonList);
			int currentPointer1=0;
			int[] commonElements1 = getCommon(n1, commonElements, n3, arrayN3, currentPointer1,commonList);
			
			int count=0;
			for(int i=0;i<commonElements1.length;i++){
				if(commonElements1[i]!=0){
					count++;
					System.out.print(commonElements1[i]+" ");
				}
			}
			if(commonList.isEmpty()){
				System.out.println("-1");
			}
		}
	}

	private static int[] getCommon(int n1, int[] arrayN1, int n2, int[] arrayN2, int currentPointer, List<Integer> commonList) {
		int[] commonElements= new int[n1];
		for(int i=0;i<n1;i++){
			for(int j=currentPointer;j<n2;j++){
				if(arrayN1[i] == arrayN2[j]){
					commonElements[i] = arrayN1[i];
					commonList.add(arrayN1[i]);
					currentPointer++;
					break;
				}else if(arrayN1[i] < arrayN2[j]){
					//currentPointer++;
					break;
				}
				currentPointer++;
			}
		}
		return commonElements;
	}

}

