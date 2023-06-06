package chap06_정렬알고리즘;

import java.util.Random;

public class quickSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;

	}

	static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr) / 2];

		do {
			while (a[pl] < x) {
				pl++;
			}
			while (a[pr] > x) {
				pr--;
			}
			if (pl <= pr) {
				swap(a, pl++, pr--);
			}

		} while (pl <= pr);

		if (left < pr) {
			quickSort(a, left, pr);
		}
		if (pl < right) {
			quickSort(a, pl, right);
		}
<<<<<<< HEAD

	}

	static void quickSortStack(int[] a, int left, int right) {
		IntStack lstack = new IntStack(right - left + 1);
		IntStack rstack = new IntStack(right - left + 1);

		lstack.push(p);
		rstack.push(right);

		while (lstack.isEmpty() != true) {
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int x = a[(left + right) / 2];

			do {
				while (a[pl] < x)
					pl++;
				while (a[pr > x])
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);

			if (left < pr) {
				lstack.push(left);
				rstack.push(pr);
			}
			if (pl < right) {
				lstack.push(pl);
				rstack.push(right);
			}
		}
	}
=======
	}
	
>>>>>>> e63065840459de02bec194e5345d359079dacbbc

	public static void main(String[] args) {
		Random random = new Random();
		int nx = 5;
		int[] x = new int[nx];
<<<<<<< HEAD
		// 재귀방법으로 풀기
=======
>>>>>>> e63065840459de02bec194e5345d359079dacbbc
		for (int i = 0; i < nx; i++) {
			x[i] = random.nextInt(10);
		}

		for (int i = 0; i < nx; i++) {
			System.out.print("arr[" + i + "] :" + x[i] + " ");

		}
		System.out.println();
		quickSort(x, 0, nx - 1);

		for (int i = 0; i < nx; i++) {
			System.out.print("arr[" + i + "] :" + x[i] + " ");

		}

<<<<<<< HEAD
		// 스택을 이용해 비재귀적인 방법으로 풀기

=======
>>>>>>> e63065840459de02bec194e5345d359079dacbbc
	}

}
