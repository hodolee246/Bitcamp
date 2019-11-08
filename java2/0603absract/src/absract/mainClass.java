package absract;

public class mainClass {

	public static void main(String[] args) {
		
		/*
		
		
			abstract : 추상
						완전체는 아닌 선언만 되어 있는 메소드를 포함하고 있는 클래스
						
						추상 메소드 + 일반 메소드 = 추상 클래스
						
			생성이 불가능하다. -> 상속 후에 갱신이 가능하다.
			
			
			
			public int method(char c, int i) -> oprototype		
			
				
		
		*/
		
		// abstractClass acls = new abstractClass(); 생성이 불가느하다.
		// 추상 클래스를 인스턴스로 접근은 불가능한다.
				
			
		MyClass cls = new MyClass();
		cls.abstractMethod();
		cls.Method();
		
		abstractClass acls = new MyClass();
		// 추상클래스의 부모 클래스를 인스턴스로 자식클래스를 호출한다.
		acls.abstractMethod();
		acls.Method();
		
		abstractClass aac = new abstractClass() {
			
			@Override
			public void abstractMethod() {
				System.out.println("abstractClass aac abstractMethod()");
				//추상 메소드는 프로토 타입으로 비워두고 상속 박은 부분에서 다시 한번 기입을하도록 만든 것이 추상 메소드 이다.
				// 그런 추상 메소드를 하나 이상 가지고 있는다면 추상 클래스가 된다. 특징 : 확장성에 강하다.
			}
		};
		
		
	}

}
