package child;

import sup.SuperClass;

public class SubClass extends SuperClass {

	
	public SubClass() {
		System.out.println("SubClass SubClass()");
	}
	
	public SubClass(int number) {
		
		super(number);
		System.out.println("SubClass SubClass(int number)");
	}
	
	public void overRideMethod() { // Over Ride
	//	super.overRideMethod();  // super class method가 출력된다.
		System.out.println("SubClass overRideMethod()");
		// Overrid 정의 자식 클래스에서 재정의 하는걸 말한다 (메소드를)
	}

	public void func() {
		System.out.println("SubClass func()");
	}









}
