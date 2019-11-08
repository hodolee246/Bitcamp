package wrapper;

public class mainClass {

	public static void main(String[] args) {
		/*
		
		Wrapper class
		일반 자료형(char, int, double)을 클래스화 한 것
		일반 자료형 대신 Wrapper class 를 이용하는 이유
		1. 객체 또는 클래스가 제공하는 메소드 사용 ( 메소드 == 실행 가능한 함수)
		2. 클레스가 제공하는 상수사용
		3. 숫자, 문자로의 형변환 또는 진법 변환시 사용
		
		일반 자료형	wrapper class
		boolean		Boolean
		
		byte		Byte
		short		Short
		int			Integer  ----  기억 ★★★
		long		Long
		
		float		Float
		double		Double	-----  기억 ★★★
		
		char		Character
		char[]		String	----  기억 ★★★
		
		String 
		숫자 == > 문자열
		String.valueOf('1') -> "1"
		String.valueOf(12) -> "12"
		String.valueOf(12.345) -> "12.345"
		
		12 + "";
		12.345 + "";

		
		*/
		
		// Integer == int 동일하게 사용을한다
		
		int i = 12;
		Integer iobj = 34;
		Integer _iobj = new Integer(i);
		
		int num = iobj.intValue();
		int _num = iobj;
		
		System.out.println("_num =" + _num); // 사실상 Integer를 int 처럼 사용할수 있다. 그래서 별로 쓰는 방식은 상관없다
		
		// 숫자 -> 문자열 	toString()
		String  nstr = iobj.toString(); // 문자열로 변형이 되어서 넘어간다. 34 -> "34"
		nstr = iobj + ""; // 이것도 숫자를 문자열로 바꿔줄때 사용한다
		
		// 문자열 -> 숫자
		String numStr = "234";
		int number = Integer.parseInt(numStr); // 숫자가 되어서 넘어온다 parseInt 자주사용함
		System.out.println(number + 11);
		
		//실수
		Double d = 234.5678;
		Double d1 = new Double(345.6789);
		double dd = d;
		
		// 실수를 문자열로 바꿔주는
		String sd = d.toString(); 
		sd = d + "";
		
		// 문자열 -> 숫자
		
		String dStrNum = "56.78";
		double d2 = Double.parseDouble(dStrNum);
		
		System.out.println((d2 +11));
	
	
	// integer.parseint 문자열에서 숫자로 바뀌고 엄청 많이 사용된다 단 Integer.parseint 사용전에 문자열에 "123"이런식이 아닌 "123A"  처럼 문자가 끼어있으면 오류를 일으킨다.
	
	}

	
}
