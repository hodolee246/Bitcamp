package number21016;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		/*
		  		int		String
				10진수 -> 2진수
				3		11
				
					10		%
				2 /  5	------> 0
				2    2  ------> 1
				2    1  ------> 0
				2    0  ------> 1	1010	
				
			2진수 -> 10진수			
			10진수 -> 16진수
			16진수 -> 10진수			
		*/
		/*
		int number10 = 56;
		String number2 = "";
		// number2 = number10to2( number10 );
		number2 = Integer.toBinaryString(number10);
		System.out.println("10진수 " + number10 + "의 2진수는 " + number2 + "입니다");

		int num10;
		// num10 = number2to10(number2);
		num10 = Integer.parseInt(number2, 2);
		System.out.println("2진수 " + number2 + "의 10진수는 " + num10 + "입니다");
		
		String number16;
		// number16 = number10to16(number10);
		number16 = Integer.toHexString(number10);
		System.out.println("10진수 " + number10 + "의 16진수는 0x" + number16 + "입니다");
		
		// num10 = number16to10(number16);
		num10 = Integer.parseInt(number16, 16);
		System.out.println("16진수 0x" + number16 + "의 10진수는 " + num10 + "입니다");
		*/
		
		// 수치 변환 프로그램
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("1. 10진수 -> 2진수");
			System.out.println("2. 2진수 -> 10진수");
			System.out.println("3. 10진수 -> 16진수");
			System.out.println("4. 16진수 -> 10진수");
			System.out.println("5. 2진수 -> 16진수");
			System.out.println("6. 16진수 -> 2진수");
			
			System.out.print("어떤 수치를 변환하시겠습니까? = ");
			choice = sc.nextInt();
			int n_um = 0;
			String snum = "";
			String snum2 = "";
			switch(choice) {
				case 1:
					// 10진수 입력
					System.out.print("");
					int num = sc.nextInt();
					String num2 = number10to2(num);
					System.out.println("2진수는 " + num2 + "입니다");
					break;
				case 2:
					System.out.println("");
					snum = sc.next();
					n_um = number2to10(snum);
					System.out.println("10진수는 " + n_um);
					break;
				case 3:
					System.out.println("");
					snum = sc.next();
					snum = number10to16(n_um);
					System.out.println("16진수는" + n_um);
					break;
				case 4:
					System.out.println();
					snum = sc.next();
					n_um = number16to10(snum);
					System.out.println("10진수는" + n_um);
					break;
				case 5:
					System.out.println();
					snum = sc.next();
					n_um = number2to10(snum);
					snum = number10to16(n_um);
					System.out.println("16진수는" + snum);
					break;
				case 6:
					System.out.println();
					snum = sc.next();
					n_um = number16to10(snum);
					snum = number10to2(n_um);
					System.out.println("2진수는 "+snum);
					break;
			
			}		
		}
		
		
		
	}
	// 10진수 -> 2진수
	static String number10to2(int num) {		
		String num2 = "";
		int tag;				
		while(true) {
			tag = num % 2;
			System.out.println("tag = " + tag);
			num2 = tag + num2;	// 1010			
			if(num / 2 == 0) {
				break;
			}
			num = num / 2;
		}		
		return num2;
	}
	
	// 2진수 -> 10진수
	static int number2to10(String num2) {
		int len = num2.length();
		int n, n1;	// n:숫자  n1:승수
		
		int num10 = 0;
		
		for(int i = 0;i < num2.length(); i++) {	// 1010
			char c = num2.charAt(i);	// 1 0 1 0
			n = Integer.parseInt(c + "");	// 1
			n1 = (int)Math.pow(2, len - 1);	// 2의 3승
			
			n = n * n1;	// 1 * 2의 3승
			len--;
			
			num10 = num10 + n;
		}
		return num10;
	}
	// 10진수 -> 16진수
	static String number10to16(int num) {	// 0 ~ 9 a b c d e f		
		int tag;
		String num16 = "";
		String str = "";	// a b c d e f
		
		while(true) {
			tag = num % 16;
			
			switch(tag) {
				case 10:
					str = "A";
					break;
				case 11:
					str = "B";
					break;
				case 12:
					str = "C";
					break;
				case 13:
					str = "D";
					break;
				case 14:
					str = "E";
					break;
				case 15:
					str = "F";
					break;
				default:	// 0 ~ 9
					str = tag + "";
			}
			num16 = str + num16;			
			if(num / 16 == 0) {
				break;
			}
			num = num / 16;
		}
		return num16;
	}
	
	// 16진수 -> 10진수
	static int number16to10(String num16) {		
		int len = num16.length();
		
		String str;
		int n = 0;	// 승수
		int n16;	// 하나씩 산출한 숫자		A132	10 1 3 2
		int num10 = 0;
		
		for (int i = 0; i < num16.length(); i++) {
			
			char c = num16.charAt(i);
			
			if(c == 'a' || c == 'A')		n16 = 10;
			else if(c == 'b' || c == 'B')	n16 = 11;
			else if(c == 'c' || c == 'C') 	n16 = 12;
			else if(c == 'd' || c == 'D') 	n16 = 13;
			else if(c == 'e' || c == 'E') 	n16 = 14;
			else if(c == 'f' || c == 'F')	n16 = 15;
			else { 	// 0 ~ 9
				n16 = Integer.parseInt(c + "");
			}
			
			n = (int)Math.pow(16, len - 1);
			n16 = n16 * n;	// 산출한 숫자에 승수를 곱한다.
			len--;
			
			num10 = num10 + n16;			
		}
		return num10;	
	}
	

}






