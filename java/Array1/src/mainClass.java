
public class mainClass {

	public static void main(String[] args) {
		// 배열의 정의란? 같은 자료형의 형변수의 묶음
				/*
	배열은 관리를 하기 위해 존재한다. 관리방법 : 숫자로 관리하며 접근방식도 숫자로 접근한다
	자료형 자료형 변수[]=new 자료형[n] n ==  배열의 갯수 ex 자료형[100]
					
	int array[]=new int[100];  배열에 접근할때 배열의 번호로 접근을 한다. 
	배열은 0부터 시작해서 본인이 지정한 숫자의 -1까지 간다
	new == 동적할당 사용자 지정의 따라 지정되는 숫자가 달라진다. 
	동적으로 잡아놓고 동적할당을 하면 정적이된다. 
							
					
	배열의 index number 란? 몇번째 배열인지 숫자이다.
	[5] 다른 공식에서 이 배열을 사용을 할때 index number를 통하여 접근을 한다
	
	Array(배열): 같은 자료형 변수의 묶음
	
	int num1, ... num10
	
	자료형 배열변수[] = new 자료형[배열 갯수];
	배열변수[0] = 자료형 데이터
			:
	배열변수[배열갯수-1] = 자료형 데이터
	배열변수[index number]			
				*/
		
	int Array[] = new int[10]; // [0]~[9]
	
	Array[0] = 10;
	Array[1] = 11;
	Array[2] = 12;
	Array[3] = 13;
	Array[4] = 14;
	Array[5] = 15;
	Array[6] = 16;
	Array[7] = 17;
	Array[8] = 18;
	Array[9] = 19;
	
	
	System.out.println("Array[0] = " + Array[0]);
	System.out.println("Array[9] = " + Array[9]);
					
	char cArray[]; // 배열변수
	cArray = new char[5]; //할당
	cArray[0] = '안';
	cArray[1] = '녕';
	cArray[2] = '하';
	cArray[3] = '세';
	cArray[4] = '요';
	// cArray[5] = ''; Exception(예외)
	
	int var =1 ;  // initialize(초기화) == init
	String sArray [] = {"hello", "hi", "good"};
	
	System.out.println("sArray[2] = "+ sArray[2]);
	
	
	// String sArr[]?
	// sArr = {"hello", "hi", "good"};
	
	// 초기화는 선언시에만 가능하다 int a; a = ~~ 이런식으로 선언후 입력이 안된다( 배열은)
	// Array Length(길이)
	System.out.println("배열 길이 : " + sArray.length);
	System.out.println("배열 길이 : " + Array.length);
	System.out.println("배열 길이 : " + cArray.length);
	
	// 배열 을 설정하기만 했으면 모든 배열에 길이값은 존재한다.
	// 배열은 복제가 가능하다 복제를 변경해도 진짜도 변경된다
	String aliasArray[]= sArray;
	
	System.out.println("aliasArray[0] = " + aliasArray[0]);
	
	
	aliasArray[1] = "안녕";
	
	System.out.println("sArray[1] = " + sArray[1]);
	
	int number1[] = {11, 12, 13};
	int number2[] = {21, 22, 23};
	
	int num1[] = number1;
	int num2[] = number2;
	
	System.out.println("1:"+ num1[0] + " " + num1[1] + " " + num1[2]);
	System.out.println("2:"+ num2[0] + " " + num2[1] + " " + num2[2]);
	
	int temp[] = num1;
	num1 = num2;
	num2 = temp;
	
	System.out.println("1:"+ num1[0] + " " + num1[1] + " " + num1[2]);
	System.out.println("2:"+ num2[0] + " " + num2[1] + " " + num2[2]);
	
	/*
	
	int temp;
	temp = number1[0];
	number1[0] = number2[0];
	number2[0] = temp;
	
	*/
	
	
	}

}
