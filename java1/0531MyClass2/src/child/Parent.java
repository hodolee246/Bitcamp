package child;


// 부모 클래스
public class Parent {

	protected int pNumber;
	// 상속받은 클래스에서 접근 허용 외부에서는 접근 X
	
	
	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}
	
	public void pMethod() {
		System.out.println("Parent pMethod()");
	}
	
}
