package com.sai.BinaryTrees;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1Test {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ArrayList<List<Integer>> allLocations = new ArrayList<>();
		allLocations.add(Arrays.asList(1, -3));
		allLocations.add(Arrays.asList(1, 2));
		allLocations.add(Arrays.asList(1, 2));
		System.out.println(solution.ClosestXdestinations(3, allLocations, 2));
	}
	
}