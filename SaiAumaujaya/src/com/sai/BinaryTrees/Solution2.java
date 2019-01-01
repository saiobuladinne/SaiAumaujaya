package com.sai.BinaryTrees;import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
		if (numRows < 1 || numRows > 1000 || numColumns < 1 || numColumns > 1000 || area.size() != numRows) {
			return -1;
		}

		try {
			ArrayList<ArrayList<Integer>> visited = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> point = new ArrayList<Integer>();
			point.add(0);
			point.add(0);
			visited.add(point);
			return getMinDistance(point, area, numRows, numColumns, visited)-1;
		} catch (Exception exception) {
			return -1;
		}
	}

	private int getMinDistance(ArrayList<Integer> point, List<List<Integer>> area, int numRows, int numColumns,
			ArrayList<ArrayList<Integer>> visited) throws Exception {
		if (point.get(0) < 0 || point.get(0) >= numRows || point.get(1) < 0 || point.get(1) >= numColumns) {
			return -1;
		}

		if (area.get(point.get(0)).get(point.get(1)) == 9) {
			return 1;
		} else if (area.get(point.get(0)).get(point.get(1)) == 0) {
			return 0;
		} else if (area.get(point.get(0)).get(point.get(1)) != 1) {
			throw new Exception("Invalid value");
		}

		int top = 0;
		int right = 0;
		int bottom = 0;
		int left = 0;

		ArrayList<Integer> topPoint = new ArrayList<Integer>();
		topPoint.add(point.get(0) - 1);
		topPoint.add(point.get(1));

		if (!visited.contains(topPoint)) {
			ArrayList<ArrayList<Integer>> topVisited = new ArrayList<ArrayList<Integer>>(visited);
			topVisited.add(topPoint);
			top = getMinDistance(topPoint, area, numRows, numColumns, topVisited);
		}

		ArrayList<Integer> rightPoint = new ArrayList<Integer>();
		rightPoint.add(point.get(0));
		rightPoint.add(point.get(1) + 1);

		if (!visited.contains(rightPoint)) {
			ArrayList<ArrayList<Integer>> rightVisited = new ArrayList<ArrayList<Integer>>(visited);
			rightVisited.add(rightPoint);
			right = getMinDistance(rightPoint, area, numRows, numColumns, rightVisited);
		}

		ArrayList<Integer> bottomPoint = new ArrayList<Integer>();
		bottomPoint.add(point.get(0) + 1);
		bottomPoint.add(point.get(1));

		if (!visited.contains(bottomPoint)) {
			ArrayList<ArrayList<Integer>> bottomVisited = new ArrayList<ArrayList<Integer>>(visited);
			bottomVisited.add(bottomPoint);
			bottom = getMinDistance(bottomPoint, area, numRows, numColumns, bottomVisited);
		}

		ArrayList<Integer> leftPoint = new ArrayList<Integer>();
		leftPoint.add(point.get(0));
		leftPoint.add(point.get(1) - 1);

		if (!visited.contains(leftPoint)) {
			ArrayList<ArrayList<Integer>> leftVisited = new ArrayList<ArrayList<Integer>>(visited);
			leftVisited.add(leftPoint);
			left = getMinDistance(leftPoint, area, numRows, numColumns, leftVisited);
		}

		return getMin(top, right, bottom, left) + 1;
	}

	private int getMin(int... values) {
		int min = -1;
		for (int i : values) {
			if (i != 0 && i != -1 && (min == -1 || i < min)) {
				min = i;
			}
		}

		return min;
	}
}