package ball;

import java.util.Scanner;

public class baseball {
	
	// 변수
	
	int r_num[], u_num[];
	boolean clear;

	
	// 메소드
	
	public void init() {
		r_num = new int[3];
		u_num = new int[3];
		clear = false;
		// 초기화를 메소드 안이 아니라 밖에서 했더라면 한번밖에 안되지만 밖에서 생성하면 
		// 메소드 하나로 초기화가 가능하다...
		
		random();
	}
	
	public void random() {	// r_num[3]
			boolean swit[] = new boolean[10];
			int w, r;
			
			w = 0 ;
			while(w < 3) {
				r = (int)(Math.random()* 10) +1;
				if(swit[r] == false) {
					swit[r] = true;
					r_num[w] = r + 1 ;
					w++;
				}
			}
			
			for (int i = 0; i < r_num.length; i++) {
				System.out.println(r_num[i] + " ");
			}
			System.out.println();
	
	}
	
	public void loop() {	// r_num[3], u_num[3], clear 
		int w = 0;
		int strike, ball;
		
		while(w < 10) {
			
			userInput();
			
			// Strike
			
			
			ball = 0;
			for (int i = 0; i < u_num.length; i++) {
				for (int j = 0; j < r_num.length; j++) {
					if(u_num[i] == r_num[j] && i != j) {
						ball++;
					}
				}
			}
			strike = 0;
			for (int i = 0; i < u_num.length; i++) {
				for (int j = 0; j < r_num.length; j++) {
					if(u_num[i] == r_num[j] ) {
						strike++;
					}
				}
			
			}
			
			if(strike > 2) {
				clear = true;
				break;
			}
			System.out.println(strike + " 스트라이크" + ball + " 볼 입니다.");
			
			w++;
		}
	}
	
	private void userInput() {	// u_num[3]
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < u_num.length; i++) {
			System.out.println((i + 1) + "번째 수:");
			u_num[i] = sc.nextInt();
		}
		
		
	//	sc.close();
		
	}
	
	public void result() {	// clear
		if(clear == true) {
			System.out.println("추카드립니다. 게임에 이기셨습니다.");
		}else {
			System.out.println("저런... 게임에 이기지 못했습니다.");
		}
	}
}
