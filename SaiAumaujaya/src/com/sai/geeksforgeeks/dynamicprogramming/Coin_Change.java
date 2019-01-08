package com.sai.geeksforgeeks.dynamicprogramming;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coin_Change {
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
			int cents = sc.nextInt();
			int solutions = getCombinations(array, cents);
			System.out.println(solutions);
		}
	}

	private static int getCombinations(int[] coin, int cents) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// arrayComb[0]
		map.put(0, 1);
		for (int j = 1; j <= cents; j++) {
			map.put(j, 0);
		}
		for (int i = 0; i < coin.length; i++) {
			for (int k = 0; k <= cents; k++) {

				if (k >= coin[i]) {
					int count = map.get(k) + map.get(k - coin[i]);
					map.put(k, count);

				}
			}
		}
		return map.get(cents);
	}

}
