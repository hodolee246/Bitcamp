package project12;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a ;
		String x, y, z;
		
		y = ("양수입니다.");
		z = ("음수입니다.");
				
		System.out.println("숫자를 입력해 주세요");
		a = scan.nextInt();
		
		x = (a >= 1)? y:z;
		
		System.out.println("입력하신 숫자는" + x);
	}

}
