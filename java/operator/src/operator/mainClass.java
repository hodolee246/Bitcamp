package operator;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		/* operator (기본연산자) = + - * / %
		
		   operator (고급연산자) bit연산 : & │ ^ << >> ~
		   
		   operator (논리연산자) &&(and) ││(or)!(not) 



*/

			Scanner scan = new Scanner(System.in);
			
			
			int number1, number2;
			int gar;
			
			System.out.print("첫번째 수:");
			number1 = scan.nextInt();
			
			System.out.print("두번째 수:");
			number2 = scan.nextInt();
			
			gar = number1 + number2 ;
			System.out.println(number1 + "+" + number2 + "=" + gar);
			
			System.out.println(number1 + "-" + number2 + "=" +(number1 - number2));
			
		//	number1 *=number2;
			gar = number1 * number2;
			System.out.println(number1 + " * " + number2 + " = " + gar);
			
			gar = number1 / number2; //number2 != 0    나누는 값이 0이 아니어야한다.
			System.out.println(number1 + " / " + number2 + " = " + gar);
			
			gar = number1 % number2;
			System.out.println(number1 + " % " + number2 + " = " + gar);
			
			
			
			
			
	int num1, num2;
	int result;
	
	num1 = 7;
	num2 = 2;
	
	result = num1 + num2 ;
	
	System.out.println(num1 + " + " + num2 + " = " + result);
	
	// a % b -> a 를 b로 나누고 나머지
	
	// Random == 무작위 
	int r;
	r = (int)(Math.random() * 10);  // 0~9
	
	System.out.println("r = "+r);
	
	int inputNumber = 27 % 5 + 1;           // 1~5 
	
	// 1 ~ 10 
	
	r = (int)(Math.random() * 10);  // 0~9
	// 0~9 +1
	System.out.println("r = "+r);
	// 10 20 30 40 50 
	r = ((int)(Math.random() * 5)+1)*10;  // 0~9
	// (0 1 2 3 4 +1) * 10
	System.out.println("r = "+r);
	
	// 사칙연산 / % 주의할점 
	r = 0 / 3;
	System.out.println("r = "+r);
	//r = 3 / 0;  오류가 뜬다
	//System.out.println("r = "+r);
	//r = 3 % 0;  %도 오류가 뜬다.
	//System.out.println("r = "+r);
	
	// 자기 자신을 갱신
	int n;
	n = 0;
	
	n = n+1;
	System.out.println(" n = " + n);
	n = n-1;
	System.out.println(" n = " + n);
	
	n += 1;
	System.out.println(" n = " + n);
	
	// increment(증가연산자)++ == +1,  decrement(감소연산자)-- == -1
	int num3 = 0 ;
	num3 ++;
	System.out.println(" num3 =" + num3);
	++num3;
	System.out.println(" num3 =" + num3);
	num3--;
	System.out.println(" num3 =" + num3);
	int num4;
	
	num4 = num3 ;
	//num4 = num3++; num3 = 2 num4 = 1
	//num4 = ++num3; num3 = 2 num4 = 2
	//num4 = (num3++); num3 = 2 num4 = 1 우선순위가 대입이 첫번째가 된다.
	System.out.println(" num3 =" + num3);
	
	System.out.println(" num4 =" + num4);
	
	
	// -1 0 1 Random             
	// int x = (int)(math,random() * 3)-1;
	// int y = (int)(math,random() * 3)-1;
	
	
	// a, a1 = 1;
	// a++;
	// a1 = a  == 후위 연산자이기때문에 먼져 대입을 한 뒤에 a의 값이 오른다 a1==1
		//	num3 == (num4++)


	
	
	}

}

	