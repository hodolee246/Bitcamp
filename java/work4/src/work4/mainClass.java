package work4;

public class mainClass {

	public static void main(String[] args) {
		// 2차원 배열을 1차원 배열에 담는 방법
/*
		int array2[][] = {
		{11, 12, 13, 14},
		{21, 22, 23, 24},
		{31, 32, 33, 34}
		};
		int _array[ ] = new int [array2.length * array2[0].length];
		for (int i = 0; i < array2.length; i++) {
			
			for (int j = 0; j < array2[0].length; j++) {
				int array[] = new int[i*j];
	
			}
		}
*/
		
		
		int array2[][] = {
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34}
				};
		int array1[]= new int [array2.length * array2[0].length];

		
		for (int i = 0; i < array2.length; i++) { // 3번
			for (int j = 0; j < array2[0].length; j++) { // 4번
				array1[array2[0].length * i + j] = array2[i][j];
				
			}
		}
		for(int i =0; i< array1.length; i++) { 
			System.out.println("array1["+i+"]="+ array1[i]);
		}
		
		
		
				
				// 피보나치 수열 - > 30
				// 0 1 1 2 3 5 8
				// a 0 b 1 c a+b
	
	
		/*
		// 피보나치수열
		int a, b, c ;
		int arrNum[] = new int[30];
		int w = 0;
		
		
		a= 0 ;
		
		b= 1;
		arrNum[0]= a;
		arrNum[1]= b;
		while(w < 28) {
		c= a+b;
		arrNum[w + 2] = c;
		a = b;
		b = c;
		System.out.print("  a:"+a);
		System.out.print("  b:" +b);
		System.out.println("  c:"+c);
		w++;
		}
		*/
		
			
		
		
	}

}
