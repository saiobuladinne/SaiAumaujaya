package com.sai.BinaryTrees;

public class QuickSortLog {
	int partition(String arr[], int low, int high) {
		String pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (isLessThan(arr[j], pivot)) {
				i++;

				String temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		String temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	void sort(String arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);

			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	static void printArray(String arr[]) {
		int n = arr.length;

		for (int i = 0; i < n; ++i) {
			System.out.println(arr[i] + " ");
		}
	}

	public static void main(String args[]) {
		String s1 = "a1 9 2 3 1";
		String s2 = "g1 act car";
		String s3 = "zo4 4 7";
		String s4 = "ab1 off key dog";
		String s5 = "a8 act zoo";
		String s6 = "a3 act zoo";

		System.out.println(isLessThan(s1, s3));

		String arr[] = { s1, s2, s3, s4, s5, s6 };
		int n = arr.length;

		QuickSortLog ob = new QuickSortLog();
		ob.sort(arr, 0, n - 1);

		System.out.println("\n\n\nsorted array");
		printArray(arr);
	}

	public static boolean isLessThan(String string1, String string2) {
		int key1EndIndex = -1;
		int key2EndIndex = -1;

		int minLength = string1.length() < string2.length() ? string1.length() : string2.length();

		System.out.println(string1 + ", " + string2);

		for (int i = 0; (key1EndIndex == -1 || key2EndIndex == -1) && i < minLength; i++) {
			if (key1EndIndex == -1 && string1.charAt(i) == ' ') {
				key1EndIndex = i;
			}
			if (key2EndIndex == -1 && string2.charAt(i) == ' ') {
				key2EndIndex = i;
			}
		}
		int index1 = key1EndIndex + 1;
		int index2 = key2EndIndex + 1;

		System.out.println(index1 + ", " + index2);

		if (key1EndIndex == -1 && key2EndIndex == -1) {
			System.out.println("return1");
			return string1.compareTo(string2) < 0;
		} else if (key1EndIndex == -1) {
			System.out.println("return2");
			return true;
		} else if (key2EndIndex == -1) {
			System.out.println("return3");
			return false;
		} else if (string1.charAt(index1) - '9' <= 0 && string2.charAt(index2) - '9' <= 0) {
			return false;
		} else if (string2.charAt(index2) - '9' <= 0) {
			System.out.println("return4");
			return true;
		} else if (string1.charAt(index1) - '9' <= 0) {
			System.out.println("return5");
			return false;
		} else {
			while (index1 < string1.length() && index2 < string2.length()) {
				if (string1.charAt(index1) == string2.charAt(index2)) {
					index1++;
					index2++;
					continue;
				} else if (string1.charAt(index1) == ' ') {
					System.out.println("return6");
					return true;
				} else if (string2.charAt(index2) == ' ') {
					System.out.println("return7");
					return false;
				} else {
					System.out.println("return8");
					return string1.charAt(index1) < string2.charAt(index2);
				}
			}

			System.out.println("return9");
			int nonKeySize1 = string1.length() - key1EndIndex;
			int nonKeySize2 = string2.length() - key2EndIndex;

			if (nonKeySize1 < nonKeySize2) {
				return true;
			} else if (nonKeySize1 > nonKeySize2) {
				return false;
			} else {
				return string1.substring(0, key1EndIndex).compareTo(string2.substring(0, key2EndIndex)) < 0;
			}
		}
	}
}