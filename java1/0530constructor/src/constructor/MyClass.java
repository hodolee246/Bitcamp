package constructor;

public class MyClass {

	
	/*
	 
	 	constructor : 생성자 != 초기화 		처음 값 설정
	 	destructor : 소멸자 == 자바 : 가비지컬렉터
	 	
	 	int arr[] = {1, 2, 3, 4, 5};
	 	
	 	structure(구조체)
	 	MYSTRUCT myst{
	 	int num,
	 	double d,
	 	String s
	 	};	 	
	 	myst st \ {1, 1.5, "abc};
	 // number, name
	 	MyClass clas = { 1, "홍길동" }; 초기화가 불가능하다
	 	
	 	생성자
	 	1. 함수 -> method 로 만들자
	 	2. 클래스명과 같은 이름을 쓰자
	 	3. return 값이 없다
	 	4. Over Load 가 가능하다. 	-> 다수
	 	5. 1번만 호출. 임의의 호출이 불가능
	 	6. initialize와 성격이 다르다.
	 	7. 생략이 가능하다.
	 	8. 실행된 시기는 객체를 생성시(new) 
	 
	 
	 	소멸자
	 	반드시 1개 (delete)
	 
	 */
	
	public MyClass(){ 	// 인수 값이 비어있음( 기본 생성자 )
		System.out.println("MyClass MyClass()");
	}
	
	public MyClass(int i) {
		this();	// MyClass() 호출
		System.out.println("MyClass MyClass(int i)");
		
	}
	
	public MyClass(char c) {
		this(1);	// MyClass (int i ) 호출
		System.out.println("MyClass MyClass(char c)");
	}
	
}














