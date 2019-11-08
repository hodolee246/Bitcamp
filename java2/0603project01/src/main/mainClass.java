package main;

import shape.CircleClass;
import shape.Rectangle;
import shape.Shape;

public class mainClass {

	public static void main(String[] args) {
		

		Shape shape[] = new Shape[3];
		
		shape[0] = new Rectangle(6, 4);
		shape[1] = new CircleClass(25, 30, 3);
		shape[1] = new CircleClass(15, 32, 6);
	
		for (int i = 0; i < shape.length; i++) {
		//	System.out.println("넓이" + shape[i].calcArea());
		}
		
		
	}

}
