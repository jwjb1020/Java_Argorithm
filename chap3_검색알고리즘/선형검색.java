package chap3_검색알고리즘;

import java.util.Scanner;

public class 선형검색 {
	class SeqSearch {
		static int seqSerch(int[] a, int n ,int key ) {
			int i =0;
			
			while(true) {
				if (i == n)
					return -1;
				if (a[i] == key)
					return i;
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[] x = new int[num];

	}

}
