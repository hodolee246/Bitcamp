package project5;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x, y;
		x = 1 ;
		y = 2 ;
		
		x = scan.nextInt();
		y = scan.nextInt();
		
		x = x+1;
		
		y = y-1;
		
		System.out.println("x ="+x);
		System.out.println("y ="+y);
		
		
		
		
		
		int num1 = 11;
		int num2 = 22;
		
		int temp ; // 아무 의미 없는 변수일 경우, 일회용일 경우
					// temp == buffer(저장소)
		// swap(교환)
		
		System.out.println("교환전num1 =" + num1 + "교환전 num2 =" + num2);
		temp = num1; // num1의 값을 보관, 저장(temp)
		
		num1 = num2 ;	//num1은 저장을 해 두었으니 새로운 값을 할당한다.
		num2 = temp ;	//num2에 저장했던 num1의 값을 대입	
		
		System.out.println("교환후 num1 =" + num1 + "교환후 num2 =" + num2);
	}

}
