package ifClass;

public class mainClass {

	public static void main(String[] args) {

		/*
		
			제어문
			
			종류:
				조건문
				if
				
				if else
				
				if
				else if
				else
				
				switch
				
				
				
				loop(반복문)
				
				for
				
				while
				
				do while
				
				반복제어문
				break
				continue

		*/
		
		// 조건문
		/*
		 	형식 : if( 조건 = 논리연산 (true/false) a > 0 && a <=10
		 	{
		 		//처리
		 	}
		 	
		 		 if( 조건 )
		 		 	System.out.println("");
		 		 	
		 		 	if else

		 */
			int number ;
			
			number = 1;
			if( number > 0)
			{
				System.out.println("number는 0 보다 큽니다");
			}
			
			if(number == 1)
			{
				System.out.println("변수 number의 값은 1입니다.");
			}
			
			if(number >= 10)
			{
				System.out.println("number는 10 보다 크거나 같습니다");
			}
			if(true)
			{
				System.out.println("true 입니다.");
			}
			
			boolean b = false ;
			
			if(b == false)
			{
				System.out.println("b == false 입니다.");
			}
			
			if( b != true)
			{
				System.out.println("b != ture 입니다.");
			}
			
			if(b)
			{
				System.out.println("b == true 입니다.");
			
			}
			
			if(!b)
			{ // b == flase
				System.out.println("!b == flase 입니다.");
			}
			if(number > 0 && number <= 10)
			{
				System.out.println("number는 0보다 크고 10보다 작거나 같습니다.");
			}
			
			if(number < 30 || number > 49)
			{
				System.out.println("number는 30보다 작거나 49보다 큽니다.");
			}
			
			// if else if문은 false 시 출력을 못하지만 if else 는 false 시에도 출력이 가능하다.
			
			/*
					if else문
					 		 	
		 		 	if ( 조건1)
		 		 	{
		 		 	// 조건 1이 사실일때 처리
		 		 	 }
		 		 	 else
		 		 	 {
		 		 	 //조건1이 거짓일때 처라
		 		 	  }		
					
			*/
			if(number > 10)
			{
				System.out.println("number는 10보다 큽니다.");
			}
			else
			{
				System.out.println("number는 10보다 작거나 같습니다.");
			}
			
			// 조건분기
			/* if
			 	else if
			 	if( 조건1)
			 	{
			 	조건 1이 참이면 처리
			 	}
			 	else if(조건2)
			 	{
			 		조건 2가 참이면 처리
			 	}
			 	else if (조건3)
			 	{
			 		조건 3가 참이면 처리
			 	}
			 	else
			 	{
			 		전부다 조건이 거짓이면 처리 ( 만약에 3개다 참이 아닐경우 출력을 없애고 싶으면 else를 안쓰면 된다.
			 	}
			*/
			
			int age = 21;
			
			if(age < 20)
			{
				System.out.println("당신은 미성년자 입니다.");
			}
			else if(age < 30)
			{
				System.out.println("당신은 20대 입니다.");
			}
			else if(age < 40)
			{
				System.out.println("당신은 30대 입니다.");
			}
			else if(age < 50)
			{
				System.out.println("당신은 40대 입니다.");
			}
			else
			{
				System.out.println("당신은 50세 이상 입니다.");
			}
			
			if( age >= 50 && age < 60)
			{
				
			}
			else if(age >= 20 && age <30)
			{
				
			}
			else if (age > 0 && age <20)
			{
				
			}
			else if (age >=30 && age <40) 
			{
				
			}
			else
			{
				
			}
			// if문 안의 if문이 있다
			
			int count = 95;
			
			if(count >= 90)
			{
				if(count >= 95)
				{
					System.out.println("A+입니다.");
				}
				else
				{
					System.out.println("A입니다.");
				}
			}
			
			
			
			
			
			
			
			
			
	}

}
