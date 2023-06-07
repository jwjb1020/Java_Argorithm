package chap_09tree;

/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;

//정수를 저정하는 이진트리 만들기 실습
class TreeNode {
	// node만들기 클래스
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode(int x) {
		LeftChild = RightChild = null;
		data =x;
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {// 재귀함수로 구현함
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(" " + CurrentNode.data);
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(" " + CurrentNode.data);
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현
//처음에 무조건 null값이기 때문에 생성해야함		
		TreeNode p = root;
		TreeNode temp = new TreeNode(x);
		// 트리에 값이 없는 경우 즉, root가 null일때 = 새로운 노드를 루트로 추가
		if (p == null) {
			root = temp;
			return true;
		}

		while (p != null) {
			if (x == p.data) {// 넣을려는 값이 중복된 값인 경우
				return false;
			} else if (x < p.data) {
				// 넣을려는 값이 현재 노드의 값보다 작은 경우, 왼쪽으로 이동
				if (p.LeftChild == null) {
					// 왼쪽 자식이 없는 경우, 새로운 노드를 왼쪽 자식으로 추가
					p.LeftChild = temp;
					
					return true;
				}
				p = p.LeftChild;

			} else // (x<current.data)
			{
				if (p.RightChild == null) {
					p.RightChild = temp;
				
					return true;
				}
				p = p.RightChild;
			}
		}
		return false;

	}

	boolean delete(int num) {
		TreeNode p = root;//부모의 노드값
		TreeNode q = null;//현재의 노드값과 데이터 값
		
		while(p != null) {
			if(p.data == num) {
				if(isLeafNode(p)) {
					if(q == null) {
						root = null;
						return true;
					} else if  (p == q.LeftChild) {
						q.LeftChild =null;
						return true;
					} else {
						q.RightChild =null;
						return true;
					}
				} else {
					TreeNode s = inorderSucc(p);
					if(s==null) {
						return false;
					}
					delete(s.data);
					p.data = s.data;
					return true;
				}
				}else if (num < p.data) {// 트리를 따라가기
		            q = p;
		            p = p.LeftChild;
		         } else {
		            q = p;
		            p = p.RightChild;
		         }
		      }
		      return false; // 삭제할 노드가 없는 경우

			}
		
	

	boolean search(int num) {
		TreeNode current = root;
		while (current != null) {
			if (num == current.data) {
				return true;

			} else if (num < current.data) {
				current = current.LeftChild;
			} else {
				current = current.RightChild;
			}
		}
		return false;

	}
}

public class BinaryTree_int {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), PreorderPrint("전위출력"), PostorderPrint("후위출력"),
		Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
				}
				for (int i = 0; i < count; i++) {
					if (t.insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
					else
						System.out.println(input[i]);
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num) == true)
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result == true)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			case PreorderPrint:
				t.preorder();
				System.out.println();
				break;
			case PostorderPrint:
				t.postorder();
				System.out.println();
				break;

			}
		} while (menu != Menu.Exit);
	}
}
