
public class mainClass {

	public static void main(String[] args) {
		/*
			over load : function의 명칭은 같고
						매개변수(인자, 인수, Parameter)
						갯수가 다른 함수들을 의미한다.
			
			
						
						
			image draw	->	RGB, RGBA
						배경을 draw		paint(String imagename)
						달, 해의 이미지	paint(String imagename, int x, int y)
						
						
		*/
		method();
		
		method('A');
		
		method(12);
		
		method('C', 51);  	// 매개변수 순서가 서로 달라도 overload가 된다
							// 가인수가 다른것은사용할수 없다. (가상인수) (매게변수 이름만 다른것)
		method(14, 'B');
		
		disp(str, num);
		
		int sum = displaySum(1, 2, 3 , 4 , 5, 8, 12, 25, 64,1, 2);
		System.out.println("sum = " + sum);
		
		sum = displaySum(4, 5, 6);
		System.out.println("sum = " + sum); // 남들이 나의 것을 편하게 사용하기 위해서 가변인수가 존재한다.
		
	}
		
		static void method() {
			System.out.println("method() 호출 ");
		}
		static void method(char c) {
			System.out.println("method(char c) 호출 ");
		}
		static void method(int i) {
			System.out.println("method(int i) 호출 ");
		}
		static void method(char c, int i) { // getter : 
			System.out.println("method(char c, int i) 호출");
		}
		static void method(int i, char c) { // getter : 
			System.out.println("method(int i, char c) 호출");
		}
		
		
		

		}
	/*	static int method() { // overload 는 매개변수만 구별한다. return 값은 overload 와 관련이 없다.
			System.out.println("method() 호출");
			return 1;
		}	*/
		
		// 가변인수
		static int displaySum(int...num) {
			int sum = 0;
			for (int i = 0; i < num.length; i++) {
				sum = sum + num[i];
			}
			return sum;
		}
		// 일반인수 + 가변인수
		static int disp(String str, int...num) { // 컴파일은 앞에서 부다 하기때문에 가변인수는 뒤에 있어야한다. 일반 인수랑 같이 사용할경우 제일 마지막 인수로 작동을 하게끔 선언한다
			int sum = 0;
			for (int i = 0; i < num.length; i++) {
				sum = sum + num[i];
			}
			System.out.println("str = " + str);
			System.out.println("sum = " + sum);
			return 0;
		}
		
		
		
}
