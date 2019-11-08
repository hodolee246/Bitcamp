package bit;

public class mainClass {

	public static void main(String[] args) {

		
		// AND
		
		int number;
		number = 0x71 & 0xb5;
		
		/*
		 
		 		8421 8421
		 		0111 0001
		 		1011 0101
		 		
		 		0011 0001  -> 0x31 
		 
		 */

			System.out.println("number =" + number);
			System.out.printf("0x%x" + "\n" , number);
			
			// OR
			/*8421 8421
	 		0111 0001
	 		1011 0101
	 		
	 		1111 0101  -> 0xFA
	 		*/
			number = 0x71 | 0xb5;
			System.out.println("number =" + number);
			System.out.printf("0x%x" + "\n" , number);
			
			// XOR
			
			/*
			 
	 		8421 8421
	 		0111 0001
	 		1011 0101
	 		
	 		1100 0100  -> 0xC4
	 */
			
			number = 0x71 ^ 0xb5;
			System.out.println("number =" + number);
			System.out.printf("0x%x" + "\n" , number);
			
			// Left shift
			
			/*                   *2  == left shift
				0001	-> 1
				0010	-> 2
				0100	-> 4
				1000	-> 8
			*/
			
			// Right shift
			/*                         /2 == Right shift
			  1000	-> 8
			  0100	-> 4
			  0010	-> 2
			  0001	-> 1
			*/
			number = 0x1 << 2;
			System.out.println("number =" + number);
			
			// ~ (반전) 계산기 사용 추천 0-> 1 | 1-> 0
			/*
				0101 0101 -> 1010 1010
			*/
			number = ~0x55; // 0x55 가 0000 0000(1byte)*3 0101 0101 인데 이걸 ~ 시켜서 1111 1111 *3 1010 1010 이되어서 값이 ffffffaa 가출력이된다.
			
			System.out.printf("0x%x" + "\n" , number);
			
			byte by;
			
			by = ~0x55;
				System.out.printf("0x%x" + "\n" , by);
				
			//  삼항 연산자
			/*	
				
				value = (조건)? 값1 : 값2
				조건 참 = 값1
				조건 거짓 = 값2
				
			*/	
				char c;
				int num = 5 ;
				c = (num > 0)?'Y':'N';
				System.out.println("c = " + c);
				
				
				
				int n=(num != -1)?100:200;
				System.out.println("n = " + n);
				
				String str = (num <= 0)?"0보다 작습니다.":"0보다 큽니다.";
				System.out.println("str = " + str);
				
				String abc = (num == 5)?"안녕하세요":"반갑습니다.";
				
				System.out.println("abc = " + abc);	
				
			
	}

}
