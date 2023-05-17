package chap5_재귀알고리즘;

import java.util.Scanner;

public class recur {
	static void recur(int n) {
//		if (n > 0) {
//			System.out.println("recur("+n+"-1);");
//			recur(n - 1);
//			System.out.println(n);
//			System.out.println("recur("+n+"-2);");
//			recur(n - 2);
//		}
	
			while (n > 0) {
				System.out.println("recur("+n+"-1);");
				recur(n - 1);
				System.out.println(n);
				System.out.println("recur("+n+"-2);");
				//recur(n - 2);
				n = n-2;
			}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력");
		int x = sc.nextInt();
		recur(x);
	}
}
