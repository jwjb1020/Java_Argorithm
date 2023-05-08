package chap3_검색알고리즘;

import java.util.Arrays;

public class 스트링배열이진탐색 {

	static void showData(String[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");

		}
	}

	static void sortData(String[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i].compareTo(data[j]) < 0) {
					String temp = data[i];
					data[i] = data[j];
					data[j] = temp;

				}

			}

		}
	}

	static int linearSearch(String[] data, String key) {
		int answer = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].compareTo(key) == 0) {
				answer = i;
			}

		}
		return answer;

	}

	static int binarySearch(String [] data, String key) {
		int pl = 0;
		int pr = data.length-1;
		
		do {
			int pc = (pl + pr)/2;
			if (data[pc].compareTo(key) == 0) {
				return pc;
				
			}else if (data[pc].compareTo(key) < 0 ) {
				pl = pc+1;
					
				}
			else {pr = pc -1;}
				
		} while(pl<=pr); 
			return -1;
		
		
	}

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "감", "배", "사과", "포도", "pear", "blueberry", "strawberry",
				"melon", "oriental melon" };

		showData(data);
		System.out.println("\n" + "-".repeat(30));
		sortData(data);
		showData(data);

		String key = "감";
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = "배";
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);

	}

}
