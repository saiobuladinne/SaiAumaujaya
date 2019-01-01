package com.sai.geeksforgeeks.string;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Java_Primality_Test {

	 private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        String n = scanner.nextLine();
	        BigDecimal bd = new BigDecimal(n);
	        
	        BigInteger a = new BigInteger(n);
	        boolean probablePrime = a.isProbablePrime(1);
	        if(probablePrime){
	            System.out.println("prime");
	        }else{
	            System.out.println("not prime");
	        }
	        scanner.close();
	    }

}
