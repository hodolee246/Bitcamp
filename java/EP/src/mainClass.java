import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int pay, guest, ft, os, fh, oh,  f,  t, temp ;
		
		pay = scan.nextInt();
		
		guest = scan.nextInt();
		
		temp = guest - pay ;
		
		System.out.println("거스름돈 입니다.");
		ft = temp / 5000;
		System.out.print("5000원 "+ft);
		System.out.println("장");
		temp = temp - 5000*ft;
		os = temp / 1000;
		System.out.print("1000원 "+ os);
		System.out.println("장");
		temp = temp - 1000*os;
		fh = temp / 500;
		System.out.print("500원 " + fh );
		System.out.println("개");
		temp = temp - 500*fh;
		oh = temp / 100;
		System.out.print("100원 " +oh);
		System.out.println("개");
		temp = temp - 100*oh;
		f = temp / 50;
		System.out.print("50원 " +f);
		System.out.println("개");
		temp = temp - 50*f;
		t = temp / 10;
		System.out.print("10원 " + t);
		System.out.println("개");
		
		
		

	}

}
