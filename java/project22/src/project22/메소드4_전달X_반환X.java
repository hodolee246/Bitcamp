package project22;

public class 메소드4_전달X_반환X {

	//매개변수를 받지않고 반환하지도 않고 출력만 찍어주는 함수.
	static void func() {
		
		System.out.println("출력만 해주는 함수입니다.");
		System.out.println("많이 사용하지는 않지만, \n많이 말해야할때 또는 여러번 말해야할때\n함수로만들어서 자주 사용할 수 있습니다.");
	}
	
	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			
			func();
			System.out.println();
		}
		System.out.println();
		func();
		
		
	}
}
