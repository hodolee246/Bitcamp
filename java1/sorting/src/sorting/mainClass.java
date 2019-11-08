package sorting;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		String c = "";
		int sort, swap;
		sort = swap = 0;
		int array[] = new int[arraylen()];

		c = NumInput(array);
		// 입력 배열 = numberInput(올림 / 내림)
		// 몇개의 숫자
		// 숫자들 입력
		// 올림/내림

		swap(array, c);

		result(array, c);

		// sorting(배열, 올림/내림)
		// swap()

		// result(배열, 올림/내림)

	}

	static int arraylen() {
		Scanner scan = new Scanner(System.in);
		System.out.println("배열의 길이를 입력해주세요.");
		int i = scan.nextInt();
		return i;
	}

	static String NumInput(int array[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("배열을 어떻게 정렬할지 입력해주세요(올림/내림");
		String c = "";
		c = scan.next();
		for (int j = 0; j < array.length; j++) {
			System.out.println(j + "번째의 배열을 입력해주세요");
			array[j] = scan.nextInt();
		}
		return c;
	}

	static void swap(int array[], String c) {
		int temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (c.equals("올림")) {
					if (array[i] < array[j]) { // 오름차순 // 내림차순 바뀌는데 가운데 부호값만 차이있음.
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				} else {
					if (array[i] > array[j]) { // 오름차순 // 내림차순 바뀌는데 가운데 부호값만 차이있음.
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
		}
	}

	static void result(int array[], String s) {
		System.out.println(s + "차순정렬입니다.");
		for (int k = 0; k < array.length; k++) {
			System.out.println(array[k]);
		}

	}
}
