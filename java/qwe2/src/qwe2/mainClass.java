package qwe2;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
	
		Scanner scan=new Scanner(System.in);
		
	/*
		int a ;
		
		a = scan.nextInt();
		
		if(a <= 10)
		{
			System.out.println(" 많이 더 하셔야 합니다.");
		}
		else if (a <= 15)
		{
			System.out.println("조금 더 하셔야 합니다.");
		}
		else
		{
			System.out.println("충분합니다.");
		}
		
		int ir;
		int ray[]=new int[7];
		
		ray[0] = 2;
		ray[1] = 6;
		ray[2] = 18;
		ray[3] = 54;
		ray[4] = 162;
		ray[5] = 486;
		ray[6] = 1458;

		
		ir = (int)(Math.random()*ray.length);

		if (ray[ir] == 54)
		{
			System.out.println("당첨 입니다.");
			System.out.println(ray[ir]);
		}
		else
		{
			System.out.println("꽝 입니다.");
			System.out.println(ray[ir]);
		}
		
	//	System.out.println("랜덤 숫자 =" + ray[ir]);
	//	System.out.println("랜덤 숫자 =" + ir);
		
	
		int a, s, d ;
		int z[] =new int[6];
		int x[] =new int[6];
		int c[] =new int[6];
		

		z[0] = 1;
		z[1] = 4;
		z[2] = 7;
		z[3] = 10;
		z[4] = 13;
		z[5] = 16;
		
		x[0] = 2;
		x[1] = 5;
		x[2] = 8;
		x[3] = 11;
		x[4] = 14;
		x[5] = 17;
		
		c[0] = 3;
		c[1] = 6;
		c[2] = 9;
		c[3] = 12;
		c[4] = 15;
		c[5] = 18;
		
		
	
		
		
	
			
		a = (int)Math.random()*x.length ;
		s = (int)Math.random()*x.length ;
		d = (int)Math.random()*x.length ;
		
		if(a == 4)
		{
			if(s == 11)
			{
				if(d == 18)
				{
					System.out.println("당첨 입니다.");
					System.out.println(a);
				}
			}
		}
		else
		{
			System.out.println("꽝 입니다.");
			System.out.println(d);
		}
		
		int a,b ;
		
		System.out.println("메뉴를 골라 주세요 \n 1.비빔밥 2.떡갈비 3.간장게장 4.신선로 5.파전");
		
		a = scan.nextInt();
		
		if(a==1)
		{
			System.out.println("비빔밥 나오는데 15분 걸립니다.");
		}
		else if( a== 2)
		{
			System.out.println("떡갈비 나오는데 30분 걸립니다. ");
		}
		else if( a==3)
		{
			System.out.println("간장게장 나오는데 5분 걸립니다.");
		}
		else if ( a== 4)
		{
			System.out.println("신선로 나오는데 25분 걸립니다.");
		}
		else if ( a==5)
		{
			System.out.println("파전 나오는데 20분 걸립니다.");
		}
		else 
		{
			System.out.println("잘못 고르셨습니다. \n 다시 선택해 주시기 바랍니다.");
			System.out.println("메뉴를 골라 주세요 \n 1.비빔밥 2.떡갈비 3.간장게장 4.신선로 5.파전");
					b = scan.nextInt();
					if(b==1)
					{
						System.out.println("비빔밥 나오는데 15분 걸립니다.");
					}
					else if( b== 2)
					{
						System.out.println("떡갈비 나오는데 30분 걸립니다. ");
					}
					else if( b==3)
					{
						System.out.println("간장게장 나오는데 5분 걸립니다.");
					}
					else if ( b== 4)
					{
						System.out.println("신선로 나오는데 25분 걸립니다.");
					}
					else if ( b==5)
					{
						System.out.println("파전 나오는데 20분 걸립니다.");
					}
					else 
					{
						System.out.println("안팔아요");
					}
		}
					*/
		
		/*
		int fmary[] = new int[20];
		
		for(int fm = 0; fm <20; fm++)
		{
			fmary[fm] = fm;
		}
		
		System.out.println(fmary[1]);
		System.out.println(fmary[2]);
		System.out.println(fmary[3]);
		System.out.println(fmary[4]);
		System.out.println(fmary[5]);
		System.out.println(fmary[1]);
		System.out.println(fmary[1]);
		System.out.println(fmary[15]);
		System.out.println(fmary[17]);
		System.out.println(fmary[19]);
		
		int i = 0;
		
		while(i <= 10)
		{
			System.out.println("While문 연습중입니다." + i +"회");
			i++;
		}
		*/
		int ga = 5;
		
		switch(ga)
		{
		case 1:
			System.out.println("ga는 1입니다.");
			break;
		case 2:
			System.out.println("ga는 2입니다.");
		case 3:
			System.out.println("ga는 3입니다.");
		case 4:
			System.out.println("ga는 4입니다.");
		case 5:
			System.out.println("ga는 5입니다.");
		default:
			System.out.println("ga값은 이미 구했습니다.");
			break;
		}
		
		
		
		
		
		
		
	}

}
