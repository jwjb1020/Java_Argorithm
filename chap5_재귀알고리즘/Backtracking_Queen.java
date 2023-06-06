package chap5_재귀알고리즘;


//package chap5_재귀알고리즘;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import chap5_재귀알고리즘.ObjectStack.EmptyGenericStackException;
//import chap5_재귀알고리즘.ObjectStack.OverflowGenericStackException;
//
//class ObjectStack {
//	private List<Point> data; // 스택용 배열
//	private int capacity; // 스택의 크기
//	private int top; // 스택 포인터
//
//	public class EmptyGenericStackException extends RuntimeException {
//		public EmptyGenericStackException() {
//		}
//	}
//
//	public class OverflowGenericStackException extends RuntimeException {
//		public OverflowGenericStackException() {
//		}
//	}
//
//	public ObjectStack() {
//		
//		data = new ArrayList<Point>();
//	}
//	
//	public ObjectStack(int maxlen) {
//		top = 0;
//		capacity = maxlen;
//		try {
//			data = new ArrayList<Point>();
//		} catch (OutOfMemoryError e) {
//			capacity = 0;
//		}
//	}
//
//	// push function,
//	public int push(Point x) throws OverflowGenericStackException {
//		if (top >= capacity) // top이 꽉찻다는 의미
//			throw new OverflowGenericStackException();
//		{
//			data.add(x); // top에 넣고~
//			top++;
//			return 1;
//		}
//	}
//
//	public Point pop() throws EmptyGenericStackException {
//		if (top <= 0)
//			throw new EmptyGenericStackException();
//		{
//			Point p = data.remove(top - 1);
//			return p;
//		}
//
////      return data[--top]; // 빼서~ -> 정수버전
//	}
//
//	public Point peek() throws EmptyGenericStackException {
//		if (top <= 0)
//			throw new EmptyGenericStackException();
////      return data[top - 1];
//		return data.get(top - 1);
//	}
//
//	public void clear() {
//		top = 0;
//	}
//
//	public int indexOf(Point x) {
//		for (int i = top - 1; i >= 0; i--)
//			if (data.get(i).equals(x)) // data.get(i) = 포인터 객체,
//				return i; // 검색 성공
//		return -1; // 검색 실패
//	}
//
//	// top이 0보다 작으면 true가 되는 거여
//	public boolean isEmpty() {
//		return top <= 0;
//	}
//
//	public void dump() {
//		if (isEmpty())
//			// if (top <= 0)
//			System.out.println("stack이 비어부렷으");
//		else {
//			for (int i = 0; i < top; i++)
//				System.out.print(data.get(i) + " ");
//			System.out.println();
//		}
//	}
//}
//
//class Point {
//	private int ix;
//	private int iy;
//
//	public Point(int ix, int iy) {
//		this.ix = ix;
//		this.iy = iy;
//	}
//
//	public String toString() {
//		return "(" + ix + ", " + iy + ")";
//	}
//
//	// equal 재정의 하는 것, 지금 Object 객체를 들고와서 쓰기 땜시롱
//	@Override
//	public boolean equals(Object p) {
//
//		Point px = (Point) p;
//		if (this.ix == px.ix && this.iy == px.iy)
//			return true;
//		else
//			return false;
//	}
//}
//
//
//
//
//public class Backtracking_Queen {
//	public static void SolveQueen(int[][] d) {
//		int count = 0, mode = 0;
//		int ix = 0, iy = 0;
//		ObjectStack st = new ObjectStack();
//		Point p = new Point(ix, iy);
//		d[ix][iy] = 1; count++;
//		st.push(p);
//		while (count < 8) {
//			ix++;		int cy = 0;
//			while (ix < d.length)
//			{
//		
//				while (cy < d[0].length) {
//		
//						st.push(px); count++;
//						break;
//			
//				}
//				if (cy != d[0].length) {
//					break;
//				} else {
//				 p = st.pop();	 count--;
//
//
//
//				}
//
//
//			}
//	
//
//		}
//	}
//	//가로에 넣을 수 있는지
//	public static boolean checkRow(int[][] d, int crow) {
//
//		return true;
//	}
//	//세로에 넣을 수 있는지
//	public static boolean checkCol(int[][] d, int ccol) {
//
//		return true;
//	}
//	//대각선 오른쪽
//	public static boolean checkDiagSW(int[][] d, int cx, int cy) { //x++, y-- or x--, y++ where 0<= x,y <= 7
//	
//		return true;
//	}
//	//대각선 왼쪽
//	public static boolean checkDiagSE(int[][] d, int cx, int cy) {//x++, y++ or x--, y--
//	
//		return true;
//	}
//    //새로 들어갈 위치
//    public static boolean CheckMove(int[][]d, int x, int y) {
//		return false;//(x,y)로 이동 가능한지를 check
// 	
//    }
//    //그다음 들어갈 위치
//    public static boolean NextMove(int[][]d, int row, int col) {//다음 row에 대하여 이동할 col을 조사
//    	
//    	return true;
//    }
//	public static void main(String[] args) {
//		int row = 8, col = 8;
//		int[][] data = new int[8][8];
//		for (int i = 0; i < data.length; i++)
//			for (int j = 0; j < data[0].length; j++)
//				data[i][j] = 0;
//
//		SolveQueen(data);
//
//		for (int i = 0; i < data.length; i++) {
//			for (int j = 0; j < data[0].length; j++) {
//				System.out.print(" " + data[i][j]);
//			}
//			System.out.println();
//		}
//	}
//}