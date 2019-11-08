package main;

import animal.Animal;
import animal.Cat;
import animal.Cow;
import animal.Dog;

public class mainClass {

	public static void main(String[] args) {
		
		
		
		
		Animal animal1 = new Cat("초롱이");
		animal1.print();
		Animal animal2 = new Dog("멍멍이");
		animal2.print();
		Animal animal3 = new Cow("소");
		animal3.print();
		
		// 관리를 해야한다
		
		// 각자 따로 한다면 서로 같은 클래스의 인스턴스로 3개의 인스턴스에 
		// 하나씩 클래스를 집어 넣어서 관리를 해야한다.
		Cat cat[] = new Cat[5];
		Dog dog[] = new Dog[3];
		Cow cow[] = new Cow[2];
		for (int i = 0; i < cat.length; i++) {		
			cat[i] = new Cat("야옹이" + i);
		}
		for (int j = 0; j < dog.length; j++) {
			dog[j] = new Dog("멍멍" + j);
		}
		for (int i = 0; i < cow.length; i++) {		
			cow[i] = new Cow("소" + i);
		}
		
		Animal ani[] = new Animal[10]; // over riding 장점 하나의 인스턴스 (부모)
		// 3개의 클래스를 묶어서 다같이 관리를 할 수 있다.
		
		ani[0] = new Dog("멍멍");
		ani[1] = new Cat("야옹");
		ani[2] = new Cow("으메");

		for (int i = 0; i < ani.length; i++) {
			if(ani[i] != null) {
			ani[i].print();
			}
		}
		Cat c = (Cat)ani[1];
		c.catMethod();
	}

}
