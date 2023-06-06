package chap06_정렬알고리즘;

import java.util.Random;

public class bubbleSort {
	// a배열에 있는 idx1번째 값과 idx2번째 값을 바꿈
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;

	}

	// 이웃한 두 요소의 대소관계 비교해서 교환 반복(단순 교환)
	static void bubbleSort(int[] a, int n) { // 파라미터로 받는 값 배열, 배열의 크기

		int k = 0;

		while (k < (n - 1)) { // n-1을 하는 이유 : 한번이라도 돌면 마지막 값이 제일 크게 됨 swap을 썻기 때문에
			int last = n - 1; // 마지막 요소 값
			for (int j = n - 1; j > k; j--) { // 마지막 배열에서

				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					last = j;
				}
			}
			k = last;

		}
	}

	static void selectionSort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
				swap(a, i, min);

			}

		}
	}

	static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int j;
			int tmp = a[i];
			for (j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;

		}

	}

	static void shellSort(int[] a, int n) {
		for (int h = n / 2; h > 0; h /= 2) {
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
				}
				a[j + h] = tmp;
			}

		}
	}

	public static void main(String[] args) {

		// 버블 정렬(버전1) -난수를 사용해서 100의 값이 있는 배열 만들기
		Random random = new Random();
		int nx = 5;
		int[] x = new int[nx];
		for (int i = 0; i < nx; i++) {
			x[i] = random.nextInt(10);
		}

		for (int i = 0; i < nx; i++) {
			System.out.print("arr[" + i + "] :" + x[i] + " ");

		}
		System.out.println();
		//bubbleSort(x, nx);
		 //insertionSort(x, nx);
		 selectionSort(x, nx);
		// shellSort(x, nx);
		System.out.println("오름차순으로 정리했습니다.");
		// a[idx1]과 a[idx2]값을 교환
		for (int i = 0; i < nx; i++) {
			System.out.print("arr[" + i + "] :" + x[i] + " ");

		}
		//

	}
}