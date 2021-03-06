package cast;

public class mainClass {

	public static void main(String[] args) {
		/*
			우선순위
			boolean
			
			byte			1
			short char		2
			int				4
			long			8
			
			float			4
			double			8
			
			자동 자료형 변환, 강제 자료형 (cast) 변환
			

		*/
		
		short sh = 1 ;
		int i ;
		i = sh; 	// 자동 자료형 변환
		System.out.println("i = " + i);
		
		i = 25;
		sh = (short)i; // cast 변환 
		System.out.println("sh = " + sh);
		
		long l = 32342213213123L;
		
		float f; 
		
		f = l;
		System.out.println("f = " + f);
		
		double d;
		
		d = l;
		System.out.println("d = " + d);
		f= (float) d;
		
		double r;
		r= (int)(Math.random()*10);
		
		System.out.println("r = " + r );
		
		// cast 변환 == 강제 자료형 변환
		
		// 0.123e2 -> 0.123 * 10*10
		double dnum = 0.123E-2 ;  // 0.123e2  e == 10 의
		// 그 뒤에숫자만큼 승 즉 0.123 *100 뒤에 숫자가 마이너스면 나누기
		System.out.println("dnum = " + dnum );
		
		int n1 = 3;
		int n2 = 2;
		
		float f1 ;
		
		f1 = (float)n1 / n2;  // cast형 변환은 안할경우 int 는 소수점 아래를 버려서 그냥 1이 나온다 
		System.out.println("f1 = " + f1);
		
		
		
	}

}
