package constructor;

public class mainClass {

	public static void main(String[] args) {
	//	MyClass cls = new MyClass();
		
		MyClass cls1 = new MyClass(1);
		
		MyClass cls2 = new MyClass('a');
		
	//	int arr[] = { 1, 2, 3 };
		
		
		
		member mem = new member(1, "전인우", 165.4);
		
		mem.setHeight(181.2);
	//	String name = mem.getName();
		
		System.out.println(mem.toString());
	
	
	}

}
