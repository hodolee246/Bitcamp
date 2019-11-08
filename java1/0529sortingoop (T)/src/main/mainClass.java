package main;

import sorting.sortingClass;

public class mainClass {

	public static void main(String[] args) {
		
		sortingClass sort = new sortingClass();
		
		
		
		// 변수 선언
		
		//int number[] = null;
		//int updown;
		
		// 초기화
		sort.init();
		// 입력
		sort.input();
		//int count;
			// 1. 몇개
			// 2. 동적할당 
			// 3. 숫자들 입력
			// 4. 오름/내림
		
		// 정렬
		sort.sorting();
		//int teamp;
		
		// 출력
		sort.resultPrint();
		
		
		
		

	}

}
