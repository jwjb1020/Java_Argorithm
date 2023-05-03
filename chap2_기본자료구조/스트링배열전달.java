package chap2_기본자료구조;

public class 스트링배열전달 {

	static void showData(String[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");

		}
		// 출력
	}

	static void sortData(String[] data) {

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i].compareTo(data[j]) < 0) {
					String s = data[i];
					data[i] = data[j];
					data[j] = s;
				}
			}

		}

	}

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "melon","love" };

		showData(data);
		sortData(data);
		System.out.println("\n");
		showData(data);

	}

}
