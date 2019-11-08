package parent;

public class Parent {
	
	private int number;

	public void Parent() {
		
		System.out.println("Parent Parent()");
		
	}
	
	public void Parent(int number) {
		
		// this();
		this.number = number;
		
		System.out.println("Parent Parent(int number)");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	/*
	  	Over Ride
	  	자식 클래스에서 상속 받은 메소드를 수정해서 기입하는 것
	  	
	  
	 */
	public void method() {
		System.out.println("Parent method()");
	}
	
}
