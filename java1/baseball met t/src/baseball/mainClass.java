package baseball;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		
		// baseball
		
		// 선언부
		int r_num[], u_num[];
		boolean clear;
		
		/////////////////////////////////// replay
		
		// 초기화		
		r_num = new int[3];
		u_num = new int[3];
		clear = false;		
		
		// 1. random number(1 ~ 10) -> 3개 
		//		n1 != n2 != n3		
		boolean swit[] = new boolean[10];	
		int r, w;
		
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false;		// 00000 00000
		}		
		w = 0;
				
		while(w < u_num.length) {		
			r = (int)(Math.random() * 10);	// 0 ~ 9
			if(swit[r] == false) {
				swit[r] = true;
				r_num[w] = r + 1;	// 1 ~ 10
				w++;
			}
		}
		
		for (int i = 0; i < r_num.length; i++) {
			System.out.println("r_num[" + i + "] = " + r_num[i]);
		}
		
		w = 0;
		//////////////////////////////////	loop 10회
		while(w < 10) {
			
			// 2. user input(1 ~ 10) -> 3개
			//		u1 != u2 != u3
			while(true) {			
				for(int i = 0;i < u_num.length; i++) {
					System.out.print((i + 1) + "번째 수:");
					u_num[i] = sc.nextInt();
				}			
				if(u_num[0] != u_num[1] 
						&& u_num[0] != u_num[2]
						&& u_num[1] != u_num[2]) {
					break;
				}			
				System.out.println("같은 숫자가 있습니다. 다시 입력하십시오");
			}
			
			int strike, ball;
			// 3. finding(strike, ball)			
			strike = 0;
			ball = 0;
			// ball
			for (int i = 0; i < u_num.length; i++) {			
				for (int j = 0; j < u_num.length; j++) {
					if(u_num[i] == r_num[j] && i != j) {
						ball++;
					}
				}			
			}
			
			// strike
			for (int i = 0; i < u_num.length; i++) {
				if(u_num[i] == r_num[i]) {
					strike++; 
				}
			}
			
			if(strike > u_num.length - 1) {
				clear = true;
				break;
			}
			
			// 4. message(printing)
			System.out.println(strike + "스트라이크 " + ball + "볼 입니다");
			
			w++;
		}
		//////////////////////////////////
		
		// 5. result(clear, no good)
		if(clear) {
			System.out.println("축하합니다");
		}
		else {
			System.out.println("아쉽습니다. 다시 도전하세요");
		}
		*/
		
		int r_num[] = null;
		boolean clear;
				
		// init(초기화)
		// 변수 초기화
		r_num = new int[3];
		clear = false;
		
		// random
		bRandom(r_num);		
		
		// loop(실프로그램)
			// user input
			// strike, ball
			// message
		clear = loop(r_num);
		
		// printing(결과 출력)
		resultPrint(clear);
				
		// release(해방)

	}
	
	static void bRandom(int r_num[]) {
		boolean swit[] = new boolean[10];	
		int r, w;
		
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false;		// 00000 00000
		}
		
		w = 0;
		while(w < r_num.length) {		
			r = (int)(Math.random() * 10);	// 0 ~ 9
			if(swit[r] == false) {
				swit[r] = true;
				r_num[w] = r + 1;	// 1 ~ 10
				w++;
			}
		}
		
		for (int i = 0; i < r_num.length; i++) {
			System.out.println("r_num[" + i + "] = " + r_num[i]);
		}
	}
	
	static boolean loop(int r_num[]) {
		int u_num[] = new int[3];
		boolean clear = false;
		int w = 0;
		
		////////// loop
		while(w < 10) {
			// user input
			userInput(u_num);
					
			// 판별 strike, ball		
			// 메시지 출력
			clear = finding(u_num, r_num);
			if(clear == true) break;
			w++;
		}
		///////////////////
		return clear;
	}
	
	static void userInput(int u_num[]) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {			
			for(int i = 0;i < u_num.length; i++) {
				System.out.print((i + 1) + "번째 수:");
				u_num[i] = sc.nextInt();
			}			
			if(u_num[0] != u_num[1] 
					&& u_num[0] != u_num[2]
					&& u_num[1] != u_num[2]) {
				break;
			}			
			System.out.println("같은 숫자가 있습니다. 다시 입력하십시오");
		}
	}
	
	static boolean finding(int u_num[], int r_num[]) {
		int strike, ball;		
		strike = ball = 0;
		
		// ball, strike
		for (int i = 0; i < u_num.length; i++) {			
			for (int j = 0; j < u_num.length; j++) {
				if(u_num[i] == r_num[j] && i != j) {
					ball++;
				}
			}		
			
			if(u_num[i] == r_num[i]) {
				strike++; 
			}
		}		
		
		if(strike > u_num.length - 1) {
			return true;
		}
		
		// 4. message(printing)
		System.out.println(strike + "스트라이크 " + ball + "볼 입니다");
		
		return false;
	}
	
	static void resultPrint(boolean clear) {
		
		if(clear) 	System.out.println("축하합니다");
		else 		System.out.println("아쉽습니다. 다시 도전하세요");		
	}
	

}






