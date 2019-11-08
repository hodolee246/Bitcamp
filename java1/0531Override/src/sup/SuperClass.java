package sup;

public class SuperClass { // extends Object 만약 상속을 안해둘경우 기본 상속값이 있다.

	private int number;
	

	public SuperClass() {
		System.out.println("SuperClass SuperClass()");
	}


	public SuperClass(int number) {
		
		this.number = number;
		System.out.println("SuperClass SuperClass(int number)");
	}
	
	public void method() {
		System.out.println("SuperClass method()");
	}
	
	public void overRideMethod() {
		System.out.println("SuperClass overRideMethod()");
		// Overrid 정의 자식 클래스에서 재정의 하는걸 말한다 (메소드를)
	}
	
	
	
	
	
	
}
