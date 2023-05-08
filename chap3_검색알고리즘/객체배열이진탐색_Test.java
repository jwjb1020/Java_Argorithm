package chap3_검색알고리즘;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData() {

	}

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override

	public String toString() {
		return this.name + " " + this.height + " cm " + this.vision;
	}

	public int compareTo(PhyscData data) {
		if (this.name.compareTo(data.name) == 0) {
			if (this.height == data.height) {
				if (this.vision == data.vision) {

					return 0;
				} else if (this.vision < data.vision) {
					return -1;
				} else {
					return 1;
				}

			} else if (this.height > data.height) {
				return -1;
			} else {
				return 1;
			}

		} else if (this.name.compareTo(data.name) < 0) {
			return -1;
		} else {
			return 1;
		}

	}

}

public class 객체배열이진탐색_Test {
	static void showData(PhyscData[] arr) {

		for (PhyscData fruit : arr) {
			System.out.print(fruit.toString() + " ");
			System.out.println();
		}
		System.out.println();
	}

	static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i].compareTo(data[j]) < 0) {
					PhyscData t = data[i];
					data[i] = data[j];
					data[j] = t;

				}
			}
		}

	}

	private static int linearSearch(PhyscData[] data, PhyscData key) {
		
		for (int i = 0; i < data.length; i++) {
			if (data[i].compareTo(key) == 0) {
				return i;
			}

		}
		return -1;

		
	}
	private static int binarySearch(PhyscData[] data, PhyscData key) {
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
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), new PhyscData("김홍길동", 172, 0.3), new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2), new PhyscData("길동", 167, 0.5), };
		showData(data);
		sortData(data);
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);

		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
	}


}
