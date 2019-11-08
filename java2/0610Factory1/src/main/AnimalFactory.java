package main;

public class AnimalFactory {

	public static Animal Create(String animalName) { // 어디서든 사용해야하면 Static 을 붙이면 좋지먼 
		if(animalName.equals("")) {
			System.out.println("생성할 클래스가 없습니다.");
		}
		if(animalName.equals("개")) {
			return new Dog();
		} else if(animalName.equals("야옹이")) {
			return new Cat();
		} else if(animalName.equals("황소")) {
			return new Cow();
		}
		return null;
	
	}

	
}
