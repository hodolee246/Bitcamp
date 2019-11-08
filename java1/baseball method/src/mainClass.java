import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {

		int ranarr[] = new int[3];

		int userarr[] = new int[3];

		rannum(ranarr);
		
		result(ranarr, userarr);
	}

	static void rannum(int ranarr[]) {
		
		int a, b, c;
		while (true) {
			a = (int) (Math.random() * 9);
			b = (int) (Math.random() * 9);
			c = (int) (Math.random() * 9);

			if (a != b && b != c && a != c) // 서로 겹치지않게
				break;
		}

		ranarr[0] = a; // 겹치지않은 숫자를 배열에 넣고
		ranarr[1] = b;
		ranarr[2] = c;
		for (int i = 0; i < ranarr.length; i++) {
			System.out.print(+ ranarr[i]);
		}
		System.out.println();
		 // 이 배열을 리턴해서 메인에 만들기만한 배열에 집어넣는다.

	}

	static int[] usernum(int userarr[]) {
		Scanner scan = new Scanner(System.in);
		int usernum = 0;	// 사용자 입력값 받을 변수
		char re ;           // 입력한 숫자를 문자열로 받고 charat 으로 받을 char 형 
	
		System.out.println("숫자를 입력해 주세요.");
		usernum = scan.nextInt();
		userarr[0] = usernum / 100;
		usernum = usernum % 100;
		userarr[1] = usernum / 10;
		usernum = usernum % 10;
		userarr[2] = usernum;
		
		System.out.print(userarr[0]);
		System.out.print(userarr[1]);
		System.out.println(userarr[2]);
		return userarr;
	}

	static void result(int ranarr[], int userarr[]) {
		int s, b;
	out:for (int k = 1; k < 11; k++) {
		s = b = 0;
		usernum(userarr);
			for (int i = 0; i < ranarr.length; i++) {
				for (int j = 0; j < userarr.length; j++) {
					if (ranarr[i] == userarr[j] && i == j)
						s++; if(s == 3) {
							System.out.println("홈런입니다.");
							break out;
						}
					else if (ranarr[i] != userarr[i] && ranarr[i] == userarr[j])
						b++;
				}
			}
			System.out.println(s + "스트라이크" + b + "볼 입니다.");
			if(k != 10)
			System.out.println(k+"번째 기회입니다.");
			else
				System.out.println("아웃입니다.");
		}
	}

}
