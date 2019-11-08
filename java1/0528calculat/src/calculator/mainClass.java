package calculator;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		int num1, num2;
		String oper;
		int result;

		// 계산기

		// 첫번째 숫자 input
		num1 = numberInput(1);
		// 연산자 입력
		oper = operatorInput();
		// 두번째 입력 숫자 input
		num2 = numberInput(2);
		// 연산
		result = processing(num1, num2, oper);
		// 결과 출력
		printing(num1, num2, oper);
	}

	static String operatorInput() {
		Scanner scan = new Scanner(System.in);
		String oper = "";
		while (true) {
			System.out.println("연산자를 입력해 주세요");
			oper = scan.next();
			if (oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
				break;
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
		}
		return oper;
	}

	static int numberInput(int n) {
		Scanner scan = new Scanner(System.in);
		System.out.println(n + "번째 숫자 입력");
		String strNum = "";
		while (true) {
			strNum = scan.next();
			boolean b = isNumber(strNum);
			if( n == 2 && strNum.equals("0")) {
				continue;
			}
			if (b == true) {
				break;
			} else {
				System.out.println("숫자가 아닙니다.");
			}
		}
		int number = Integer.parseInt(strNum);
		return number;
	}

	static int processing(int num1, int num2, String oper) {
		int result = 0;
		switch (oper) {
		case "+":
			result = num1 + num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;

		}
		return result;
	}
	static void printing(int num1, int num2, String oper) {
		int result = 0;
		System.out.println(num1 + " " + oper + " " + num2 + " = " + result);
	}


	static boolean isNumber(String str) {
		boolean abc = true;
		int a = 0;

		for (int i = 0; i < str.length(); i++) {
			char ab = str.charAt(i);
			if ((int) ab > 47 || (int) ab < 56) {
				abc = false;
				break;
			}
		}

		return abc;
	}
}
