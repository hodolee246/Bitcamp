package work2;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		
		int d = 0;
		int sc = 0;
		int z = 0;
		int temp2 = 0;
		
		
		System.out.println("원하시는 구구단의 숫자를 입력해 주세요 ");
		sc = scan.nextInt();
		
			for(d=1; d<=100; d++)
			{
				temp2 = d*sc;
				System.out.print(sc+"x"+d+"="+temp2+"\t");
			}
		
		
		System.out.println("\n");


		int i = 0;
		int y = 0;
		
		for(i=1;i<10;i++)
		{
			for(y=1;y<10;y++)
			{
			
			
			System.out.print(i+"x"+y+"="+i*y+"\t");
			}
			System.out.print("\n");
		}
		
		
		
	}

}
