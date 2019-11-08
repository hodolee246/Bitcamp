
public class mainClass {

	public static void main(String[] args) {
		
		int num1[] = {1,2,3,4,5};
		
		DDuble(num1);
		for (int i = 0; i < num1.length; i++) {
			System.out.println("num1[" + i + "] = " + num1[i]);
		}

	}

	
	
	static void DDuble(int num1[]) {
		
		for (int i = 0; i < num1.length; i++) {
			num1[i] = num1[i] *2;
		}
		
		
	}
	
	
	
	
	
}








