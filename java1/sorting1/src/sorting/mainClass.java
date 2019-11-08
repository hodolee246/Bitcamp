package sorting;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		
		
		int number[];					// 정렬을 할 숫자의 배열
		int updown[] = new int[1];		// 올림(1)/내림(2)
		
		// 배열 = numberInput(올림/내림)
			// 몇개의 숫자
			// 숫자들 입력
			// 올림/내림
		number = numberInput(updown);
		
		
		/*
		System.out.print("몇개의 숫자를 정렬하시겠습니까? = ");
		count = sc.nextInt();
		
		// 배열을 정렬할 숫자에 맞게 확보
		number = new int[count];
		
		// 숫자의 갯수의 맞게 숫자들을 입력 받는다
		for(int i = 0;i < number.length; i++) {
			System.out.print((1 + i) + "번째 숫자:");
			number[i] = sc.nextInt();
		}
		
		// 올림/내림
		System.out.print("올림(1)/내림(2):");
		updown = sc.nextInt();
		*/
				
		// sorting(배열, 올림/내림)
			// swap()
		sorting(number, updown[0]);

		// result(배열, 올림/내림)
		result(number, updown[0]);
	}
	
	static int[] numberInput(int updown[]) {
		Scanner sc = new Scanner(System.in);
		int count;		// 정렬하고 싶은 숫자의 갯수
		int number[];

		System.out.print("몇개의 숫자를 정렬하시겠습니까? = ");
		count = sc.nextInt();
		
		// 배열을 정렬할 숫자에 맞게 확보
		number = new int[count];
		
		// 숫자의 갯수의 맞게 숫자들을 입력 받는다
		for(int i = 0;i < number.length; i++) {
			System.out.print((1 + i) + "번째 숫자:");
			number[i] = sc.nextInt();
		}
		
		// 올림/내림
		System.out.print("올림(1)/내림(2):");
		updown[0] = sc.nextInt();
		
		return number;
	}
	
	static void sorting(int number[], int updown) {
	//	int temp;
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = i + 1; j < number.length; j++) {
				if(updown == 1) {
					if(number[i] > number[j]) {	// 올림						
						swap(number, i, j);							
					/*	temp = number[i];
						number[i] = number[j];
						number[j] = temp;*/
					}
				}
				else {
					if(number[i] < number[j]) {	// 내림						
						swap(number, i, j);						
					/*	temp = number[i];
						number[i] = number[j];
						number[j] = temp;	*/
					}
				}
			}
		}		
	}
	static void swap(int number[], int i, int j) {
		int temp;		
		temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}
	
	static void result(int number[], int updown) {
		String ud = "";
		if(updown == 1) ud = "올림";
		else			ud = "내림";
			
		System.out.println(ud + "차순 정렬입니다");
		
		for (int i = 0; i < number.length; i++) {
			System.out.println((1 + i) + ": " + number[i]);
		}
	}

}






