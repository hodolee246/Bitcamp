package dto;

public class Human {

	private int number;
	private int age;
	private String name;
	private double height;
	
	
	
	
	public Human() {
		
	}
	
	public Human(int number, String name, int age, double height) {
		
		this.number = number;
		this.name = name;
		this.age = age;
		this.height = height;
		
	}

	@Override
	public String toString() {
		return "Human [number=" + number + ", age=" + age + ", name=" + name + ", height=" + height + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}





