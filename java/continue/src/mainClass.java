import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		/*
		 
		 	continue == 생략
		 
		 
		 	continue문 자체만으로 사용할 수 없다.
		 	loop문이랑 같이 사용을 해야 한다. ( for , while, do while)
		 */
		
		for (int i = 0; i < 10; i++) {
			System.out.println("i ="+i);
			System.out.println("for start");
			
			if(i > 4 && i<8) {
				continue;
			}
			
			// continue == 다음 작업은 스킵한다 break 문은 그 이후로 종료를 하지만 이거는 특정 부분만 종료 시키고 나머지는 계속 할수가 있다.
			System.out.println("for end");
			
		}
		
		Scanner sc = new Scanner(System.in);
		
		int number;
		/*
		for(int i = 0; i<3; i++) {
			System.out.println("숫자를 입력해 주십시오 =");
			number = sc.nextInt();
			if(number < 0) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}
		 */
		int w= 0;
		while(w < 3 ) {
			System.out.println("숫자를 입력해 주십시오 =");
			number = sc.nextInt();
			if(number < 0) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			w++;
		}
		// continue 문 for 문과 while문 차이 입력한 문자가 정상 작동하게 하려면 while 문이 더 좋다.
		// for문에서 사용시 잘못 입력시에도 빠져나가는대 까지 입력 횟수는 똑같지만 while문에서는 잘못 입력시 카운트를 안한다.
		
	}

}
