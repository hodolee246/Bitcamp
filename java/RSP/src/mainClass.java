import java.util.Scanner;

import javax.swing.SwingConstants;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*
		int com, user = 0;
		int w, l ;
		w = l = 0;
		int loop = 0;
		String cho;
		
	for (int y = 0; y < y+1; y++) {
			System.out.println("가위바위보 게임입니다. 하시겠습니까?(Y, N)");
			cho = scan.next();
			if(cho.equals("N")
					|| cho.equals("n")) {
				
				break;
			}
	out:for (int i = 0; i < i+1; i++) {
		com = (int)(Math.random()*3);
		System.out.print("0[가위], 1[바위], 2[보] ");
		System.out.println(" 3개중 하나를 입력해 주세요");
		user = scan.nextInt();
		
		int ma = 0;
		
		if(user < 0 || user > 2) {
			System.out.println("잘못 입력하셨습니다.");
		}
		else if(com == user) {
			System.out.println("비기셨습니다.");
			
		}
		else if((com + user !=2 && user > com)
				|| (com == 2 && user == 0)) {
			System.out.println("이기셨습니다.");
			w++;
			break out;
		}
			else {
				System.out.println("패배하셨습니다.");
				l++;
			}
		
		}
			
	}	
		System.out.println(w+"승"+l+"패 입니다.");
		System.out.println("안녕히 가세요");

		
		*/
		
		
		// 선언부 
		int userNum, comNum;
		int win, lose, draw;
		int result; // 승패무승부
		
		// 초기화
		win = lose = draw = 0;
		while(true) {
		// 1. 컴퓨터 랜덤숫자 출력(0~2)
		comNum = (int)(Math.random()*3);
		System.out.println(comNum);
		// 2. 유저가 숫자 입력(0~2)
		System.out.print("가위(0), 바위(1), 보(2) = ");
		userNum = scan.nextInt();
		// 문자열 -> 숫자
	//	userNum = Integer.parseInt(userInput);
		// 3. finding
		
		
		/*
		if(userNum ==  0 && comNum ==2) {
			result = 0;
		}else if(userNum == 1 && comNum ==0) {
			result = 0;
		}else if(userNum == 2 && comNum ==1) {
			result = 0;
		}
		//lose
		if(userNum ==  2 && comNum ==0) {
			result = 1;
		}else if(userNum == 0 && comNum ==1) {
			result = 1;
		}else if(userNum == 1 && comNum ==2) {
			result = 1;
		}
		//draw
		if(userNum ==  0 && comNum ==0) {
			result = 2;
		}else if(userNum == 1 && comNum ==1) {
			result = 2;
		}else if(userNum == 2 && comNum ==2) {
			result = 2;
		}
		*/
		//공식
		/*
			user win
			com		user
			2	-	0	+	2	=	4 % 3 = 1
			0	-	1	+	2	=	1 % 3 = 1
			1	-	2	+	2	=	1 % 3 = 1
			
			user lose
			com		user
			0	-	2	+	2	=0	% 3 = 0
			1	-	0	+	2	=3	% 3 = 0
			2	-	1	+	2	=3	% 3 = 0
			
			user draw
			0	-	0	+	2	=	2	%	3 ->2
			1	-	1	+	2	=	2	%	3 ->2
			2	-	2	+	2	=	2	%	3 ->2
	
		*/
		result = (comNum - userNum + 2) % 3;
		String resultMsg = "";
		
		switch(result) {
		case 1:	//승
			resultMsg = "You win";
			win ++;
			break;
		case 0:	//패
			resultMsg = "You lose";
			lose ++;
			break;
		case 2:	//무승부
			resultMsg = "Draw";
			draw ++;
			break;
		}
		String userChar = "";
		String comChar = "";
		
		if(userNum == 0) userChar = "가위";
		else if(userNum == 1) userChar = "바위";
		else					userChar = "보";
		
		if(comNum == 0) comChar = "가위";
		else if(comNum ==1) comChar = "바위";
		else				comChar = "보";
		// 4. result(결과 출력)
		
		System.out.println(resultMsg + "으로 당신은" + userChar + "이고 com은 " + comChar + "입니다.");
		
		System.out.println(win + "승"+ lose + "패" +draw+ "무 입니다.");
		
		System.out.println("한판 더? 아무키나 눌러 주십시오. 그만하시려면 n을 입력해 주십시오.");
		
		String nextstage = scan.next();
		
		if(nextstage.equals("n")) {
			System.out.println("안녕히 가십시오,");
			break;
		}
		System.out.println("다시 게임을 시작합니다.");				
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
			
		
		
	}


