package project22;

public class 메소드1_전달O_반환O {

	// 매개변수로 받고 반환해서 되돌아오는 함수.
	static char func(char b, int num) {
		
		char result;
		result = (char) (num+b);
		// char 2byte int 4byte
		int num = 1;
		double num2 = 1.1;
		int cal = (int) (num * num2);
		return result;
	}
	
	
	public static void main(String[] args) {

		// 'a'에서 1을더한 아스키코드로 된 문자를 반환받아서 출력한다.
		int num;
		System.out.println("결과물 : " + func('a',num));
		func(b, num)
		
	}
}
