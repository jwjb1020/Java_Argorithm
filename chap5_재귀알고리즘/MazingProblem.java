package chap5_재귀알고리즘;

import java.util.ArrayList;
import java.util.List;

enum Directions {N, NE, E, SE, S, SW, W, NW}
class Items {
	
	int x;
	int y;
	int dir;
	public Items(int x, int y, int dir) {
		
	}
}
class Offsets {
	int a;
	int b;

}
class StackList{
	private List<Integer> arr;
	private int top;
	
	public StackList(){
		arr = new ArrayList<>();
		top = 0;
		
	}
	
	public void push() {
		arr.add(top);
		top++;
	}
	public int pop() {
		if(arr.isEmpty()) {
			return 0;
		}
		top--;
		return arr.remove(top);
		
	}

	public boolean isEmpty() {
		if(top== 0) {
			return false;
		} else return true;
		
		
	}
	
	
	
}
public class MazingProblem {

	static Offsets[] moves = new Offsets[8];//static을 선언하는 이유를 알아야 한다

//	public static void path(int[][] maze, int[][] mark, int ix, int iy) {
//		//백트래킹 초기값
//		mark[0][0] = 1;
//		StackList st = new StackList();
//		Items temp = new Items(0, 0, 0);
//		//초기값 설정 (입구)
//		temp.x = 1;
//		temp.y = 1;
//		temp.dir = 2;
//		mark[temp.x][temp.y] = 2;//미로 찾기 궤적은 2로 표시
//		st.push(temp);
//
//		while (!st.isEmpty()) // stack not empty
//		{
//			Items tmp = st.pop(); // unstack
//			int i = tmp.x;
//			int j = tmp.y;
//			int d = tmp.dir;
//			mark[i][j] = 1;//backtracking 궤적은 1로 표시
//			while (d < 8) // moves forward
//			{
//
//				if ((g == ix) && (h == iy)) { // reached exit
//												// output path
//
//				}
//				if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
//					
//
//				} 
//				
//			}
//		}
//		System.out.println("no path in maze ");
//	}

	public static void main(String[] args) {
		int[][] maze = new int[12][15];
		int[][] mark = new int[12][15];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		for (int news = 0; news < 8; news++) {
			//방향을 넣는 배열을 만듬 총 7개
			moves[news] = new Offsets();}
		moves[0].a = -1;	moves[0].b = 0; //N
		moves[1].a = -1;	moves[1].b = 1; //NE
		moves[2].a = 0;		moves[2].b = 1; //E
		moves[3].a = 1;		moves[3].b = 1; //SE
		moves[4].a = 1;		moves[4].b = 0; //S
		moves[5].a = 1;		moves[5].b = -1; //SW
		moves[6].a = 0;		moves[6].b = -1; //W
		moves[7].a = -1;	moves[7].b = -1; //NW
		
		//Directions d;
		//d = Directions.N;
		//d = d + 1;//java는 지원안됨
//		현 위치에서 E, W, S, N, NE, NW, SE, SW 방향 순서대로 확인한다.
//		1. 갈 수 있는 경로의 경우, 그 방향의 좌표값 하나를 스택에 Push한다. 그 후, 그 좌표로 이동한다.
//		(이후, 1번으로 이동)
//
//		2. 갈 수 없는 경로의 경우, 무시하고 방향 확인 순서를 이어서 확인한다. (이미 왔던 경로, 정의된 좌표밖의 경로)
//
//		3. 모든 방향을 다 확인했는데도 갈 수 있는 방향이 없다면, 3번으로 이동
//
//		현 좌표를 스택에서 Pop한다. Pop한 뒤의 Top이 현 위치가 된다. (1번으로 복귀)
//		for (int i = 0; i < 14; i++) {
//			for (int j = 0; j < 17; j++) {
//		
//
//			}
//		}
		//input에 넣은 값을 구현(미로 표시)
		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 11; i++) {
			for (int j = 0; j <= 14; j++) {
				System.out.print(input[i][j] + " ");

			}
			System.out.println();
		}
		//미로를 빠져나오는 경로를 2로 표현
		System.out.println("mark::");
		for (int i = 0; i <= 11; i++) {
			for (int j = 0; j <= 14; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}
		//한번에 넣어서 값을 바로 정답이 나오도록
//		path(maze, mark, 11, 14);
//		System.out.println("mark::");
//		for (int i = 1; i <= 11; i++) {
//			for (int j = 1; j <= 14; j++) {
//				System.out.print(mark[i][j] + " ");
//
//			}
//			System.out.println();
//		}

	}
}

