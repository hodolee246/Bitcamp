package sing;

import robot.Robot;

public class SingClass extends Robot {

	public SingClass() {
		super();
		System.out.println("SingClass 생성자 입니당");
	}
	
	public void print() {
		System.out.println("노래하는중입니다.");
	}
	
	public void method() {
		System.out.println("SingClass 퍼블릭 메소드 입니당.");
	}
	
}
