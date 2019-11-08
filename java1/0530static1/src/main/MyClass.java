package main;

public class MyClass {

	
	private int number;
	
	private String name;
	
	public static MyClass getInstance() { // Instance == 객체
		MyClass cls = new MyClass();
		cls.method();
		cls.function();
		
		return cls;
	}
	
	public void method() {
		System.out.println("MyClass method()");
	}

	public void function() {
		System.out.println("MyClass function()");
	}
	
}
