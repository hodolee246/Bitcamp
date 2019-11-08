package Child;

import parent.Parent;

public class Child extends Parent {

	public Child() {
	//	  super(3);
		// super == 부모 클래스를 지칭
		
		System.out.println("Child Child()");
	}
	
	public Child(int num) {
		//super(num);
		System.out.println("Child Child(int num)");
	}
	
	// Over Riding
	public void method() {
		super.method(); // Over Riding 을 쓰기 전 메소드도 실행이 된다.
		System.out.println("Child method()");
	}
	
}
