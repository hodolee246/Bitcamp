package main;

public class mainClass {

	public static void main(String[] args) {
		// final (상속의 대한 파이널) 
		final int number = 1; // 변수에서 상수로 바꾼다 final
	} 

}
// class 에 final 을 붙이면 최종 클래스 이기때문에 상속을 못받는다.
/* final */ class SuperClass {	// 파이널 클래스 : class 상속 금지
	
	public /* final */ void method() { // 파이널 메소드 : over ride 금지
		
	}
	
}


class ChildClass extends SuperClass{

	public void method() { // over ride
		
	}
	
	
}