package com.sai.BinaryTrees;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2Test {

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		List<List<Integer>> area = new ArrayList<List<Integer>>();
		List<Integer> sol1 = new ArrayList<Integer>();
		sol1.add(1);
		sol1.add(1);
		sol1.add(1);
		sol1.add(1);
		area.add(sol1);
		
		List<Integer> sol2 = new ArrayList<Integer>();
		sol2.add(0);
		sol2.add(1);
		sol2.add(1);
		sol2.add(1);
		area.add(sol2);
		
		List<Integer> sol3 = new ArrayList<Integer>();
		sol3.add(0);
		sol3.add(1);
		sol3.add(0);
		sol3.add(1);
		area.add(sol3);

		List<Integer> sol4 = new ArrayList<Integer>();
		sol4.add(1);
		sol4.add(1);
		sol4.add(9);
		sol4.add(1);
		area.add(sol4);

		List<Integer> sol5 = new ArrayList<Integer>();
		sol5.add(0);
		sol5.add(0);
		sol5.add(1);
		sol5.add(1);
		area.add(sol5);
		
		int minimumDistance = solution.minimumDistance(5, 4, area);
		
		System.out.println(minimumDistance);
	}
	
}