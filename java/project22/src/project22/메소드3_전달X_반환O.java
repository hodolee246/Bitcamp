package project22;

import java.util.Scanner;

public class 메소드3_전달X_반환O {

	//매개변수를 받지않고 반환만 해주는 함수. =>> 입력을 받을 때 자주 사용한다.
	static int func() {
		Scanner sc = new Scanner(System.in);
		System.out.println("입력에 쓰이는 함수입니다. 값을 입력하세요.");
		int num = sc.nextInt();
		
		return num;
	}
	
	public static void main(String[] args) {

		int number; 
		int a,b,c,d,e,f,g,h,i,j,k; 
		a = func();
		
		
		System.out.println(func()+" "+a);
		
	}
}
