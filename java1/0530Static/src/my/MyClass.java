package my;

public class MyClass {
	
	private int number; // member 변수( variable )
	
	public static int st_number; // 정적 변수
	
	public static int num;
	
	public int getNumber() {	// member(인스턴스) method
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public void method() {
		int i; // stack == auto(자동)
		// local(지역) variable
		System.out.println("MyClass method()");
		
		MyClass.st_number = 222; 
		
		int num; // 보통은 같은 이름으로 변수를 선언을 하지를 않지만
		// 만약 선언을 한 뒤 사용을 하더라도 사용시 우선순위는 지역변수 부터 사용된다. 
	}
	
	public void function() {
		int num = 0;
		num ++; // 로컬변수
		number++; // 멤버변수
		MyClass.st_number++; // 정적변수
		
		System.out.println("num =" + num);
		System.out.println("number =" + number);
		System.out.println("st_number =" + MyClass.st_number);
		int number;
		
		
	}
	// 원래 변수 접근방식 this.멤버변수
	public static void st_method() { // this 접근 불가능 
		System.out.println("MyClass st_method()");
		// number = 12; 접근 불가능
		// st_number = 234; 접근 가능
		
	}
	
}
