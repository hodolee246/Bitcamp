package baseball;

import java.util.Scanner;

public class baseballClass {
	Scanner sc = new Scanner(System.in);
	// 랜덤 숫자 받고 나눠서 배열
	private int ran[];
	// 사용자 숫자 받고 나눠서 배열
	private int user[];
	// 비교 후 결과 출력
	
	// 끝
	
	public void init() {
		ran = new int[3];
		user = new int[3];
	}
	
	private void ranNum() {
		
		while(true) {
			int num1 = (int)(Math.random()*9+1);
			int num2 = (int)(Math.random()*10);
			int num3 = (int)(Math.random()*10);
			if(num1 != num2
			&& num2 != num3
			&& num1 != num3) {
				
			ran[0] = num1;
			ran[1] = num2;
			ran[2] = num3;
			
			break ;
			}
		}
		System.out.print(ran[0]);
		System.out.print(ran[1]);
		System.out.println(ran[2]);
		
		
	}
	public void userNum() {
		System.out.println("숫자를 입력해주세요");
		int temp = sc.nextInt();
		user[0] = temp / 100;
		temp = temp % 100;
		user[1] = temp / 10;
		temp = temp % 10;
		user[2] = temp;
		
		
		
	}
	public void check() {
		int count, s, b;
		count = s = b = 0;
		ranNum();
		
		out:while(count < 10) {
			s = b = 0;
			userNum();
			for (int i = 0; i < ran.length; i++) {
				for (int j = 0; j < user.length; j++) {
					if(i == j && ran[i] == user[j]) {
						s++;
						if(s ==3) {
							System.out.println("정답입니다.");
							break out;
						}
					}else if(i != j && ran[i] == user[j]) {
						b++;
					}
				}
			}
			System.out.println(s+" 스트라이크" + b + " 볼 입니다.");
			System.out.println((10 - (count+1)) + "번 남았습니다.");
			if(count == 9
			&& s !=3) {
				System.out.println("게임 클리어에 실패했습니다. 이용해주셔서 감사합니다.");
			}
			count ++;
			
		
	}
		
	}
	
	
	
	
	
	
	
}
