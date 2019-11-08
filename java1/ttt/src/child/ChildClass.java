package child;

import parent.ParentClass;

public class ChildClass extends ParentClass {

	private String test;
	
	public ChildClass(String test) {
		super(test);
	}
	
	public void print() {
		System.out.println("ChildClass");
	}
	
}
