package project11;

public class mainClass {

	public static void main(String[] args) {
		
		int num1, num2 ;
		
		num1 = 0x80;
		
		num2 = 0x38;
		
		num1 = (num1 & num2) | (num1 & num2);
		num2 = ~(num1^num2);
		
		System.out.println("num1 = "+ num1);
		System.out.println("num2 = "+ num2);
		
		/*    80 			38
		   1000 0000    0011 1000
		   0011 1000    1000 0000
		   0000 0000	1011 1000
		   0000 0000    0100 0111
		   0000 0000	8421 8421
		   				
		   
		   
		 */
	}

}
