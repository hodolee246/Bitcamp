package study5;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// baseball
		
		
		/*
		// 선언부
		int r_num[] = new int[3];
		int u_num[] = new int[3];
		boolean clear;
		
		// 초기화
		clear = false;

		boolean swit[] = new boolean [10];	// 00000 000000
		int r, w ;
		
		for (int i = 0; i < swit.length; i++){
			swit[i] = false;
		}
		w = 0;
		while(w < u_num.length) {
		r = (int)(Math.random() *9);
		if(swit[r] == false) {
			swit[r] = true ;
			// 맨처음 랜덤숫자가 swir[r] 들어오면 최초에는 거짓이니 통과하고 그걸 진실로 바꿔주고 다시 돌리면 똑같은 숫자가 뜰경우 거짓이 아니라 통과를 못해서 포문이 다시 돌아간다.
			
			r_num[w] = r+1;
			w++;
		}
			
	}	
		for (int i = 0; i < r_num.length; i++) {
			System.out.print(r_num[i]);
		}
			System.out.println();
			
		w = 0;
		//LOOP
		while(w < 10) {
		// 2. user number input (1~9) -> 3개
		//		u1 != u2 != u3
		while(true) {
			
			for(int z = 0; z <u_num.length; z++) {
			System.out.println((z + 1) +"번째 수: ");
			u_num[z] = sc.nextInt();
			
		}
			
			if(u_num[0] != u_num[1]
			&& u_num[0] != u_num[2]
			&& u_num[1] != u_num[2]	) {
				break;
			}
			System.out.println("같은 숫자가 있습니다.");
	}
		
		int s, b;
		s = b = 0;
		
		// 3. finding(strike, ball)
		//		strike : 자리, 숫자
		//		ball   : 숫자
		
		// ball
		for (int j = 0; j < u_num.length; j++) {
			for (int j2 = 0; j2 < u_num.length; j2++) {
				if(u_num[j] == r_num[j2]
				&& j != j2) {
					b++;
				}
				
			}
			
		}
		// strike
		for (int j = 0; j < u_num.length; j++) {
			if(u_num[j] == r_num[j]) {
				s++;
			}
			
		}
		if(s > u_num.length - 1) {
			
			clear = true;
			break;
		}
		
		// 4. message(printing)
		System.out.println(s +"스트라이크 \t"+b + "볼 입니다.");
		
			w++;
		}
		// LOOP 
		
		// 5. result(clear, lose)
		if(clear) {
			System.out.println("축하합니다");
		}
		else {
			System.out.println("다시 도전하세요");
			
		}
		/*	
		// 1. random number(1~9) -> 3개
		//		n1 != n2 != n3
	while(true) {	
		r_num[0] = (int)((Math.random()*9 +1));
		r_num[1] = (int)(Math.random()*10);
		r_num[2] = (int)(Math.random()*10);
		
		if(r_num[0] != r_num[1]
		&& r_num[0] != r_num[2]
		&& r_num[1] != r_num[2]) {
			break;
		}
	}
	
	int rnum[] = {0, 1, 2, 3, 4, 5,  6, 7, 8, 9};
	int temp;
	int n1, n2;

	
	for (int i = 0; i < 54; i++) {
		n1 = (int)(Math.random()*10);
		n2 = (int)(Math.random()*10);
		
		temp = rnum[n1];
		rnum[n1] = rnum[n2];
		rnum[n2] = temp;
	}
	for (int i = 0; i < rnum.length; i++) {
		System.out.println("rnum[" + i + "] = " + rnum[i]);
	}*/
/*	
	for (int i = 0; i < r_num.length; i++) {
		System.out.println("r num["+i+"]" + "=" + r_num[i]);
		
	}	
		
		
			00000	00000
			random number -> 3
			00010 	00000
			random number -> 5
			00010 	10000
		
		
	
		sort 정렬	174235968
		선택 정렬		123456789 각 자릿수끼리 비교를 하여 정렬한다 (오름차순, 내림차순) (서로서로 스왑을 해준다)
		버블 정렬		
		합병 정렬
		퀵	정렬
	*/
		
		
		
		
		
		
		
	}

}

	















