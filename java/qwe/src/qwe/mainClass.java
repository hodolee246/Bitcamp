package qwe;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int pay, guest, temp ;
		
		pay = scan.nextInt();
		
		guest = scan.nextInt();
		
		temp = guest - pay ;
		
		System.out.println("거스름돈 입니다.");
		System.out.print("10000원 "+temp / 10000);
		System.out.println("장");
		temp = temp % 10000;
		System.out.print("5000원 "+temp / 5000);
		System.out.println("장");
		temp = temp % 5000;
		System.out.print("1000원 "+ temp / 1000);
		System.out.println("장");
		temp = temp % 1000;
		System.out.print("500원 " + temp / 500 );
		System.out.println("개");
		temp = temp % 500;
		System.out.print("100원 " + temp / 100);
		System.out.println("개");
		temp = temp % 100;
		System.out.print("50원 " + temp / 50);
		System.out.println("개");
		temp = temp % 50;
		System.out.print("10원 " + temp / 10);
		System.out.println("개");
		
		
		/*
		 
		 편의점 프로그램
		 
		 금액 : 4230원
		 지불한 금액 : 10000원
		 
		 거스름돈: 출력
		 5000-> ?장
		 1000-> ?장
		 500-> ?개
		 100-> ?개
		 50-> ?개
		 10-> ?개
		 
		 */
	}

}
