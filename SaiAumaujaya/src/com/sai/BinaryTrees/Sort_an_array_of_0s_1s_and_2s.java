package com.sai.BinaryTrees;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sort_an_array_of_0s_1s_and_2s {

	static class MyScanner{
		BufferedReader br;
		StringTokenizer st;

		MyScanner(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nn(){
			while(st == null || !st.hasMoreElements()){
				try{
					st = new StringTokenizer(br.readLine());
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int ni(){
			return Integer.parseInt(nn());
		}

		long nl(){
			return Long.parseLong(nn());
		}

		double nd(){
			return Double.parseDouble(nn());
		}
	}
	
	private static PrintWriter out;
	
	public static void main(String[] args) {
		
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		
		int t = sc.ni();
		
		while(t-- > 0) {
			int lengthOfArrayInput = sc.ni();
			int[] arrayOutput = new int[3];
	
			for (int i = 0; i < lengthOfArrayInput; i++) {
				arrayOutput[sc.ni()]++;
			}
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < arrayOutput[i]; j++){
					out.print(i + " ");
				}
				out.println();
			}
			out.close();
			
		}
	}
}
