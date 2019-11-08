package bit.com.a.model;

import java.io.Serializable;

public class myClass implements Serializable {

	private int number;
	private String name;

	public myClass() {
		// TODO Auto-generated constructor stub
	}

	public myClass(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "myClass [number=" + number + ", name=" + name + "]";
	}
		
}
