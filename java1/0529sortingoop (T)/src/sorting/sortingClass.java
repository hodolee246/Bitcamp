package sorting;

import java.util.Scanner;

public class sortingClass {

	// 클래스 멤버 Variable
	
	private int number[];
	private int updown;
	
	// 클래스 멤버 method
	
	public void init() {
		updown = 0;
	}
	
	public void input() { // Sorting 클래스 내부에서는 서로 다른 클래스가 아니기 때문에 return 값이 없어도 배열을 그냥 참조할수있다.
	Scanner sc = new Scanner(System.in);
	
	System.out.println("몇개를 정렬하시겠습니까?");
	int count = sc.nextInt();
	
	number = new int[count];
	
	for (int i = 0; i < number.length; i++) {
		System.out.println((i + 1) + "번째 수 = ");
		number[i] = sc.nextInt();
	}
	
	System.out.println("오름(1) / 내림(2) = ");
	updown = sc.nextInt();
	sc.close();
		
		
	}
	
	public void sorting() {
		for (int i = 0; i < number.length -1 ; i++) {
			for (int j = i+1 ; j < number.length; j++) {
				if(updown == 1) {
					if(number[i] > number[j]) {
						swap(i, j);
					}
				}else {
					if(number[i] < number[j]) {
						swap(i, j);
					}
				}
			}
		}
	}
	
	private void swap(int i, int j) { // 이거는 sorting class 에서만 사용하기 떄문에 굳이 퍼블릭으로 설정할 필요, 이유가 없다. 
		
		int temp;
		temp = number[i];
		number[i] = number[j];
		number[j] = temp;
		
	}
	
	public void resultPrint() {
		if(updown ==1) {
			System.out.println("오름차순 입니다.");
		}else System.out.println("내림차순 입니다.");
		for (int i = 0; i < number.length; i++) {
			System.out.println((i + 1) + ":" + number[i]);
		}
	}
	
	
	
	
	
	
	
}
