package chap3_검색알고리즘;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/

import java.util.Arrays;
import java.util.Comparator;

class Fruit {
	// 이름, 가격, 날짜
	String name;
	int price;
	String date;
	public static final Comparator<Fruit> cc_date = new dateOrderComparator();

	private static class dateOrderComparator implements Comparator<Fruit> {

		public int compare(Fruit a, Fruit b) {

			return a.getDate().compareTo(b.getDate());
		}

	};

	

	public Fruit() {

	}

	public Fruit(String name, int price, String date) {
		this.name = name;
		this.price = price;
		this.date = date;

	}

	public String toString() {
		return this.name + " " + this.price + " " + this.date;
	}

	public int getPrice() {
		return price;

	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getDate() {
		return date;
	}

}

public class Fruit객체배열이진탐색_Test {
	static void showData(Fruit[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].toString() + " ");
			System.out.println();

		}
	}

	private static void sortData(Fruit[] arr, Comparator<Fruit> cc) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (cc.compare(arr[i], arr[j]) < 0) {
					Fruit t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;

				}
			}
		}

	}

	private static int binarySearch(Fruit[] arr, Fruit newFruit, Comparator<Fruit> cc) {

		int pl = 0;
		int pr = arr.length - 1;

		do {
			int pc = (pl + pr) / 2;
			if (cc.compare(arr[pc], newFruit) == 0) {
				return pc;

			} else if (cc.compare(arr[pc], newFruit) < 0) {
				pl = pc + 1;

			} else {
				pr = pc - 1;
			}

		} while (pl <= pr);
		return -1;
	}

	public static void main(String[] args) {
		Fruit[] arr = { new Fruit("사과", 200, "2023-5-8"), new Fruit("키위", 500, "2023-6-8"),
				new Fruit("오렌지", 200, "2023-7-8"), new Fruit("바나나", 50, "2023-5-18"), new Fruit("수박", 880, "2023-5-28"),
				new Fruit("체리", 10, "2023-9-8") };
		System.out.println("정렬전 객체 배열: ");
		showData(arr);

		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit에 compareTo()가 있어도 람다식 우선 적용
		System.out.println("\n" + "람다식 정렬(가격)후 객체 배열: ");
		showData(arr);

		Arrays.sort(arr, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit a1, Fruit a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
//		Arrays.sort(arr, new Comparator<Fruit>() {
//			@Override
//			public int compare(Fruit a1, Fruit a2) {
//				return a1.price - a2.price;
//			}
//		});
		Comparator<Fruit> cc_price = new Comparator<Fruit>() {

			@Override
			public int compare(Fruit a, Fruit b) {

				return a.getPrice() - b.getPrice();
			}

		};

		Comparator<Fruit> cc_name = new Comparator<Fruit>() {

			@Override
			public int compare(Fruit o1, Fruit o2) {

				return o1.getName().compareTo(o2.getName());
			}

		};
		Comparator<Fruit> cc_date = new Comparator<Fruit>() {

			@Override
			public int compare(Fruit o1, Fruit o2) {

				return o1.getDate().compareTo(o2.getDate());
			}

		};
		System.out.println("\n" + "comparator 정렬(이름)후 객체 배열: ");
		showData(arr);
		System.out.println();
		Fruit newFruit = new Fruit("체리", 500, "2023-5-18");
		System.out.println("key 갑 = " + newFruit.toString());
		int result3 = Arrays.binarySearch(arr, newFruit, cc_name);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);

		result3 = binarySearch(arr, newFruit, cc_name);
		System.out.println("\nbinarySearch() 조회결과::" + result3);

		sortData(arr, cc_price);
		System.out.println("comparator 정렬(가격)후 객체 배열: ");
		showData(arr);

		result3 = Arrays.binarySearch(arr, newFruit, cc_price);
		System.out.println("\nArrays.binarySearch() 조회결과::" + result3);

		result3 = binarySearch(arr, newFruit, cc_price);
		System.out.println("\nbinarySearch() 조회결과::" + result3);

		Arrays.sort(arr, (a, b) -> a.getDate().compareTo(b.getDate()));
		showData(arr);

		result3 = Arrays.binarySearch(arr, newFruit, Fruit.cc_date);
		System.out.println("\nbinarySearch() 조회결과::" + result3);
		Arrays.sort(arr, cc_date);
		showData(arr);
		result3 = Arrays.binarySearch(arr, newFruit, Fruit.cc_date);
		System.out.println("\nbinarySearch() 조회결과::" + result3);
	}

}