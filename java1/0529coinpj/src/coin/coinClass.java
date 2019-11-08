package coin;

import java.util.Scanner;

public class coinClass {

	Scanner sc = new Scanner(System.in);
	
	private int dice_a;
	private int dice_b;
	private int coin;
	private int user;
	private int usercoin;
	private String stop;
	
	public void init() {
		
		dice_a = (int)((Math.random()*6)+1);
		dice_b = (int)((Math.random()*6)+1);
		coin = 20;
		user = 0;
		usercoin = 0;
		
	}
	
	
	private void batcoin() {
		
		
		System.out.println("배팅할 코인 갯수를 입력해주세요");
		while(true) {
		usercoin = sc.nextInt();
		if(usercoin > coin) {
			System.out.println("현재 코인 갯수 : " + coin);
		}else {
			
			break;
		}
	}
		
		
	}
	
	private void batuser() {
		
		System.out.println("두 주사위 합은?");
		while(true) {
			user = sc.nextInt();
			if(user == 2 || user ==12) {
				System.out.println("2, 12는 입력이 불가능 합니다.");
			}else {
				break;
			}
		}
	}
	
	
	
	public void bating() {
		init();
		
		while(coin > 0) {
			
			
			dice_a = (int)((Math.random()*6)+1);
			dice_b = (int)((Math.random()*6)+1);
			System.out.println(dice_a + dice_b);
			batcoin(); // private 메소드 유저가 코인 배팅
			
			batuser(); // private 메소드 유저가 숫자 입력
			//-------------------------------------
			if((user == 3 && dice_a + dice_b == 3) || (user == 11 && dice_a + dice_b == 11)) {
				System.out.println("18배 입니다.");
				coin = (coin - usercoin) + (usercoin * 18);
				System.out.println("코인 : " + coin);
			}else if((user == 4 && dice_a + dice_b == 4) || (user == 10 && dice_a + dice_b == 10)) {
				System.out.println("12배 입니다.");
				coin = (coin - usercoin) + (usercoin * 12);
				System.out.println("코인 : " + coin);
			}else if((user == 5 && dice_a + dice_b == 5) || (user == 9 && dice_a + dice_b == 9)) {
				System.out.println("9배 입니다.");
				coin = (coin - usercoin) + (usercoin * 9);
				System.out.println("코인 : " + coin);
			}else if((user == 6 && dice_a + dice_b == 6) || (user == 8 && dice_a + dice_b == 8)) {
				System.out.println("7배 입니다.");
				coin = (coin - usercoin) + (usercoin * 7);
				System.out.println("코인 : " + coin);
			}else if(user == 7 && dice_a + dice_b == 7) {
				System.out.println("6배 입니다.");
				coin = (coin - usercoin) + (usercoin * 6);
				System.out.println("코인 : " + coin);
			} else{
				System.out.println("도박에 실패하셨습니다.");
				coin = coin - usercoin;
			}// if end
			System.out.println("남은 코인 : " + coin);
			if(coin == 0) {
				System.out.println("코인이 없습니다.");
				break;
			}
			System.out.println("계속 하시겠습니까? (Y,N)");
			stop = sc.next();
			if(stop.equals("N") || stop.equals("n")) {
				break;
			}else if(stop.equals("Y") || stop.equals("y")) {
				System.out.println("계속합니다.");
			}else {
				System.out.println("Y,N 둘중 하나를 입력해주세요.");
			}
			
		} // while end
		
		System.out.println("수고하셨습니다.");
		
		
	}
	
	
	
	
}
