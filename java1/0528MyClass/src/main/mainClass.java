package main;

import cal.MyCal;
import myclass.MyClass;

public class mainClass {
	public static void main(String[] args) {
		// 객체지향 OOP
		// object oriented programing
		//	객체	지향	프로그래밍
	
	//(우리가 선언한 클래스의 자료형)
	 MyClass 				cls = new MyClass(); // 객체 생성
	// class template(형태) 변수(객체object, 주체instance)
	//						Main(stack) 		heap 영역

	// System.out.println(cls); // -> heap영역에 있는 주소

	cls.number = 123;
	cls.name = "홍길동";
	
	cls.method();
	
	MyClass mcls = null; // 객체를 초기화 할때에는 null 값으로 초기화를 한다.
	
	mcls = new MyClass();
	/*
	 
	 	OOP의 3대 요소 
	 	
	 	캡슐화 == 은닉성
	 	다양성
	 	상속성
	 	
	 	!= <=
	 
	 */
	
		//	int number[5][5]
	
	
	/*	int number[] = new int[5];
		String name[] = new String[5];
		int lang[] = new int[5];
		MyClass member[] = new MyClass[5];
		
		member[0].lang = 12; // 객체 장점 각각 따로 관리하던걸 한 묶음으로 관리할 수 있다.
	
		String students[][] = {
				{"1001", "홍길동", "90", "100", "80"},
				{"1002", "일지매", "90", "100", "80"}
		};
		String num = 	students[0][0];
		String num2 = 	students[1][0];
		
		// 가독성 : 해석하기 쉽게 보이는 성질
		MyClass mycls = new MyClass();
		
		int num1 = mycls.number;
		
		// 객체?
		MyClass my1, my2, my3;
		my1 =new MyClass();
		my2 =new MyClass();
		my3 =new MyClass();
		
		my1.number = 1;
		my1.name = "김유신";
		
		my2.number = 2;
		my2.name = "계백";
		
		my3.number = 3;
		my3.name = "연개소문";
		*/
		
		MyCal cal = new MyCal(); // 객체화 = 클래스화
		
		cal.input();
		cal.process();
		cal.resultprint();
		
		
		
		
		
	// = new (동적할당) 동적할당을 해야 heap 영역에 저장을한다 
	// 자바는 동적 할당을 해야한다.
	
	// stack(자동) heap
	
	/*{
		int n;
		
		MyClass cls1 = new MyClass();
		
		
	}*/
	
	// MyClass 				cls = new MyClass();
	// 							객체를 생성한다			
	
	}
}







