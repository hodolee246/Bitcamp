package variable;

public class mainClass {

	public static void main(String[] args) {
		/*
		 *  소스코드
		 *  
		 *  1.컴파일 (문자코드 -> 기계어(2진수코드)) lib파일을 불러온다
		 *  2.(*.jar) 자료파일들을 (*) 전부 불러와서 컴파일을 시키고 
		 *  3.Build를한다 == .exe 파일 생성한다. 
		 *  4.실행
		 *  
		 *  거의 123번을 통합을 해서 실행을 시킨다 (에러 부분을 검출을 해서 알려준다.)
		 *  
		 *  숫자 (상수) : 정해진 숫자 (( 2진수 : 0,1)
		 *  					 8진수 : 0~7 10 진수로 햇을경우 10 == 8 -> 010 (8진수 표기법)
		 *  					10진수 : 0~9 
		 *  					16진수 : 0~9 + A~F  --> 0x8(16진수 표기법) ex)0xA1
		 *  				{	
		 *  					10101100  1111 1111 -> 255  
		 *  					8421 8421  0xf  0xf          (0xff0000 r 0x0000ff b g는??)
		 *  				  16의 1승 16의 0승
		 *                      16*10   +   1 * 12 == 10진수 } 2진수 계산방법 ((원리))
		 *                      
		 *                      0xAC == 1010 1100
		 *  변수 : 특정 이름을 정하고 값을 원할때 변경할 수 있는 수 (특정 이름을 지은후 값을 넣어둔다.) 변[하는 ]수 변수를 찾을때에는 값을 보고 찾는 것이 아니라 변수의 이름으로 찾는다.
		 *  변수 상위 == 핸들   
		 *   변수 선언  int == integer 
		 *   변수 선언 불가능한 것 
		 *   예약어 = 이미 정의가 되어 있음 (사용할수 없는 단어) ex int int;
 			같은 이름의 변수는 또 선언할 수 가 없다.
			int -num ( 연산자 포함 불가) int *num; 이것도 사용 못한다 (*)은 자바에서는 사용 불가능 몇몇 언어에서는 사용가능
			int 1sb; 변수의 이름의 첫 글자의 숫자를 선언할수 없다. 하지만 int a2 이런식으로 두번째 이상 부터는 숫자를 선언할수 있다.
			예외 ( 한글은 변수로 선언할수 있지만 거의 안쓴다. )
		 *  
		 */
		int i;
//      자료형  변수명
		
		int aa;
		int _num;
		int studentNumber;
		int sn;
		int stNum;
		int stu_num;
		// 변수명을 지을때에는 바로 알아볼수 있도록 선언한다. (변수가 점점 많아질수록 점점 알아보기 힘들어지기 떄문에 왠만하면 알아볼수 있도록 선언한다.)
		// 변수를 선언할시 두번째 단어의 시작은대 문자로 한다.
		
		/* 변수의 종류
		 숫자형 
			정수
			byte	1byte == 8bit 256개  숫자를 표현이 가능하다.
			short	2byte
			int		4byte
			long	8byte
			
			소수(실수)
			float 	4byte
			double 	8byte
		
		 문자형
		 	문자
		 	char(character) 	2byte  ASCII == 문자의 숫자 'A' == 65 'a' == 97
		 	문자열 "abceefg"	 string (!= 자료형) == class wrapper class
		 참/거짓
		 	boolean 	1byte true(1)/false(0)
		 */
		
		
		
		// 변수 사용법
		int number;
		// 변수의 자료형 int
		// 변수명 	 number
		number = 123; // 대입 연산자

		System.out.println(number);
		
		number =234;
		
		System.out.println(number);
		
		byte by; // 변수의 선언
		by = 12; // 변수의 값의 대입
		byte by1 = 23; // 변수의 선언과 동시에 변수 값을 대입
		
		System.out.println("by = " +by);
		by = -128;
		System.out.println("by = " + by);
	
		short sh;
		sh = 1234;
		System.out.println("sh =" + sh);
		
		int Number; // 대문자와 소문자는 컴퓨터가 다른 단어라고 인식을함 (결론 대문자 사용 자제)
		Number = 12345;
		System.out.println(Number);
		
		long lo;
		lo = 456456456456456L;
		System.out.println(lo);
		
		// 소수
		
		float f;
		f = 123.4F; // 소수점이 있을경우 double로 취급을한다 그래서 뒤에 F 자를 붙여서 float 라고 인식을 하게 만든다.
		
		System.out.println("f = " + f);
		
		
		double d ;
		
		d = 123.45678912214;
		System.out.println(d);
		
		// 문자 
		char c;
		c = 'A' +1 ; // 65 + 1 이 되어서 B가 출력이 된다.
		System.out.println("c =" +c);
		// c = "A" // " == 문자열로 취급해서 오류를 발생한다
		c = 65; // 아스키 코드에서 65 == 대문자 A
		System.out.println("c =" + c); // "%d"
		System.out.printf("%c %d \n", c, (int)c); // c에 A를 집어넣어서 숫자로 강제 변환시 65가 출력이 된다.
		
		// 문자열
		// string == 자료형이 아니다!!!!!
		// wrapper class == 자료형을 클래스로 만들어 놓은 것
		
		
		
		String str;
		str = "안녕하세요";
		System.out.println("str = " + str);
		
		str = "반갑습니다.";
		
		System.out.println("str = " + str);
		
		// true(1) false(0)
		//
		// bool ==	1byte 0/1 BOOL ==	4byte 0/213212
		//                거짓/참                           거짓/ 그 외 전부다 참
		
		boolean b;
		b = true;
		System.out.println(b);
		b = false;
		System.out.println(b);
	//	b 대입에 0이나 1이라는 숫자를 집어넣으면 오류가 발생한다 (이유) == 코드 규격값이 이미 정해져 있어서 true false 2개를 제외하고는 못 집어넣는다.
		
		// escape sequence
		// \n == 개행
		// \t == tap 띄어쓰기
		
		System.out.println("hello \t" + "world");
		
		// " world "
		
		System.out.println("\"world\""); // 큰 따음표를 넣고 싶을때 역슬래쉬를 넣고 한다.
		System.out.println("\'world\'"); // ex 작은 따음표
		
		
		
		
				
	}

}
