package chap2_기본자료구조;

class PhyscData implements Comparable<PhyscData> {

	private String name;
	private int height;
	private double vision;

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public String toString() {
		return this.name + " " + this.height + "cm " + this.vision;

	}

	public int compareTo(PhyscData data) {
		if (this.name.compareTo(data.name) == 0 ) {
			if (this.height == data.height ) {
				if (this.vision == data.vision ) {
					
					return 0;
				} else if (this.vision < data.vision) {
					return -1;
				} else {
					return 1;
				}
				
			} else if (this.height > data.height) {
				return -1;
			} else {
				return 1;
			}
			
			
			
		} else if (this.name.compareTo(data.name) < 0) {
			return -1;
		} else {
			return 1;
		}

	}

}

public class 과제1_2장기본자료구조 {

	static void showData(PhyscData[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i].toString() + " ");

		}
		System.out.println("-".repeat(30));
	}

	static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i].compareTo(data[j]) < 0) {
					PhyscData t = data[i];
					data[i] = data[j];
					data[j] = t;

				}
			}
		}

	}

	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.5),
				new PhyscData("길동", 167, 0.2), };

		showData(data);
		sortData(data);
		showData(data);
	}
}
