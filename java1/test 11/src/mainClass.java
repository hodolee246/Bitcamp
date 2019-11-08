import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		int number[]; 	// 정렬을할 숫자의 배열 (사용자 입력)
		
		int updown[] = new int[1]; 	// 올림(1)/내림(2)
		// 배열  배열 입력및 어떻게 정렬할지 등등...
		
		// 배열 정렬한 숫자의 맞게 배열정렬
		number = numberInput(updown); // count 는 더이상 필요가없음 number.len있기때문에
		
		// 숫자의 갯수에 맞게 숫자들을 입력 받는다.
		
		}
		
		// 정렬 차순 
		
		
		
		// sorting 정렬
		
		sorting
	
		// result 결과 출력
		result(number, updown[0]);
		
		
		
	}
		static int[] numberInput() {
			Scanner scan = new Scanner(System.in);
			int count  ; // 배열을 만들고 싶은 갯수 (사용자 입력)
			int number[];
			int updown[];
			System.out.println("몇개의 숫자를 정렬하시겠습니까?");
			
			count = scan.nextInt();
			
			number = new int[count];
			
			System.out.println();
			updown = scan.nextInt();
			updown[0] = scan.nextInt();
			
			for(int i= 0; i < number.length; i++) {
				System.out.println((i+1)+"번쨰의 배열을 입력해주세요");
				number[i] = scan.nextInt();
		}
	

	
}
		static void sorting(int number[], int updown) {
			int temp = 0;
			for (int i = 0; i < number.length-1; i++) {
				for (int j = i+1; j < number.length; j++) {
					if(updown == 1) {
						if(number[i] > number[j]) { // 올림차순
						swap(number, i, j);
							
						/*	temp = number[i]; // swap 으로 한줄로 줄임
							number[i] = number[j];
							number[j] = temp; */
				}
					else{
						if(number[i] < number[j]) { // 내림차순
							swap(number, i, j);
							
							/*	temp = number[i]; // swap 으로 한줄로 줄임
							number[i] = number[j];
							number[j] = temp; */
				}
					}
				}
				
			
		}

}
		}
		static void swap(int number[], int i, int j) {
		int temp;
		
		temp = number[i];
		number[i] = number[j];
		number[j] = temp;
		
		
		}
		static void result(int number[], int updown) {
			String ud = "";
			if(updown == 1) {
				ud = "올림";
			}
			else ud = "내림";
			System.out.println(ud + "차순 정렬 입니다");
			
			for (int i = 0; i < number.length; i++) {
				System.out.println(number[i]);
			}
		}
	}