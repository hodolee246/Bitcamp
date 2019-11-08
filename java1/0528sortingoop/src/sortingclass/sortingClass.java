package sortingclass;

import java.util.Scanner;

public class sortingClass {

	Scanner scan = new Scanner(System.in);
	
	// 클래스 멤버 변수 Variable : 
	
	// 클래스 멤버 메소드
	
	private int array[] ;

	
	
	public void arrayindexnumber() { // 배열 indexnumber 입력
		System.out.println("배열의 크기를 입력해 주세요(Index Number)");
		int count = scan.nextInt();
		
		array = new int[count];
		
			
		
	}
		
	public void arraynumber() { //배열 값 입력
		for (int i = 0; i < array.length; i++) {
			System.out.println(i+1 + " 번째 배열에 넣을 값을 입력해 주세요");
			int count = scan.nextInt();
			
			array[i] = count;
			
		}
			
	}
	public void howtosorting() { // 정렬
	
		boolean abc = false;
		while(abc == false) {
			
			System.out.println("어떻게 정렬 하시겠습니까? 오름차순(1), 내림차순(2) ");
			
			int count = scan.nextInt();
		
			if(count ==1) {
			for (int i = 0; i < array.length -1; i++) {
				for (int j = i+1; j < array.length; j++) {
					if(array[i] > array[j]) {
						swap(i, j);
						abc = true;
					}
				}
			}
		}else if(count ==2) {
			for (int i = 0; i < array.length -1; i++) {
				for (int j = i+1; j < array.length; j++) {
					if(array[j] > array[i]) {
						swap(i, j);
						abc = true;
					}
				}
			}
		
		
		
		
			}	// while end
	
		}
	}
	
	public void swap(int i, int j) { // 스왑 
		
		int temp ;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}
	
	public void allprint() { // 전부 출력
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	

		static void GetNumber() {
		      Scanner scan = new Scanner(System.in);
		      try {

		         int value = scan.nextInt();
		  

		      } catch(Exception e) {

		     System.out.println("정수를 입력해주세요.");

		      }

		   }
	
}




