package Chap5_Recursive;

import java.util.Scanner;

public class Factorial {
	static int factorial(int n) {
		if(n>0)
			return n *factorial(n-1);
		else return 1;
		
		//=> 삼항 연사자로 바꾸면
		//return (n>0) ? n*factorial(n-1) : 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력");
		int x = sc.nextInt();
		int result = factorial(x);
		System.out.println(x + "의 factorial 값:" + result);
		
	}

}
