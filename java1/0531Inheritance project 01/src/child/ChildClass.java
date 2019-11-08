package child;

import parent.ParentClass;

public class ChildClass extends ParentClass {
	
	int x = 3000;
	
	public ChildClass() { // 부모 클래스에 접근을 할때 Super를 통해서 접근을 한다.
		this(1000);  // 부모 부터 호출
		System.out.println("Child Child() 4");
	}
	
	public ChildClass(int x) {
					// 부모 부터 호출후 
		this.x = x;
		System.out.println("Child Child() 3");
		
	}

}
