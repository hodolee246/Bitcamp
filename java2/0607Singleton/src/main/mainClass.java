package main;


import cls.MyClass;
import hcls.HeClass;
import ycls.YouClass;

public class mainClass {

	public static void main(String[] args) {
		
		MyClass mcls = new MyClass();
		
		YouClass ycls = new YouClass();
		
		HeClass hcls = new HeClass();
		
	
		
	//	int n = mcls.getMynum();

	//	ycls.setYounum(n);
		
	//	mcls.method();
	//	ycls.method();
	//	hcls.method();
		
		hcls.Function();
		
		mcls.Function();
		ycls.Function();
		System.out.println(mcls.toString());
		System.out.println(ycls.toString());
		System.out.println(hcls.toString());
	}

}
