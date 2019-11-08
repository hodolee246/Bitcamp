import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		
		/*
		 * Scanner scan = new Scanner(System.in);
		 * 
		 * 
		 * int num1, num2, num3; int b, s ; b = s = 0; String game; int userNum[] = new
		 * int[3]; int comnum[] = new int[3]; int user_Num = 0; num1 = num2 = num3 = 0;
		 * while(true) {
		 * 
		 * 
		 * while(true) { num1 = (int)(Math.random()*9+1); num2 =
		 * (int)(Math.random()*10); num3 = (int)(Math.random()*10); if(num1 != num2 &&
		 * num2 != num3 && num1 != num3) {
		 * 
		 * comnum[0] = num1; comnum[1] = num2; comnum[2] = num3;
		 * 
		 * break ; } } System.out.print(comnum[0]); System.out.print(comnum[1]);
		 * System.out.print(comnum[2]); out:for (int k = 1; k < 11; k++) { s = b = 0;
		 * 
		 * System.out.println("숫자를 입력해 주세요"); user_Num = scan.nextInt(); userNum[0] =
		 * user_Num / 100; userNum[1] = user_Num / 10 % 10; userNum[2] = user_Num % 10;
		 * 
		 * for (int i = 0; i < comnum.length; i++) {
		 * 
		 * for (int j = 0; j < userNum.length; j++) { if(comnum[i] == userNum[j] && i==
		 * j) { s++;if(s == 3) { System.out.println("정답입니다."); break out; } } else
		 * if(comnum[i] != userNum[i] && comnum[i] == userNum[j]) { b++; }
		 * 
		 * } }
		 * 
		 * System.out.println(s+"스트라이크"+b+"볼 입니다."); System.out.println(10-k +
		 * "번 남았습니다.");
		 * 
		 * 
		 * 
		 * } System.out.println("게임을 계속 하시려면 아무 문자나 입력해 주시고 그만하실 경우 (n)입력을 바랍니다."); game
		 * = scan.next(); if(game.equals("n") || game.equals("N")) {
		 * System.out.println("수고하셨습니다."); break; } }
		 */
	
			/*	
			int b1, b2, b3 ;
			b1 = b2 = b3 = 0;
			int user = 0 ;
			for (int i = 0; i < i+1; i++) {

			b1 = (int)((Math.random()*8)+1);
			b2 = (int)(Math.random()*9);
			b3 = (int)(Math.random()*9);
			
			if(b1 != b2
			&& b2 != b3
			&& b1 != b3) {
				break;
			}
			
			String _b1 = String.valueOf(b1);
			String _b2 = String.valueOf(b2);
			String _b3 = String.valueOf(b3);
			
			}
				for (int i = 0; i < 10; i++) {
					System.out.println("숫자 3개를 입력해 주세요");
					user = scan.nextInt();
				String _user = String.valueOf(user);
				char sb = _user.charAt(0);
				char sb1 = _user.charAt(1);
				char sb2 = _user.charAt(2);
				
				if(_user.equals(sb)) {
					
				}
				
				
				
				}
				
				*/
			
			
				int r_num[] = null; //변수 초기화
				boolean clear; // 불린형으로 트루, 펄스로 클리어 여부를 구분하기 위해서 사용한다.
				// 이 2개는 다른 함수에서도 사용하기때문에 메인에서 선언을한다.
			// init(초기화)
				// 변수 초기화 (2개 이상의 함수에서 사용할 변수는 메인에도 선언이 되있어야 한다.
				
				r_num = new int[3];
				clear = false;
				
				// random
			bRandom(r_num);
			// loop(실프로그램)
				// 이번 숫자야구 같은경우는 기회제한이 있기 때문에 10번으로 제한하지만 보통은 무한루프를 돌리는 프로그램이 많다.
				// user input
			userInput(u_num);
				// Strike or Ball (equlas)
				// message output
			// printing(결과 출력)
			// release(해방)
				// 사실상 release 부분은 프로그래머가 하기 보다는 쓰레기 수집가가 자동으로 처리해준다.
	
	
	}

	
	static void bRandom(int r_num[]) { // 함수내 매개변수는 가변수이기 때문에 딱히 이름을 맞출 필요는 없다.
		boolean swit[] = new boolean [10];
		int r, w;
		
		for (int i = 0; i < swit.length; i++) {
			swit[i] = false; // 
		}
		
		w = 0 ;
		while(w<r_num.length) {
			r = (int)(Math.random()*10);
			if(swit[r] == false) {
				swit[r] = true;
				r_num[w] = r + 1;
 			}
			for (int i = 0; i < r_num.length; i++) {
				System.out.println(r_num[i]);
			}
		}
	
	}
	static boolean loop(int r_num) {
		int u_num[] = new int[3];
		
		// user input (숫자 3자리)
		// 판별 Strike 인지 Ball인지 만약 맞추지 못하면 몇S 몇B 인지 확인 후 출력문
		
	}
	static void userInput(int u_num[]) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			for (int i = 0; i < u_num.length; i++) {
				System.out.println((i+1) "번째 수");
				u_num[i] = sc.nextInt();
			}
			if(u_num[0] !
					&& u_num[1] != u_num[2]) {
				break;
			}
		}
	}
	static boolean finding(int u_num[], int r_num[]) {
		int strike, ball;
		strike = ball = 0;
		// ball
		for (int i = 0; i < u_num.length; i++) {
			for (int j = 0; j < r_num.length; j++) {
				if(u_num[i] == r_num[j] && i != j) {
					ball++;
				}
			}
			
			if(u_num[i] == r_num[i]) {
				strike ++;
			}
		}
		
		if(strike > u_num.length - 1) {
			return true;
			
		}
		
		System.out.println(strike + "스크라이크" + ball+"볼");
		
		return false;
	}
}
