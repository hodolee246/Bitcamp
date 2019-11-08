
public class mainClass {

	public static void main(String[] args) {
		int r;
		r = (int)(Math.random() * 10);  // 0~9
		
		System.out.println("r = "+r);
		
		int inputNumber = 27 % 5 + 1;           // 1~5 
		
		// 1 ~ 10 
		
		r = (int)(Math.random() * 10);  // 0~9
		// 0~9 +1
		System.out.println("r = "+r);
		// 10 20 30 40 50 
		r = ((int)(Math.random() * 5)+1)*10;  // 0~9
		// (0 1 2 3 4 +1) * 10
		System.out.println("r = "+r);

	}

}
