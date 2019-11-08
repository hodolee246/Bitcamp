
public class mainClass {

	public static void main(String[] args) {
		
		 
		System.out.println( getDistance(1, 1, 2, 2));
		
		
		
	}

	// 두점 (x, y)와 (x1, y1)간의 거리를 구하여라
	static double getDistance(int x, int y, int x1, int y1) {
		/*
			루트( (y1 - y)2승  + (x1-x)2승 )
			ㄴ sqrt(루트)
			pow(power *2 *3)
		*/
		double value;
		
		value = Math.pow(y1 - y, 2) + Math.pow(x1 - x, 2);
		
		//value = Math.sqrt( value ); // root == 0.5승 == ½승
		value = Math.pow(value, 0.5); // sqrt 는 개인적으로 코드가 무거워져서 많아지면 코딩이 느려진다 그래서 pow 에 2분의1승을 하여 루트를 대신하여 사용도 가능하다.
		return value;
	}
	
	
	
	
	
	
	
}









