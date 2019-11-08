package project8;

import java.util.Scanner;

public class classMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double inch, yard, mile, dnumber;
		
		double cm, m, km;
		
		System.out.println("단위 환산 프로그램 입니다.");
		
		dnumber = scan.nextDouble();
		
		inch = dnumber * 2.54;
		
		yard = dnumber * 0.3048;
		
		mile = dnumber * 1.6093;
		
		cm = dnumber * 2.54;
		
		m = dnumber * 0.3048;
		
		km = dnumber * 1.6093;
		
		
		// 변수 이름 설정할때 (더블, 인티저 동시에 사용할때) 더블의 d 인티저 i 약자를 때와서 앞에다 붙여주면 구분하기가 쉽다.
	
		System.out.println("Inch는 " + cm + "cm입니다.");
		
		
		System.out.println("Yard는 " + m + "m입니다.");
		
		
		System.out.println("Mile은 " + km + "km입니다.");
		
		
		

	}

}
