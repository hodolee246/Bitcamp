package qwe4;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a, b, c ;
		String cul ;
		a = b = c = 0;
		
		System.out.println("숫자를 입력해주세요.");
		a = scan.nextInt();
		
		while(true) {
			System.out.println("부호를 입력해 주세요(+, -, *, /)");
			cul = scan.next();
			if( cul.equals("+") == true
					|| cul.equals("-")
					|| cul.equals("*")
					|| cul.equals("/")) {
				break;
			}
			System.out.println("잘못입력하셨습니다.");
		}
		while(true) {
			System.out.println("두번째 숫자를 입력해 주세요.");
			b = scan.nextInt();
			if( cul.equals("/")) {
				if( a != 0) {
					break;
				}
				else {
					System.out.println("0으로 나눌수 없습니다.");
				}
			}
		}
		sw
	
	}

}
