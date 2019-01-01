package com.sai.geeksforgeeks.string;

public class Test2 {

	public static void main(String[] args) {

		for(int i=1;i<=100;i++) {
			if(i%3 ==0 && i%4==0) { //3rd If condition
				System.out.println("C");
			}else if(i%3==0) {   //1rd If condition
				System.out.println("A");
			}else if(i%4==0) {//2rd If condition
				System.out.println("B");
			}else { //Last one
				System.out.println(i);
			}
			
		}
	}

}
