package project22;

public class mainClass {

	public static void main(String[] args) {
		
					//abcdefghijklmnopqrstuvwxyz
		char[]abcCode=
			{'`','~','!','@','#','$','%','^','&','*',
			'(',')','-','_','+','=','|','[',']','{','}',';',':',
			',','.','/'};
		
		
		// 0 1 2 3 4 5 6 7 8 9
		
		char[]numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		String src = "gooday";
		String result = "";    // `~!qwe
		 
		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
		for (int i = 0; i < src.length(); i++) {
			char ch=src.charAt(i);
		
			int num = (int)ch; // 아스키 코드 값 취득
			// 알파벳일 경우 -> 숫자
			if(num >= 97 && num <= 122) { // 'a' == 0으로 세팅
				num = num - 97;
				
			result = result + abcCode[num]; // 아스키 코드로 그 값을 빼면 0부터 돌릴수있다.
			
			}
			// 알파벳이 아닐경우 -> 특수문자
			else {
				num = num -48; // '0' == 0으로 셋팅하기 위해서
				result = result + numCode[num];
		}
		}
		System.out.println("src: " + src);
		System.out.println("result: "+result);
		
		
		
		
		
		
		
		
			
	}
}

