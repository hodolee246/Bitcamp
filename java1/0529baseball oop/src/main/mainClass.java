package main;

import baseball.baseballClass;

public class mainClass {

	public static void main(String[] args) {
		
		baseballClass bs = new baseballClass();
		// 계속 할껀지 그만할껀지 추가 하고싶은경우 메인 클래스에서 추가
		bs.init();
		bs.check();

	}

}
