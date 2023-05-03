package chap2_기본자료구조;

import java.util.Random;

public class 행렬곱 {
	static void getMatrix(int[][] data) {
		// 난수 생성하여 배열에 입력
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = rand.nextInt(20);
			}

			

		}

	}
	
	static void showMatrix(int[][] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void showMatrixSum(int[][] a,int[][] b) {
		
	}
	

	public static void main(String[] args) {
		int[][] m1 = new int[2][3];
		
		getMatrix(m1);
		showMatrix(m1);
		
	}

}
