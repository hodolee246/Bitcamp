package children;

import parent.ParentClass;

public class ChildrenClass extends ParentClass {

	private String test;
	
	public ChildrenClass(String test) {
		
		super(test);
		
	}
	
	public void print() {
		
		System.out.println("ChildrenClass");
	}
	
}
