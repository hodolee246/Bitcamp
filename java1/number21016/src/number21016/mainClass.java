package number21016;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("1. 10진수 -> 2진수");
			System.out.println("2. 2진수 -> 10진수");
			System.out.println("3. 10진수 -> 16진수");
			System.out.println("4. 16진수 -> 10진수");
			System.out.println("5. 2진수 -> 16진수");
			System.out.println("6. 16진수 -> 2진수");
			
			System.out.println("어떤 수치를 변환하시겠습니까");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				// 10진수 입력
				System.out.print("10진수:");
				int num = sc.nextInt();
				String num2 = number10to2(num);
				System.out.println("2진수는" + num2 + "입니다.");
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				
			}
		}
		
		
		
	}
		
		/*	int num = 0;
		String result = "";
		String abc = "010101";
		number10to2(33);
		System.out.println();
		number10to16(999);
		number2to10(abc);
		
		number16to10(num16);
		
				int		String
				10진수 -> 2진수
				3      -> 0011
		
					10
				2	5	----->	0
				2	2	----->	1
				2	1			0
				2	0			1
		// 
		
	}*/

/*	static String number10to2(int num) {
 		String result = "";	
 		while(true) {	
 			result = num % 2 + "";
 			num = num / 2;
 			System.out.print(result);
 			if(num == 0)
 				break;
			
		}
 		return result;
	}*/
		
		static String number10to2(int num) {
			String str = "";
			String re = "";
			
			while(true) {
				re = num % 2 + "";
				num = num / 2;
				str = re + str;
				if(num == 0) {
					break;
				}
			}
			for (int i = str.length()-1; i > -1; i--) {
				System.out.print(str.charAt(i));
			}
			
			
			return str;
		}
		
		static String number10to16(int num) {
			String re = "";
			String str = "";
			int ab = 0;
			
			while(true) {
				ab = num % 16 ;
				if( ab == 10 ) {
					re = "A";
				}
				else if( ab == 11 ) {
					re = "B";
				}
				else if( ab == 12 ) {
					re = "C";
				}
				else if( ab == 13 ) {
					re = "D";
				}
				else if( ab == 14 ) {
					re = "E";
				}
				else if( ab == 15 ) {
					re = "F";
				}
				else
					re = ab + "";
				num = num / 16;
				str = str + re;
				if( num == 0) {
					
					break;
				}
			}
			re = "";
			for (int i = str.length()-1; i > -1; i--) {
				char c = str.charAt(i);
				re = re + c;
			}
			str = "0x" + re;
			System.out.println(str);
			
			return str;
		}
			
			static int number2to10(String str) {
				int len = str.length();
				int n, n1;  //n : 숫자 n1 : 승수
				
				int num10 = 0;
				
				for(int i = 0; i < str.length(); i++ ) {
					char c = str.charAt(i); // 
					n = Integer.parseInt(c + ""); // 
					n1 = (int)Math.pow(2, len-1); // 
					n = n * n1; // 1*2의 3승
					len --;
					
					num10 = num10 + n ;
					
				}
					System.out.println(num10);
					return num10;
			}
				
				
				/*int result2 = 0 ;
				int result = 0 ;
				
				for (int i = str.length()-1; i > -1; i--) {
					int y = 0;
					result2 = (((int)str.charAt(i)-48));
					System.out.println(result2);
					result = result + result2 ;
					y ++;
				}
				
				System.out.println(result);
				return result;
			}*/
	/*
	 * static String number10to16(int num) { int tag; String num16 = ""; String str
	 * = ""; // a, b, c, d, e,f
	 * 
	 * while(true) { tag = num % 16;
	 * 
	 * switch(tag) {
	 * 
	 * case 10: str = "A"; break; case 11: str = "B"; break; case 12: str = "C";
	 * break; case 13: str = "D"; break; case 14: str = "E"; break; case 15: str =
	 * "F"; break; default: str = tag + ""; } num16 = str = num16; if(num / 16 == 0
	 * ) { break; } num = num / 16; } return num16;
	 * 
	 * }
	 */
			
			
			// 16진수 ->> 10진수
			static int number16to10(String num16) {
			
				int len = num16.length();
				int n16 = 0; // 하나씩의 숫자를 산출 (A 1 3 2)
				String str;
				int n = 0 ;
				int num10 = 0;
				
				for (int i = 0; i < num16.length(); i++) {
					
					
					char c = num16.charAt(i);
					
					if(c == 'a' || c == 'A') {
						n16 = 10;
					}
					else if(c == 'b' || c == 'B') {
						n16 = 11;
					}
					else if(c == 'b' || c == 'C') {
						n16 = 12;
					}
					else if(c == 'd' || c == 'D') {
						n16 = 13;
					}
					else if(c == 'e' || c == 'E') {
						n16 = 14;
					}
					else if(c == 'f' || c == 'F') {
						n16 = 15;
					}
					else { // 0~9
						n16 = Integer.parseInt(c + "");
					}
					n = (int)Math.pow(16, len - 1);
					n16 = n16 * n; // 산출한 숫자에 승수를 곱한다.
				
					num10 = num10 + n;
				}
				return num10;
			}
			
		






}
	
	
	
	
	
	

