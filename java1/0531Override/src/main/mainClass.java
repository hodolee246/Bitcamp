package main;

import child.ChildClass;
import child.SubClass;
import sup.SuperClass;

public class mainClass {

	public static void main(String[] args) {

		/*
		SubClass sub = new SubClass(123);
		
		sub.method();
		sub.overRideMethod();
		*/
		/*
		// 부모 클래스의 인스턴스를 사용하여 자식클래스를 선언함
		SuperClass sc = new SubClass();
		System.out.println();
		sc.method();			// super Class
		sc.overRideMethod(); 	// 자식클래스의 over ride method <- subclass
		
		SubClass sub = (SubClass)sc;
		System.out.println();
		sub.func();
		*/
		
		SuperClass arrCls[] = new SuperClass[4];
		
		System.out.println();
		
		arrCls[0] = new SubClass();
		arrCls[1] = new ChildClass();
		arrCls[2] = new ChildClass();
		arrCls[3] = new SubClass();
		
		for (int i = 0; i < arrCls.length; i++) {
			arrCls[i].overRideMethod();
		}
		
		System.out.println();
		for (int i = 0; i < arrCls.length; i++) {
			// instanceof 인스터스가 어떤어떤 것 인지
			if(arrCls[i] instanceof SubClass) {
				SubClass s = (SubClass)arrCls[i];
				s.func();
			}
			else if(arrCls[i] instanceof ChildClass) {
				ChildClass c = (ChildClass)arrCls[i];
				c.function();
			}
			
		}
		
		
		/*
			상속되어있는 자식클래스는 부모 클래스 인스턴스 하나로 전부다 관리할수있다.
			
		*/
		
		
		
		
		// 부모 클래스 인스턴스로 자식 클래스 호출하기 위해 오버라이딩을한다.
		// 관리는 부모 클래스 인스턴스로 overriding 을 하지 않는 자식클래스의 메소드를
		// 접근하기 위해서 instanceof 로 접근한다.
		
		
		
	}

}
