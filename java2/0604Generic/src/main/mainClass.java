package main;

public class mainClass {

	public static void main(String[] args) {
		
		/*
			Generic : 자료형 변수 == template(형태)
			
			int n1, n2;
			double d1, d2;
			
		*/
		Box<Integer> box = new Box<Integer>(2);
		
		int r = box.getNumber();
		System.out.println("r = " + r);
		
		Box<String> box1 = new Box<String>("Generic"); // 객체를 생성시 생성
														// 클래스만 사용이 가능한 뤱퍼 클래스
		String str = box1.getNumber();
		System.out.println("str = " + str);
		
		Box<Double> box2 = new Box<Double>(5.2);
		double d = box2.getNumber();
		System.out.println("d = " + d);
				
		Box2<Integer, String> _box = new Box2(12, "hello");
		System.out.println(_box.toString());
		
	}
	// Generic == 클래스 뒤에 정의해주고 나중에 본인의 사용 목적에 맞게 자료형을 집어넣어서 사용한다.
	// Generic 사용목적 == 계산기로 계산을 해보면 정수랑 소수 소수와 소수 정수

}

class Box<T>{	// T == template 의 약자 (추가적으로 사용자 지정 단어이기 때문에 다른거 써도 무관함)
		//<T> == Generic
	T number;
	
	public Box(T number) {
		this.number = number;
	}
	
	public T getNumber() {
		return number;
	}
	
}

class Box2<T, A>{
	
	T time;
	
	A area;

	public Box2(T time, A area) {
		
		this.time = time;
		this.area = area;
	}

	@Override
	public String toString() {
		return "Box2 [time=" + time + ", area=" + area + "]";
	}

	public T getTime() {
		return time;
	}

	public void setTime(T time) {
		this.time = time;
	}

	public A getArea() {
		return area;
	}

	public void setArea(A area) {
		this.area = area;
	}
	
	
	
	
	
	
	
}