package doing;

import robot.Robot;

public class DoingClass extends Robot {

	public DoingClass() {
		super();
		System.out.println("DoingClass 생성자 입니다.");
	}
	
	public void print() {
		System.out.println("움직입니다.");
	}
	
	public void method() {
		System.out.println("DoingClass 퍼블릭 메소드 입니당.");
	}
	
}

