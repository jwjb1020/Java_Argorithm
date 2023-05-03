package chap2_기본자료구조;

import java.util.Random;

public class 메소드배열전달 {
	static void getData(int[] data) {
		// 난수 생성하여 배열에 입력
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {

			data[i] = rand.nextInt(20);

		}

	}

	static void showData(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");

		}
		// 출력
	}

	static int findMax(int[] data) {
		int max = data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}

		}
		return max;

	}

	static void sortData(int[] data) {

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {

				if (data[i] < data[j]) {
					int t = data[i];
					data[i] = data[j];
					data[j] = t;

				}
			}

		}

	}
	
	

	public static void main(String[] args) {
		int[] data = new int[10];
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println("\nmax = " + mvalue);
		sortData(data);
		System.out.println("\n정렬 후 결과");
		showData(data);
	
	}

}
