package calculator;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int number1, number2;
		String oper;
		int result = 0;
		String replay;
		
		while(true) {
		
			// 1. 첫번째 숫자 입력
			System.out.print("첫번째 숫자 = ");
			number1 = sc.nextInt();
			
			// 2. 연산자 입력
			while(true) {
				System.out.print("연산자(+,-,*,/) = ");
				oper = sc.next();			
				if(oper.equals("+") == true 
						||oper.equals("-") == true
						|| oper.equals("*") == true 
						|| oper.equals("/") == true) {
					break;			
				}
				System.out.println("연산자를 잘못 입력하셨습니다. 다시 입력해 주십시오");
			}
			
			// 3. 두번째 숫자 입력
			while(true) {
				System.out.print("두번째 숫자 = ");
				number2 = sc.nextInt();
				
				if(oper.equals("/")) {				
					if(number2 != 0) {
						break;
					}else {
						System.out.println("0으로 나눌수 없습니다 다시 입력해 주십시오");
					}				
				}else {
					break;
				}
			}
			
			// 4. 계산처리
			/*
			if(oper.equals("+")) {
				result = number1 + number2;
			}
			else if(oper.equals("-")) {
				result = number1 - number2;
			}
			else if(oper.equals("*")) {
				result = number1 * number2;
			}
			else if(oper.equals("/")) {
				result = number1 / number2;
			}
			*/
			switch ( oper ) {
				case "+":
					result = number1 + number2;
					break;
				case "-":
					result = number1 - number2;
					break;
				case "*":
					result = number1 * number2;
					break;
				case "/":
					result = number1 / number2;
					break;
			}
			
			// 5. 출력
			System.out.println(number1 + " " + oper + " " + number2 + " = " + result);
			
			// 계속할건지?
			System.out.print("계산을 계속하시겠습니까?(y/n) = ");
			replay = sc.next();
			
			if(replay.equals("n")) {
				System.out.println("안녕히 가십시오");
				break;
			}
		}
	}

}





