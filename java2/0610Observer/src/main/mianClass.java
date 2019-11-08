package main;

public class mianClass {

	public static void main(String[] args) {
		/*
		  	Observer : 감시자 
		  	
		 */
		// 감시대상의 클래스 
		MyClass human = new MyClass();
		human.addObserver(new ObserverA());
		human.addObserver(new ObserverB());
		
		human.notifyObservers("이것은 비밀사항입니다.");
		human.notifyObservers("비밀번호 : abc123");
	}

}
