package main;

import boy.BoyClass;
import child.ChildClass;
import children.ChildrenClass;
import parent.ParentClass;

public class mainClass {

	public static void main(String[] args) {
		
		ParentClass pc[] = new ParentClass[3];
		
		pc[0] = new ChildClass("ChildClass");
		pc[1] = new ChildrenClass("ChildrenClass");
		pc[2] = new BoyClass("BoyClass");
		for (int i = 0; i < pc.length; i++) {
			
		if(pc[i] instanceof ChildrenClass) {
			System.out.println("ChildrenClass 입니다.");
			ChildrenClass a = (ChildrenClass)pc[i];
			a.print();
		} else if(pc[i] instanceof ChildClass) {
			System.out.println("ChildClass 입니다.");
			ChildClass b = (ChildClass)pc[i];
			b.print();
		} else if(pc[i] instanceof BoyClass) {
			System.out.println("BoyClass 입니다.");
			BoyClass c = (BoyClass)pc[i];
			c.print();
		}
		
	}
		
		
	}
	
	
	
	
	
	
}
