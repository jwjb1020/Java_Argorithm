
//package Chap4_스택과큐;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//
////배열로 하지 않고 list로 쓰는 방법 list는 제네릭
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
//public class 스택객체_test {
//
//	public static void main(String[] args) {
//      Scanner stdIn = new Scanner(System.in);
//      ObjectStack s = new ObjectStack(8); // 최대 8 개를 push할 수 있는 stack
//      Random random = new Random();
//      int rndx = 0, rndy = 0;
//      Point p = null;
//      while (true) {
//         System.out.println(); // 메뉴 구분을 위한 빈 행 추가
////         System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
//         System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");
//
//         int menu = stdIn.nextInt();
//         if (menu == 0)
//            break;
//
//         switch (menu) {
//         case 1: // 푸시
//            System.out.print("데이터: ");
//            rndx = random.nextInt(30);
//            rndy = random.nextInt(20);
//            p = new Point(rndx, rndy);
//            try {
//               s.push(p);
//            } catch (ObjectStack.OverflowGenericStackException e) {
//               System.out.println("stack이 가득찼있습니다.");
//            }
//            break;
//
//         case 2: // 팝
//            try {
//               p = s.pop();
//               System.out.println("pop한 데이터는 " + p + "입니다.");
//            } catch (ObjectStack.EmptyGenericStackException e) {
//               System.out.println("stack이 비어있습니다.");
//            }
//            break;
//
//         case 3: // 피크
//            try {
//               p = s.peek();
//               System.out.println("peek한 데이터는 " + p + "입니다.");
//            } catch (ObjectStack.EmptyGenericStackException e) {
//               System.out.println("stack이 비어있습니다.");
//            }
//            break;
//
//         case 4: // 덤프
//            s.dump();
//            break;
//         }
//         
//      } 
//      
//      }
//}
