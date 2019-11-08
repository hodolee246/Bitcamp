package game;

import java.util.Scanner;

import dice.Dice;

public class gamePlay {

	
	
	private int coin = 20;
	private int batting;
	private int inputNumber;
	
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();
	
	public void init() {
		dice1.diceRandom();
		dice2.diceRandom();
		
		System.out.println("첫번째 주사위: " + dice1.getNumber());
		System.out.println("두번째 주사위: " + dice2.getNumber());
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		// batting 배팅할 코인을 입력받는다
		System.out.print("배팅할 코인 : ");
		batting = sc.nextInt();
		
		coin = coin - batting; // 자세히 디테일 하게 하고싶으면 인트형이 아닌경우 다시 입력 하라는 try, catch 문
		//	투자할 코인이 0개 이하면 안되고 자신이 가진 코인 갯수를 넘어서도 안된다.
		
		// inputNumber 주사위 번호를 입력받는다.
		while(true) {
		System.out.print("주사위 숫자 : ");
		inputNumber = sc.nextInt();
		if(inputNumber > 2 && inputNumber < 12 &&
				inputNumber != 2 && inputNumber != 12) {
				break;
			}
			System.out.println("다시입력해주세요");
		}
		
	}
	
	public void finding() {
		int dNum1 = dice1.getNumber();
		int dNum2 = dice2.getNumber();
		
		int sum = dNum1 + dNum2;
		
		if(inputNumber == sum ) {
			if(sum == 3 || sum == 11) {
				batting = batting * 18;
			}else if(sum == 4 || sum == 110) {
				batting = batting * 12;
			}else if(sum ==5 || sum == 9) {
				batting = batting * 9;
			}else if(sum == 6 || sum == 8) {
				batting = batting * 7;
			}else if(sum == 7) {
				batting = batting * 6;
			}
			System.out.println("축하합니다.");
			coin = coin + batting;
		}
		else {
			System.out.println("다음 기회에...");
		}
	}
	
	public void resultPrint() {
		System.out.println("주사위1: " + dice1.getNumber());
		System.out.println("주사위2: " + dice2.getNumber());
		
		System.out.println("합계: " + (dice1.getNumber() + dice2.getNumber()) );
		System.out.println("코인: " + coin);
	}
	
	
	
	
	
}
