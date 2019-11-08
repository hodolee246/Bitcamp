package single;

public class SingletonClass {

	private static SingletonClass single = null;
	public int num;
	public String name;
	
	private SingletonClass() { // 프라이빗으로 싱글톤 생성자 생성
		// 2
	}
	
	public static SingletonClass getInstance() { // 인스턴스값을 하나만 만들고 계속 유지시킨다.
		if(single == null) {
			single = new SingletonClass(); // 3      6
		}
		return single;   // 4    7
		// static 변수 싱글톤이 널로 생성
		// 겟인스턴스 메소드 실행되면서 널이니 싱글톤 클래스 생성 후 리턴
	}
	
}
