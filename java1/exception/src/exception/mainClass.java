package exception;

public class mainClass {

	public static void main(String[] args) {
		/*
		 
		 	Exception : 예외 != 에러 -> 개발자용 


			Baseball -> 1 ~ 10 -> 'A' == 65
			random find -> 1 ~ 100 -> 'B' == 66
			number format 10 -> 'a' == 97
			array index [5] -> [0] ~ [4] -> [5] 
			class not find
			file not found 

			형식
			
			try[
				// 예외가 발생할 가능성이 있는 코드
				  
			]catch(예외클래스1 e{
				 // 예외 메세지를 발생
			}catch(예외클래스2 e{
				 // 예외 메세지 발생2
			}...............3....
			}finally{
				// 무조건 실행
				// 되롤림(undo)
				// rollback 
			}
		 */
/*
		int arr[] = {11, 22, 33 };
		
		System.out.println("프로그램 시작");
		
		try {
		
			for (int i = 0; i < 3; i++) {
				System.out.println(arr[i]);
			}
			System.out.println("for문 탈출 부분");
			
			return;
		}catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("배열의 범위를 벗어났습니다.");
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally 부분 입니당.");
			
		}
		System.out.println("프로그램 끝 부분"); // 리턴을 사용해도 반드시 거쳐가기 때문에 뒤처리를 사용한다.
	}
*/		
		
		try { // 어느부분에서 Exception이 발생하는지 확인하려는 것이 try catch 발생문이다.
			callFUnc();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// Exception e 입력시 알아서 어느 부분에서 exception 이 발생했는지 알수있다.
	}
		// Exception 은 다 외울필요없이 사용할꺼면 자주 사용하는것 + Exception 만 입력해서 자동 지원으로 한다.
		static void callFUnc() throws Exception{
								// 함수를 사용할때 뒤에다가 throws exception 적어주면 함수 발생하며 나오는 exception 을 볼수있다.
			int num[] = {11, 22, 33};
			
		//	try {
				for (int i = 0; i < 4; i++) {
					System.out.println(num[i]);
				}
			
		//	}catch (IndexOutOfBoundsException e) {
		//		e.printStackTrace();
		//	}
				
				
				
				
		}
		
		
		
		static void function() {
			System.out.println("function() 시작");
			return;
		//	System.out.println("function() 끝");
		}
}
