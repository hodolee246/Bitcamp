package study3;

import java.util.Scanner;

public class classMain {

	public static void main(String[] args) {
		
		
		/*

			&	(AND)			1 * 1 = 1
			|	(OR)			1 + 1 = 1
			^	(XOR)			1(+)1 = 1
			<<	(Left Shift)	*2	0001 0010
			>>	(Right Shift)	/2	1000 0100
			~	 0 -> 1	1 -> 0

		
		
		int number;
		number = 5;            
		number = number << 4;	// 0101 0000
		
		System.out.println("number = " + number);
		
		number = number >> 5;	// 0000 0010
		
		System.out.println("number = " + number);
		
		int num1, num2;
		
		num1 = 128;		// 1000 0000	0x80
		num2 = 56;		// 0011 1000	0x38
		
	//	num1 = (num1 & num2) | (num1 & num2);
		num2 =~(num1 ^ num2);
		
		System.out.println("num1 = "+num1);
		
		System.out.println("num2 = "+num2);
		
		// 1000 0000
		// 0011 1000
		// 1011 1000
		// 0100 0111
		
		System.out.println("Num2 = " + num2);
		
		Scanner sc = new Scanner(System.in);
		
		int inNum;
		
		String numName;
		
		System.out.println("숫자 입력");
		
		inNum = sc.nextInt();
		
		numName = (inNum > 0)? "양수":"음수";
		
		System.out.println("입력하신 숫자는 " +numName + "입니다.");
		
		
		int ran;
		
		int array[] = new int [5];
		int array2[] = {3, 7, 9, 13, 15};
		
		// 0 ~ 99 숫자중 하나를 랜덤으로 출력
		
		ran = (int)(Math.random()*100) ;
		
		System.out.println("랜덤 숫자의 값 = " + ran);
		
		// 11 ~ 15 숫자중 하나를 랜덤으로 출력
		
		ran = (int)(Math.random()*5)+11 ;
		
		System.out.println("랜덤 숫자의 값 = " + ran);
		
		// 3, 7, 9, 13, 15 숫자중 하나를 랜덤으로 출력
		
		ran =(int)(Math.random()* array2.length);

		System.out.println(array2[ran]);
		
		
		*/
		// ~   int = 4byte
		
		// int a  = 14
		//    0000
		//    1110 ~
		// 0000 0000 0000 0000 0000 0000 0000 1110 = 14 
		// 1111 1111 1111 1111 1111 1111 1111 0001 =10
		// 0xf     f    f    f   f    f    f    1
		
		
		/* IF (만약)
		   if (조건)
		   if (조건)
		   else
		   
		   if(조건1)
		   else if(조건2)
		   
		 	조건문안에조건문
		 	if( )
		 	{
		 	 if( )
		 	 {
		 	 
		 	 }
		 	 else
		 	 {
		 	 }
		 	 }
		 	
		 	if ( 논리연산 ) ex) == >= <= > < != ...
		 	x >= 0 && y <= 0  x <= 0 || x >= 10
		 	x > 20 && str == false  
		  
		*/
		
		
		
		
		
		
		
		
	}

}
