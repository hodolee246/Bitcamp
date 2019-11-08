package scan;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		
		// 입력(콘솔에서 입력받는다)
		// 입력을 받을때에는 특정 공간에 입력을 받는다.
		Scanner scan = new Scanner(System.in);
		
		// boolean
		boolean b;
		System.out.print("input b = ");
		b = scan.nextBoolean();
		System.out.println("b = " + b);
		
		// int
		int i;
		System.out.print("input i =");
		i = scan.nextInt();
		System.out.println("i =" + i);
		// double
		double d;
		System.out.print("input d =");
		d = scan.nextDouble();
		System.out.println("d =" + d);
		// string 
		String str;
		System.out.print("str =");
		
		str = scan.next();
		System.out.println("str = " + str);
	
		//next , nextline
		System.out.print("str:");
		str = scan.next();
		System.out.println("str = " + str);
		
		System.out.print("i:");
		i = scan.nextInt();
		System.out.println("i =" + i);
		
		// 주로 scan 받는 것은 3가지만 자주 사용한다. int double next(string)
	}

}
