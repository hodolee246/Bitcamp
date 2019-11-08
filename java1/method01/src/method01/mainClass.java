package method01;

public class mainClass {

	
		/*
		
			function	: 함수
						: 특정 처리를 하기위한 Process
			구성 : return값(자료형), 매개변수(인수, 인자, parameter)
			
			형태:
			return 값	함수명(매개변수1, 매개변수2, ...){
				처리영역
				
				return 값;
			}
		
			void : 형태가 없는 자료형
			
			method == function
			: 특정 Class에 소속되어 있는 function을 method라고 한다.
			
			C언어 : function -> C++ function(method)
			자바	: Class <= function(method)

			
		*/
	public static void main(String[] args) {
		function1(); //매인 함수에서 함수1을 불러서 실행을 가능하게 만든거다
		function2(42);
		function2(162);
		function3('A', 34, "hello");
		String re; // retrun 받아줄 변수
		re = function4();
		System.out.println("re = "+re);
		/*
		double r;
		r = Math.random();
		r = r * 20;
		int ir = (int)r;
		*/
		double d;
		d = function5(5, 2);
		System.out.println("d = " + d);
		
		int num1, num2 ;
		String op;
		int result ;
		num1 = 10;
		num2 = 3;
		op = "+";
		
		result = calculator(num1, op, num2);
		System.out.println(num1 + op + num2 + "=" + result);
		
		num1 = 6;
		num2 = 5;
		op = "-";
		result = calculator(num1, op, num2);
		System.out.println(num1 + op + num2 + "=" + result);
		
		// char 집어넣으면 아스키 코드값이 출력 되도록
		
		// 아스키 코드값을 집어넣으면 캐릭터가 나오도록
		
		int ac ;
		char ab ;
		ab = '-' ;
		ac = asci(ab);
		System.out.println(ac);
		ac = 49;
		ab = asci2(ac);
		System.out.println(ab);
		
		char c1 = 'J';
		char c_;
		// char(대문자) -> char(소문자) 
		c_ = change(c1);
		System.out.println(c_);
	}

	// void는 돌려주는 값이 없다.
	// 들어가는 값도, 나가는 값이 없는 함수
	static void function1( ) { 
		System.out.println("function1() 호출");
	}
	// 들어가는 값은 하나가 있지만 나가는 값이 없다.
	static void function2(int n) { // n == 가상 인수
		System.out.println("function2(int n)호출");
		System.out.println("n =" + n); // 여러번 호출해도 상관이 없다 각각 다른값을 호출할수있다.
	
	
	}
	// 들어가는 값이 3개 나가는 값은 없다
	static void function3(char c, int i, String str) {
		System.out.println("function3(char c, inti, String str)");
		System.out.println("c = " +c);
		System.out.println("i = " +i);
		System.out.println("str = " +str);
	}
	// 들어가는 값은 없지만 돌려받는 값이 하나인경우
	static String function4() {
		System.out.println("function4()");
		
		return "dadedo";
	// 들어가는 값 == 매개변수 나오는값 == retrun 값	
	// 들어가는값이 2개있으면서 돌려 받는 값이 하나인경우	

	}
	
	static double function5(int num1, int num2) {
		System.out.println("function5(int num1, int num2");
		double d = (double)num1 / num2 ;
		return d;
	}
	
	static int calculator(int num1, String oper, int num2) {
		int result = 0;
		if(oper.equals("+")) {
			result = num1 + num2 ;
		}
		else if(oper.equals("-")) {
			result = num1 - num2 ;
		}
		else if(oper.equals("*")) {
			result = num1 * num2 ;
		}
		else if(oper.equals("/")) {
			result = num1 / num2 ;
		}
		return result;
	}
	// 문자 입력시 숫자로(아스키코드)
	static int asci(char ac) {
		
		int a = (int)ac;
		
		return a;
	}
	// 숫자 입력시 문자로(아스키코드)
	static char asci2(int ab) {
		char b = (char)ab;
		
		return b;
	}
	// 대 > 소문자로
	static char change(char code) {
		char test = (char)(int)(code+32);
		
		return test;
	}
	}
	









