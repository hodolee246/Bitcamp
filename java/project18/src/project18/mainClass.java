package project18;

public class mainClass {

	public static void main(String[] args) {
		int number;
		int evenTotal = 0;
		int oddTotal = 0;
		for(number =0; number <101;  number++)
		{
			if( number % 2 == 0)
			{
			evenTotal = number + evenTotal ;
			}
			else 
			{
				oddTotal = number + oddTotal;
			}
		}
		System.out.println("1부터 100 사이 짝수의 합은:"+evenTotal);
		System.out.println("1부터 100 사이 홀수의 합은:"+oddTotal);
	
	}

}
