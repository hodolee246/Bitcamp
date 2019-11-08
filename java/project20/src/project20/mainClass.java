package project20;

public class mainClass {

	public static void main(String[] args) {
		
		
		int[][]arr = {
				{5,5,5,5,5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30},
		};
		int total = 0;
		float average = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				total = total + arr[i][j];
			}
		} 
		average = (float)total / (arr.length*arr[0].length);
		System.out.println("총합 =" + total);
		System.out.println("평균 =" + average);
		
		
		

	}

}
