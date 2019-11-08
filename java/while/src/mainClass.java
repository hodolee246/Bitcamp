
public class mainClass {

	public static void main(String[] args) {
	
		/*
		
			loop
			
			for(초기화;조건식;연산식
			{
				처리
			}
			초기화
			while(조건식)
			{
			처리
			연산식
			
			do
			{
				처리
				연산식
			}while(조건)
		*/
		
		int w;
		
		w = 0;				// 초기화
		while(w < 10)		// 조건식
		{
			System.out.println("while w:" + w);
			
			w++;			// 연산식
		}
		
		w = 0;
		while (w <= 3 && w >= 0 && w !=10)
		{
			System.out.println("while w :" + w);
			w++;
		}
		
		w = 5 ;
		do
		{
			System.out.println("do while w: "+w);
			w++;
		} while(w <5);
		
		// do while == 거꾸로 올라가기 때문에 무조건 한번은 실행이됨 
		
		// 무한루프
		w=0;
		while(true) // 조건식에 그냥 트루 를 집어넣으면 무한루프가 돈다)
		{
			
		}
		
		// application
		
		// 1. init(초기화) a = 0 ; t = 0;
		
		// 2. loop(무한루프) 무한루프문을  사용할때 while문이 적합하다.(탈출하기가 간단하다)
		
		// 3. release(해방) 메모리, 프로세스 에서 해방을 시킨다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}	
	}


