package work1;

public class mainClass {

	public static void main(String[] args) {

		/*
		 * 
		 * function : 함수 templata(형태) 자료형 함수명(매개변수1, 매개변수2, ...){ //매개변수는 필요한만큼 늘려갈수 있다.
		 * 처리 return 값; (항상 value가 나감) }(함수의 목적 == 처리, 간략화, 분산)
		 * 
		 * 호출 자료형 변수 = 함수명(변수, 값) //매개변수의 자료형의 변수나 값을 넣는다.
		 * 
		 * 들어오는 값 나오는 값(return value) 함수명( 값(value), 주소(address)) ;
		 * 
		 * func(int n, String []str, double d[][]) == func(int n String* str, double** d
		 * 
		 * 
		 * 
		 */

		// 두수의 몫과 나머지를 구하여라. 함수를 하나만 사용하라.

		int number1, number2;
		int result, tag[];

		number1 = 958;
		number2 = 24;
		tag = new int[1];

		result = divproc(number1, number2, tag);
		System.out.println("목 :" + result + "나머지 :" + tag[0]);
		// swap를 할 수 있는 함수를 제작하라.
		// swap 자체는 2수를 바꾸는거 일뿐 특정 지정이 없으면 두수만 바꾸는 의미로 사용된다.
		int _number[] = new int[2];
		_number[0] = number1;
		_number[1] = number2;
		System.out.println("_number[0] = " + _number[0] + "_number[1] = " + _number[1]);

		swap(_number);
		System.out.println("_number[0] = " + _number[0] + "_number[1] = " + _number[1]);
	}

	static int divproc(int num1, int num2, int t[]) {
		int re;
		re = num1 / num2;
		t[0] = num1 % num2;
		return re;
	}

	static void swap(int num[]) {
		int temp = num[0];
		num[0] = num[1];
		num[1] = temp;
	}

}
