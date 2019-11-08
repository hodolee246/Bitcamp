package main;

public class mainClass {

	public static void main(String[] args) {
		/*
		  
		  	interface : 추상 메소드만 포함하고 있다.
		  				abstract를 붙이지 않는다.
		  				
		  				interface 자체 만으로는 생성할 수 없다.
		  				항상 상속 후 에 생성이 가능하다.
		  				
		  				
		  				다중 상속이 가능하다.
		  				일반 메소드는 추가할 수 없다.
		  				변수 추가가 불가능하다.
		  				
		  		부모 class	: method를 정의를 해주셔야 하는게 class 이다.
		  			|
		  			|- 자식 클래스 1
		  			|- 자식 클래스 2
		  			|- 자식 클래스 3
		  				
		  		interface 선언만 한 뒤
		  			|
		  			|- 자식 클래스 1 밑에서 작성을 한다.
		  			|- 자식 클래스 2
		  			|- 자식 클래스 3	
		  				
		  
		  
		 */

	//	ainterface ai = new ainterface() ; 불가능하다
			
		aClass ac = new aClass();
		ac.method();
		
		
		// 부모 인터페이스를 자식으로 잡아서 사용은 가능하다.
		ainterface ai = new aClass();
		
		aaClass aac = new aaClass();
		aac.method();
		aac.function();
		
		aainterface ai2 = new aaClass();
		ainterface ai3 = new aClass();
		// ai2.method();
		ai2.function();
			
		ainterface a1 = new aClass();  // 상속 받는 클래스는 동일한 인터페이스, 클래스를 상속 받아야한다.
		ainterface a2 = new a1class(); // 
		
	}

}



