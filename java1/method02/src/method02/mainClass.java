package method02;

public class mainClass {

	public static void main(String[] args) {
		
		/*
			function
			매개변수 : 일반 자료형(value의 의한 할당)
					배열도 넘겨줄수가있다?!?!(address의 할당) 배열을 그자체를 넘겨주기 때문에 안에서 값이 변경되어 나올수도 있다.
		*/

		
		
		int n = 123; // 123이 넘어가서 123이 대입이 되었기 떄문에( value 의 의한 할당이라 바뀌지가 않는다)
		function1('C', n);
		
		System.out.println("n = " + n);
		int array[]= {1, 2, 3};
		function2(array);
		
		int array2[];
		array2 = function3();
		for(int i=0; i<array2.length;i++) {
			System.out.println("array2[" + i + "] = " + array2[i]);
		}
		
		int num = 11;
		int numArr[]=new int [1];
		numArr[0] = 11;
		
		System.out.println("함수전 : num = " + num + " numArr[0] = " + numArr[0]);
		
		function4(num, numArr);
		
		System.out.println("함수후 : num = " + num + " numArr[0] = " + numArr[0]);
		
		//int ar[] = {1, 2 };
		//int alias[] = ar;
		//alias[0] = 10;
		// ar[0] -> 10;
		
		int myArray[] = {10, 20, 30, 40, 50};
		// 10으로 나눈 값이 필요하다
		// div10 -> 1, 2, 3, 4, 5
		div10(myArray);
			for (int i = 0; i < myArray.length; i++) {
				System.out.println(myArray[i]);
			}
		}
	
	

	static void function1(char c, int i) {
		System.out.println("c = " + c + "i = " + i);
		i = 45;
	
	}
	static void function2(int arr[]) {// 배열은 비워두어야 되고 배열이 변수명 앞에 와도 상관없고 []array array[] 뒤에 있어도 상관이 없다.
		for(int i =0; i<arr.length; i++) {
			System.out.println("arr[" + i + "] = " + arr[i]);
		}
	}
	static int[] function3() {
		int arr[] = {10, 20 , 30};
		
		return arr; // 
	
		
	}
	
	static void function4(int num, int arr[]) { //num 은 들어가는 값이지만 arr[]는 값이 들어갔다 나온다.
		num = 22;
		arr[0] = 22;
		
		System.out.println("함수안 num = " + num + "arr[0] = " +arr[0]);
	
	
	}
	
	static void div10(int inArray[]) {
		
		for (int i = 0; i < inArray.length; i++) {
			inArray[i] = inArray[i] / 10; // inArray[]가 메인 에서 설정한 함수로 바뀌기 때문에 10 20 30 40 50 들어있는 5개자리 배열이 그대로 넘어온다.
		}
	
	}
	static int[] div101(int inArray2[]) {
		
		for (int i = 0; i < inArray2.length; i++) {
			inArray2[i] = inArray2[i] / 10;
		}
			return inArray2;




	}
}

