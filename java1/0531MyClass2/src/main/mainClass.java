package main;

import child.Child;
import child.Parent;

public class mainClass {

	public static void main(String[] args) {
		/*
			상속성 : 부모클래스에 있는 모든 특성을 하위(자식)클래스 에서
					상속(계승)을 받는걸 의미한다 

		*/
		
		Child ch = new Child();
		ch.pMethod();
		ch.setpNumber(12); // 그 외 setter 
		ch.getpNumber(); // getter 는 설정을 했기 때문에 setter, getter로 값을 바구고 지정할수 있다.
		
		Parent pa = new Parent();
		pa.pMethod();
		pa.setpNumber(11);
		pa.getpNumber();
		
		// ch.pNumber = 12;
		
		
	}

}
