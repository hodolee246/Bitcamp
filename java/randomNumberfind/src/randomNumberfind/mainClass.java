package randomNumberfind;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		
		Scanner scan =new Scanner(System.in);
		
		
		// random number 찾기
		// 선언부
		int ran_num, user_num;
		boolean clear;
		
		
		// init(초기화)
		clear = false ;
		
		// 1. 랜덤 넘버를 설정을 한다.
		ran_num =(int)(Math.random() * 100) + 1;
		
		System.out.println(ran_num);
		// loop start 10번
		int w = 0;
		while(w <10) {
		// 2. 사용자 지정 숫자를 받는다.
		while(true) {
		System.out.println("숫자를 입력해 주세요(1~100):");
		user_num = scan.nextInt();
		
		if(user_num < 1 || user_num > 100) {
			
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			continue;
		}
		break;
	}
		// 3. 랜덤 넘버와 사용자 지정숫자를 비교를 한다.
		int msg = 0;
		
		if(user_num > ran_num) {
			msg = 1;	
		}else if(user_num < ran_num) {
			msg = 2;
		}
		else if(user_num == ran_num){
			clear = true;
			break;
		
		}
		// 4. 출력을 한다
		switch(msg) {
			case 1:
				System.out.println("숫자가 너무 큽니다.");
				break;
			case 2:
				System.out.println("너무 작습니다.");
				break;
		}
			w++;
		}
		// loop end
		
		// 5. 피드백을 해준다.
		if(clear == true) {
			System.out.println("축하드립니다. 정답입니다.");
		}
		else {
			System.out.println("아쉽게도 기회가 끝났습니다. 오답입니다.");
		}
		}
	
	}


