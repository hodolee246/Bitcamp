package capsul;

public class Myclass {

	//	캡슐화 class 내부에 사용할 변수를 묶음 
	
	private int number;  // privata == 개인적인
	String name;
	
	// 은닉성 변수의 외부와 접근을 제어
	//자신이 마음대로 세팅을 할수있게 만들수도 있지만 할수 없게도 할수있다.
	// this == instance 의 주소
	
	public void setNumber(int number) {	// setter 메서드  외부에서 세팅을 할수있는 함수
		// 어떤 number 가 멤버 변수인지 서로 구분이 필요할때 this를 앞에다 붙여준다.
		this.number = number;
	}
	public int getNumber() {	// getter 메서드	외부에서 접근해서 얻어올수있는 함수
		return number;
	}
	
	public Myclass getInstance() {
		return this; // 자기 자신을 가리키는 주소
	}
	
	
}
