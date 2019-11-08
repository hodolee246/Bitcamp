package study4;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		/*
			저번주 복습
			
			java == OPP (Object Oriented Program)
			
			기본 자료형
			숫자
			byte	1 byte	== 8 bit 0000 0000
			short	1 byte
			int		4 byte
			long	8 byte (long 사용시 L 를 붙여야 long 으로 인식을 한다)
			
			float 	4 byte
			double 	8 byte
			
			문자
			char 	2 byte
			String	? byte length()
			
			true/false
			boolean 1 byte (딱히 바이트는 중요하지않음)
			
			Array(배열)
			: 같은 자료형 변수의 묶음
			
			int iArray[] = new int[10]; (처음부터 할당), (new 가 나올경우 동적 할당이다.)
			동적 할당 10
			int iArray[]; (배열의 숫자가 정해지지 않을경우)
			iArray = new int[5] 동적할당 5
			정적사용 -> 0 ~ 4 -> 5X
			
			자료형 변환	char -> int
			
			char ch = 'A' ;  출력시 A
			System.out.println(ch); -> A
			System.out.println((int)ch); -> 65  (아스키 코드로 변환되어서 나온다)
			
			int num = (int)ch; -> 자동 형변환
			
			byte by = (byte)num;	강제(cast) 형변환
			
			int num1 = 3, num2 = 2;
			double avg = num1 / num2 ; = 1.0
			double avg = (double)num1 / num2;  = 1.5 (앞에 숫자가 매인 숫자이므로 앞만 형변환 시켜도 정상적으로 작동한다.)
			
			// 영어 대문자를 -> 영어 소문자
			// A == 65 a == 97  
			
			 
		*/
			char c = 'A';
			int n = c;
			System.out.println(c);
			n = n + 32;
			c = (char)n;
			System.out.println(c);
			
			// toUpperCase, toLowerCase
			
			String str = "abc" ;
			
			for(int i = 0; i < str.length(); i++) {
				int cn = (int)str.charAt(i);
				System.out.print((char)(cn - 32));
			}
		
		
			//if
			int number = 5;
			
			if(number > 0) { // 조건 안에는 논리연산 true / false
				// 조건이 사실이면 이 블록 안에 처리가 실행된다.
			}
			
			// &&(AND), ||(OR) !(NOT)
			if(number > 0 && number < 10) {
				// number가 0보다 크고 10보다 작을때 둘다 참일경우 이 블록이 실행된다.
			}
			
			if(number < 0 || number > 10) {
				// number 가 0보다 크거나 10보다 클경우 이 블록이 실행된다.
			}
			
			if(!(number < 0 || number > 10)) { // 이렇게 왠만하면 안적는다.
				
			}
			if(number >= 0 && number <= 10) {
				
			
				
			boolean b = true ;
			
			if( b == true ) { // 이렇게 적어도 되고
				
			}
			if( b ) { //이렇게 적어도 된다 (if(b) == b일경우
				
			}
			
			b = false ;
			if( b == false) {
				
			}
			if( !b ) {
				
			}
			
			
			// 조건분기를 할수있는 if 문과 else if 문이 있다.
			
			if(number > 0 && number <= 10) { // 0 ~ 10
			}
			else if (number > 10 && number <= 20) { // 10 ~ 20
			}
			else if (number > 10 && number <= 30) { // 10 ~ 30
			}
			
			// switch
			switch(number) { //switch문 을 사용할때 조건이 범위가 되면 안된다 1~30, 실수를 사용할수없다
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default :
				break;
			}
			// loop(순환문) for, while, do while 3가지가 있다.
				
			for(int y ; y < 10; y++) {
			}
			for(int i = 5 ; i < 10; i++) {	
			}
			for(int i ; i >10; i--) {
			}
			
			for (int i=0; i < 10; i++) {
				for( int j = 0; j < 5; j ++) {
					
				}
			}
			
			int w;
			w = 0 ;
			while (w < 10) {
				// 처리 포문은 초기값이 제어문 안에 있지만 while 문은 조건식 하나밖에 없다.
				w++;
			}
			
			int w1, w2;
			w1 = w2 = 0;
			while(w1 < 10) {
				w2 = 0; // while 문은 for 문이랑 다르게 초기화를 먼져 한 뒤에 while 문이 돌아가기 때문에 while 문을 작성하기전에 먼져 초기화를 시켜야한다.
				while(w2 < 5) {
					
					w1 ++;
				}
				w2 ++;
			}
			
			// do while ( while 문은 실행이 한번도 되지 않게 만들수 있지만
			// do while 문은 한번은 실행이 되기 때문에 사용 빈도가 많이 낮다.)
			int w3 = 0;
			do {
				// 처리 
				w3++;
			}while(w3 > 10);
			
			while(w3 > 10) {
				
			}
			
			// Application
			
			// initialize(초기화)
			
			// loop(프로그램 실제  처리)
			//while(true) {
			}
			// release(해방) - 동적할당  -> delete 
			// 원래라면 위 과정대로 만들고 삭제해줘야하는데 삭제를 거의다 까먹는다. 계속 메모리 사용시 결국 다운된다. 하지만 자바에서는 자동으로 해준다 그게 아래에서 설명하는 가비지 컬렉터이다.
			int arr[] = new int[3];
			//delete arr; -> 자바에서는 사라졌음 (하지만 가비지 컬렉터가 자동으로 삭제해주고 있다)
			
			// break; + for, while( 루프문이랑 같이 사용한다)
			
			int _number[] = {11, 22, 33, 44, 55 };
			for(int i = 0; i< _number.length; i++) {
				if(_number[i] == 33) { // 찾은후 계속해서 루프를 돌릴 이유가 없기 때문에 break 를 걸어서 빠져 나오게 된다. 이게 실행되지 않으면 프로그램 규모가 커지면 시간이 길어진다. 
					break;
				}
			}
			
			// loop -> break 루프문 하나당 브레이크가 적용되는건 하나다
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 5; j++) {
					if( i == 5 && j == 3) {
						break; // 이럴경우 두번째 for문 만 break 로 탈출하고 첫번째 포문은 계속 돌아간다 
					}
					
				}
			}
			
			
			boolean bo = false ;
			for (int i = 0; i < 10; i++) {
				
				for ( int j = 0; j < 5 ; j++) {
					if( i == 5 && j == 3) {
						bo = true;
					}
					if(bo ==true) {
						break;
					}
				}
				if(bo) {
					break;
			}
			
			}
			
			loopout:for( int i = 0; i < 10; i++) {
				
				for(int j = 0; j < 10; j++) {
					 if(i == 5 && j == 3) {
						 break loopout;
					 }
				}
			}
			
			
			// continue (skip == 생략)  loop문 없이 사용을 할수없다 (break 랑 똑같음)
			Scanner scan = new Scanner(System.in);
			
			// num < 0  다시 입력하세요
			int w = 0 ;
			int myNum ; 
			while (w < 5) {
				System.out.print((w + 1) + "번째 수 :");
				myNum = scan.nextInt();
				if(myNum < 0) {
					System.out.println("음수를 입력하셨습니다. 다시 입력해주세요");
					continue; // 음수를 입력시 메세지만 나오고 w++는 생략을 하고 다시 while 문을 돌린다.
				}
				
				w++;
			}
			/*
			 
			 	
			 
			 
			 
			 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
