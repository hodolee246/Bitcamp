package project22;

import java.util.Scanner;


	//매개변수로 받고 출력만하는(반환되지않는) 함수.
	static void func(int n, int b) {
		
		int result = n+b;
		System.out.println("덧셈 = " + result);
		
		result = n-b;
		System.out.println("뺄셈 = " + result);
		
		result = n*b;
		System.out.println("곱셈 = " + result);
		
		result = n/b;
		System.out.println("나눗셈 = " + result);
		
	}
	
	public static void main(String[] args) {

		int num1, num2;
		num1 = 200;
		num2 = 100;
	
		func(num1, num2);
	}

