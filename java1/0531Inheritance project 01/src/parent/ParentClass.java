package parent;

public class ParentClass {

	int x = 100;
	
	public ParentClass() {
		this(200); //생성자 호출 ( 맨 위에 존재해야함)
		
		System.out.println("Parent Parent() 2");
	
	}
	
	public ParentClass(int x) {
		this.x = x;
		System.out.println("Parent Parent() 1");
	}
	
	public int getX() {
		return x;
	}
	
}
