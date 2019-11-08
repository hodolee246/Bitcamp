package operator2;

public class mainClass {

	public static void main(String[] args) {
		// 논리연산자 == true / false
		
		/*
		 	&&  : AND   그리고
		 	||  : OR    또는
		 	!   : ~NOT  
		 	if제어문과 같이 많이 사용하는 편
		 	a = b 대입 
		 	a > b
		 	a < b
		 	a >= b
		 	a <= b
		 	a == b
		 
		 */
		int number = 5;
		System.out.println(number == 5);
		System.out.println(number > 5);
		System.out.println(number < 5);
		System.out.println(number >= 5);
		System.out.println(number <= 5);
		
		System.out.println(number > 0 && number < 10);
		System.out.println(number < 0 && number < 10);
		
		System.out.println(number < 0 || number < 10);
		System.out.println(number != 6);
		
		System.out.println(!(number < 0 || number > 10));
		//system.out.println((number >= 0 || number <=10)); 이렇게 변경된다
		
		// 자바에서는 != 밖에 사용을 못한다.
		
	}

}
